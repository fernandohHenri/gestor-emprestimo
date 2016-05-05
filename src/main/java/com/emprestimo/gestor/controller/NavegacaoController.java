package com.emprestimo.gestor.controller;

import com.emprestimo.gestor.model.Navegacao;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "navegacaoController")
@ViewScoped
public class NavegacaoController extends AbstractController<Navegacao> {

    @Inject
    private UsuarioController usuarioController;

    public NavegacaoController() {
        super(Navegacao.class);
    }
    
    public void resetParents() {
        usuarioController.setSelecionado(null);
    }
    
    public void preparaUsuario(ActionEvent event) {
        if (this.getSelecionado() != null && usuarioController.getSelecionado() == null) {
            usuarioController.setSelecionado(this.getSelecionado().getUsuarioIdusuario());
        }
    }
}
