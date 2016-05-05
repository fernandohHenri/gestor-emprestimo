package com.emprestimo.gestor.controller;

import com.emprestimo.gestor.model.Fase;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

@Named(value = "faseController")
@ViewScoped
public class FaseController extends AbstractController<Fase> {

    public FaseController() {
        // Inform the Abstract parent controller of the concrete Fase Entity
        super(Fase.class);
    }

    /**
     * Sets the "items" attribute with a collection of Emprestimo entities that
     * are retrieved from Fase?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Emprestimo page
     */
    public String navigateEmprestimoList() {
        if (this.getSelecionado() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Emprestimo_items", this.getSelecionado().getEmprestimoList());
        }
        return "/emprestimo/index";
    }

}
