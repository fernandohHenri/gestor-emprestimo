package com.emprestimo.gestor.filter;

import com.emprestimo.gestor.controller.UsuarioSessao;
import com.emprestimo.gestor.model.Navegacao;
import com.emprestimo.gestor.model.Usuario;
import com.emprestimo.gestor.controller.NavegacaoController;
import com.emprestimo.gestor.controller.UsuarioController;
import com.emprestimo.gestor.repository.NavegacaoFacade;
import com.emprestimo.gestor.repository.UsuarioFacade;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.Date;

@WebFilter(urlPatterns = "*.xhtml", servletNames = "{Faces Servlet}")
public class AutorizacaoFilter implements Filter {

    @Inject
    private UsuarioSessao autenticacao;

    @Inject
    private NavegacaoFacade navegacoes;

    @Inject
    private UsuarioFacade usuarios;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        if (!autenticacao.isLogado() && !request.getRequestURI().endsWith("/login.xhtml")
                && !request.getRequestURI().endsWith("/recuperar-senha.xhtml")
                && !request.getRequestURI().contains("/javax.faces.resource/")) {
            response.sendRedirect(request.getContextPath() + "/login.xhtml");
        } else {
            if (autenticacao.isLogado() && !request.getRequestURI().contains("/javax.faces.resource/")) {
                
                Usuario us = usuarios.porMatricula(autenticacao.getMatricula());
                this.registraNavegacao(request.getRequestURI(), us);
            }
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }

    private void registraNavegacao(String pagina, Usuario usuario) {
        
        try{
            
            Navegacao navegacao = new Navegacao();
            navegacao.setData(new Date());
            navegacao.setUsuarioIdusuario(usuario);
            navegacao.setPagina(pagina);

            navegacoes.create(navegacao);
        } catch(NullPointerException npe){
            System.out.println("Erro ao registrar navegação");
        }
    }
}
