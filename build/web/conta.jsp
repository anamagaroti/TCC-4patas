<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/conta.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Document</title>
</head>
<body>
    <div class="container emp-profile">
        <p class="titulo">Editar Perfil</p>
        <form method="post">
            <div class="row">
                <div class="col-md-4">
                    <div class="profile-img">
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>
                        <div class="file btn btn-lg btn-primary">
                            Editar Foto
                            <input class="file" type="file" name="file"/>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="profile-head">
                                <h5>
                                    Kshiti Ghelani
                                </h5>
                                <h6>
                                    Perfil
                                </h6>
                               
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Timeline</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-2">
                    <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Enviar"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="profile-work">
                        <p class="Txt_alterar"><Strong>Alterações Possiveis</Strong></p>
                        <a class="links_alterar" href="">Alterar senha</a><br/><br>
                        <a class="links_alterar" href="">Editar endereço</a> <br><br>
                        <a class="links_alterar" href="">Editar dados pessoais</a><br/><br>
                        <a class="links_alterar" href="">Editar Email</a> <br><br>
                        <a class="links_alterar" href="">Editar Telefone</a>
                        
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="tab-content profile-tab" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>Id de Usuario</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p>Kshiti123</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>Nome</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p>Kshiti Ghelani</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>Email</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p>kshitighelani@gmail.com</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>Telefone</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p>123 456 7890</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>Data de nascimento</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p>20/06/2005</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>CPF</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p>111.111.111-11</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>CEP</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p>99999-999</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>SEXO</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p> Feminino                                               
                                            </p>
                                            
                                        </div>
                                    </div>
                                    <!-- Endereço -->                                   
                                        </div>
                                    
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>ENDEREÇO</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p><strong>RUA:</strong>  Jorgin do Grau <br> <Strong>Número:</Strong> 157                                              
                                            </p>
                                            
                                        </div>
                                    </div>
                        </div>

                        
                    </div>
                </div>
            </div>
        </form>           
    </div>
</body>
</html>