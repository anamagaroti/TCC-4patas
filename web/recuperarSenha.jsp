<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <title>Recuperar Senha</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link href="css/Razao_Social.css" rel="stylesheet" type="text/css"/>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <input type="checkbox" id="flip">
            <div class="cover">
                <div class="front">
                    <div class="text">
                        <span class="text-1">Você não adota um Pet<br>adota um melhor Amigo</span>
                    </div>
                </div>
                <div class="back">
                    <img class="img" src="/imgs/cachorroegato.jpg" alt="Imagem Cadastro">
                    <div class="text">
                        <span class="text-1">Venha adotar um Dog<br> </span>
                        <span class="text-2">Vamos começar</span>
                    </div>
                </div>
            </div>
            <div class="forms">
                <div class="form-content">
                    <div class="login-form">
                        <a href="/indexCadastro.html"> <svg xmlns="http://www.w3.org/2000/svg"  fill="currentColor" class="bi bi-arrow-left-circle-fill" viewBox="0 0 16 16">
                            <path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0zm3.5 7.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
                            </svg></a>
                        <div class="title">Recuperar Senha</div>
                        <form action="#">
                            <div class="input-boxes">
                                <div class="input-box">
                                    <i class="fas fa-envelope"></i>
                                    <input type="text" placeholder="Digite seu email" required>
                                </div>
                                <div class="input-box">
                                    <i class="fas fa-lock"></i>
                                    <input type="password" placeholder="Digite sua nova senha" required>
                                </div>
                                <div class="input-box">
                                    <i class="fas fa-lock"></i>
                                    <input type="password" placeholder="Repita sua senha" required>
                                </div>           
                                <div class="button input-box">
                                    <input type="submit" value="Enviar">
                                </div>
                                <div class="text sign-up-text">Não tem uma conta?  <a href="indexCadastro.html">Inscreva-se agora</a> </div>
                            </div>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
