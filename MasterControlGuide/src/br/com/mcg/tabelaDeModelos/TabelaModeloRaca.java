/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.tabelaDeModelos;

import br.com.mcg.model.RacaDePersonagem;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloRaca extends AbstractTableModel{

    public static final int COLUNA_ID_RACA = 0;
    public static final int COLUNA_RACA = 1;
    public ArrayList<RacaDePersonagem>lista;

    public TabelaModeloRaca(ArrayList<RacaDePersonagem> lista) {
        this.lista = new ArrayList(lista);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        RacaDePersonagem racaDePersonagem = lista.get(linha);
        if (coluna == COLUNA_ID_RACA) return racaDePersonagem.getCodigo();
        if (coluna == COLUNA_RACA) return racaDePersonagem.getRaca();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_ID_RACA) return "Identificador";
       if (coluna == COLUNA_RACA) return "Classe";
       return "";
    }
    
    
}
