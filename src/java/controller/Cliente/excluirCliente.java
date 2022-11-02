package controller.Cliente;

import dao.ClienteDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "excluirCliente", urlPatterns = {"/excluirCliente"})
public class excluirCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int idCliente = Integer.parseInt(request.getParameter("idcliente"));
            ClienteDAO clientedao = new ClienteDAO();
            clientedao.excluir(idCliente);
            request.setAttribute("mensagem", "Excluído com sucesso!");
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }

        request.getRequestDispatcher("listarCliente").forward(request, response);
    }
}
