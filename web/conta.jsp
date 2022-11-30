<%@page import="model.Pessoa"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="img/logo_navegador.jpeg">
        <link rel="stylesheet" href="css/conta.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>Perfil</title>
    </head>

    <body>
        <% Pessoa usuario = (Pessoa) session.getAttribute("usuario");%>

        <div class="container emp-profile">
            <form action="EditarPessoa" style="display: flex; justify-content: center;" method="post" enctype="multipart/form-data" multiple=webkitdirectory=''>
                <div>
                    <div class="col-md-4">
                        <div>
                            <img width="250em" src="imagem/<%=usuario.getNomeImg()%>"/>
                            <div class="btn">
                                <label hidden="true" id="fotoPerfil" class="Label" for="arquivo">
                                    Foto 
                                    <input hidden type="file" name="imagem" id="arquivo">
                                </label> 
                            </div>
                            <button class="botao-editar" onclick="editar();" id="editarPerfil" type="button">Editar Perfil</button>  
                            <button class="botao-editar" id="enviar" type="submit" hidden="true">Editar</button>
                        </div>
                    </div>
                </div>
                <div class="col-md-8" id="todos-inputs">
                    <div class="tab-content profile-tab" id="myTabContent" style="margin-bottom: 100px;">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <input name="idPessoa" id="idpessoa" type="text" value="<%=usuario.getIdPessoa() > 0 ? usuario.getIdPessoa() : ""%>" readonly hidden/>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Nome</label>
                                </div>
                                <div class="col-md-6">
                                    <input class="input" type="text" name="nomePessoa" value="<%=usuario.getNomePessoa()%>" disabled="true"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Email</label>
                                </div>
                                <div class="col-md-6">
                                    <input class="input" type="email" name="emailPessoa" value="<%=usuario.getEmailPessoa()%>" disabled="true"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Senha</label>
                                </div>
                                    <div class="col-md-6">
                                    <input class="input" type="text" name="senhaPessoa" value="<%=usuario.getSenhaPessoa()%>" disabled="true"/>
                            </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Telefone</label>
                                </div>
                                <div class="col-md-6">
                                    <input class="input" type="text" name="telefonePessoa" value="<%=usuario.getTelefonePessoa()%>" disabled="true"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Data de nascimento</label>
                                </div>
                                <div class="col-md-6">
                                    <input type="date" name="dataNascimentoPessoa"
                                           class="input" value="<%=usuario.getDataNascimentoPessoa()%>" disabled="true"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>CPF</label>
                                </div>
                                <div class="col-md-6">
                                    <input class="input" type="text" name="cpfPessoa" value="<%=usuario.getCpfPessoa()%>" disabled="true"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>CEP</label>
                                </div>
                                <div class="col-md-6">
                                    <input class="input" type="text" name="cepPessoa" value="<%=usuario.getCepPessoa()%>" disabled="true"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Gênero</label>
                                </div>
                                <div class="col-md-6">
                                    <input class="input" type="text" name="generoPessoa" value="<%=usuario.getGeneroPessoa()%>" disabled="true"/>
                                </div>
                            </div>
                            <!-- Endereço -->
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <label>Endereço</label>
                            </div>
                            <div class="col-md-6">
                                <p class="pe"><strong> RUA: </strong><input class="input" type="text" name="ruaPessoa"
                                                                value="<%=usuario.getRuaPessoa()%>" disabled="true"/> <br>
                                    <Strong>Número: </Strong><input class="input" type="text" name="numeroPessoa"
                                                                    value="<%=usuario.getNumeroPessoa()%>" disabled="true"/> <br>
                                    <strong>Cidade: </strong><input class="input" type="text" name="cidadePessoa"
                                                                    value="<%=usuario.getCidadePessoa()%>" disabled="true"/><br>
                                    <strong>Bairro: </strong> <input class="input" type="text" name="bairroPessoa"
                                                                     value="<%=usuario.getBairroPessoa()%>" disabled="true"/>
                                    <br> <strong>complemento: </strong><input class="input" type="text" name="complementoPessoa"
                                                                              value="<%=usuario.getComplementoPessoa()%>" disabled="true"/> <br>
                                    <strong>estado: </strong> <input class="input" type="text" name="estadoPessoa"
                                                                     value="<%=usuario.getEstadoPessoa()%>" disabled="true"/>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <script src="js/conta.js" type="text/javascript"></script>
    </body>

</html>