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
    <body>              
        <%
            List<Adocao> lista = (List<Adocao>) request.getAttribute("adocoes");
        %>
        <h1>Pedidos de Adoção</h1>
        <div class="tudo">
        <%
            if (lista == null) {

        %>
        
            <div style="display: grid; justify-content: center;">
                <div style="margin-top: 50px;">
                    <img  style="display: flex; justify-content: center; width: 300px;" 
                          src = "img/cachorroTriste.png" width = "width" height = "height" alt = "alt"/>  
                </div>
                <h5  style="margin-top: 20px;">Não há nenhum pedido de adoção!</h5> 
            </div>
            <%        } else {
            %>
            <div class="row row-cols-2 row-cols-md-3 col-10">
                <%
                    for (Adocao adocao : lista) {
                %>
                <div class="col">
                    <div class="card">            
                        <img class="card-img-top" src="imagem/<%=adocao.getPet().getNomeImg()%>" 
                             <div class="card-body">
                        <h5 class="card-title"><%=adocao.getPet().getNomePet()%></h5>
                        <p class="card-text">Doador: <%=adocao.getPessoa().getNomePessoa()%></p>
                        <p hidden><%=adocao.getPessoa().getIdPessoa()%></p>
                        <p hidden><%=adocao.getPet().getPessoa()%></p>
                        <!-- Button trigger modal -->
                        <a class="btn-lista" href="consultarAdocao?idadocao=<%=adocao.getIdAdocao()%>">
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                                Ver mais 
                            </button>  
                        </a>
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
