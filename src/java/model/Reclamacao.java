
package model;


public class Reclamacao {

    private int idReclamacao;
    private String reclamacao;
    private Cliente cliente;

    public Reclamacao(int idReclamacao, String reclamacao, Cliente cliente) {
        this.idReclamacao = idReclamacao;
        this.reclamacao = reclamacao;
        this.cliente = cliente;
    }
    
    public Reclamacao(int idReclamacao, String reclamacao) {
        this.idReclamacao = idReclamacao;
        this.reclamacao = reclamacao;
    }
   
    public int getIdReclamacao() {
        return idReclamacao;
    }

    public void setIdReclamacao(int idReclamacao) {
        this.idReclamacao = idReclamacao;
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
