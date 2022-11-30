package controller.Img;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig
@WebServlet(name = "imagem", urlPatterns = {"/imagem"})
public class imagem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            request.setCharacterEncoding("UTF-8");
            String caminho = "C:/Users/ficav/OneDrive/Área de Trabalho/4patas/web/imagem" + "/";

            File diretorio = new File(caminho);
            if (!diretorio.exists()) {
                diretorio.mkdir();
            }

            try {

                Part filePart = request.getPart("imagem");
                String filename = filePart.getSubmittedFileName();

                if (filename == null) {
                    filename = request.getParameter("imagem");
                }

                if (filename != null) {
                    OutputStream os = null;
                    InputStream is = null;

                    File filePath = new File(caminho, filename);

                    if (!filePart.getSubmittedFileName().endsWith(".png") && !filePart.getSubmittedFileName().endsWith(".jpg") 
                            && !filePart.getSubmittedFileName().endsWith(".jpeg") && 
                            !filePart.getSubmittedFileName().endsWith(".webp")) {
                        request.setAttribute("erro", "Seu arquivo não foi aceito");
                    } else {

                        if (!filePath.exists()) {

                            os = new FileOutputStream(filePath);
                            is = filePart.getInputStream();

                            int read = 0;
                            while ((read = is.read()) != -1) {
                                os.write(read);
                            }
                        }
                    }
                } else {
                    filename = null;
                }

                request.setAttribute("nomeImg", filename);
            } catch (FileNotFoundException | NullPointerException ex) {
                Logger.getLogger(imagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
