package controller.Pet;

import dao.PetDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listarPet", urlPatterns = {"/listarPet"})
public class listarPet extends HttpServlet {

    @SuppressWarnings("ConvertToStringSwitch")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String pagina = request.getParameter("pagina") == null ? "index" : request.getParameter("pagina");
        try {
            String tipoListagem = request.getParameter("todos");

            if ("cachorro".equals(tipoListagem)) {
                PetDAO petdao = new PetDAO();
                request.setAttribute("pets", petdao.listarCachorro());
            } else if ("gato".equals(tipoListagem)) {
                PetDAO petdao = new PetDAO();
                request.setAttribute("pets", petdao.listarGato());
            } else {
                PetDAO petdao = new PetDAO();
                request.setAttribute("pets", petdao.listar());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(listarPet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (pagina.equals("index")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
