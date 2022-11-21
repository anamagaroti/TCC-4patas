<%@page import="model.Pet"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>Adotados</title>
    </head>
    <body>
        <h1>Adotados</h1>

        <% List<Pet> lista = (List<Pet>) request.getAttribute("pets"); %>

        <div class="row row-cols-2 row-cols-md-3 col-10">
            <%
                for (Pet pet : lista) {
                    if (pet.isAdocao() == true) {
            %>
            <div class="col">
                <div class="card">            
                    <img class="card-img-top" src="<%= (String) request.getContextPath() + "/imagem/" + pet.getNomeImg()%>"/> 
                    <div class="card-body">
                        <h5 class="card-title"><%= pet.getNomePet()%></h5>
                        <p class="card-text"><%= pet.getObservacoes()%></p>
                    </div>
                </div>
            </div>
            <%
                    }
                }
            %> 
        </div>   
    </body>
</html>
