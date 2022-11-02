package controller.Adocao;

import dao.adocaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Adocao;
import model.Cliente;
import model.Funcionario;
import model.Pet;

@WebServlet(name = "CadastrarAdocao", urlPatterns = {"/CadastrarAdocao"})
public class CadastrarAdocao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       try {
            int idAdocao = request.getParameter("idAdocao").isEmpty() ? 0 : Integer.parseInt(request.getParameter("idAdocao"));
            String dataAdocao = request.getParameter("dataAdocao");
            String horarioAdocao = request.getParameter("horarioAdocao") + ":00";
            int idPet = Integer.parseInt(request.getParameter("idPet"));
            int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            
            Adocao adocao = new Adocao(idAdocao, dataAdocao, horarioAdocao, 
                    new Pet(idPet), new Funcionario(idFuncionario), new Cliente(idCliente));

            adocaoDAO adocaodao = new adocaoDAO();

            adocaodao.cadastrar(adocao);

            request.setAttribute("mensagem", "Adoção gravada com sucesso!");
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.getRequestDispatcher("ListarConsulta").forward(request, response);
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
