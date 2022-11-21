<%@page import="model.Cliente"%>
<%@page import="model.Reclamacao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reclamações</title>
    </head>
    <body>
        <h1>Reclamações</h1>
        <%
            List<Reclamacao> lista = (List<Reclamacao>) request.getAttribute("reclamacoes"); 
        %>
        <table>
                    <thead>
                        <tr>
                            <th>Reclamação</th>
                            <th>pessoa</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                           for (Reclamacao reclamacao : lista) {
                        %>
                        <tr>
                            <p hidden><%= reclamacao.getIdReclamacao()%></p>
                            <td><%= reclamacao.getReclamacao()%></td>
                            <td><%= reclamacao.getCliente().getNomePessoa()%></td>
                            <td><%= reclamacao.getCliente().getTelefonePessoa()%></td>
                            <td><a href="excluirReclamacao?idReclamacao=<%= reclamacao.getIdReclamacao()%>">Excluir</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
        </table> 
    </body>
</html>
