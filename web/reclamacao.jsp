<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reclamação usuário</title>
    </head>
    <body>
        <%
            Pessoa usuario = (Pessoa) session.getAttribute("usuario");

            if (usuario == null) {
                response.sendRedirect("login_cadastro.jsp");
            }
        %>
        <form action="CadastrarReclamacao" method="post">
            <div>
                <h1>Relatar um problema</h1>
                <input name="idreclamacao" id="idreclamacao" hidden/>
                <input name="idcliente" value="<%=usuario.getIdPessoa()%>" hidden/>
                <textarea id="reclamacoes" name="reclamacao" rows="25" cols="60" 
                    placeholder="Descreva brevemente o que aconteceu"></textarea>
                <div>
                    <button type="submit">Enviar relato</button>
                </div>
            </div> 
        </form>
    </body>
</html>
