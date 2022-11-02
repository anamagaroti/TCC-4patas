package model;

import java.io.File;

public class Cliente extends Pessoa{

    private int idCliente;
    private String imagem;
    private String nomeImg;

    public Cliente(int idCliente, String imagem, String nomePessoa, String cpfPessoa, String dataNascimentoPessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa, String senhaPessoa, String logouPessoa) {
        super(nomePessoa, cpfPessoa,  dataNascimentoPessoa, cepPessoa, cidadePessoa, bairroPessoa, ruaPessoa, numeroPessoa, complementoPessoa, estadoPessoa, telefonePessoa, emailPessoa, generoPessoa, senhaPessoa, logouPessoa);
        this.imagem = imagem;
        this.idCliente = idCliente;
    }
    
    public Cliente(){
        super("","","","","","","","","","","","","");
    }
 
    public Cliente(int idCliente, String nomeImg, String nomePessoa, String dataNascimentoPessoa, String cepPessoa, String cidadePessoa, String bairroPessoa, String ruaPessoa, String numeroPessoa, String complementoPessoa, String estadoPessoa, String telefonePessoa, String emailPessoa, String generoPessoa) {
        super(nomePessoa, dataNascimentoPessoa, cepPessoa, cidadePessoa, bairroPessoa, ruaPessoa, numeroPessoa, complementoPessoa, estadoPessoa, telefonePessoa, emailPessoa, generoPessoa);
        this.idCliente = idCliente;
        this.nomeImg = nomeImg;
    }

        public Cliente(File filePath, String nomeImg) {
        this.imagem = imagem;
        this.nomeImg = nomeImg;
    }

    public Cliente(int idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }
        public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNomeImg() {
        return nomeImg;
    }

    public void setNomeImg(String nomeImg) {
        this.nomeImg = nomeImg;
    }
}
    
    