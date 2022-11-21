package controller.Login;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pessoa;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            
            String emailUsuario = request.getParameter("emailUsuario");
            String senhaUsuario = request.getParameter("senhaUsuario");
            
            PessoaDAO pessoadao = new PessoaDAO();
            Pessoa usuario = (Pessoa) pessoadao.consultar(emailUsuario);
            
            ClienteDAO cliDAO = new ClienteDAO();
            Pessoa cli = (Pessoa) cliDAO.consultar(usuario.getIdPessoa());
            
            FuncionarioDAO funcDAO = new FuncionarioDAO();
            Pessoa func = (Pessoa) funcDAO.consultar(usuario.getIdPessoa());
            
            
            
            boolean loginSucesso = false;
            
            if(func != null && usuario.getSenhaPessoa().equals(senhaUsuario)){
            
                loginSucesso = true;
            } else if(cli != null && usuario.getSenhaPessoa().equals(senhaUsuario)){       
                loginSucesso = true;
            }  
            if(loginSucesso == true) {
                HttpSession sessao = request.getSession(true);
                sessao.setAttribute("usuario", usuario);
                sessao.setMaxInactiveInterval(-1);
                
                request.getRequestDispatcher("/").forward(request, response);
            } 
            else {
                request.setAttribute("mensagem", "Email ou senha estão incorretos!");
                request.getRequestDispatcher("login_cadastro.jsp").forward(request, response);
            }           
            } catch(SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
            request.getRequestDispatcher("login_cadastro.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
