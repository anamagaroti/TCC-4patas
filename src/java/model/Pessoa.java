package model;

public class Pessoa {
    int idPessoa;
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

    public Pessoa(String nomePessoa, String cpfPessoa, String dataNascimentoPessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa, String senhaPessoa, String logouPessoa) {
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
    
    public Pessoa(String nomePessoa, String cpfPessoa, String dataNascimentoPessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa) {
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
    
    public Pessoa(String nomePessoa, String cpfPessoa, String emailPessoa, String generoPessoa){
        this.nomePessoa = nomePessoa;
        this.cpfPessoa = cpfPessoa;
        this.emailPessoa = emailPessoa;
        this.generoPessoa = generoPessoa;
    }

    public Pessoa(String nomePessoa, String dataNascimentoPessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa) {
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
    
     public Pessoa(int idPessoa, String nomePessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
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
    
    public Pessoa() {
    }
 
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int codigoPessoa) {
        this.idPessoa = codigoPessoa;
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

    public void setBairroPessoa(String bairroPessoa) {
        this.bairroPessoa = bairroPessoa;
    }

    public String getRuaPessoa() {
        return ruaPessoa;
    }

    public void setRuaPessoa(String ruaPessoa) {
        this.ruaPessoa = ruaPessoa;
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

    public void setNumeroPessoa(String numeroPessoa) {
        this.numeroPessoa = numeroPessoa;
    }

    public String getComplementoPessoa() {
        return complementoPessoa;
    }

    public void setComplementoPessoa(String complementoPessoa) {
        this.complementoPessoa = complementoPessoa;
    }

    public String getCidadePessoa() {
        return cidadePessoa;
    }

    public void setCidadePessoa(String cidadePessoa) {
        this.cidadePessoa = cidadePessoa;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    public String getEstadoPessoa() {
        return estadoPessoa;
    }

    public void setEstadoPessoa(String estadoPessoa) {
        this.estadoPessoa = estadoPessoa;
    }

    public String getGeneroPessoa() {
        return generoPessoa;
    }

    public void setGeneroPessoa(String generoPessoa) {
        this.generoPessoa = generoPessoa;
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
    public void setSenhaPessoa(String senhaPessoa){
        this.senhaPessoa = senhaPessoa;
    }

    public String getLogouPessoa() {
        return logouPessoa;
    }

    public void setLogouPessoa(String logouPessoa) {
        this.logouPessoa = logouPessoa;
    }
}