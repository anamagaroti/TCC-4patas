package controller.Funcionario;

import TratamentoErros.Erros;
import model.Funcionario;
import dao.FuncionarioDAO;
import dao.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;

@MultipartConfig
@WebServlet(name = "CadastrarFuncionario", urlPatterns = {"/CadastrarFuncionario"})
public class CadastrarFuncionario extends HttpServlet {

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
        processRequest(request, response);
        
          try {
            int idFuncionario = request.getParameter("idFuncionario").isEmpty() 
                    ? 0 : Integer.parseInt(request.getParameter("idFuncionario"));
            String nomePessoa = request.getParameter("nomePessoa");            
            String cpfPessoa = request.getParameter("cpfPessoa");
            String dataNascimentoPessoa = request.getParameter("dataNascimentoPessoa");
            String cepPessoa = request.getParameter("cepPessoa");            
            String cidadePessoa = request.getParameter("cidadePessoa");
            String bairroPessoa = request.getParameter("bairroPessoa");
            String ruaPessoa = request.getParameter("ruaPessoa");
            String numeroPessoa = request.getParameter("numeroPessoa");
            String complementoPessoa = request.getParameter("complementoPessoa");
            String estadoPessoa = request.getParameter("estadoPessoa");          
            String telefonePessoa = request.getParameter("telefonePessoa");
            String emailPessoa = request.getParameter("emailPessoa");
            String generoPessoa = request.getParameter("generoPessoa"); 
            String senhaPessoa = request.getParameter("senhaPessoa");
            String confirmarSenha = request.getParameter("confirmarSenha");
            String cargo = request.getParameter("cargo");
            
            
            request.getRequestDispatcher("imagem").include(request, response);
            String nomeImg = (String) request.getAttribute("nomeImg");
            
            Funcionario funcionario = new Funcionario(idFuncionario, nomeImg, nomePessoa, cpfPessoa,  dataNascimentoPessoa, cepPessoa, 
            cidadePessoa, bairroPessoa, ruaPessoa, numeroPessoa, complementoPessoa, estadoPessoa,  telefonePessoa, emailPessoa, generoPessoa, 
            senhaPessoa, "funcionario", cargo);

            
            FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
            
            PessoaDAO pessoadao = new PessoaDAO();
            Pessoa usuario = (Pessoa) pessoadao.consultar(emailPessoa); 
            
            if(usuario != null){ 
                Erros erro = new Erros();
                erro.validaEmail();
            }else if(!senhaPessoa.equals(confirmarSenha)){

                Erros erro = new Erros();
                erro.confirmarSenha();
            }else{            
            FuncionarioDAO.cadastrar(funcionario);
            request.setAttribute("mensagem", "Gravado com sucesso!");
            }
 
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        
        request.getRequestDispatcher("ListarFuncionario").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}