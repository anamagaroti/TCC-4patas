<%@page import="model.Cliente"%>
<%@page import="model.Reclamacao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reclamações</title>
        <link rel="shortcut icon" href="img/logo_navegador.jpeg">
        <link rel="stylesheet" href="css/stylereclamação.css">

    </head>
    <body class="body">
        <h1 class="titulo">Reclamações</h1>
        <%
            List<Reclamacao> lista = (List<Reclamacao>) request.getAttribute("reclamacoes"); 
        %>
        <table>
                    <thead>
                        <tr>
                            <th class="reclamarg">Reclamação</th>
                            <th>pessoa</th>
                            <th class="email">Email</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                           for (Reclamacao reclamacao : lista) {
                        %>
                        <tr>
                            <p hidden><%= reclamacao.getIdReclamacao()%></p>
                            <td class="reclamar"><%= reclamacao.getReclamacao()%></td>
                            <td><%= reclamacao.getCliente().getNomePessoa()%></td>
                            <td class="email"><%= reclamacao.getCliente().getTelefonePessoa()%></td>
                            <td class="emailg"><a href="excluirReclamacao?idReclamacao=<%= reclamacao.getIdReclamacao()%>">Excluir</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
        </table> 
    </body>
</html>
