<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/logo_navegador.jpeg">

        <title>Adoção</title>
    </head>
    <body>
        <h1>Adoção</h1>
        
        <div>
        <table>
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Raça</th>
                    <th>Idade</th>
                    <th>Espécie</th>
                    <th>Cores</th>
                    <th>Sexo</th>
                    <th>Porte</th>
                    <th>Observações</th>

                </tr>
            </thead>
            <tbody>
                <tr>
                    <td hidden>${pet.idpet} </td>
                    <td>${pet.nomepet}</td>
                    <td>${pet.racapet}</td>
                    <td>${pet.idadepet}</td>
                    <td>${pet.especiepet}</td>
                    <td>${pet.corespet}</td>
                    <td>${pet.sexopet}</td>
                    <td>${pet.portepet}</td>
                    <td>${pet.observacoes}</td>
                </tr>
            </tbody>
        </table>
        </div>
            
        
    </body>
</html>
