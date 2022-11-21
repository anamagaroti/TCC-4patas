package model;

import java.io.File;

public class Cliente extends Pessoa{

    private int idCliente;

    //1
    public Cliente(int idCliente, String nomeImg, String nomePessoa, String cpfPessoa, String dataNascimentoPessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa, String senhaPessoa, String logouPessoa) {
        super(nomeImg, nomePessoa, cpfPessoa,  dataNascimentoPessoa, cepPessoa, cidadePessoa, bairroPessoa, ruaPessoa, numeroPessoa, complementoPessoa, estadoPessoa, telefonePessoa, emailPessoa, generoPessoa, senhaPessoa, logouPessoa);
        this.idCliente = idCliente;
    }
    
    public Cliente(){
        super("","","","","","","","","","","","","");
    }
 
    //3
    public Cliente(int idCliente, String nomeImg, String nomePessoa, String dataNascimentoPessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa) {
        super(nomeImg, nomePessoa, dataNascimentoPessoa, cepPessoa, cidadePessoa, bairroPessoa, ruaPessoa, numeroPessoa, complementoPessoa, estadoPessoa, telefonePessoa, emailPessoa, generoPessoa);
        this.idCliente = idCliente;
    }
    
    //4
    public Cliente(File filePath, String nomeImg) {
        super(filePath, nomeImg);
    }

    @Override
    public String getTelefonePessoa(String string) {
        return super.getTelefonePessoa(string); 
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }

    @Override
    public String getNomePessoa(String string) {
        return super.getNomePessoa(string);    
    }

    @Override
    public String getNomeImg(String string) {
        return super.getNomeImg(); 
    }
    
}
    
    