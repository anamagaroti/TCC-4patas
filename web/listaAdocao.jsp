<%@page import="model.Adocao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/logo_navegador.jpeg">
        <link href="css/pedidosAdocao.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>Adoção</title>
    </head>
    <body style="background-color: #EDD4AB;">          
        <%
            List<Adocao> lista = (List<Adocao>) request.getAttribute("adocoes");
        %>
        <div style="display: flex; ">
            <a style="margin-left: 20em;" href="listarPet">Voltar</a>
            <h1 style="color: rgb(94, 50, 20);">Pedidos de Adoção</h1>
        </div>
        <div class="tudo">
            <div class="row row-cols-2 row-cols-md-3 col-10">
                <%
                    for (Adocao adocao : lista) {
                        if (adocao.isAdotado() == false) {
                %>
                <div class="col"  style="margin-bottom: 10px;">
                    <div class="card">            
                        <img class="card-img-top" src="imagem/<%=adocao.getPet().getNomeImg()%>" 
                             <div class="card-body">
                        <div  style="padding: 5px;">
                            <h5 class="card-title"><%=adocao.getPet().getNomePet()%></h5>
                            <p class="card-text">Doador: <%=adocao.getPessoa().getNomePessoa()%></p>
                            <p hidden><%=adocao.getPessoa().getIdPessoa()%></p>
                            <p hidden><%=adocao.getPet().getPessoa()%></p>
                            <!-- Button trigger modal -->
                            <a class="btn-lista" href="consultarAdocao?idadocao=<%=adocao.getIdAdocao()%>">
                                <button type="button" style="background-color: rgb(91, 109, 54);
                                        border: rgb(91, 109, 54); color: #fff;" class="btn" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                                    Ver mais 
                                </button>  
                            </a>
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
