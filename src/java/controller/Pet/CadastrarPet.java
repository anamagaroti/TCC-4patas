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
import javax.servlet.http.HttpSession;
import model.Pessoa;
import model.Pet;

@MultipartConfig
@WebServlet(name = "CadastrarPet", urlPatterns = {"/CadastrarPet"})
public class CadastrarPet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            request.setCharacterEncoding("UTF-8");
            int idPet = request.getParameter("idPet").isEmpty() ? 0 : Integer.parseInt(request.getParameter("idPet"));
            int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
            String nomePet = request.getParameter("nomePet");
            String racaPet = request.getParameter("racaPet");
            String idadePet = request.getParameter("idadePet");
            String especiePet = request.getParameter("especiePet");
            String coresPet = request.getParameter("coresPet");
            String sexoPet = request.getParameter("sexoPet");
            String portePet = request.getParameter("portePet");
            String observacoes = request.getParameter("observacoes");
            
            request.getRequestDispatcher("imagem").include(request, response);
            String nomeImg = (String) request.getAttribute("nomeImg");
            
           Pet pet = new Pet(idPet, new Pessoa(idPessoa),  nomeImg, nomePet, racaPet, 
           idadePet, especiePet, coresPet, sexoPet, portePet, observacoes, false, false); //doar é a logica do confirmação de cadastro.
            
           PetDAO petDAO = new PetDAO();
            
           petDAO.cadastrar(pet);
            request.setAttribute("mensagem", "Gravado com sucesso!");

        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        
        HttpSession sessao = request.getSession(true);
        Pessoa usuario = (Pessoa) sessao.getAttribute("usuario");
        
        if("funcionario".equals(usuario.getLogouPessoa())){
            request.getRequestDispatcher("ListaDoacoes").forward(request, response);
        }else{
            request.getRequestDispatcher("pedidoDoacao.jsp").forward(request, response);
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