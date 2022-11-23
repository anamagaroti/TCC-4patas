package controller.Adocao;

import dao.PetDAO;
import dao.adocaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Adocao;
import model.Pessoa;
import model.Pet;

@MultipartConfig
@WebServlet(name = "CadastrarAdocao", urlPatterns = {"/CadastrarAdocao"})
public class CadastrarAdocao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int idAdocao = request.getParameter("idAdocao").isEmpty()
                ? 0 : Integer.parseInt(request.getParameter("idAdocao"));
        int idPet = Integer.parseInt(request.getParameter("idPet"));
        int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
        
        try {
            Adocao adocao = new Adocao(idAdocao, new Pessoa(idPessoa), new Pet(idPet), false);

            adocaoDAO adocaodao = new adocaoDAO();
            
            adocaodao.cadastrar(adocao);
            
            request.setAttribute("mensagem", "Adoção gravada com sucesso!");
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }

        try {

            PetDAO petdao = new PetDAO();

            Pet pet = (Pet) petdao.consultar(idPet);

            pet.setAdocao(true);

            PetDAO petDAO = new PetDAO();

            petDAO.cadastrar(pet);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarAdocao.class.getName()).log(Level.SEVERE, null, ex);
        }

        HttpSession sessao = request.getSession(true);
        Pessoa usuario = (Pessoa) sessao.getAttribute("usuario");

        if ("funcionario".equals(usuario.getLogouPessoa())) {
            request.getRequestDispatcher("listarAdocao").forward(request, response);
        } else {
            request.getRequestDispatcher("pedidoAdocao.jsp").forward(request, response);
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
