<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar perfil - 4patas</title>
        <link rel="shortcut icon" href="img/logo_navegador.jpeg">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link href="css/stylesConfiguracoes.css" rel="stylesheet" type="text/css"/>
    </head>   
    <body>
        <div class="container">
            <aside>
                <ul>
                    <li>
                        <a href="#">Editar perfil</a>
                    </li>
                    <li>
                        <a href="#">Alterar senha</a>
                    </li>
                    <li>
                        <a href="#">Editar endereço</a>
                    </li>
                    <li>
                        <a href="#">Editar dados pessoais</a>
                    </li>
                </ul>
            </aside>
            <form action="CadastrarCliente" method="post">
                <input type="type" name="idCliente" id="idcliente" hidden value="${cliente.idpessoa > 0 ? cliente.idpessoa : ""}">
            <div>
                <label for="foto">Foto de perfil</label>
                <input type="file" id="foto" name="imagem">
            </div>
            <div>
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nomeCliente" value="${cliente.nomePessoa}">
            </div>
            <div>
                <label for="dn">Data de nascimento</label>
                <input type="date" id="dn" name="dataNascimentoCliente" value="${cliente.datanascimentoPessoa}">                
            </div>
            <div>
                <label for="cpf">CPF</label>
                <input type="text" id="cpf" name="cpfCliente" value="${cliente.cpfPessoa}">
            </div>
            <div>
                <label for="endereco"> Endereço</label>
                <input type="text" id="endereco" name="enderecoCliente" value="${cliente.enderecoPessoa}">
            </div>
            <div>
                <label for="cidade">Cidade</label>
                <input type="text" id="cidade" name="cidadeCliente" value="${cliente.cidadePessoa}">
            </div>
            <div>
                <label for="estado">Estado</label>
                <input type="text" id="estado" name="estadoCliente" value="${cliente.estadoPessoa}">
            </div>
            <div>
                <label for="cep">CEP</label>
                <input type="text" id="cep" name="cepCliente" value="${cliente.cepPessoa}">
            </div>
            <div>
                <label for="email">Email</label>
                <input type="email" id="email" name="emailCliente" value="${cliente.emailPessoa}">
            </div>
            <div class="gender-group" >
                <h5>Gênero</h5>
		<div class="gender-input">
		    <input id="female" type="radio" name="generoCliente" value="Feminino"${cliente.generopessoa}>
                    <label for="female">Feminino</label>
		</div>

		<div class="gender-input">
                    <input id="male" type="radio" name="generoCliente" value="Masculino"${cliente.generopessoa}>
                    <label for="male">Masculino</label>
		</div>
		<div class="gender-input">
                    <input id="others" type="radio" name="generoCliente" value="Outros" ${cliente.generopessoa}>
                    <label for="others">Outros</label>
		</div>
            <div>
                <label for="senha">Senha antiga</label>
                <input type="password" id="senha">
            </div>
            <div>
                <label for="senha">Nova senha</label>
                <input type="password" id="senha" name="senhaCliente">
            </div>
            <div>
                <label for="confimacaoSenha">Confirmar nova senha</label>
                <input type="password" id="confimacaoSenha">
            </div>
            <div>
                <button type="submit">Enviar</button>
            </div>
        </form>
        </div>
    </body>
</html>

