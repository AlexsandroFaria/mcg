/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.model;

/**
 *
 * @author alafaria
 */
public class RepositorioMonstros {
    
    private int idRepositorioMonstros;
    private String nomeMonstro;
    private String tipo;
    private int classeDeArmadura;
    private String pontosDeVida;
    private int pontosDeVidaAtual;
    private String deslocamento;
    private String nivelDeDesafio;
    private String referencia;
    private String situacao;

    public int getIdRepositorioMonstros() {
        return idRepositorioMonstros;
    }

    public void setIdRepositorioMonstros(int idRepositorioMonstros) {
        this.idRepositorioMonstros = idRepositorioMonstros;
    }

    public String getNomeMonstro() {
        return nomeMonstro;
    }

    public void setNomeMonstro(String nomeMonstro) {
        this.nomeMonstro = nomeMonstro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getClasseDeArmadura() {
        return classeDeArmadura;
    }

    public void setClasseDeArmadura(int classeDeArmadura) {
        this.classeDeArmadura = classeDeArmadura;
    }

    public String getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(String pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public int getPontosDeVidaAtual() {
        return pontosDeVidaAtual;
    }

    public void setPontosDeVidaAtual(int pontosDeVidaAtual) {
        this.pontosDeVidaAtual = pontosDeVidaAtual;
    }

    public String getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(String deslocamento) {
        this.deslocamento = deslocamento;
    }

    public String getNivelDeDesafio() {
        return nivelDeDesafio;
    }

    public void setNivelDeDesafio(String nivelDeDesafio) {
        this.nivelDeDesafio = nivelDeDesafio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return this.getNomeMonstro();
    }
}
