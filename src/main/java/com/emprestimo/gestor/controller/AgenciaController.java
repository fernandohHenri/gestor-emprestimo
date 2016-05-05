package com.emprestimo.gestor.controller;


import com.emprestimo.gestor.model.Agencia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

@Named(value = "agenciaController")
@ViewScoped
public class AgenciaController extends AbstractController<Agencia> {

    public AgenciaController() {
        // Inform the Abstract parent controller of the concrete Agencia Entity
        super(Agencia.class);
    }

    /**
     * Sets the "items" attribute with a collection of Emprestimo entities that
     * are retrieved from Agencia?cap_first and returns the navigation outcome.
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
