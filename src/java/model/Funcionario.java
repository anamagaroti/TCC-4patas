package model;

import java.io.File;

public class Funcionario extends Pessoa {

    private int idFuncionario;
    private String cargo;

    //1
    public Funcionario(int idFuncionario, String nomeImg, String nomePessoa, String cpfPessoa, String dataNascimentoPessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa, String senhaPessoa,String logouPessoa, String cargo) {
        super(nomeImg, nomePessoa, cpfPessoa, dataNascimentoPessoa, cepPessoa, cidadePessoa, bairroPessoa, ruaPessoa, numeroPessoa, complementoPessoa, estadoPessoa, telefonePessoa, emailPessoa, generoPessoa, senhaPessoa, logouPessoa);
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
    }
    //2
    public Funcionario(int idFuncionario, String nomeImg, String nomePessoa, String cpfPessoa, String emailPessoa, String generoPessoa, String cargo) {
        super(nomeImg, nomePessoa, cpfPessoa, emailPessoa, generoPessoa);
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
    }
      
    public  Funcionario(){
        super("","","","","","","","","","","","","");
    }

    //3
     public Funcionario(int idPessoa, String nomeImg, String nomePessoa, String cpfPessoa, String dataNascimentoPessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa, String cargo) {
        super(idPessoa, nomeImg, nomePessoa, cpfPessoa,  dataNascimentoPessoa, cepPessoa, cidadePessoa, bairroPessoa, ruaPessoa, numeroPessoa, complementoPessoa, estadoPessoa, telefonePessoa, emailPessoa, generoPessoa);
        this.cargo = cargo;
    }
  
    //4
    public Funcionario(File filePath, String nomeImg) {
       super(filePath, nomeImg);
    }
   
    public Funcionario(int idFuncionario){
       this.idFuncionario = idFuncionario;
   }
   
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }  

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
