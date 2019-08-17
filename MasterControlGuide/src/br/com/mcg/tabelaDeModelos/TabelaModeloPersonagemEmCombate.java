/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.tabelaDeModelos;

import br.com.mcg.model.Personagem;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloPersonagemEmCombate extends AbstractTableModel{

    public static final int COLUNA_NOME_PERSONAGEM = 0;
    public static final int COLUNA_PONTOS_VIDA_ATUAL = 1;
    public static final int COLUNA_SITUACAO = 2;
    public ArrayList<Personagem>lista;

    public TabelaModeloPersonagemEmCombate(ArrayList<Personagem> lista) {
        this.lista = new ArrayList(lista);
    }
    
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Personagem personagem = lista.get(linha);
         if (coluna == COLUNA_NOME_PERSONAGEM) return personagem.getNome();
         if (coluna == COLUNA_PONTOS_VIDA_ATUAL) return personagem.getPontosVidaAtual();
         if (coluna == COLUNA_SITUACAO) return personagem.getSituacao();
         return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_NOME_PERSONAGEM) return "Nome do Personagem";
        if (coluna == COLUNA_PONTOS_VIDA_ATUAL) return "Pontos de Vida";
        if (coluna == COLUNA_SITUACAO) return "Situação";
        return "";
    }
 
    
    
}
