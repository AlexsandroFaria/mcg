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
public class Iniciativa {
    
    private int id_iniciativa;
    private String combatente;
    private int valor_iniciativa;

    public int getId_iniciativa() {
        return id_iniciativa;
    }

    public void setId_iniciativa(int id_iniciativa) {
        this.id_iniciativa = id_iniciativa;
    }

    public String getCombatente() {
        return combatente;
    }

    public void setCombatente(String combatente) {
        this.combatente = combatente;
    }

    public int getValor_iniciativa() {
        return valor_iniciativa;
    }

    public void setValor_iniciativa(int valor_iniciativa) {
        this.valor_iniciativa = valor_iniciativa;
    }
    
    
    
}
