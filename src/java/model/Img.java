package model;

import java.io.File;

public class Img {
    private int codigo;
    private String imagem;
    private String nomeImg;

    public Img(int codigo, String imagem, String nomeImg) {
        this.codigo = codigo;
        this.imagem = imagem;
        this.nomeImg = nomeImg;
    }

    public Img(File filePath, String nomeImg) {
        this.imagem = imagem;
        this.nomeImg = nomeImg;
   }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
