package model;

public class Adocao{

    private int idAdocao;
    private Pessoa pessoa;
    private Pet pet;
    private boolean adotado;


    public Adocao(int idAdocao, Pessoa pessoa, Pet pet, boolean adotado) {
        this.idAdocao = idAdocao;
        this.pessoa = pessoa;
        this.pet = pet;
        this.adotado = adotado;
    }
    
     public Adocao(int idAdocao, Pessoa pessoa, Pet pet) {
        this.idAdocao = idAdocao;
        this.pessoa = pessoa;
        this.pet = pet;
    }
  
    public Adocao(){
        
    }

    public int getIdAdocao() {
        return idAdocao;
    }

    public void setIdAdocao(int idAdocao) {
        this.idAdocao = idAdocao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public boolean isAdotado() {
        return adotado;
    }

    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }
}
