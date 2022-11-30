package model;

import java.io.File;

public class Pet {

    private int idPet;
    private Pessoa pessoa;
    private String nomeImg;
    private String nomePet;
    private String racaPet;
    private String idadePet;
    private String coresPet;
    private String especiePet;
    private String sexoPet;
    private String portePet;
    private String observacoes;
    private boolean adocao;
    private boolean doar;

    public Pet(int idPet, Pessoa pessoa, String nomeImg, String nomePet, String racaPet, String idadePet, String especiePet, String coresPet, String sexoPet, String portePet, String observacoes, boolean adocao, boolean doar) {
        this.idPet = idPet;
        this.pessoa = pessoa;
        this.nomeImg = nomeImg;
        this.nomePet = nomePet;
        this.idadePet = idadePet;
        this.racaPet = racaPet;
        this.coresPet = coresPet;
        this.especiePet = especiePet;
        this.sexoPet = sexoPet;
        this.portePet = portePet;
        this.observacoes = observacoes;
        this.adocao = adocao;
        this.doar = doar;
    }
    public Pet(int idPet, String nomeImg, String nomePet, String racaPet, String idadePet, String especiePet, String coresPet, String sexoPet, String portePet, String observacoes, boolean adocao, boolean doar) {
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
        this.adocao = adocao;
        this.doar = doar;
    }

    public Pet(int idPet, String nomeImg, String nomePet, String racaPet, String idadePet, String especiePet, String coresPet, String sexoPet, String portePet, String observacoes) {
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

    public Pet(int idPet) {
        this.idPet = idPet;
    }

    public Pet(File filePath, String nomeImg) {
        this.nomeImg = nomeImg;
    }

    public Pet() {
    }

    public int getIdPet() {
        return idPet;
    }

    public void getIdPet(int idPet) {
        this.idPet = idPet;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public int getPessoa(int pessoa) {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

    public String getNomePet() {
        return nomePet;
    }

    public String getNomePet(String string) {
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

    public String setEspeciePet(String especiePet) {
        this.especiePet = especiePet;
        return especiePet;
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

    public void getRacaPet(String string) {
        this.racaPet = string;
    }

    public void getIdadePet(String string) {
        this.idadePet = string;
    }

    public void getCoresPet(String string) {
        this.coresPet = string;
    }

    public void getEspeciePet(String string) {
        this.especiePet = string;
    }

    public void getSexoPet(String string) {
        this.sexoPet = string;
    }

    public void getPortePet(String string) {
        this.portePet = string;
    }

    public void getObservacoes(String string) {
        this.observacoes = string;
    }

    public boolean setAdocao(boolean adocao) {
        this.adocao = adocao;
        return adocao;
    }
    
    public boolean isAdocao() {
        return adocao;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public boolean isAdocao(boolean adocao) {
        return adocao;
    }

    public boolean isDoar() {
        return doar;
    }

    public void setDoar(boolean doar) {
        this.doar = doar;
    }
}
