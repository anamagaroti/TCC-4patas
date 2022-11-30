<%@page import="model.Adocao"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Pet"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/logo_navegador.jpeg">
        <link href="css/pedidosAdocao.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>Pets para doação</title>
    </head>
    <body style="background-color: #EDD4AB;">          
        <%
            List<Adocao> lista = (List<Adocao>) request.getAttribute("adocoes");
        %>
        <div style="display: flex; ">
            <a style="margin-left: 20em; margin-top: 15px; color: black; text-decoration: none;" href="listarPet">< Voltar</a>
            <h1 style="color: rgb(94, 50, 20); margin-left: 15rem; margin-bottom: 5rem;">Doações</h1>
        </div>
        <div class="tudo">
            <div class="row row-cols-2 row-cols-md-3 col-10">
                <%
                    for (Adocao adocao : lista) {
                        if (adocao.isAdotado() == false) {
                %>
                <div class="col" style="padding-bottom: 10px;">
                    <div class="card">     

                        <img style="object-fit: cover" width="150rem" height="150rem" class="card-img-top" src="imagem/<%=adocao.getPet().getNomeImg()%>"/>
                        <div class="card-body">
                            <div  style="padding: 5px;">
                                <h5 class="card-title"><%=adocao.getPet().getNomePet()%></h5>
                                <p class="card-text">Doador: <%=adocao.getPessoa().getNomePessoa()%></p>
                                <p hidden><%=adocao.getPessoa().getIdPessoa()%></p>
                                <p hidden><%=adocao.getPet().getPessoa()%></p>
                                <!-- Button trigger modal -->
                                <a class="btn-lista"  href="consultarAdocao?idadocao=<%=adocao.getIdAdocao()%>">
                                    <button type="button" style="background-color: rgb(91, 109, 54);
                                            border: rgb(91, 109, 54); color: #fff;" class="btn" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                                        Ver mais 
                                    </button>  
                                </a>
                            </div>
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
