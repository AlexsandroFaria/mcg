/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.tabelaDeModelos;

import br.com.mcg.model.ClasseDePersonagem;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloClasse extends AbstractTableModel{
    
    public static final int COLUNA_ID_CLASSE = 0;
    public static final int COLUNA_CLASSE = 1;
    public ArrayList<ClasseDePersonagem>lista;

    public TabelaModeloClasse(ArrayList<ClasseDePersonagem> lista) {
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
        ClasseDePersonagem classeDePersonagem = lista.get(linha);
        if (coluna == COLUNA_ID_CLASSE) return classeDePersonagem.getCodigo();
        if (coluna == COLUNA_CLASSE) return classeDePersonagem.getClasse();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
       if (coluna == COLUNA_ID_CLASSE) return "Identificador";
       if (coluna == COLUNA_CLASSE) return "Classe";
       return "";
    }
    
    
}
