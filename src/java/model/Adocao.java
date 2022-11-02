package model;

public class Adocao{

    private int idAdocao;
    private String dataAdocao;
    private String horarioAdocao;
    private Pet pet;    
    private Funcionario funcionario;
    private Cliente cliente;

    public Adocao(int idAdocao, String dataAdocao, String horarioAdocao, Pet pet, Funcionario funcionario, Cliente cliente) {
        this.idAdocao = idAdocao;
        this.dataAdocao = dataAdocao;
        this.horarioAdocao = horarioAdocao;
        this.pet = pet;
        this.funcionario = funcionario;
        this.cliente = cliente;
    }
    public Adocao(int idAdocao, String dataAdocao, String horarioAdocao, Pet pet, Funcionario funcionario) {
        this.idAdocao = idAdocao;
        this.dataAdocao = dataAdocao;
        this.horarioAdocao = horarioAdocao;
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

    public String getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(String dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    public String getHorarioAdocao() {
        return horarioAdocao;
    }

    public void setHorarioAdocao(String horarioAdocao) {
        this.horarioAdocao = horarioAdocao;
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
