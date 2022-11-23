<%@page import="model.Pet"%>
<%@page import="model.Adocao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/logo_navegador.jpeg">
        <title>Confirmação de doação</title>
    </head>
    <body>
        <h1 style="text-align: center;">Informações do pet e cliente</h1>
        <div class="row row-cols-2 row-cols-md-3 col-10">
            <div class="col" style="display: flex; justify-content: center;">
                <div class="card  cardes">            
                    <img width="150rem" src="imagem/${pet.nomeImg}" 
                         <div class="card-body">
                    <h5 class="card-title">Nome: ${pet.nomePet}</h5>
                    <p class="card-text">Raça: ${pet.racaPet}</p>
                    <p class="card-text">Idade: ${pet.idadePet}</p>
                    <p class="card-text">Cores: ${pet.coresPet}</p>
                    <p class="card-text">Espécie: ${pet.especiePet}</p>
                    <p class="card-text">Sexo: ${pet.sexoPet}</p>
                    <p class="card-text">Porte: ${pet.portePet}</p>
                    <p class="card-text">Observações: ${pet.observacoes}</p>
                </div>
                <div class="card">            
                    <img width="150rem" src="imagem/${pet.pessoa.nomeImg}" 
                         <div class="card-body">
                    <h5 class="card-title">Nome: ${pet.pessoa.nomePessoa}</h5>
                    <p class="card-text">CPF: ${pet.pessoa.cpfPessoa}</p>
                    <p class="card-text">Data de nascimento: ${pet.pessoa.dataNascimentoPessoa}</p>
                    <p class="card-text">CEP: ${pet.pessoa.cepPessoa}</p>
                    <p class="card-text">Telefone: ${pet.pessoa.telefonePessoa}</p>
                    <p class="card-text">Email: ${pet.pessoa.emailPessoa}</p>
                    <p class="card-text">Gênero: ${pet.pessoa.generoPessoa}</p>
                </div>
            </div>
        </div>   
        <%
            Pet pet = (Pet) request.getAttribute("pet");
        %>
        <div style="display: flex; justify-content: center; padding: 10px;">
            <a class="btn-lista" href="excluirPet?idpet=<%= pet.getIdPet()%>">
                <button type="button" style="margin-left:10px;"  class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    Recusar Doação 
                </button>  
            </a>
            <a class="btn-lista" href="">
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    Confirmar Doação 
                </button>  
            </a>
        </div>
    </body>
</html>
