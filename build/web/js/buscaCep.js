$("input#cep").blur(function () {

    //Nova variável "cep" somente com dígitos.
    let cep = $(this).val();

    //Verifica se campo cep possui valor informado.
    if (cep !== "") {
        //Consulta o webservice viacep.com.br/
        $.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {

            if (!("erro" in dados)) {
                //Atualiza os campos com os valores da consulta.
                $("#cidade").val(dados.localidade);
                $("#bairro").val(dados.bairro);
                $("#uf").val(dados.uf);
            } //end if.
            else {
                //CEP pesquisado não foi encontrado.
                limpa_formulário_cep();
                alert("CEP não encontrado.");
            }
        });
        //end if.
    } else {
        //cep é inválido.
        limpa_formulário_cep();
        alert("Formato de CEP inválido.");
    }
    });

