<%@page import="model.Adocao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/logo_navegador.jpeg">

        <title>Confirmação de Adoção</title>
    </head>
    <body style="background-color: #EDD4AB">
        <h1 style="text-align: center;">Informações do pet e cliente</h1>
        <div>
            <div class="col" style="display: flex; justify-content: space-evenly;">
                <div style="border: solid black 1px; width: 250px;  padding: 20px;  
                     background-color: #fff; border-radius: 5px;" class="card">            
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
                <div style="margin-left: 20px; border: solid black 1px; width: 250px; padding: 20px;  
                     background-color: #fff; border-radius: 5px;">            
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
        <div style="display: flex; justify-content: center; padding: 10px; margin-top: 25px;">
            <a class="btn-lista" href="recusado?idPet=<%= adocao.getPet().getIdPet()%>">
                <button type="button"style="margin-left:10px; padding: 8px; border-radius: 5px;  background-color: rgb(91, 109, 54);">
                    Recusar Adoção 
                </button>  
            </a>
            <a class="btn-lista" href="AdocaoConfirmada?idAdocao=<%=adocao.getIdAdocao()%>">
                <button type="button" style="border-radius: 5px; padding: 8px; margin-left:10px; background-color: rgb(91, 109, 54);">
                    Confirmar Adoção 
                </button>  
            </a>
        </div>
    </body>
</html>
