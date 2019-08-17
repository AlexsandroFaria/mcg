/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.dao;

import br.com.mcg.jdbc.ConnectionFactory;
import br.com.mcg.model.Iniciativa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alafaria
 */
public class IniciativaDao {

    private Connection con;
    private ResultSet rs;
    private Statement st;
    private PreparedStatement stmt;
    private final ArrayList<Iniciativa>lista = new ArrayList<>();

    public IniciativaDao() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void adicionarIniciativa(Iniciativa iniciativa){
         String sql = "insert into tb_iniciativa(combatente, valor_iniciativa) values(?, ?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, iniciativa.getCombatente());
            stmt.setInt(2, iniciativa.getValor_iniciativa());
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }                
    
    public ArrayList<Iniciativa>ListarIniciativa(){
        String sql = "select * from tb_iniciativa order by valor_iniciativa desc";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Iniciativa iniciativa = new Iniciativa();
                iniciativa.setId_iniciativa(rs.getInt("id_iniciativa"));
                iniciativa.setCombatente(rs.getString("combatente"));
                iniciativa.setValor_iniciativa(rs.getInt("valor_iniciativa"));
                lista.add(iniciativa);
            }
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
        return lista;
    }
            
    
    public void excluir(String iniciativa){
        String sql = "truncate tb_iniciativa";
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }
    
}
