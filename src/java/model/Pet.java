package model;

import java.io.File;

public class Pet{

    private int idPet;
    private Cliente cliente;
    private String nomeImg;
    private String imagem;
    private String nomePet;
    private String racaPet;
    private String idadePet;
    private String coresPet;
    private String especiePet;
    private String sexoPet;
    private String portePet;
    private String observacoes;
    public Object getCliente;

    public Pet(int idPet, Cliente cliente, String nomeImg, String nomePet, String racaPet,  String idadePet, String especiePet, String coresPet, String sexoPet, String portePet, String observacoes) {
        this.idPet = idPet;
        this.cliente = cliente;
        this.nomeImg = nomeImg;
        this.nomePet = nomePet;
        this.idadePet = idadePet;
        this.racaPet = racaPet;
        this.coresPet = coresPet;
        this.especiePet = especiePet;
        this.sexoPet = sexoPet;
        this.portePet = portePet;
        this.observacoes = observacoes;
    }
     public Pet(int idPet, String nomeImg, String nomePet, String racaPet,  String idadePet, String especiePet, String coresPet, String sexoPet, String portePet, String observacoes) {
        this.idPet = idPet;
        this.nomeImg = nomeImg;
        this.nomePet = nomePet;
        this.idadePet = idadePet;
        this.racaPet = racaPet;
        this.coresPet = coresPet;
        this.especiePet = especiePet;
        this.sexoPet = sexoPet;
        this.portePet = portePet;
        this.observacoes = observacoes;
    }

    public Pet(int idPet){
        this.idPet = idPet;
    }
    public Pet(File filePath, String nomeImg) {
        this.imagem = imagem;
        this.nomeImg = nomeImg;
    }

    public Pet() {     
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNomeImg() {
        return nomeImg;
    }

    public void setNomeImg(String nomeImg) {
        this.nomeImg = nomeImg;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getIdadePet() {
        return idadePet;
    }

    public void setIdadePet(String idadePet) {
        this.idadePet = idadePet;
    }

    public String getRacaPet() {
        return racaPet;
    }

    public void setRacaPet(String racaPet) {
        this.racaPet = racaPet;
    }

    public String getCoresPet() {
        return coresPet;
    }

    public void setCoresPet(String coresPet) {
        this.coresPet = coresPet;
    }

    public String getEspeciePet() {
        return especiePet;
    }

    public void setEspeciePet(String especiePet) {
        this.especiePet = especiePet;
    }

    public String getSexoPet() {
        return sexoPet;
    }

    public void setSexoPet(String sexoPet) {
        this.sexoPet = sexoPet;
    }

    public String getPortePet() {
        return portePet;
    }

    public void setPortePet(String portePet) {
        this.portePet = portePet;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}

