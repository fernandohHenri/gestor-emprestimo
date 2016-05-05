package com.emprestimo.gestor.controller;

import com.emprestimo.gestor.model.Emprestimo;
import com.emprestimo.gestor.model.Registro;
import static com.emprestimo.gestor.model.Registro_.emprestimoIdemprestimo;
import com.emprestimo.gestor.model.Usuario;
import com.emprestimo.gestor.repository.EmprestimoFacade;
import com.emprestimo.gestor.repository.RegistroFacade;
import com.emprestimo.gestor.repository.UsuarioFacade;
import java.util.Date;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "emprestimoController")
@ViewScoped
public class EmprestimoController extends AbstractController<Emprestimo> {

    @Inject
    private AgenciaController agenciaCodAgenciaController;

    @Inject
    private FaseController faseIdfasesController;

    @Inject
    private PorteController porteIdporteController;

    @Inject
    private RegistroFacade registros;

    @Inject
    private EmprestimoFacade emprestimos;
    
    @Inject
    private UsuarioSessao userSessao;
    
    @Inject
    private UsuarioFacade usuarios;

    public EmprestimoController() {
        // Inform the Abstract parent controller of the concrete Emprestimo Entity
        super(Emprestimo.class);
    }

    public void resetParents() {
        agenciaCodAgenciaController.setSelecionado(null);
        faseIdfasesController.setSelecionado(null);
        porteIdporteController.setSelecionado(null);
    }

    public void prepareAgenciaCodAgencia(ActionEvent event) {
        if (this.getSelecionado() != null && agenciaCodAgenciaController.getSelecionado() == null) {
            agenciaCodAgenciaController.setSelecionado(this.getSelecionado().getAgenciaCodAgencia());
        }
    }

    public void prepareFaseIdfases(ActionEvent event) {
        if (this.getSelecionado() != null && faseIdfasesController.getSelecionado() == null) {
            faseIdfasesController.setSelecionado(this.getSelecionado().getFaseIdfases());
        }
    }

    public void preparePorteIdporte(ActionEvent event) {
        if (this.getSelecionado() != null && porteIdporteController.getSelecionado() == null) {
            porteIdporteController.setSelecionado(this.getSelecionado().getPorteIdporte());
        }
    }

    public String navigateRegistroList() {
        if (this.getSelecionado() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Registro_items", this.getSelecionado().getRegistroList());
        }
        return "/registro/index";
    }

    public void save(ActionEvent event) {

        String msg = "Cadastro Realizado com sucesso!";
        emprestimos.create(this.getSelecionado());

        Usuario usuario = this.usuarios.porMatricula(userSessao.getMatricula());
        Registro registro = new Registro();
        registro.setUsuarioIdusuario(usuario);
        registro.setData(new Date());
        registro.setEmprestimoIdemprestimo(this.getSelecionado());
        registro.setOperacao("criou");
        
        registros.create(registro);
        
        
    }

}
