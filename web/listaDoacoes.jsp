<%@page import="model.Pessoa"%>
<%@page import="model.Pet"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pets para doação</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            HttpSession sessao = request.getSession(true);
            Pessoa usuario = (Pessoa) sessao.getAttribute("usuario");
            List<Pet> lista = (List<Pet>) request.getAttribute("doacoes");
        %>
        <div class="row row-cols-2 row-cols-md-3 col-10">
            <%
                for (Pet pet : lista) {
                if(pet.isAdocao() == false){
            %>
            <div class="col">
                <div class="card">            
                    <img width="150rem" src="imagem/<%=pet.getNomeImg()%>" 
                         <div class="card-body">
                    <h5 class="card-title"><%=pet.getNomePet()%></h5>
                    <p class="card-text"><%=pet.getPessoa().getNomePessoa()%></p>
                    <p hidden><%=pet.getPessoa().getIdPessoa()%></p>
                    <!-- Button trigger modal -->
                    <a class="btn-lista" href="consultarPet?idPet=<%=pet.getIdPet()%>">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                            Ver mais 
                        </button>  
                    </a>
                </div>
            </div>
            <%
                }}
            %> 
        </div>           
    </body>
</html>
