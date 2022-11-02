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
        <div class="body">
            <div class="tudo">
                <p hidden>${pet.idPet}</p>
                <div class="text">
                  <h1 class="">${pet.nomePet}</h1>
                </div>
                <div>
                    <img src="imagem/WhatsApp Image 2022-10-29 at 14.47.00 (1).jpeg" alt=""/>
                </div>
                <div class="infos">        
                    <p class="text">Raça: ${pet.racaPet}</p>
                    <p class="text">Idade: ${pet.idadePet}</p>
                    <p class="text">Espécie: ${pet.especiePet}</p>
                    <p class="text">Cores: ${pet.coresPet}</p>
                    <p class="text">Sexo: ${pet.sexoPet}</p>
                    <p class="text">Porte: ${pet.portePet}</p>
                    <p class="text">Observacões: ${pet.observacoes}</p>
                  </div>
                <div class="">
                    <a href="listarPet"><button class="btn">Voltar</button></a>
                    <a href="pedido.jsp"><button class="btn">Adotar</button></a>
                </div>
            </div> 
        </div>
    </body>
</html>
