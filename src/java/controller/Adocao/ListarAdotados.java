package controller.Adocao;

import dao.adocaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarAdotados", urlPatterns = {"/ListarAdotados"})
public class ListarAdotados extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        String pagina = request.getParameter("pagina") == null ? "adotados" : request.getParameter("pagina");
        try {           
            adocaoDAO adocaodao = new adocaoDAO();
            request.setAttribute("adocoes", adocaodao.listar());
        } catch (SQLException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarAdotados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (pagina.equals("adotados")) {
            request.getRequestDispatcher("adotados.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarAdotados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarAdotados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
