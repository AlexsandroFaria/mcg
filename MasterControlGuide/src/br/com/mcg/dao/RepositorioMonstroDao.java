/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.dao;

import br.com.mcg.jdbc.ConnectionFactory;
import br.com.mcg.model.RepositorioMonstros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author alafaria
 */
public class RepositorioMonstroDao {

    private ResultSet rs;
    private PreparedStatement stmt;
    private Connection con;
    private Statement st;
    private final ArrayList<RepositorioMonstros> lista = new ArrayList<>();
    

    public RepositorioMonstroDao() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void adicionarMonstro(RepositorioMonstros repositorioMonstros){
        String sql = "insert into tb_repositorio_monstros (nome, tipo, classe_de_armadura, pontos_de_vida, pontos_de_vida_atual, deslocamento, nivel_de_desafio, referencia, situacao)values (?,?,?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, repositorioMonstros.getNomeMonstro());
            stmt.setString(2, repositorioMonstros.getTipo());
            stmt.setInt(3, repositorioMonstros.getClasseDeArmadura());
            stmt.setString(4, repositorioMonstros.getPontosDeVida());
            stmt.setInt(5, repositorioMonstros.getPontosDeVidaAtual());
            stmt.setString(6, repositorioMonstros.getDeslocamento());
            stmt.setString(7, repositorioMonstros.getNivelDeDesafio());
            stmt.setString(8, repositorioMonstros.getReferencia());
            stmt.setString(9, repositorioMonstros.getSituacao());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Monstro cadastrado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados!");
            throw new RuntimeException(erro);
        }
    }
    
    public void editarMonstros(RepositorioMonstros repositorioMonstros){
        String sql = "update tb_repositorio_monstros set nome = ?, tipo = ?, classe_de_armadura = ?, pontos_de_vida = ?, pontos_de_vida_atual = ?, deslocamento = ?, nivel_de_desafio = ?, referencia = ? where idrepositorio_monstros = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, repositorioMonstros.getNomeMonstro());
            stmt.setString(2, repositorioMonstros.getTipo());
            stmt.setInt(3, repositorioMonstros.getClasseDeArmadura());
            stmt.setString(4, repositorioMonstros.getPontosDeVida());
            stmt.setInt(5, repositorioMonstros.getPontosDeVidaAtual());
            stmt.setString(6, repositorioMonstros.getDeslocamento());
            stmt.setString(7, repositorioMonstros.getNivelDeDesafio());
            stmt.setString(8, repositorioMonstros.getReferencia());
            stmt.setInt(9, repositorioMonstros.getIdRepositorioMonstros());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Monstro alterado com sucesso.");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados. Tente Novamente mais tarde!");
            throw new RuntimeException(erro);
        }
    }
    
    public ArrayList<RepositorioMonstros>listarMonstrosBatalha(){
        String sql = "select * from tb_repositorio_monstros";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                RepositorioMonstros repositorioMonstros = new RepositorioMonstros();
                repositorioMonstros.setNomeMonstro(rs.getString("nome"));
                repositorioMonstros.setPontosDeVida(rs.getString("pontos_de_vida"));
                repositorioMonstros.setPontosDeVidaAtual(rs.getInt("pontos_de_vida_atual"));
                repositorioMonstros.setSituacao(rs.getString("situacao"));
                lista.add(repositorioMonstros);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados. Tente novamente mais tarde!");
            throw new RuntimeException(erro);
        }
        return lista;
    }
    
    public ArrayList<RepositorioMonstros>listarMonstros(){
        String sql = "select * from tb_repositorio_monstros";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                RepositorioMonstros repositorioMonstros = new RepositorioMonstros();
                repositorioMonstros.setIdRepositorioMonstros(rs.getInt("idrepositorio_monstros"));
                repositorioMonstros.setNomeMonstro(rs.getString("nome"));
                repositorioMonstros.setTipo(rs.getString("tipo"));
                repositorioMonstros.setClasseDeArmadura(rs.getInt("classe_de_armadura"));
                repositorioMonstros.setPontosDeVida(rs.getString("pontos_de_vida"));
                repositorioMonstros.setPontosDeVidaAtual(rs.getInt("pontos_de_vida_atual"));
                repositorioMonstros.setDeslocamento(rs.getString("deslocamento"));
                repositorioMonstros.setNivelDeDesafio(rs.getString("nivel_de_desafio"));
                repositorioMonstros.setReferencia(rs.getString("referencia"));
                lista.add(repositorioMonstros);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados. Tente novamente mais tarde!");
            throw new RuntimeException(erro);
        }
        return lista;
    }
    
    public ArrayList<RepositorioMonstros> listarMonstroPorNome(String valor){
        String sql = "SELECT * FROM tb_repositorio_monstros WHERE nome LIKE '%"+valor+"%' ";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                RepositorioMonstros repositorioMonstros = new RepositorioMonstros();
                //rm.setIdMonstros(rs.getInt("idrepositorio_monstros"));
                repositorioMonstros.setNomeMonstro(rs.getString("nome"));
                repositorioMonstros.setPontosDeVida(rs.getString("pontos_de_vida"));
                repositorioMonstros.setPontosDeVidaAtual(rs.getInt("pontos_de_vida_atual"));
                lista.add(repositorioMonstros);   
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro 6: "+e);
        }
        return lista;
    }
    
    public void cadastrarMonstroEmBatalha(RepositorioMonstros repositorioMonstros){
        String sql = "insert into tb_monstro_batalha (nome_monstro_batalha, pontos_vida_atual, situacao) values(?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, repositorioMonstros.getNomeMonstro());
            stmt.setInt(2, repositorioMonstros.getPontosDeVidaAtual());
            stmt.setString(3, repositorioMonstros.getSituacao());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados");
            throw new RuntimeException(erro);
        }
    }
    
    public ArrayList<RepositorioMonstros> listarMonstroParaBatalha(){
        String sql = "SELECT * FROM tb_monstro_batalha";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                RepositorioMonstros repositorioMonstros = new RepositorioMonstros();
                //rm.setIdMonstros(rs.getInt("idrepositorio_monstros"));
                repositorioMonstros.setNomeMonstro(rs.getString("nome_monstro_batalha"));
                repositorioMonstros.setPontosDeVidaAtual(rs.getInt("pontos_vida_atual"));
                repositorioMonstros.setSituacao(rs.getString("situacao"));
                lista.add(repositorioMonstros);   
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro 6: "+e);
        }
        return lista;
    }
    
    public void excluirListaDeMonstros(String nome){
        String sql = "truncate tb_monstro_batalha";
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco. Tente novamente mais tarde.");
            throw new RuntimeException(sqle);
        }
    }

    public void editarMonstroEmCombate(RepositorioMonstros repositorioMonstros) {
       String sql = "update tb_monstro_batalha set pontos_vida_atual = ?, situacao = ? where nome_monstro_batalha = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, repositorioMonstros.getPontosDeVidaAtual());
            stmt.setString(2, repositorioMonstros.getSituacao());
            stmt.setString(3, repositorioMonstros.getNomeMonstro());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco de Dados.");
            throw new RuntimeException(erro);
        }
    }

    public void excluirMonstros(String nome) {
        String sql = "delete from tb_repositorio_monstros where nome = " + "'" + nome + "'";
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
            JOptionPane.showMessageDialog(null, "Monstro excluido com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados!");
            throw new RuntimeException(erro);
        }
    }
    
    public ArrayList<RepositorioMonstros> listarRepositorioMonstroPorNome(String valor){
        String sql = "SELECT * FROM tb_repositorio_monstros WHERE nome LIKE '%"+valor+"%' ";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                RepositorioMonstros repositorioMonstros = new RepositorioMonstros();
                repositorioMonstros.setIdRepositorioMonstros(rs.getInt("idrepositorio_monstros"));
                repositorioMonstros.setNomeMonstro(rs.getString("nome"));
                repositorioMonstros.setTipo(rs.getString("tipo"));
                repositorioMonstros.setClasseDeArmadura(rs.getInt("classe_de_armadura"));
                repositorioMonstros.setPontosDeVida(rs.getString("pontos_de_vida"));
                repositorioMonstros.setPontosDeVidaAtual(rs.getInt("pontos_de_vida_atual"));
                repositorioMonstros.setDeslocamento(rs.getString("deslocamento"));
                repositorioMonstros.setNivelDeDesafio(rs.getString("nivel_de_desafio"));
                repositorioMonstros.setReferencia(rs.getString("referencia"));
                lista.add(repositorioMonstros);   
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de Dados!admi");
            throw new RuntimeException(erro);
        }
        return lista;
    }
}
