<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reclamação usuário</title>
        <link rel="shortcut icon" href="img/logo_navegador.jpeg">
        <link rel="stylesheet" href="css/stylereclamar">
    </head>
    <body     style="background-color: blanchedalmond; display: grid;
              justify-content: center; overflow:">
        <%
            Pessoa usuario = (Pessoa) session.getAttribute("usuario");

            if (usuario == null) {
                response.sendRedirect("login_cadastro.jsp");
            }
        %>
        <form action="CadastrarReclamacao" method="post">
            <div style="border: solid black 3px; width: 600px; height: 550px;
                 background-color: brown; height:100%">
                <h1 style=" text-align: center; color: white  ">Relatar um problema</h1>

                <input name="idreclamacao" id="idreclamacao" hidden/>
                <input name="idcliente" value="<%=usuario.getIdPessoa()%>" hidden/>
                <div style="display: flex; justify-content: center;">
                    <textarea  name="reclamacao" rows="25" cols="60" 
                               placeholder="Descreva brevemente o que aconteceu"></textarea>
                </div>


                <div style=" text-align: center;
                     position: relative;
                     top: 30px;
                     right: 0px
                     ">

                    <button     type="submit"style="width: 130px;
                                height: 40px;">Enviar Relato</button>

                </div>

            </div> 
            <img  style=" height: 300px; position: relative;
                  left :41em; bottom: 670px;  "   src="img/kisspng-dog-cartoon-cartoon-space-dog-5a9bc66d098d94.2522703315201583170391.png"  alt="...">

        </form>
    </body>
</html>
