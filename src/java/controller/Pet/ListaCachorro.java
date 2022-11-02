
package controller.Pet;

import dao.PetDAO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaCachorro {
    public void cachorro(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException{           
            
            PetDAO petdao = new PetDAO();
            
            request.setAttribute("pets", petdao.listarCachorro());
            
        }
}
