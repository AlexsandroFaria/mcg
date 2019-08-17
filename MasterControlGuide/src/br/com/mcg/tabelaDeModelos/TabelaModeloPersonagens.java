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
public class TabelaModeloPersonagens extends AbstractTableModel{
    
    public static final int COLUNA_CODIGO = 0;
    public static final int COLUNA_NOME = 1;
    public static final int COLUNA_CLASSE = 2;
    public static final int COLUNA_RACA = 3;
    public static final int COLUNA_DADOS_VIDA = 4;
    public static final int COLUNA_TOTAL_PONTOS_VIDA = 5;
    public static final int COLUNA_PONTOS_VIDA_ATUAL = 6;
    public static final int COLUNA_PONTOS_EXPERIENCIA = 7;
    public static final int COLUNA_NIVEL = 8;
    public static final int COLUNA_PONTO_HEROICO = 9;
    public ArrayList<Personagem>lista;

    public TabelaModeloPersonagens(ArrayList<Personagem> lista) {
        this.lista = new ArrayList(lista);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Personagem personagem = lista.get(linha);
        if (coluna == COLUNA_CODIGO) return personagem.getPersonagemId();
        if (coluna == COLUNA_NOME) return personagem.getNome();
        if (coluna == COLUNA_CLASSE) return personagem.getClasse();
        if (coluna == COLUNA_RACA) return personagem.getRaca();
        if (coluna == COLUNA_DADOS_VIDA) return personagem.getDadosDeVida();
        if (coluna == COLUNA_TOTAL_PONTOS_VIDA) return personagem.getTotalPontosVida();
        if (coluna == COLUNA_PONTOS_VIDA_ATUAL) return personagem.getPontosVidaAtual();
        if (coluna == COLUNA_PONTOS_EXPERIENCIA) return personagem.getPontosDeExperiencia();
        if (coluna == COLUNA_NIVEL) return personagem.getNivel();
        if (coluna == COLUNA_PONTO_HEROICO) return personagem.getPontoHeroico();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_CODIGO) return "Código";
        if (coluna == COLUNA_NOME) return "Nome";
        if (coluna == COLUNA_CLASSE) return "Classe";
        if (coluna == COLUNA_RACA) return "Raça";
        if (coluna == COLUNA_DADOS_VIDA) return "Dados de Vida";
        if (coluna == COLUNA_TOTAL_PONTOS_VIDA) return "Pontos de Vida";
        if (coluna == COLUNA_PONTOS_VIDA_ATUAL) return "Pontos de Vida Atual";
        if (coluna == COLUNA_PONTOS_EXPERIENCIA) return "Pontos de Experiência";
        if (coluna == COLUNA_NIVEL) return "Nível";
        if (coluna == COLUNA_PONTO_HEROICO) return "Pontos Heróicos";
        return "";
    }
    
    
}
