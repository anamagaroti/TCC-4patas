<!DOCTYPE html>
<html lang="pt-br" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>Login</title>
  <link rel="stylesheet" href="css/styleCadastro_login.css">
  <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
  <link rel="shortcut icon" href="img/logo_navegador.jpeg">
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
  <script src="js/buscaCep.js" type="text/javascript"></script>
</head>

<body>
	
<div class="container" id="container">
	
	<div class="form-container sign-up-container">
            <form action="CadastrarCliente" method="post" enctype="multipart/form-data" multiple=webkitdirectory='' class="Form-criar-conta">
			
			<h1 class="h1NovaConta">Nova Conta</h1>
                        
                        <input type="text" name="idpessoa" hidden/>
                        
                        <input enctype="multi-part/form-data" type="file" name="imagem" required>
                        <input type="text" placeholder="Nome" required name="nomeCliente"/>
                        <input type="text" placeholder="Cpf" required name="cpfCliente" />
                        <input type="date" placeholder="Data nascimento" name="dataNascimentoCliente" required />                 
                        <input type="text" id="cep" value="" placeholder="Cep" name="cepCliente" required />
                        <input type="text" id="cidade" placeholder="Cidade" name="cidadeCliente" required />
                        <input type="text" id="bairro" placeholder="Bairro" name="bairroCliente" required />
                        <input type="text" id="ruaCliente" placeholder="Rua" name="ruaCliente" required />
                        <input type="text" id="numero" placeholder="Número de sua casa" name="numeroCliente" required />
                        <input type="text" id="complemento" placeholder="Complemento do seu endereço" name="complementoCliente" required />
                        <label for="uf" name="estadoCliente">Estado</label>
                            <select id="uf" name="estadoCliente">
                                <option value="AC">Acre</option>
                                <option value="AL">Alagoas</option>
                                <option value="AP">Amapá</option>
                                <option value="AM">Amazonas</option>
                                <option value="BA">Bahia</option>
                                <option value="CE">Ceará</option>
                                <option value="DF">Distrito Federal</option>
                                <option value="ES">Espírito Santo</option>
                                <option value="GO">Goiás</option>
                                <option value="MA">Maranhão</option>
                                <option value="MT">Mato Grosso</option>
                                <option value="MS">Mato Grosso do Sul</option>
                                <option value="MG">Minas Gerais</option>
                                <option value="PA">Pará</option>
                                <option value="PB">Paraíba</option>
                                <option value="PR">Paraná</option>
                                <option value="PE">Pernambuco</option>
                                <option value="PI">Piauí</option>
                                <option value="RJ">Rio de Janeiro</option>
                                <option value="RN">Rio Grande do Norte</option>
                                <option value="RS">Rio Grande do Sul</option>
                                <option value="RO">Rondônia</option>
                                <option value="RR">Roraima</option>
                                <option value="SC">Santa Catarina</option>
                                <option value="SP">São Paulo</option>
                                <option value="SE">Sergipe</option>
                                <option value="TO">Tocantins</option>
                            </select>
			<input type="text" placeholder="Telefone" name="telefoneCliente" required />	
			<input type="email" placeholder="E-mail" name="emailCliente" required />
			<input type="password" placeholder="Senha" name="senhaCliente" required />
			<input type="password" placeholder="Repita sua senha" name="senhaCliente" required />
			<div class="gender-inputs">
				<div class="gender-title">
					<h6>Gênero</h6>
				</div>

				<div class="gender-group" >
					<div class="gender-input">
						<input id="female" type="radio" name="generoCliente" value="Feminino">
						<label for="female">Feminino</label>
					</div>

					<div class="gender-input">
                                            <input id="male" type="radio" name="generoCliente" value="Masculino">
						<label for="male">Masculino</label>
					</div>
					<div class="gender-input">
                                            <input id="others" type="radio" name="generoCliente" value="Outros">
						<label for="others">Outros</label>
					</div>
                            </div>
                            </div>
                    <button class="btn_entrar btn_criar_conta" type="submit">Criar nova conta</button>	
		</form>
	</div>
	<div class="form-container sign-in-container">
		<a href="listarPet"> <svg xmlns="http://www.w3.org/2000/svg"  fill="currentColor" class="bi bi-arrow-left-circle-fill" viewBox="0 0 16 16">
			<path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0zm3.5 7.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
		  </svg></a>

		<form action="Login" method="post" class="form-entrar">
                        <div class="alert alert-primary text-center" role="alert">
                            ${mensagem}
                        </div>
			<h1 class="h1entrar">Entrar</h1>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
			<span>Use sua conta</span>
                        <input type="email" name="emailUsuario" placeholder="E-mail" required />
                        <input type="password" name="senhaUsuario" placeholder="Senha" required />
			<a href="recuperarSenha.jsp">Esqueceu sua Senha?</a>
			<button class="btn_entrar">Entrar</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1 class="ola">Bem vindo Novamente</h1>
				<p>Para se manter conectado conosco, faça login com seus dados pessoais</p>
				<button class="ghost" id="signIn">Entrar</button>
			</div>
			<div class="overlay-panel overlay-right">
				
				<h1 class="ola">Olá!</h1>
				<p>Insira seus dados pessoais para abrir uma conta conosco</p>
				<button class="ghost" id="signUp">Criar conta</button>
			</div>
		</div>
	</div>
</div>

<script src="js/script.js" charset="utf-8"></script>
</body>

</html>
