/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.model;

/**
 *
 * @author Alexsandro Luiz de Faria
 */
public class Personagem {

    private int personagemId;
    private String nome;
    private String classe;
    private String raca;
    private String dadosDeVida;
    private int totalPontosVida;
    private int pontosVidaAtual;
    private int pontosDeExperiencia;
    private int nivel;
    private int pontoHeroico;
    private String situacao;

    public int getPersonagemId() {
        return personagemId;
    }

    public void setPersonagemId(int personagemId) {
        this.personagemId = personagemId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getDadosDeVida() {
        return dadosDeVida;
    }

    public void setDadosDeVida(String dadosDeVida) {
        this.dadosDeVida = dadosDeVida;
    }

    public int getTotalPontosVida() {
        return totalPontosVida;
    }

    public void setTotalPontosVida(int totalPontosVida) {
        this.totalPontosVida = totalPontosVida;
    }

    public int getPontosVidaAtual() {
        return pontosVidaAtual;
    }

    public void setPontosVidaAtual(int pontosVidaAtual) {
        this.pontosVidaAtual = pontosVidaAtual;
    }

    public int getPontosDeExperiencia() {
        return pontosDeExperiencia;
    }

    public void setPontosDeExperiencia(int pontosDeExperiencia) {
        this.pontosDeExperiencia = pontosDeExperiencia;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPontoHeroico() {
        return pontoHeroico;
    }

    public void setPontoHeroico(int pontoHeroico) {
        this.pontoHeroico = pontoHeroico;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
