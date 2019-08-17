/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.tabelaDeModelos;

import br.com.mcg.model.NivelPersonagem;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloNivelPersonagem extends AbstractTableModel{
    
    public static final int COLUNA_NIVEL_PERSONAGEM = 0;
    public static final int COLUNA_NIVEL_FACIL = 1;
    public static final int COLUNA_NIVEL_MEDIO = 2;
    public static final int COLUNA_NIVEL_DIFICIL = 3;
    public static final int COLUNA_NIVEL_MORTAL = 4;
    public ArrayList<NivelPersonagem>lista;

    public TabelaModeloNivelPersonagem(ArrayList<NivelPersonagem> lista) {
        this.lista = new ArrayList(lista);
    }
 
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        NivelPersonagem nivelPersonagem = lista.get(linha);
        if (coluna == COLUNA_NIVEL_PERSONAGEM) return nivelPersonagem.getIdNivelPersonagem();
        if (coluna == COLUNA_NIVEL_FACIL) return nivelPersonagem.getNivelFacil();
        if (coluna == COLUNA_NIVEL_MEDIO) return nivelPersonagem.getNivelMedio();
        if (coluna == COLUNA_NIVEL_DIFICIL) return nivelPersonagem.getNivelDificil();
        if (coluna == COLUNA_NIVEL_MORTAL) return nivelPersonagem.getNivelMortal();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_NIVEL_PERSONAGEM) return "Nível";
        if(coluna == COLUNA_NIVEL_FACIL) return "Nível Fácil";
        if(coluna == COLUNA_NIVEL_MEDIO) return "Nível Médio";
        if(coluna == COLUNA_NIVEL_DIFICIL) return "Nível Dificil";
        if(coluna == COLUNA_NIVEL_MORTAL) return "Nível Mortal";
        return "";
    }
    
    
}
