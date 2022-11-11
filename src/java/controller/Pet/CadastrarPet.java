package controller.Pet;

import dao.PetDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Pet;

@MultipartConfig
@WebServlet(name = "CadastrarPet", urlPatterns = {"/CadastrarPet"})
public class CadastrarPet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            int idPet = request.getParameter("idpet").isEmpty() ? 0 : Integer.parseInt(request.getParameter("idpet"));
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            String nomePet = request.getParameter("nomepet");
            String racaPet = request.getParameter("racapet");
            String idadePet = request.getParameter("idadepet");
            String especiePet = request.getParameter("especiepet");
            String coresPet = request.getParameter("corespet");
            String sexoPet = request.getParameter("sexopet");
            String portePet = request.getParameter("portepet");
            String observacoes = request.getParameter("observacoes");
            
            request.getRequestDispatcher("imagem").include(request, response);
            String nomeImg = (String) request.getAttribute("nomeImg");
            
           Pet pet = new Pet(idPet, new Cliente(idCliente), nomeImg, nomePet, racaPet, idadePet, especiePet, coresPet, sexoPet, portePet, observacoes);
            
           PetDAO petDAO = new PetDAO();
            
           petDAO.cadastrar(pet);
            request.setAttribute("mensagem", "Gravado com sucesso!");

        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        
        request.getRequestDispatcher("listarPet").forward(request, response);
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