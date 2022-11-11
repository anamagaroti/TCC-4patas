package controller.Cliente;

import TratamentoErros.Erros;
import dao.ClienteDAO;
import dao.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Pessoa;

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
            String nomeImg = (String) request.getAttribute("nomeImg");
            
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
            String confirmarSenha = request.getParameter("confirmarSenha");
            String generoPessoa = request.getParameter("generoCliente");
            
            
            Cliente cliente = new Cliente (idCliente, nomeImg, nomePessoa, cpfPessoa, dataNascimentoPessoa, cepPessoa, 
            cidadePessoa, bairroPessoa, ruaPessoa, numeroPessoa, complementoPessoa, estadoPessoa, telefonePessoa, 
            emailPessoa, generoPessoa, senhaPessoa, "Cliente");
           
            ClienteDAO clientedao = new ClienteDAO();
            
            PessoaDAO pessoadao = new PessoaDAO();
            Pessoa usuario = (Pessoa) pessoadao.consultar(emailPessoa); 
            
            if(usuario != null){ 
                Erros erro = new Erros();
                erro.validaEmail();
            }else if(!senhaPessoa.equals(confirmarSenha)){

                Erros erro = new Erros();
                erro.confirmarSenha();
            }else{            
            clientedao.cadastrar(cliente);
            request.setAttribute("mensagem", "Gravado com sucesso!");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
    
        request.getRequestDispatcher("login_cadastro.jsp").forward(request, response);
        
    }
      @Override
    public String getServletInfo() {
        return "Short description";
    }
}
       