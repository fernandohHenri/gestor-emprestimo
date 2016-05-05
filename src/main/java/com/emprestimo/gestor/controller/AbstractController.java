package com.emprestimo.gestor.controller;


import com.emprestimo.gestor.repository.AbstractFacade;
import com.emprestimo.gestor.repository.LazyEntityDataModel;
import com.emprestimo.gestor.util.JsfUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import java.util.ResourceBundle;
import javax.ejb.EJBException;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;


public abstract class AbstractController<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AbstractFacade<T> ejbFacade;
    private Class<T> item;
    private T selecionado;
    private Collection<T> itens;
    private LazyEntityDataModel<T> lazyItems;

    private enum PersistAction {
        CREATE,
        DELETE,
        UPDATE
    }

    public AbstractController() {
    }

    public AbstractController(Class<T> itemClass) {
        this.item = itemClass;
    }


    public T getSelecionado() {
        return selecionado;
    }

    
    public void setSelecionado(T selected) {
        this.selecionado = selected;
    }

    
    protected void setEmbeddableKeys() {
        // Nothing to do if entity does not have any embeddable key.
    }

    ;

    
    protected void initializeEmbeddableKey() {
        // Nothing to do if entity does not have any embeddable key.
    }


    public Collection<T> getItens() {
        if (itens == null) {
            itens = this.ejbFacade.findAll();
        }
        return itens;
    }

    
    public void setItems(Collection<T> items) {
        this.itens = items;
    }

    
    public LazyEntityDataModel<T> getLazyItems() {
        if (lazyItems == null) {
            lazyItems = new LazyEntityDataModel<>(this.ejbFacade);
        }
        return lazyItems;
    }

    public void setLazyItems(LazyEntityDataModel<T> lazyItems) {
        this.lazyItems = lazyItems;
    }

    public void setLazyItems(Collection<T> items) {
        if (items instanceof List) {
            lazyItems = new LazyEntityDataModel<>((List<T>) items);
        } else {
            lazyItems = new LazyEntityDataModel<>(new ArrayList<>(items));
        }
    }

    
    
    public void save(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/Mensagem").getString(item.getSimpleName() + "Updated");
        persist(PersistAction.UPDATE, msg);
    }
    
    public void saveNew(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/Mensagem").getString(item.getSimpleName() + "Created");
        persist(PersistAction.CREATE, msg);
        if (!isValidationFailed()) {
            itens = null; // Invalidate list of items to trigger re-query.
            lazyItems = null; // Invalidate list of lazy items to trigger re-query.
        }
    }
    
    public void delete(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/Mensagem").getString(item.getSimpleName() + "Deleted");
        persist(PersistAction.DELETE, msg);
        if (!isValidationFailed()) {
            selecionado = null; // Remove selection
            itens = null; // Invalidate list of items to trigger re-query.
            lazyItems = null; // Invalidate list of lazy items to trigger re-query.
        }
    }

    
    
    private void persist(PersistAction persistAction, String successMessage) {
        if (selecionado != null) {
            this.setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    this.ejbFacade.edit(selecionado);
                } else {
                    this.ejbFacade.remove(selecionado);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                Throwable cause = JsfUtil.getRootCause(ex.getCause());
                if (cause != null) {
                    if (cause instanceof ConstraintViolationException) {
                        ConstraintViolationException excp = (ConstraintViolationException) cause;
                        for (ConstraintViolation s : excp.getConstraintViolations()) {
                            JsfUtil.addErrorMessage(s.getMessage());
                        }
                    } else {
                        String msg = cause.getLocalizedMessage();
                        if (msg.length() > 0) {
                            JsfUtil.addErrorMessage(msg);
                        } else {
                            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Mensagem").getString("PersistenceErrorOccured"));
            }
        }
    }

    
    
    public T prepareCreate(ActionEvent event) {
        T newItem;
        try {
            newItem = item.newInstance();
            this.selecionado = newItem;
            initializeEmbeddableKey();
            return newItem;
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
    public boolean isValidationFailed() {
        return JsfUtil.isValidationFailed();
    }

    
    
    public String getComponentMessages(String clientComponent, String defaultMessage) {
        return JsfUtil.getComponentMessages(clientComponent, defaultMessage);
    }

    
    
    @PostConstruct
    public void initParams() {
        Object paramItems = FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(item.getSimpleName() + "_items");
        if (paramItems != null) {
            setItems((Collection<T>) paramItems);
            setLazyItems((Collection<T>) paramItems);
        }
    }

}
