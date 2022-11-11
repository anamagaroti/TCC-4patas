package controller.Login;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.spec.XPathType.Filter;
import model.Usuario;

@WebServlet(name = "Filtro", 
        urlPatterns = {"/Filtro"})

public class Filtro implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession sessao = req.getSession(false);
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        if(usuario != null) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("listarPet").forward(request, response);
        }
    }
}
