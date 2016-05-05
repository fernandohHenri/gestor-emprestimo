package com.emprestimo.gestor.controller;


import com.emprestimo.gestor.model.Registro;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "registroController")
@ViewScoped
public class RegistroController extends AbstractController<Registro> {

    @Inject
    private EmprestimoController emprestimoIdemprestimoController;
    @Inject
    private UsuarioController usuarioIdusuarioController;

    public RegistroController() {
        // Inform the Abstract parent controller of the concrete Registro Entity
        super(Registro.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        emprestimoIdemprestimoController.setSelecionado(null);
        usuarioIdusuarioController.setSelecionado(null);
    }

    /**
     * Sets the "selected" attribute of the Emprestimo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEmprestimoIdemprestimo(ActionEvent event) {
        if (this.getSelecionado() != null && emprestimoIdemprestimoController.getSelecionado() == null) {
            emprestimoIdemprestimoController.setSelecionado(this.getSelecionado().getEmprestimoIdemprestimo());
        }
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUsuarioIdusuario(ActionEvent event) {
        if (this.getSelecionado() != null && usuarioIdusuarioController.getSelecionado() == null) {
            usuarioIdusuarioController.setSelecionado(this.getSelecionado().getUsuarioIdusuario());
        }
    }
}
