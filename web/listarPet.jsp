<%@page import="model.Pessoa"%>
<%@page import="controller.Img.imagem"%>
<%@page import="java.io.File"%>
<%@page import="model.Pet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
        <title>Pet - 4patas</title>
        <link href="css/maisPet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 
        <%
            Pessoa usuario = (Pessoa) session.getAttribute("usuario");
        %>
        <div class="body">
            <form action="CadastrarAdocao" method="post" enctype="multipart/form-data" multiple=webkitdirectory=''>
                <div class="tudo">            
                    <input type="text" name="idAdocao" hidden/>
                    <%
                        if (usuario != null) {
                    %>
                    <input value="<%=usuario.getIdPessoa()%>" name="idPessoa" hidden/>
                    <%
                        } else {
                            response.sendRedirect("login_cadastro.jsp");
                        }
                    %>
                    <input type="text" name="idPet" value="${pet.idPet}" hidden/>
                    <div class="text">
                        <h1 class="">${pet.nomePet}</h1>
                        <input type="text" name="nomepet" value="${pet.nomePet}" hidden/>
                    </div>
                    <div>                    
                        <img src="imagem/${pet.nomeImg}" alt=""/>

                        <input type="text" name="nomeImg" value="${pet.nomeImg}" hidden/>
                    </div>
                    <div class="infos"> 
                        <p class="text">Raça: ${pet.racaPet}</p>
                        <p class="text">Idade: ${pet.idadePet}</p>
                        <p class="text">Espécie: ${pet.especiePet}</p>
                        <p class="text">Cores: ${pet.coresPet}</p>
                        <p class="text">Sexo: ${pet.sexoPet}</p>
                        <p class="text">Porte: ${pet.portePet}</p>
                        <p class="text">Observações: ${pet.observacoes}</p>
                    </div>
                    <div class="">
                        <a href="listarPet" class="btn">Voltar</a>
                        <button class="btn" type="submit">Adotar</button>
                    </div>            
                </div> 
            </form>
        </div>
    </body>
</html>
