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

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //String parametro = request.getParameter("pets");  
         //            if(parametro.equals("ListaTodos")) {
     //                   ListaTodos todos = new ListaTodos();
     //                todos.todos(request, response);
     //                
     //        }else if(parametro.equals("ListaCachorro")) {
     //             ListaCachorro cachorro = new ListaCachorro();
     //                cachorro.cachorro(request, response);
     //       }else if(parametro.equals("ListaGato")) {
     //               ListaGato gato = new ListaGato();
     //               gato.gato(request, response);
     //       }else{
           
           try {
                
                 PetDAO petdao = new PetDAO();
                 request.setAttribute("pets", petdao.listar());
            }         
             catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(listarPet.class.getName()).log(Level.SEVERE, null, ex);
            }     
            
        request.getRequestDispatcher("index.jsp").forward(request, response);

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
