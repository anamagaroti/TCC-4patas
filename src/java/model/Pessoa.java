package model;

import java.io.File;

public class Pessoa {
    int idPessoa;
    private String nomeImg;
    private String nomePessoa;
    private String cpfPessoa;  
    private String dataNascimentoPessoa;
    private String cepPessoa;
    private String cidadePessoa;
    private String bairroPessoa;  
    private String ruaPessoa;
    private String numeroPessoa;
    private String complementoPessoa;
    private String estadoPessoa;
    private String telefonePessoa;
    private String emailPessoa;
    private String generoPessoa;
    private String senhaPessoa;
    private String logouPessoa;

    //3 funcionario
     public Pessoa(int idPessoa, String nomeImg, String nomePessoa, String cpfPessoa, String dataNascimentoPessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa) {
        this.idPessoa = idPessoa;
        this.nomeImg = nomeImg;
        this.nomePessoa = nomePessoa;
        this.cpfPessoa = cpfPessoa;
        this.dataNascimentoPessoa = dataNascimentoPessoa;
        this.cepPessoa = cepPessoa;
        this.cidadePessoa = cidadePessoa;
        this.bairroPessoa = bairroPessoa;
        this.ruaPessoa = ruaPessoa;
        this.numeroPessoa = numeroPessoa; 
        this.complementoPessoa = complementoPessoa; 
        this.estadoPessoa = estadoPessoa;     
        this.telefonePessoa = telefonePessoa;
        this.emailPessoa = emailPessoa;
        this.generoPessoa = generoPessoa;
    }
    //1 funcionario e cliente
    public Pessoa(String nomeImg, String nomePessoa, String cpfPessoa, String dataNascimentoPessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa, String senhaPessoa, String logouPessoa) {
        this.nomeImg = nomeImg;
        this.nomePessoa = nomePessoa;
        this.cpfPessoa = cpfPessoa;
        this.dataNascimentoPessoa = dataNascimentoPessoa;
        this.cepPessoa = cepPessoa;
        this.cidadePessoa = cidadePessoa;
        this.bairroPessoa = bairroPessoa;
        this.ruaPessoa = ruaPessoa;
        this.numeroPessoa = numeroPessoa; 
        this.complementoPessoa = complementoPessoa; 
        this.estadoPessoa = estadoPessoa;     
        this.telefonePessoa = telefonePessoa;
        this.emailPessoa = emailPessoa;
        this.generoPessoa = generoPessoa;
        this.senhaPessoa = senhaPessoa;
        this.logouPessoa = logouPessoa;
    }
    
    //PessoaDAO
    public Pessoa(int idPessoa, String nomeImg, String nomePessoa, String cpfPessoa, String dataNascimentoPessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa, String senhaPessoa, String logouPessoa) {
        this.idPessoa = idPessoa;
        this.nomeImg = nomeImg;
        this.nomePessoa = nomePessoa;
        this.cpfPessoa = cpfPessoa;
        this.dataNascimentoPessoa = dataNascimentoPessoa;
        this.cepPessoa = cepPessoa;
        this.cidadePessoa = cidadePessoa;
        this.bairroPessoa = bairroPessoa;
        this.ruaPessoa = ruaPessoa;
        this.numeroPessoa = numeroPessoa; 
        this.complementoPessoa = complementoPessoa; 
        this.estadoPessoa = estadoPessoa;     
        this.telefonePessoa = telefonePessoa;
        this.emailPessoa = emailPessoa;
        this.generoPessoa = generoPessoa;
        this.senhaPessoa = senhaPessoa;
        this.logouPessoa = logouPessoa;
    }
    
    //2 funcionario 
    public Pessoa(String nomeImg, String nomePessoa, String cpfPessoa, String emailPessoa, String generoPessoa){
        this.nomeImg = nomeImg;
        this.nomePessoa = nomePessoa;
        this.cpfPessoa = cpfPessoa;
        this.emailPessoa = emailPessoa;
        this.generoPessoa = generoPessoa;
    }

