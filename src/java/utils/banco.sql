        create table pessoa(
            idPessoa serial not null primary key,
            nomeImg varchar,
            nomePessoa varchar not null,                        
            cpfPessoa varchar not null,
            dataNascimentoPessoa varchar not null,
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

        create table funcionario(
            idFuncionario int not null primary key references pessoa(idpessoa),
            cargo varchar not null
        );

        create table cliente(
            idCliente int not null primary key references pessoa(idpessoa)
        );

        create table pet(
            idPet serial not null primary key,
            idPessoa int not null references pessoa(idpessoa),
            nomeImg varchar not null,
            nomepet varchar not null,
            racapet varchar not null,
            idadepet varchar not null,
            especiepet varchar not null,
            corespet varchar not null,
            sexopet varchar not null,
            portepet varchar not null,
            observacoes varchar not null,
            adocao boolean not null,
            doado boolean not null
        );

        create table Adocao(
            idAdocao serial not null primary key,
            idPessoa int not null references pessoa(idpessoa),
            idPet int not null references pet(idpet),
            adotado boolean not null
        );

        create table reclamacao(
            idreclamacao serial not null primary key,
            reclamacao varchar not null,
            idcliente int not null references cliente(idcliente)      
        );
        
        -- PROCEDURE CADASTRO E CONSULTA DE PESSOA;

        create or replace function cadastrarpessoa(id_pessoa int, nome_img varchar, nome_pessoa varchar, cpf_pessoa varchar, data_nascimento_pessoa varchar, cep_pessoa varchar, cidade_pessoa varchar, bairro_pessoa varchar, numero_pessoa varchar, rua_pessoa varchar, complemento_pessoa varchar, estado_pessoa varchar,  telefone_pessoa varchar, email_pessoa varchar, genero_pessoa varchar, senha_pessoa varchar, logou_pessoa varchar) returns int as $$
                    declare
                retornoCodigoPessoa int := 0;
                begin
                    if id_pessoa > 0 then
                        update pessoa set  nomeImg = nome_img, nomepessoa = nome_pessoa, cpfpessoa = cpf_pessoa, datanascimentopessoa = data_nascimento_pessoa, ceppessoa = cep_pessoa, cidadepessoa = cidade_pessoa, bairropessoa = bairro_pessoa, ruapessoa = rua_pessoa, numeropessoa = numero_pessoa, complementopessoa = complemento_pessoa, estadopessoa = estado_pessoa, telefonepessoa = telefone_pessoa, emailpessoa = email_pessoa, generopessoa = genero_pessoa, senhapessoa = senha_pessoa, logoupessoa = logou_pessoa where idpessoa = id_pessoa returning idpessoa into retornoCodigoPessoa;
                    else
                        insert into pessoa values(DEFAULT, nome_img, nome_pessoa, cpf_pessoa, data_nascimento_pessoa, cep_pessoa, cidade_pessoa, bairro_pessoa, rua_pessoa, numero_pessoa, complemento_pessoa, estado_pessoa,  telefone_pessoa, email_pessoa, genero_pessoa, senha_pessoa, logou_pessoa) returning idpessoa into retornoCodigoPessoa;
                    end if;
                return retornoCodigoPessoa;
            end;
        $$ language plpgsql;
        
        -- PROCEDURE CADASTRO E CONSULTA DO FUNCIONARIO;

        create or replace procedure cadastrarfuncionario(id_funcionario int, nome_img varchar, nome_pessoa varchar, cpf_pessoa varchar, data_nascimento_pessoa varchar, cep_pessoa varchar, cidade_pessoa varchar, bairro_pessoa varchar, numero_pessoa varchar, rua_pessoa varchar, complemento_pessoa varchar, estado_pessoa varchar,  telefone_pessoa varchar, email_pessoa varchar, genero_pessoa varchar, senha_pessoa varchar, logou_pessoa varchar, cargo_funcionario varchar) as $$
            declare
                idFunc int := 0;
                idPe int := 0;
            begin
                select into idFunc idFuncionario from funcionario where idFuncionario = id_funcionario;
                select into idPe idpessoa from pessoa where idpessoa = id_funcionario;
                if idFunc > 0 and idPe > 0 then
                    update funcionario set idFuncionario = (select cadastrarpessoa(id_funcionario, nome_img, nome_pessoa, cpf_pessoa, data_nascimento_pessoa, cep_pessoa, cidade_pessoa, bairro_pessoa, rua_pessoa, numero_pessoa, complemento_pessoa, estado_pessoa,  telefone_pessoa, email_pessoa, genero_pessoa, senha_pessoa, logou_pessoa)), cargo = cargo_funcionario where idFuncionario = id_cliente;
                else
                    insert into funcionario values((select cadastrarpessoa(id_funcionario, nome_img, nome_pessoa, cpf_pessoa, data_nascimento_pessoa, cep_pessoa, cidade_pessoa, bairro_pessoa, rua_pessoa, numero_pessoa, complemento_pessoa, estado_pessoa,  telefone_pessoa, email_pessoa, genero_pessoa, senha_pessoa, logou_pessoa)), cargo_funcionario);
                end if;
            end;
        $$ language plpgsql;


        
        -- PROCEDURE CADASTRO E CONSULTA DO CLIENTE;

        create or replace procedure cadastrarcliente(id_cliente int, nome_img varchar, nome_pessoa varchar, cpf_pessoa varchar, data_nascimento_pessoa varchar, cep_pessoa varchar, cidade_pessoa varchar, bairro_pessoa varchar, numero_pessoa varchar, rua_pessoa varchar, complemento_pessoa varchar, estado_pessoa varchar,  telefone_pessoa varchar, email_pessoa varchar, genero_pessoa varchar, senha_pessoa varchar, logou_pessoa varchar) as $$
            declare
                idCli int := 0;
                idPe int := 0;
            begin
                select into idCli idCliente from cliente where idCliente = id_cliente;
                select into idPe idpessoa from pessoa where idpessoa = id_cliente;
                if idCli > 0 and idPe > 0 then
                    update cliente set idCliente = (select cadastrarpessoa(id_cliente, nome_img, nome_pessoa, cpf_pessoa, data_nascimento_pessoa, cep_pessoa, cidade_pessoa, bairro_pessoa, rua_pessoa, numero_pessoa, complemento_pessoa, estado_pessoa,  telefone_pessoa, email_pessoa, genero_pessoa, senha_pessoa, logou_pessoa)) where idcliente = id_cliente;
                else
                    insert into cliente values((select cadastrarpessoa(id_cliente, nome_img, nome_pessoa, cpf_pessoa, data_nascimento_pessoa, cep_pessoa, cidade_pessoa, bairro_pessoa, rua_pessoa, numero_pessoa, complemento_pessoa, estado_pessoa,  telefone_pessoa, email_pessoa, genero_pessoa, senha_pessoa, logou_pessoa)));
                end if;
            end;
        $$ language plpgsql;

        -- CALL PARA TESTE:


        -- PROCEDURE CADASTRO E CONSULTA DE PET;

         create or replace procedure cadastrarpet(id_pet int, id_pessoa int, nome_img varchar, nome_pet varchar, raca_pet varchar, idade_pet varchar, especie_pet varchar, cores_pet varchar, sexo_pet varchar, porte_pet varchar, observacoes_pet varchar, adocao_pet boolean, doado_pet boolean) as $$
            begin
                if id_pet > 0 then
                    update pet set idpessoa = id_pessoa, nomeimg = nome_img, nomePet = nome_pet, racaPet = raca_pet, idadePet = idade_pet, especiePet = especie_pet, coresPet = cores_pet, sexoPet = sexo_pet, portePet = porte_pet, observacoes = observacoes_pet, adocao = adocao_pet, doado = doado_pet where idPet = id_pet;
                else
                    insert into pet values(default, id_pessoa, nome_img, nome_pet, raca_pet, idade_pet, especie_pet, cores_pet, sexo_pet, porte_pet, observacoes_pet, adocao_pet, doado_pet);
                end if;
            end;
        $$ language plpgsql;

        -- PROCEDURE CADASTRO E CONSULTA DE ADOÇÃO;
        
        create or replace procedure cadastraradocao(id_adocao int, id_pessoa int, id_pet int, adotado_adocao boolean) as $$
            begin
                if id_adocao > 0 then
                    update adocao set idpessoa = id_pessoa, idpet = id_pet, adotado = adotado_adocao where idAdocao = id_adocao;
                else
                    insert into adocao values(default, id_pessoa, id_pet, adotado_adocao);
                end if;
            end;
        $$ language plpgsql;

        -- PROCEDURE CADASTRO E CONSULTA DE RECLAMAÇÃO;

        create or replace procedure cadastrarReclamacao(id_reclamacao int, reclamacao varchar, id_cliente int) as $$
            begin
                if id_reclamacao > 0 then
                    update reclamacao set reclamacao = reclamacao, idCliente = id_cliente where idreclamacao = id_reclamacao;
                else
                    insert into reclamacao values(default, reclamacao, id_cliente);
                end if;
            end;
        $$ language plpgsql;


        -- CALL PARA TESTE:


-- CALL PARA TESTE:
insert into funcionario (idpessoa, nomeImg, nomepessoa, cpfpessoa, datanascimentopessoa, ceppessoa, cidadepessoa, bairropessoa, ruapessoa, numeropessoa, complementopessoa, estadopessoa,  telefonepessoa, emailpessoa, generopessoa, senhapessoa, cargo, logoupessoa) 
	VALUES (0, 'imagem', 'marta', '4747474747474', '45454555', '157550000', 'turmalina', 'jardim', 'rua 12', '47', 'jjjjjjjjjjj', 'sp', '454477777', 'ficava123@gmail.com', 'feminino', '1234', 'funcionario', 'funcionario')
        
call cadastrarfuncionario(0, 'imagem', 'marta', '4747474747474', '45454555', '157550000', 'turmalina', 'jardim', 'rua 12', '47', 'jjjjjjjjjjj', 'sp', '454477777', 'ficava123@gmail.com', 'feminino', '1234', 'funcionario', 'escritora')

call cadastrarcliente(0, 'imagem', 'marta', '4747474747474', '45454555', '157550000', 'turmalina', 'jardim', 'rua 12', '47', 'jjjjjjjjjjj', 'sp', '454477777', 'anamagaroti@gmail.com', 'feminino', '1234', 'cliente')

 CALL cadastrarPet(1,'ana','vira-lata','2anos', 'gata', 'preto e branco', 'femea', 'pequena', 'linda, cheirosa, carinhosa e obediente');
