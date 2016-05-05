package com.emprestimo.gestor.controller;

import com.emprestimo.gestor.model.Porte;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

@Named(value = "porteController")
@ViewScoped
public class PorteController extends AbstractController<Porte> {

    public PorteController() {
        // Inform the Abstract parent controller of the concrete Porte Entity
        super(Porte.class);
    }

    /**
     * Sets the "items" attribute with a collection of Emprestimo entities that
     * are retrieved from Porte?cap_first and returns the navigation outcome.
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
