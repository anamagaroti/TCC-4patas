<%@page import="dao.PetDAO"%>
<%@page import="model.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Pet"%>
<%@page import="java.util.List"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="img/logo_navegador.jpeg">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/jquery-3.6.1.min.js" type="text/javascript"></script>
    <script src="js/listar.js" type="text/javascript"></script>
  </head>
  <body id="body">
      <%
      Pessoa pessoa = new Pessoa();
      String emailUsuario = request.getParameter("emailUsuario");
      String senhaUsuario = request.getParameter("senhaUsuario");
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      Usuario usuario = (Usuario) usuarioDAO.realizarLogin(emailUsuario, senhaUsuario);
      %>
    <nav class="navbar col-12  navbar-expand-lg navbar-dark" style="z-index: 999;">
        <div class="container-fluid col-11 m-auto">
          <img src="img/LogoComTexto.png" class="Logo col-2" alt="...">
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Inicio</a>
              </li>
              <% 
                 if(usuario != null){ 
              %>
              <li class="nav-item">
                <a class="nav-link" href="#">Como ajudar</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="CadastrarPet.jsp">Doar</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Sobre
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="#">Contatos</a></li>
                  <li><a class="dropdown-item" href="#">Responsaveis</a></li>
              <% 
                 if(pessoa.getLogouPessoa() != "cliente"){ 
              %>
                  <li><a class="dropdown-item" href="formulario.jsp">Cadastro Funcionário</a></li>
                  <li><a class="dropdown-item" href="ListarFuncionario">Lista dos Funcionarios</a></li>
              <% 
                }
              %>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="razaoSocial.jsp">Razão social</a></li>
                </ul>
              </li>
              <% 
                  }else{
              %>
              <li class="nav-item">
                <a class="nav-link" href="login_cadastro.jsp">Como ajudar</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="login_cadastro.jsp"></a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Sobre
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="#">Contatos</a></li>
                  <li><a class="dropdown-item" href="#">Responsaveis</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="razaoSocial.jsp">Razão social</a></li>
                </ul>
              </li>
              <a class="btn btn-primary" href="login_cadastro.jsp" role="button">Entrar</a>
            </ul>
              <% 
                  }
              %>
            <form class="d-flex" role="search">
              <input class="form-control me-2" type="search" placeholder="Pesquisar nome do pet..." aria-label="Search">
              <button class="btn-buscar btn-success" type="submit">Buscar</button>
            </form>
              <% 
                 if(usuario != null){ 
              %>
              
              <div class="perfil">
              <img width="40px" src="img/seta.png" alt="alt"/>
              <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="login_cadastro.jsp" id="perfil" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                nome
              </a>
              <ul class="dropdown-menu" aria-labelledby="perfil">
                  <li><a class="dropdown-item" href="consultarCliente?idcliente=<%=usuario.getIdUsuario()%>">Conta</a></li>
                  <%
                    if(pessoa.getLogouPessoa() == "cliente"){
                  %>
                  <li><a class="dropdown-item" href="">Pets em doação</a></li>
                  <%
                    }else{
                  %>
                    <li><a class="dropdown-item" href="ListaAdocoes">Pedidos de adoção</a></li>
                  <%
                    }
                  %>
                  <li><a class="dropdown-item" href="">Relatar um Problema</a></li>
                  <li><a class="dropdown-item" href="Logout">Sair</a></li>
                </ul>
                </li>
              <%
                }else{
              %>         
              <div class="perfil">
              <img width="40px" src="img/seta.png" alt="alt"/>
            <li class="nav-item dropdown">
              <a class="nav-link" href="login_cadastro.jsp">
                Cadastre-se
              </a>
            
            </div>
              <%
                }
              %>
          </div>
        </div>
       </div>
      </nav>    
      <br>
      <div id="carouselExampleIndicators" class="carousel slide col-11" data-bs-ride="true">
        <div class="carousel-indicators ">
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="foto_escura"></div>
        <div class="carousel-inner" >
          <div class="carousel-item active">
            <img src="img/cathorroa.jpg" class="d-block w-100" alt="...">   
            <div class="carousel-caption d-none d-md-block">
              <h5>Projeto 4 patas</h5>
              <p>O olhar do seu cachorro e o melhor espelho da grandeza da sua alma.</p>
            </div>       
          </div>
          <div class="carousel-item">
            <img src="img/cathorroa.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Projeto 4 patas</h5>
              <p>O olhar do seu cachorro e o melhor espelho da grandeza da sua alma.</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="img/cathorroa.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Projeto 4 patas</h5>
              <p>O olhar do seu cachorro e o melhor espelho da grandeza da sua alma.</p>
            </div>
          </div>
        </div>
        <button class="carousel-control-prev carrossel-icone" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next carrossel-icone" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>

      <!-- Pets -->
      
      <div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group me-2" role="group" aria-label="First group">
          <button href="listarPet?ListaTodos" type="button" class="btn btn-todos btn-outline" id="todos" value="todos" id="botao " onclick="Click ('todos')">Todos</button>
          <button href="listarPet?ListaCachorro" type="button" class="btn btn-outline" id="cachorro" value="cachorro" onclick="Click ('cachorro')"> Cachorro</button>
          <button href="listarPet?ListaGato" type="button" class="btn btn-outline" id="gato" value="gato" onclick="Click ('gato')">Gato</button>
        </div>
      </div>   
      <% List<Pet> lista = (List<Pet>) request.getAttribute("pets"); %>
        <%
           for (Pet pet : lista) {         
        %>
      <div class="row row-cols-md-3 col-10 ">
          
          <div class="col">
          <div class="card">            
            <img class="card-img-top" src="<%= (String) request.getContextPath() + "/imagem/" + pet.getNomeImg()%>">
            <div class="card-body">
                <h5 class="card-title"><%= pet.getNomePet()%></h5>
              <p class="card-text"><%= pet.getObservacoes()%></p>
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                <a class="btn-lista" href="consultarPet?idpet=<%=pet.getIdPet()%>">ver mais</a> 
            </button>        
            </div>
          </div>
        </div>
      </div> 
        <%
           }
        %>
            
      <nav class="navegar" aria-label="Page navigation example">
        <ul class="pagination">
          <li class="page-item">
            <a  id="BackEnd" class="page-link" href="#" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
          <li class="page-item"><a class="page-link" href="#">1</a></li>
          <li class="page-item"><a class="page-link" href="#">2</a></li>
          <li class="page-item"><a class="page-link" href="#">3</a></li>
          <li class="page-item">
            <a id="BackEnd" class="page-link" href="#" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
        </ul>
      </nav>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    <script src="js/inicial.js" ></script>
    <script src="js/listar.js"></script>
    </body>
</html>