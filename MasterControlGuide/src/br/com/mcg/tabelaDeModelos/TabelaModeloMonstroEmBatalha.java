/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.tabelaDeModelos;

import br.com.mcg.model.RepositorioMonstros;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloMonstroEmBatalha extends AbstractTableModel{

    public static final int COLUNA_NOME_MONSTRO = 0;
    public static final int COLUNA_PONTOS_VIDA_ATUAL = 1;
    public static final int COLUNA_SITUACAO = 2;
    public ArrayList<RepositorioMonstros>lista;

    public TabelaModeloMonstroEmBatalha(ArrayList<RepositorioMonstros> lista) {
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
        RepositorioMonstros repositorioMonstros = lista.get(linha);
        if (coluna == COLUNA_NOME_MONSTRO) return repositorioMonstros.getNomeMonstro();
        if (coluna == COLUNA_PONTOS_VIDA_ATUAL) return repositorioMonstros.getPontosDeVidaAtual();
        if (coluna == COLUNA_SITUACAO) return repositorioMonstros.getSituacao();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_NOME_MONSTRO) return "Nome do Monstro";
        if (coluna == COLUNA_PONTOS_VIDA_ATUAL) return "Pontos de Vida Atual";
        if (coluna == COLUNA_SITUACAO) return "Situação";
        return "";
    }
    
    
    
}
