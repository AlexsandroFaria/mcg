/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.tabelaDeModelos;

import br.com.mcg.model.Iniciativa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloIniciativa extends AbstractTableModel{

    public static final int COLUNA_ID_INICIATIVA = 0;
    public static final int COLUNA_COMBATENTE = 1;
    public static final int COLUNA_VALOR_INICIATIVA = 2;
    ArrayList<Iniciativa>lista;

    public TabelaModeloIniciativa(ArrayList<Iniciativa> lista) {
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
        Iniciativa iniciativa = lista.get(linha);
        if (coluna == COLUNA_ID_INICIATIVA)return iniciativa.getId_iniciativa();
        if (coluna == COLUNA_COMBATENTE)return iniciativa.getCombatente();
        if (coluna == COLUNA_VALOR_INICIATIVA)return iniciativa.getValor_iniciativa();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if(coluna == COLUNA_ID_INICIATIVA) return "Identificador";
        if(coluna == COLUNA_COMBATENTE) return "Combatente";
        if(coluna == COLUNA_VALOR_INICIATIVA) return "Iniciativa";
        return "";
    }
    
    
}
