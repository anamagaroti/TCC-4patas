package controller.Adocao;

import dao.ClienteDAO;
import dao.PetDAO;
import dao.adocaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "consultarAdocao", urlPatterns = {"/consultarAdocao"})
public class consultarAdocao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int idAdocao = Integer.parseInt(request.getParameter("idPet"));

            adocaoDAO adocaodao = new adocaoDAO();

            request.setAttribute("adocoes", adocaodao.consultar(idAdocao));
            request.setAttribute("pets", new PetDAO().listar());
            request.setAttribute("clientes", new ClienteDAO().listar());

        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.getRequestDispatcher("Adocao.jsp").forward(request, response);
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
