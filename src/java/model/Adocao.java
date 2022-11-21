package model;

public class Adocao{

    private int idAdocao;
    private Pessoa pessoa;
    private Pet pet;


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
}
