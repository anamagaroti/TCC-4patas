        create table pessoa(
            idPessoa serial not null primary key,
            nomeImg varchar,
            nomePessoa varchar not null,            
            dataNascimentoPessoa varchar not null,
            cpfPessoa varchar not null,
            cepPessoa varchar not null,
            cidadePessoa varchar not null,
            bairroPessoa varchar not null,
            ruaPessoa varchar not null,
            numeroPessoa varchar not null,
            complementoPessoa varchar not null,
            estadoPessoa varchar not null,           
            telefonePessoa varchar not null,
            emailPessoa varchar not null,
            generoPessoa varchar not null,
            senhaPessoa varchar not null,
            logoupessoa varchar not null
        );

        create table funcionario(cargo varchar not null) inherits (pessoa);

        create table cliente() inherits (pessoa);

        create table pet(
            idPet serial not null primary key,
            nomeImg varchar not null,
            nomepet varchar not null,
            racapet varchar not null,
            idadepet varchar not null,
            especiepet varchar not null,
            corespet varchar not null,
            sexopet varchar not null,
            portepet varchar not null,
            observacoes varchar not null
        );

        create table Adotar(
            idAdocao serial not null primary key,
            idPessoa int not null references pessoa(idPessoa),
            idPet int not null references pet(idPet),
            horarioAdocao varchar not null,
            dataAdocao varchar not null
        );
  
        -- PROCEDURE CADASTRO E CONSULTA DO FUNCIONARIO;


       create or replace procedure cadastrarfuncionario(id_pessoa int, nomeImg varchar, nome_pessoa varchar, cpf_pessoa varchar, data_nascimento_pessoa varchar, cep_pessoa varchar, cidade_pessoa varchar, bairro_pessoa varchar, numero_pessoa varchar, rua_pessoa varchar, complemento_pessoa varchar, estado_pessoa varchar,  telefone_pessoa varchar, email_pessoa varchar, genero_pessoa varchar, senha_pessoa varchar, logou_pessoa varchar, cargo varchar) as $$
            begin
                if id_pessoa > 0 then
                        update funcionario set nomeImg = nomeImg, nomepessoa = nome_pessoa, cpfpessoa = cpf_pessoa, datanascimentopessoa = data_nascimento_pessoa, ceppessoa = cep_pessoa, cidadepessoa = cidade_pessoa, bairropessoa = bairro_pessoa, ruapessoa = rua_pessoa, numeropessoa = numero_pessoa, complementopessoa = complemento_pessoa, estadopessoa = estado_pessoa, telefonepessoa = telefone_pessoa, emailpessoa = email_pessoa, generopessoa = genero_pessoa, senhapessoa = senha_pessoa, logoupessoa = logou_pessoa, cargo = cargo where idpessoa = id_pessoa;   
                else
                    insert into funcionario values(DEFAULT, nomeImg, nome_pessoa, cpf_pessoa, data_nascimento_pessoa, cep_pessoa, cidade_pessoa, bairro_pessoa, rua_pessoa, numero_pessoa, complemento_pessoa, estado_pessoa,  telefone_pessoa, email_pessoa, genero_pessoa, senha_pessoa, logou_pessoa, cargo);
                end if;
            end;
        $$ language plpgsql;

        
        -- PROCEDURE CADASTRO E CONSULTA DO CLIENTE;

        create or replace procedure cadastrarcliente(id_pessoa int, nomeImg varchar, nome_pessoa varchar, cpf_pessoa varchar, data_nascimento_pessoa varchar, cep_pessoa varchar, cidade_pessoa varchar, bairro_pessoa varchar, rua_pessoa varchar, numero_pessoa varchar, complemento_pessoa varchar, estado_pessoa varchar, telefone_pessoa varchar, email_pessoa varchar, genero_pessoa varchar, senha_pessoa varchar, logou_pessoa varchar) as $$
            begin
                if id_pessoa > 0 then
                        update cliente set nomeImg = nomeImg, nomepessoa = nome_pessoa, cpfpessoa = cpf_pessoa, datanascimentopessoa = data_nascimento_pessoa, ceppessoa = cep_pessoa, cidadepessoa = cidade_pessoa, bairropessoa = bairro_pessoa, ruapessoa = rua_pessoa, numeropessoa = numero_pessoa, complementopessoa = complemento_pessoa, estadopessoa = estado_pessoa, telefonepessoa = telefone_pessoa, emailpessoa = email_pessoa, generopessoa = genero_pessoa, senhapessoa = senha_pessoa, logoupessoa = logou_pessoa where idpessoa = id_pessoa;   
                else
                    insert into cliente values(DEFAULT, nomeImg, nome_pessoa, cpf_pessoa, data_nascimento_pessoa, cep_pessoa, cidade_pessoa, bairro_pessoa, rua_pessoa, numero_pessoa, complemento_pessoa, estado_pessoa,  telefone_pessoa, email_pessoa, genero_pessoa, senha_pessoa, logou_pessoa);
                end if;
            end;
        $$ language plpgsql;

        -- CALL PARA TESTE:


        -- PROCEDURE CADASTRO E CONSULTA DE PET;

        create or replace procedure cadastrarpet(id_pet int, nomeImg varchar, nome_pet varchar, raca_pet varchar, idade_pet varchar, especie_pet varchar, cores_pet varchar, sexo_pet varchar, porte_pet varchar, observacoes_pet varchar) as $$
            begin
                if id_pet > 0 then
                    update pet set nomeimg = nomeImg, nomePet = nome_pet, racaPet = raca_pet, idadePet = idade_pet, especiePet = especie_pet, coresPet = cores_pet, sexoPet = sexo_pet, portePet = porte_pet, observacoes = observacoes_pet where idPet = id_pet;
                else
                    insert into pet values(default, nomeimg, nome_pet, raca_pet, idade_pet, especie_pet, cores_pet, sexo_pet, porte_pet, observacoes_pet);
                end if;
            end;
        $$ language plpgsql;

        -- CALL PARA TESTE:

       
        -- PROCEDURE DE USUARIO:


        create or replace view usuario as
        select pe.idpessoa as idusuario, pe.emailpessoa as emailusuario, pe.senhapessoa as senhausuario
        from pessoa pe inner join funcionario func on func.idpessoa = pe.idpessoa
        union
        select pe.idpessoa as idusuario, pe.emailpessoa as emailusuario, pe.senhapessoa as senhausuario
        from pessoa pe inner join cliente cli on cli.idpessoa = pe.idpessoa

