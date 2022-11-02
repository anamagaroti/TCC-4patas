package controller.Cliente;

import dao.ClienteDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

@MultipartConfig
@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastrarCliente"})
public class CadastrarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try {
            int idCliente = request.getParameter("idpessoa").isEmpty() ? 0 : Integer.parseInt(request.getParameter("idpessoa"));
            
            request.getRequestDispatcher("imagem").include(request, response);
            String imagem = (String) request.getAttribute("nomeImg");
            
            String nomePessoa = request.getParameter("nomeCliente");
            String cpfPessoa = request.getParameter("cpfCliente");
            String dataNascimentoPessoa = request.getParameter("dataNascimentoCliente");
            String cepPessoa = request.getParameter("cepCliente");
            String cidadePessoa = request.getParameter("cidadeCliente");
            String bairroPessoa = request.getParameter("bairroCliente");
            String ruaPessoa = request.getParameter("ruaCliente");
            String numeroPessoa = request.getParameter("numeroCliente");
            String complementoPessoa = request.getParameter("complementoCliente");           
            String estadoPessoa = request.getParameter("estadoCliente");          
            String telefonePessoa = request.getParameter("telefoneCliente");
            String emailPessoa = request.getParameter("emailCliente");
            String senhaPessoa = request.getParameter("senhaCliente");
            String generoPessoa = request.getParameter("generoCliente");
           
            
            
            Cliente cliente = new Cliente (idCliente, imagem, nomePessoa, cpfPessoa, dataNascimentoPessoa, cepPessoa, 
            cidadePessoa, bairroPessoa, ruaPessoa, numeroPessoa, complementoPessoa, estadoPessoa, telefonePessoa, 
            emailPessoa, generoPessoa, senhaPessoa, "Cliente");
            
            ClienteDAO clientedao = new ClienteDAO();
            
            clientedao.cadastrar(cliente);
            
            request.setAttribute("mensagem", "Gravado com sucesso!");
    
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        
        request.getRequestDispatcher("Login").forward(request, response);

    }
      @Override
    public String getServletInfo() {
        return "Short description";
    }
}
       