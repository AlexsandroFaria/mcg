/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.dao;

import br.com.mcg.jdbc.ConnectionFactory;
import br.com.mcg.model.ClasseDePersonagem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author alafaria
 */
public class ClasseDePersonagemDao {
    
    private ResultSet rs;
    private PreparedStatement stmt;
    private Connection con;
    private Statement st;
    private final ArrayList<ClasseDePersonagem> lista = new ArrayList<>();
    
    public ClasseDePersonagemDao() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarClasse(ClasseDePersonagem classeDePersonagem){
        String sql = "insert into tb_classe_personagem (classe) values (?)";
        try {
           stmt = con.prepareStatement(sql);
           stmt.setString(1, classeDePersonagem.getClasse());
           stmt.execute();
           stmt.close();
           JOptionPane.showMessageDialog(null, "Classe cadastrada com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados. Tente novamente mais tarde!");
            throw new RuntimeException(erro);
        } 
    }
    
    public ArrayList<ClasseDePersonagem>listarClasse(){
        String sql = "select * from tb_classe_personagem";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                ClasseDePersonagem classeDePerosnagem = new ClasseDePersonagem();
                classeDePerosnagem.setCodigo(rs.getInt("id_classe"));
                classeDePerosnagem.setClasse(rs.getString("classe"));
                lista.add(classeDePerosnagem);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados. Tente novamente mais tarde!");
            throw new RuntimeException(erro);
        }
        return lista;
    }
    
    public void excluirClasse(String classe){
        String sql = "delete from tb_classe_personagem where classe = " + "'" + classe + "'";
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    public List<ClasseDePersonagem> consultarClassePorNome(String classe) {
        try {
            List<ClasseDePersonagem>lista = new ArrayList<>();
            String sql = "select * from tb_classe_personagem where classe like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, classe);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ClasseDePersonagem classeDePersonagem = new ClasseDePersonagem();
                
                classeDePersonagem.setCodigo(rs.getInt("id_classe"));
                classeDePersonagem.setClasse(rs.getString("classe"));
                              
                lista.add(classeDePersonagem);
            }
            
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Classe!");
            throw new RuntimeException(erro);
        }
    }
    
}
