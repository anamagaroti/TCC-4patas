package model;

public class Adocao{

    private int idAdocao;
    private Pet pet;    
    private Funcionario funcionario;
    private Cliente cliente;

    public Adocao(int idAdocao, Pet pet, Cliente cliente) {
        this.idAdocao = idAdocao;
        this.pet = pet;
        this.cliente = cliente;
    }
    public Adocao(int idAdocao, Pet pet, Funcionario funcionario) {
        this.idAdocao = idAdocao;
        this.pet = pet;
        this.funcionario = funcionario;
    }
    public Adocao(){
        
    }

    public int getIdAdocao() {
        return idAdocao;
    }

    public void setIdAdocao(int idAdocao) {
        this.idAdocao = idAdocao;
    }
    
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }  
}
