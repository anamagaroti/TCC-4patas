<%@page import="model.Adocao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/logo_navegador.jpeg">
        <title>Confirmação de Adoção</title>
    </head>
    <body>
        <h1 style="text-align: center;">Informações do pet e cliente</h1>
        <div class="row row-cols-2 row-cols-md-3 col-10">
            <div class="col" style="display: flex; justify-content: center;">
                <div class="card  cardes">            
                    <img width="150rem" src="imagem/${adocao.pet.nomeImg}" 
                         <div class="card-body">
                    <h5 class="card-title">Nome: ${adocao.pet.nomePet}</h5>
                    <p class="card-text">Raça: ${adocao.pet.racaPet}</p>
                    <p class="card-text">Idade: ${adocao.pet.idadePet}</p>
                    <p class="card-text">Cores: ${adocao.pet.coresPet}</p>
                    <p class="card-text">Espécie: ${adocao.pet.especiePet}</p>
                    <p class="card-text">Sexo: ${adocao.pet.sexoPet}</p>
                    <p class="card-text">Porte: ${adocao.pet.portePet}</p>
                    <p class="card-text">Observações: ${adocao.pet.observacoes}</p>
                </div>
                <div class="card">            
                    <img width="150rem" src="imagem/${adocao.pessoa.nomeImg}" 
                         <div class="card-body">
                    <h5 class="card-title">Nome: ${adocao.pessoa.nomePessoa}</h5>
                    <p class="card-text">CPF: ${adocao.pessoa.cpfPessoa}</p>
                    <p class="card-text">Data de nascimento: ${adocao.pessoa.dataNascimentoPessoa}</p>
                    <p class="card-text">CEP: ${adocao.pessoa.cepPessoa}</p>
                    <p class="card-text">Telefone: ${adocao.pessoa.telefonePessoa}</p>
                    <p class="card-text">Email: ${adocao.pessoa.emailPessoa}</p>
                    <p class="card-text">Gênero: ${adocao.pessoa.generoPessoa}</p>
                </div>
            </div>
        </div>   
        <%
            Adocao adocao = (Adocao) request.getAttribute("adocao");
        %>
        <div style="display: flex; justify-content: center; padding: 10px;">
            <a class="btn-lista" href="recusado?idPet=<%= adocao.getPet().getIdPet()%>">
                <button type="button" style="margin-left:10px;"  class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    Recusar Adoção 
                </button>  
            </a>
            <a class="btn-lista" href="listarAdocao?idAdocao=<%= adocao.getIdAdocao()%>">
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    Confirmar Adoção 
                </button>  
            </a>
        </div>
    </body>
</html>
