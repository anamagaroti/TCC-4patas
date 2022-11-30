<%@page import="model.Pessoa"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="img/logo_navegador.jpeg">
        <link href="css/styleCadastrarPet.css" rel="stylesheet" type="text/css"/>
        <link href="css/cadastrarPet2.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <title>Cadastrar Pet</title>
    </head>
    <body>
        <%
            Pessoa usuario = (Pessoa) session.getAttribute("usuario");
        %>
        <img class="wave" src="img/wave.png">
        <div class="container">
            <div class="img">
                <p>AuAu</p>
                <img
                    src="img/kisspng-golden-retriever-labrador-retriever-puppy-pet-sitt-golden-dogs-word-5ad89edacb7d74.7990172915241458828335.png">
            </div>
            <div class="Fundo">
                <div class="login-content">
                    <form action="CadastrarPet" method="post" enctype="multipart/form-data" multiple=webkitdirectory=''>
                        <%
                            if (usuario != null) {
                        %>
                        <input hidden="" value="<%=usuario.getIdPessoa()%>" name="idPessoa" />
                        <%
                            } else {
                                response.sendRedirect("login_cadastro.jsp");
                            }
                        %>
                        <img class="icone" src="img/logo-cadastro.png" alt=""/>
                        <h2 class="title">Bem vindo</h2>
                        <div class="Enviar">
                            <label class="Label_arq" for="arquivo">Adicionar foto
                                do PET
                            </label>
                            <input type="file" name="imagem" id="arquivo">
                        </div>
                        <input hidden="" name="idPet" id="idpet" type="text" value="${pet.idpet > 0 ? pet.idpet : ""}" />
                        <br>
                        <div class="input-div  pass">	
                            <div class="div">
                                <h5 class="tx">Nome</h5>
                                <input type="text" class="input" name="nomePet" value="${pet.nomePet}" required/>
                            </div>
                        </div>
                        <div class="input-div pass">

                            <div class="div">
                                <h5>Raça</h5>
                                <input type="text" class="input" name="racaPet" value="${pet.racaPet}" required/>
                            </div>
                        </div>
                        <div class="input-div pass">

                            <div class="div">
                                <h5>Idade</h5>
                                <input type="text" class="input" name="idadePet" value="${pet.idadePet}" required/>
                            </div>
                        </div>
                        <div class="input-div pass">

                            <div class="div">
                                <h5>Cores</h5>
                                <input type="text" class="input" name="coresPet" value="${pet.coresPet}" required/>
                            </div>
                        </div>

                        <h3>especie</h3>
                        <div class="radios">

                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="especiePet" value="gato"${pet.especiePet} required id="inlineRadio1"/>
                                <label class="form-check-label" for="inlineRadio1">Gato</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="especiePet" value="cachorro"${pet.especiePet} required id="inlineRadio2"/>
                                <label class="form-check-label" for="inlineRadio2">Cachorro</label>
                            </div>
                        </div>
                        <h3>Sexo</h3>
                        <div class="radios">

                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="sexoPet" value="macho"${pet.sexoPet} required id="inlineRadio1"/>
                                <label class="form-check-label" for="inlineRadio1">Macho </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="sexoPet" value="femea"${pet.sexoPet} required id="inlineRadio2"/>
                                <label class="form-check-label" for="inlineRadio2">Fêmea </label>
                            </div>
                        </div>

                        <h3>Porte</h3>
                        <div class="radios">

                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="portePet" value="Pequeno"${pet.portePet} required id="inlineRadio1"/>
                                <label class="form-check-label" for="inlineRadio1">Pequeno</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="portePet" value="Médio"${pet.portePet} required id="inlineRadio2"/>
                                <label class="form-check-label" for="inlineRadio2">Medio</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="portePet" value="Grande"${pet.portePet} required id="inlineRadio2"/>
                                <label class="form-check-label" for="inlineRadio3">Grande</label>
                            </div>
                        </div>
                        <div class="input-div pass">

                            <div class="div">
                                <h5>Observação</h5>
                                <input type="text" class="input" name="observacoes" value="${pet.observacoes}" required/>
                            </div>
                        </div>
                        <input type="submit" class="btn" value="Cadastrar">
                    </form>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/main.js"></script>
    </body>

</html>