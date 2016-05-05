package com.emprestimo.gestor.controller;


import com.emprestimo.gestor.model.Usuario;
import com.emprestimo.gestor.repository.UsuarioFacade;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("loginBean")
@RequestScoped
public class LoginController {

    @Inject
    private UsuarioFacade usuarios;

    @Inject
    private UsuarioSessao usuarioSessao;

    private String nomeUsuario;
    private String senha;
    private String matricula;

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();

        Usuario usuario = usuarios.login(nomeUsuario, senha);

        if (usuario != null) {
            usuarioSessao.setNome(usuario.getApelido());
            usuarioSessao.setMatricula(usuario.getMatricula());
            usuarioSessao.setTipoUsuario(usuario.getTipoUsuario());
            System.out.println("Salvo usuario sessão " + usuarioSessao.getMatricula());
            return "/index?faces-redirect=true";
        } else {
            FacesMessage mensagem = new FacesMessage("Usuário/senha inválidos!");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }

        return null;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login?faces-redirect=true";
    }

    public void buscarSenha() {
        Usuario usuario = usuarios.recuperarSenha(nomeUsuario, matricula);
        
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage("Senha = " + usuario.getSenha());
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, mensagem);
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