-- CALL PARA TESTE:
insert into funcionario (idpessoa, nomeImg, nomepessoa, cpfpessoa, datanascimentopessoa, ceppessoa, cidadepessoa, bairropessoa, ruapessoa, numeropessoa, complementopessoa, estadopessoa,  telefonepessoa, emailpessoa, generopessoa, senhapessoa, cargo, logoupessoa) 
	VALUES (0, 'imagem', 'marta', '4747474747474', '45454555', '157550000', 'turmalina', 'jardim', 'rua 12', '47', 'jjjjjjjjjjj', 'sp', '454477777', 'ficava123@gmail.com', 'feminino', '1234', 'funcionario', 'funcionario')
        
call cadastrarfuncionario(0, 'imagem', 'marta', '4747474747474', '45454555', '157550000', 'turmalina', 'jardim', 'rua 12', '47', 'jjjjjjjjjjj', 'sp', '454477777', 'ficava123@gmail.com', 'feminino', '1234', 'funcionario', 'escritora')

call cadastrarcliente(0, 'imagem', 'marta', '4747474747474', '45454555', '157550000', 'turmalina', 'jardim', 'rua 12', '47', 'jjjjjjjjjjj', 'sp', '454477777', 'anamagaroti@gmail.com', 'feminino', '1234', 'cliente')

 CALL cadastrarPet(1,'ana','vira-lata','2anos', 'gata', 'preto e branco', 'femea', 'pequena', 'linda, cheirosa, carinhosa e obediente');

