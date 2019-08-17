/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.dao;

import br.com.mcg.jdbc.ConnectionFactory;
import br.com.mcg.model.RacaDePersonagem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author alafaria
 */
public class RacaDePersonagemDao {
    
    private ResultSet rs;
    private PreparedStatement stmt;
    private Connection con;
    private Statement st;
    private final ArrayList<RacaDePersonagem> lista = new ArrayList<>();
    
    public RacaDePersonagemDao() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarRaca(RacaDePersonagem racaDePersonagem){
        String sql = "insert into tb_raca_personagem (raca) values (?)";
        try {
           stmt = con.prepareStatement(sql);
           stmt.setString(1, racaDePersonagem.getRaca());
           stmt.execute();
           stmt.close();
           JOptionPane.showMessageDialog(null, "Raça cadastrada com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados. Tente novamente mais tarde!");
            throw new RuntimeException(erro);
        } 
    }
    
    public ArrayList<RacaDePersonagem>listarRaca(){
        String sql = "select * from tb_raca_personagem";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                RacaDePersonagem racaDePerosnagem = new RacaDePersonagem();
                racaDePerosnagem.setCodigo(rs.getInt("id_raca"));
                racaDePerosnagem.setRaca(rs.getString("raca"));
                lista.add(racaDePerosnagem);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados. Tente novamente mais tarde!");
            throw new RuntimeException(erro);
        }
        return lista;
    }
    
    public void excluirRaca(String raca){
        String sql = "delete from tb_raca_personagem where raca = " + "'" + raca + "'";
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
            JOptionPane.showMessageDialog(null, "Raca excluida!");
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }
    
}
