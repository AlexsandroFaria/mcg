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
public class TabelaModeloRepositorioMonstros extends AbstractTableModel {

    public static final int COLUNA_ID_REPOSITORIO_MONSTROS = 0;
    public static final int COLUNA_NOME_MONTROS = 1;
    public static final int COLUNA_TIPO_MONTROS = 2;
    public static final int COLUNA_CLASSE_DE_ARMADURA_MONTROS = 3;
    public static final int COLUNA_PONTOS_DE_VIDA_MONTROS = 4;
    public static final int COLUNA_PONTOS_DE_VIDA_ATUAL_MONTROS = 5;
    public static final int COLUNA_DESLOCAMENTO_MONTROS = 6;
    public static final int COLUNA_NIVEL_DE_DESAFIO_MONTROS = 7;
    public static final int COLUNA_REFERENCIA_MONTROS = 8;
    ArrayList<RepositorioMonstros>lista;

    public TabelaModeloRepositorioMonstros(ArrayList<RepositorioMonstros> lista) {
        this.lista = new ArrayList(lista);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        RepositorioMonstros repositorioMonstros = lista.get(linha);
        if (coluna == COLUNA_ID_REPOSITORIO_MONSTROS) return repositorioMonstros.getIdRepositorioMonstros();
        if (coluna == COLUNA_NOME_MONTROS) return repositorioMonstros.getNomeMonstro();
        if (coluna == COLUNA_TIPO_MONTROS) return repositorioMonstros.getTipo();
        if (coluna == COLUNA_CLASSE_DE_ARMADURA_MONTROS) return repositorioMonstros.getClasseDeArmadura();
        if (coluna == COLUNA_PONTOS_DE_VIDA_MONTROS) return repositorioMonstros.getPontosDeVida();
        if (coluna == COLUNA_PONTOS_DE_VIDA_ATUAL_MONTROS) return repositorioMonstros.getPontosDeVidaAtual();
        if (coluna == COLUNA_DESLOCAMENTO_MONTROS) return repositorioMonstros.getDeslocamento();
        if (coluna == COLUNA_NIVEL_DE_DESAFIO_MONTROS) return repositorioMonstros.getNivelDeDesafio();
        if (coluna == COLUNA_REFERENCIA_MONTROS) return repositorioMonstros.getReferencia();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_ID_REPOSITORIO_MONSTROS) return "Identificador";
        if (coluna == COLUNA_NOME_MONTROS) return "Nome";
        if (coluna == COLUNA_TIPO_MONTROS) return "Tipo";
        if (coluna == COLUNA_CLASSE_DE_ARMADURA_MONTROS) return "Classe de Armadura";
        if (coluna == COLUNA_PONTOS_DE_VIDA_MONTROS) return "Pontos de Vida";
        if (coluna == COLUNA_PONTOS_DE_VIDA_ATUAL_MONTROS) return "Pontos de Vida Atual";
        if (coluna == COLUNA_DESLOCAMENTO_MONTROS) return "Deslocamento";
        if (coluna == COLUNA_NIVEL_DE_DESAFIO_MONTROS) return "Nivel de Desafio";
        if (coluna == COLUNA_REFERENCIA_MONTROS) return "Referencia";
        return "";
    }

}
