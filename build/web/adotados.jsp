<%@page import="model.Adocao"%>
<%@page import="model.Pet"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/logo_navegador.jpeg">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>Adotados</title>
    </head>
    <body style="background-color: #EDD4AB;">
        <div style="display: flex; ">
            <a style="margin-left: 20em; margin-top: 15px; color: black; text-decoration: none;" href="listarPet">< Voltar</a>
            <h1 style="color: rgb(94, 50, 20); margin-left: 15rem; margin-bottom: 3rem;">Doações</h1>
        </div>

        <% List<Adocao> lista = (List<Adocao>) request.getAttribute("adocoes"); %>
        <div  style="display: flex; justify-content: center;">
            <div class="row row-cols-2 row-cols-md-3 col-10">
                <%
                    for (Adocao ado : lista) {
                        if (ado.isAdotado() == true) {
                %>
                <div class="col" style="margin-bottom: 10px;">
                    <div class="card">            
                        <img class="card-img-top" style="object-fit: cover" width="150rem" height="150rem" src="<%= (String) request.getContextPath() + "/imagem/" + ado.getPet().getNomeImg()%>"/> 
                        <div class="card-body">
                            <h5 class="card-title"><%= ado.getPet().getNomePet()%></h5>
                            <p class="card-text"><%= ado.getPet().getObservacoes()%></p>
                            <p class="card-text">Adotado por: <%=ado.getPessoa().getNomePessoa()%></p>
                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                %> 
            </div>  
        </div>
    </body>
</html>
