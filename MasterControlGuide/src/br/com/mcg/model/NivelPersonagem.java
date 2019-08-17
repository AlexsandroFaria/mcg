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
public class NivelPersonagem {

    private int idNivelPersonagem;
    private int nivelPersonagem;
    private int nivelFacil;
    private int nivelMedio;
    private int nivelDificil;
    private int nivelMortal;

    public int getIdNivelPersonagem() {
        return idNivelPersonagem;
    }

    public int getNivelPersonagem() {
        return nivelPersonagem;
    }

    public void setNivelPersonagem(int nivelPersonagem) {
        this.nivelPersonagem = nivelPersonagem;
    }
    
    

    public void setIdNivelPersonagem(int idNivelPersonagem) {
        this.idNivelPersonagem = idNivelPersonagem;
    }

    public int getNivelFacil() {
        return nivelFacil;
    }

    public void setNivelFacil(int nivelFacil) {
        this.nivelFacil = nivelFacil;
    }

    public int getNivelMedio() {
        return nivelMedio;
    }

    public void setNivelMedio(int nivelMedio) {
        this.nivelMedio = nivelMedio;
    }

    public int getNivelDificil() {
        return nivelDificil;
    }

    public void setNivelDificil(int nivelDificil) {
        this.nivelDificil = nivelDificil;
    }

    public int getNivelMortal() {
        return nivelMortal;
    }

    public void setNivelMortal(int nivelMortal) {
        this.nivelMortal = nivelMortal;
    }

}
