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
import model.Adocao;

@WebServlet(name = "AdocaoConfirmada", urlPatterns = {"/AdocaoConfirmada"})
public class AdocaoConfirmada extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int idAdocao = Integer.parseInt(request.getParameter("idAdocao"));
            adocaoDAO adocaodao = new adocaoDAO();
            Adocao adocao = (Adocao) adocaodao.consultar(idAdocao);
            
            if (adocao.isAdotado() == false) {
                
                adocao.setAdotado(true);

                adocaoDAO ado = new adocaoDAO();

                ado.cadastrar(adocao);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarAdocao.class.getName()).log(Level.SEVERE, null, ex);
        }
            request.getRequestDispatcher("ListarAdotados").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
