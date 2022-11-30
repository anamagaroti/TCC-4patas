package controller.Adocao;

import dao.adocaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listarAdocao", urlPatterns = {"/listarAdocao"})
public class listarAdocao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String pagina = request.getParameter("pagina") == null ? "adocao" : request.getParameter("pagina");
        try {
            adocaoDAO adocaodao = new adocaoDAO();
            request.setAttribute("adocoes", adocaodao.listar());
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        if (pagina.equals("adocao")) {
            request.getRequestDispatcher("listaAdocao.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("adotados.jsp").forward(request, response);
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
