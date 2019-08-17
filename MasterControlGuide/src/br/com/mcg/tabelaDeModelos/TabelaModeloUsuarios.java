/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.tabelaDeModelos;

import br.com.mcg.model.Usuario;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloUsuarios extends AbstractTableModel{

    public static final int COLUNA_ID = 0;
    public static final int COLUNA_NOME = 1;
    public static final int COLUNA_EMAIL = 2;
    public static final int COLUNA_USUARIO = 3;
    public static final int COLUNA_SENHA = 4;
    public static final int COLUNA_CONTRASENHA = 5;
    public ArrayList<Usuario>lista;

    public TabelaModeloUsuarios(ArrayList<Usuario> lista) {
        this.lista = new ArrayList(lista);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Usuario usuario = lista.get(linha);
        if (coluna == COLUNA_ID) return usuario.getIdLogin();
        if (coluna == COLUNA_NOME) return usuario.getNome();
        if (coluna == COLUNA_EMAIL) return usuario.getEmail();
        if (coluna == COLUNA_USUARIO) return usuario.getUsuario();
        if (coluna == COLUNA_SENHA) return usuario.getSenha();
        if (coluna == COLUNA_CONTRASENHA) return usuario.getContraSenha();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_ID) return "Identificador";
        if (coluna == COLUNA_NOME) return "Nome";
        if (coluna == COLUNA_EMAIL) return "Email";
        if (coluna == COLUNA_USUARIO) return "Usuário";
        if (coluna == COLUNA_SENHA) return "Senha";
        if (coluna == COLUNA_CONTRASENHA) return "Contra Senha";
        return "";
    }
    
}
