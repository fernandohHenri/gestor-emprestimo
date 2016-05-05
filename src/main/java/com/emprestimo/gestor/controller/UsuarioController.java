package com.emprestimo.gestor.controller;

import com.emprestimo.gestor.model.Usuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Sets the "items" attribute with a collection of Navegacao entities that
     * are retrieved from Usuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Navegacao page
     */
    public String navigateNavegacaoList() {
        if (this.getSelecionado() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Navegacao_items", this.getSelecionado().getNavegacaoList());
        }
        return "/navegacao/index";
    }

    /**
     * Sets the "items" attribute with a collection of Registro entities that
     * are retrieved from Usuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Registro page
     */
    public String navigateRegistroList() {
        if (this.getSelecionado() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Registro_items", this.getSelecionado().getRegistroList());
        }
        return "/registro/index";
    }

}
