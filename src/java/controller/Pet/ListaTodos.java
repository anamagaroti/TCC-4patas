
package controller.Pet;

import dao.PetDAO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaTodos {
       
        public void todos(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException{           
            
            PetDAO petdao = new PetDAO();
            
            request.setAttribute("pets", petdao.listar());
            
        }
}