    //3 cliente
    public Pessoa(String nomeImg, String nomePessoa, String dataNascimentoPessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa) {
        this.nomeImg = nomeImg;
        this.nomePessoa = nomePessoa;
        this.dataNascimentoPessoa = dataNascimentoPessoa;
        this.cepPessoa = cepPessoa;
        this.cidadePessoa = cidadePessoa;
        this.bairroPessoa = bairroPessoa;
        this.ruaPessoa = ruaPessoa;
        this.numeroPessoa = numeroPessoa;
        this.complementoPessoa = complementoPessoa;
        this.estadoPessoa = estadoPessoa;
        this.telefonePessoa = telefonePessoa;
        this.emailPessoa = emailPessoa;
        this.generoPessoa = generoPessoa;
    }
    
    //4 cliente e funcionario 
    public Pessoa(File filePath, String nomeImg) {
        this.nomeImg = nomeImg;
    }
    
    public Pessoa(int idPessoa){
        this.idPessoa = idPessoa;
    }
    
    public Pessoa() {
    
    }
    
    public int getPessoa(int pessoa){
        return pessoa;
    }

    public int getIdPessoa() {
        return idPessoa;
    }
    
    public void setIdPessoa(int codigoPessoa) {
        this.idPessoa = codigoPessoa;
    }
    
    public String getNomeImg() {
        return nomeImg;
    }
    
    public String getNomeImg(String string) {
        return nomeImg; 
    }
    
    public void setNomeImg(String nomeImg) {
        this.nomeImg = nomeImg;
    }

    public String getNomePessoa(String string) {
        return nomePessoa;
    }
    
    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getDataNascimentoPessoa() {
        return dataNascimentoPessoa;
    }

    public void setDataNascimentoPessoa(String dataNascimentoPessoa) {
        this.dataNascimentoPessoa = dataNascimentoPessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public String getBairroPessoa() {
        return bairroPessoa;
    }

    public String setBairroPessoa(String bairroPessoa) {
        this.bairroPessoa = bairroPessoa;
        return bairroPessoa;
    }

    public String getRuaPessoa() {
        return ruaPessoa;
    }

    public String setRuaPessoa(String ruaPessoa) {
        this.ruaPessoa = ruaPessoa;
        return ruaPessoa;
    }

    public String getCepPessoa() {
        return cepPessoa;
    }

    public void setCepPessoa(String cepPessoa) {
        this.cepPessoa = cepPessoa;
    }

    public String getNumeroPessoa() {
        return numeroPessoa;
    }

    public String setNumeroPessoa(String numeroPessoa) {
        this.numeroPessoa = numeroPessoa;
        return numeroPessoa;
    }

    public String getComplementoPessoa() {
        return complementoPessoa;
    }

    public String setComplementoPessoa(String complementoPessoa) {
        this.complementoPessoa = complementoPessoa;
        return complementoPessoa;
    }

    public String getCidadePessoa() {
        return cidadePessoa;
    }

    public String setCidadePessoa(String cidadePessoa) {
        this.cidadePessoa = cidadePessoa;
        return cidadePessoa;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public String setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
        return emailPessoa;
    }

    public String getEstadoPessoa() {
        return estadoPessoa;
    }

    public String setEstadoPessoa(String estadoPessoa) {
        this.estadoPessoa = estadoPessoa;
        return estadoPessoa;
    }

    public String getGeneroPessoa() {
        return generoPessoa;
    }

    public String setGeneroPessoa(String generoPessoa) {
        this.generoPessoa = generoPessoa;
        return generoPessoa;
    }
    
    public String getTelefonePessoa(String string) {
        return telefonePessoa;
    }
    
    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }
    public String getSenhaPessoa(){
        return senhaPessoa;
    }
    public String setSenhaPessoa(String senhaPessoa){
        this.senhaPessoa = senhaPessoa;
        return senhaPessoa;
    }

    public String getLogouPessoa() {
        return logouPessoa;
    }

    public void setLogouPessoa(String logouPessoa) {
        this.logouPessoa = logouPessoa;
    }

    public String getCpfPessoa(String cpfpessoa) {
        this.cpfPessoa = cpfpessoa;
        return cpfPessoa;
    }

    public String getDataNascimentoPessoa(String data) {
        this.dataNascimentoPessoa = data;
        return data;
    }

    public String getCepPessoa(String cep) {
        this.cepPessoa = cep;
        return cep;
    }

    public String getEmailPessoa(String email) {
        this.emailPessoa = email;
        return email;
    }

    public String getGeneroPessoa(String genero) {
        this.generoPessoa = genero;
        return genero;
    }
}