<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/logo_navegador.jpeg">
        <title>Cadastro do Pet</title>
        <link rel="stylesheet" href="css/styleCadastrarPet.css">

    </head>
    <body>
        <div>
        <div>
            <div>
                <h1>Cadastre seu Pet</h1>
            </div>           
            <form action="CadastrarPet" method="post" enctype="multipart/form-data" multiple=webkitdirectory=''> 
                
                    <input name="idpet" id="idpet" type="text" value="${pet.idpet > 0 ? pet.idpet : ""}" hidden/>
                    <div class="input-box">
                        <label for="foto">Fotos do pet</label>
                        <input type="file" id="foto" name="imagem" multiple="multiple">                                        
                    </div>
                    <div class="input-box">
                        <label for="nome">Nome</label>
                        <input id="nome" type="text" name="nomepet" value="${pet.nomepet}" placeholder="Digite o nome do Pet" required>
                    </div>                    
                    <div class="input-box">
                        <label for="raca">Raça</label>
                        <input id="raca" type="text" name="racapet" value="${pet.racapet}" placeholder="Digite a raca do seu Pet" required>                    
                    </div>
                    <div class="input-box">
                        <label for="idade">Idade</label>
                        <input id="idade" type="text" name="idadepet" value="${pet.idadepet}" placeholder="Digite a idade do seu Pet" required>                    
                    </div>
                     <div class="input-box">
                        <h3>espécie</h3>
                        <input id="especieC" type="radio" name="especiepet" value="cachorro"${pet.especiepet} required>
                        <label for="especieC">Cachorro</label>
                        <input id="especieG" type="radio" name="especiepet" value="gato"${pet.especiepet} required>
                        <label for="especieG">Gato</label>
                     </div>
                    <div class="input-box">
                        <label for="cores">Cores</label>
                        <input id="cores" type="text" name="corespet" value="${pet.corespet}" placeholder="Digite as cores do seu Pet" required>                    
                    </div>
                      
                      <div class="input-box">
                        <h3>Sexo</h3>
                        <input id="sexoM" type="radio" name="sexopet" value="macho"${pet.sexopet} required>
                        <label for="sexoM">Macho</label>
                        <input id="sexoF" type="radio" name="sexopet" value="femea"${pet.sexopet} required>
                        <label for="sexoF">Fêmea</label>
                      </div>
                     <div class="input-box">
                        <h3>Porte</h3>
                        <input id="porteG" type="radio" name="portepet" value="Grande"${pet.portepet} required> 
                        <label for="porteG">Grande</label>
                        <input id="porteM" type="radio" name="portepet" value="Médio"${pet.portepet} required>
                        <label for="porteM">Médio</label>
                        <input id="porteP" type="radio" name="portepet" value="Pequeno"${pet.portepet} required>
                        <label for="porteP">Pequeno</label>
                     </div>
                      <div class="input-box">
                        <label for="observacoes">Observações</label>
                        <textarea id="observacoes" name="observacoes" rows="8" cols="20" spellcheck="true" placeholder="Diga-nos como seu pet é..."></textarea>
                      </div>
                    <div>
                    <button type="submit">Cadastrar pet</button>                    
                    </div>
               </form>
              </div>
            </div>
                
    </body>
</html>
