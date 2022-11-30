package controller.Pessoa;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;

@MultipartConfig
@WebServlet(name = "EditarPessoa", urlPatterns = {"/EditarPessoa"})
public class EditarPessoa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
            int idPessoa = request.getParameter("idPessoa").isEmpty() ? 0 : Integer.parseInt(request.getParameter("idPessoa"));
            PessoaDAO pessoadao = new PessoaDAO();
            Pessoa pe = (Pessoa) pessoadao.adotar(idPessoa);

            String imagem = request.getParameter("imagem");
            if (imagem == null || !imagem.equals(pe.getNomeImg())) {
                request.getRequestDispatcher("imagem").include(request, response);
                pe.setNomeImg((String) request.getAttribute("nomeImg"));
            } else {
                pe.setNomeImg(imagem);
            }
            pe.setNomePessoa((String) request.getParameter("nomePessoa"));
            pe.setCpfPessoa((String) request.getParameter("cpfPessoa"));
            pe.setDataNascimentoPessoa((String) request.getParameter("dataNascimentoPessoa"));
            pe.setCepPessoa((String) request.getParameter("cepPessoa"));
            pe.setCidadePessoa((String) request.getParameter("cidadePessoa"));
            pe.setBairroPessoa((String) request.getParameter("bairroPessoa"));
            pe.setRuaPessoa((String) request.getParameter("ruaPessoa"));
            pe.setNumeroPessoa((String) request.getParameter("numeroPessoa"));
            pe.setComplementoPessoa((String) request.getParameter("complementoPessoa"));
            pe.setEstadoPessoa((String) request.getParameter("estadoPessoa"));
            pe.setTelefonePessoa((String) request.getParameter("telefonePessoa"));
            pe.setEmailPessoa((String) request.getParameter("emailPessoa"));
            pe.setGeneroPessoa((String) request.getParameter("generoPessoa"));
            pe.setSenhaPessoa((String) request.getParameter("senhaPessoa"));

            PessoaDAO pedao = new PessoaDAO();
            pedao.editar(pe);

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
