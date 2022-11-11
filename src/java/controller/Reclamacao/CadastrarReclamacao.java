package controller.Reclamacao;

import dao.ReclamacaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Funcionario;
import model.Reclamacao;

@WebServlet(name = "CadastrarReclamacao", urlPatterns = {"/CadastrarReclamacao"})
public class CadastrarReclamacao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try {
            int idReclamacao = request.getParameter("idreclamacao").isEmpty() 
                    ? 0 : Integer.parseInt(request.getParameter("idreclamacao"));
            String Reclamacao = request.getParameter("reclamacao");
            int idCliente = Integer.parseInt(request.getParameter("idcliente"));
            
            Reclamacao reclamacao = new Reclamacao (idReclamacao, Reclamacao, new Cliente(idCliente));

            ReclamacaoDAO reclamacaodao = new ReclamacaoDAO();

            reclamacaodao.cadastrar(reclamacao);

            request.setAttribute("mensagem", "reclamação gravada com sucesso!");
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        
        Funcionario func = new Funcionario();
        
        if(func.getLogouPessoa().equals("funcionario")){
            request.getRequestDispatcher("listarReclamacoes").forward(request, response);
        }else{
            request.getRequestDispatcher("listarPet").forward(request, response);
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
    }
}
