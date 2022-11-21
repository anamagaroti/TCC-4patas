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
        <title>Cadastre seu Pet</title>
    </head>
    <body>
        <%
            Pessoa usuario = (Pessoa) session.getAttribute("usuario");
        %>
        <div class="container">
            <div>
                <img class="wave" src="img/wave.png">
                <div class="img">
                    <p>AuAu</p>
                    <img src="img/kisspng-golden-retriever-labrador-retriever-puppy-pet-sitt-golden-dogs-word-5ad89edacb7d74.7990172915241458828335.png">
                </div> 
            </div>
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
                    <h2 class="title">Cadastrar Pet</h2>
                    <input hidden="" name="idpet" id="idpet" type="text" value="${pet.idpet > 0 ? pet.idpet : ""}" />
                    <div class="div">
                        <label for='selecao-arquivo'>Selecionar imagem &#187;</label>
                        <input id='selecao-arquivo' type='file' name="imagem" multiple="multiple" required>
                    </div>
                    <div class="input-div one">
                        <div class="div">
                            <input type="text" name="nomepet" class="input_txt" placeholder="Nome" id="nome" value="${pet.nomepet}" required>
                        </div>
                    </div>
                    <div class="input-div one">
                        <div class="div">
                            <input type="text" class="input_txt" name="racapet" value="${pet.racapet}"  placeholder="Raça" id="raca" required>
                        </div>
                    </div>
                    <div class="input-div one">
                        <div class="div">
                            <input class="input_txt" id="idade" type="text" name="idadepet" value="${pet.idadepet}"  placeholder="Idade" required>
                        </div>
                    </div>
                    <div class="">
                        <div class="">
                            <h3>Espécie</h3>
                            <input  id="especieC" type="radio" name="especiepet" value="cachorro"${pet.especiepet} required>
                            <label for="especieC">Cachorro</label>
                            <input id="especieG" type="radio" name="especiepet" value="gato"${pet.especiepet} required>
                            <label for="especieG">Gato</label>
                        </div>
                    </div>
                    <div class="input-div one">
                        <div class="div">
                            <input class="input_txt" id="cores" type="text" name="corespet" value="${pet.corespet}" placeholder="Cores" required>
                        </div>
                    </div>     
                    <div class="">
                        <div class="">
                            <h3>Sexo</h3>
                            <input id="sexoM" type="radio" name="sexopet" value="macho"${pet.sexopet} required>
                            <label for="sexoM">Macho</label>
                            <input id="sexoF" type="radio" name="sexopet" value="femea"${pet.sexopet} required>
                            <label for="sexoF">Fêmea</label>
                        </div>
                    </div>
                    <div class="">
                        <div class="">
                            <h3>Porte</h3>
                            <input id="porteG" type="radio" name="portepet" value="Grande"${pet.portepet} required> 
                            <label for="porteG">Grande</label>
                            <input id="porteM" type="radio" name="portepet" value="Médio"${pet.portepet} required>
                            <label for="porteM">Médio</label>
                            <input id="porteP" type="radio" name="portepet" value="Pequeno"${pet.portepet} required>
                            <label for="porteP">Pequeno</label>
                        </div>
                    </div>
                    <div class="input-div one">
                        <div class="div">
                            <label for="observacoes">Observações</label>
                            <textarea id="observacoes" name="observacoes" style="width: 45ch" spellcheck="true"
                                      maxlength="45" placeholder="Caracteristicas do seu pet..."></textarea>
                        </div>
                    </div> 
                    <input type="submit" class="btn" value="Enviar">
                    <!-- aq é o loginde cahorro -->
                </form>
            </div>
        </div>
        <script src="js/main.js" type="text/javascript"></script>
    </body>
</html>