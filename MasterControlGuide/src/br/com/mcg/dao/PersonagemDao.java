/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.dao;

import br.com.mcg.jdbc.ConnectionFactory;
import br.com.mcg.model.NivelPersonagem;
import br.com.mcg.model.Personagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alafaria
 */
public class PersonagemDao {
    
    private ResultSet rs;
    private Statement st;
    private PreparedStatement stmt;
    private Connection con;
    private final ArrayList<Personagem> lista = new ArrayList<>();
    private final ArrayList<NivelPersonagem> listaNivelPesonagem = new ArrayList<>();
    

    public PersonagemDao() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void adicionarPersonagem(Personagem personagem){
        String sql = "insert into tb_personagem (nome, classe, raca, dados_de_vida, total_pontos_vida, pontos_vida_atual, pontos_experiencia, nivel, ponto_heroico, situacao)values (?,?,?,?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, personagem.getNome());
            stmt.setString(2, personagem.getClasse());
            stmt.setString(3, personagem.getRaca());
            stmt.setString(4, personagem.getDadosDeVida());
            stmt.setInt(5, personagem.getTotalPontosVida());
            stmt.setInt(6, personagem.getPontosVidaAtual());
            stmt.setInt(7, personagem.getPontosDeExperiencia());
            stmt.setInt(8, personagem.getNivel());
            stmt.setInt(9, personagem.getPontoHeroico());
            stmt.setString(10, personagem.getSituacao());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Personagem cadastrado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados!");
            throw new RuntimeException(erro);
        }
    }
    
    public ArrayList<Personagem> listarPersonagem(){
        String sql = "select * from tb_personagem";
        ArrayList<Personagem>lista = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);           
            while(rs.next()){
                Personagem personagem = new Personagem();
                personagem.setPersonagemId(rs.getInt("id_personagem"));
                personagem.setNome(rs.getString("nome"));
                personagem.setClasse(rs.getString("classe"));
                personagem.setRaca(rs.getString("raca"));
                personagem.setDadosDeVida(rs.getString("dados_de_vida"));
                personagem.setTotalPontosVida(rs.getInt("total_pontos_vida"));
                personagem.setPontosVidaAtual(rs.getInt("pontos_vida_atual"));
                personagem.setPontosDeExperiencia(rs.getInt("pontos_experiencia"));
                personagem.setNivel(rs.getInt("nivel"));
                personagem.setPontoHeroico(rs.getInt("ponto_heroico"));
                                
                lista.add(personagem);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a consulta de Personagem!");
            throw new RuntimeException(erro);
        }
       return lista; 
    }
    
    public void editarPersonagem(Personagem personagem){
        String sql = "update tb_personagem set nome=?, classe=?, raca=?, dados_de_vida=?, total_pontos_vida=?, pontos_vida_atual=?, pontos_experiencia=?, nivel=?, ponto_heroico=? where id_personagem = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, personagem.getNome());
            stmt.setString(2, personagem.getClasse());
            stmt.setString(3, personagem.getRaca());
            stmt.setString(4, personagem.getDadosDeVida());
            stmt.setInt(5, personagem.getTotalPontosVida());
            stmt.setInt(6, personagem.getPontosVidaAtual());
            stmt.setInt(7, personagem.getPontosDeExperiencia());
            stmt.setInt(8, personagem.getNivel());
            stmt.setInt(9, personagem.getPontoHeroico());
            stmt.setInt(10, personagem.getPersonagemId());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Personagem Alterado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados!");
            throw new RuntimeException(erro);
        } 
    }
    
     public void excluirPersonagem(String nome) {
        String sql = "delete from tb_personagem where nome = " + "'" + nome + "'";
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
            JOptionPane.showMessageDialog(null, "Personagem excluido com sucesso!");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir! Tente Novamente.");
            throw new RuntimeException(sqle);
        }
    }

    public ArrayList<Personagem> listarPersonagemEmBatalha(){
        String sql = "select * from tb_personagem";
        ArrayList<Personagem>lista = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);           
            while(rs.next()){
                Personagem personagem = new Personagem();
                personagem.setNome(rs.getString("nome"));
                personagem.setPontosVidaAtual(rs.getInt("pontos_vida_atual"));
                personagem.setSituacao(rs.getString("situacao"));
                                
                lista.add(personagem);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a consulta de Personagem!");
            throw new RuntimeException(erro);
        }
       return lista; 
    }

    public void editarPersonagemEmCombate(Personagem personagem) {
        String sql = "update tb_personagem set pontos_vida_atual = ?, situacao = ? where nome = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, personagem.getPontosVidaAtual());
            stmt.setString(2, personagem.getSituacao());
            stmt.setString(3, personagem.getNome());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco de Dados.");
            throw new RuntimeException(erro);
        }
    }
    
    public ArrayList<Personagem> listarPersonagemPorNome(String valor){
        String sql = "select * from tb_personagem where nome like '%" + valor + "%' ";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Personagem personagem = new Personagem();
                personagem.setPersonagemId(rs.getInt("id_personagem"));
                personagem.setNome(rs.getString("nome"));
                personagem.setClasse(rs.getString("classe"));
                personagem.setRaca(rs.getString("raca"));
                personagem.setDadosDeVida(rs.getString("dados_de_vida"));
                personagem.setTotalPontosVida(rs.getInt("total_pontos_vida"));
                personagem.setPontosVidaAtual(rs.getInt("pontos_vida_atual"));
                personagem.setPontosDeExperiencia(rs.getInt("pontos_experiencia"));
                personagem.setNivel(rs.getInt("nivel"));
                personagem.setPontoHeroico(rs.getInt("ponto_heroico"));
                lista.add(personagem);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados!");
            throw new RuntimeException(erro);
        }
        return lista;
    }
    
    
    public ArrayList<NivelPersonagem>listarNivelPersonagem(){
        String sql = "select * from tb_nivel_personagem";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                NivelPersonagem nivelPersonagem = new NivelPersonagem();
                nivelPersonagem.setIdNivelPersonagem(rs.getInt("id_nivel_personagem"));
                nivelPersonagem.setIdNivelPersonagem(rs.getInt("nivel_personagem"));
                nivelPersonagem.setNivelFacil(rs.getInt("nivel_facil"));
                nivelPersonagem.setNivelMedio(rs.getInt("nivel_medio"));
                nivelPersonagem.setNivelDificil(rs.getInt("nivel_dificil"));
                nivelPersonagem.setNivelMortal(rs.getInt("nivel_mortal"));
                listaNivelPesonagem.add(nivelPersonagem);
            }
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
        return listaNivelPesonagem;
    }
    
  public void adicionarNivelPersonagem(NivelPersonagem nivelPersonagem){
      String sql = "insert into tb_nivel_personagem(nivel_personagem, nivel_facil, nivel_medio, nivel_dificil, nivel_mortal)values(?,?,?,?,?)";
      try {
          PreparedStatement stmt = con.prepareStatement(sql);
          //stmt.setInt(1, nivelPersonagem.getIdNivelPersonagem());
          stmt.setInt(1, nivelPersonagem.getNivelPersonagem());
          stmt.setInt(2, nivelPersonagem.getNivelFacil());
          stmt.setInt(3, nivelPersonagem.getNivelMedio());
          stmt.setInt(4, nivelPersonagem.getNivelDificil());
          stmt.setInt(5, nivelPersonagem.getNivelMortal());
          stmt.execute();
          stmt.close();
      } catch (SQLException sqle) {
          throw new RuntimeException(sqle);
      }
  }
  
  
  public void excluirListaNivel(int nivelPersonagem){
        String sql = "truncate tb_nivel_personagem";
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    public void adicionarNivelPersonagemCalculo(NivelPersonagem nivelPersonagem) {
      String sql = "truncate tb_nivel_peronagem_calculo_dificuldade; insert into tb_nivel_peronagem_calculo_dificuldade(facil, medio, dificil, mortal)values(?,?,?,?)";
      try {
          PreparedStatement stmt = con.prepareStatement(sql);
          stmt.setInt(1, nivelPersonagem.getNivelFacil());
          stmt.setInt(2, nivelPersonagem.getNivelMedio());
          stmt.setInt(3, nivelPersonagem.getNivelDificil());
          stmt.setInt(4, nivelPersonagem.getNivelMortal());
          stmt.execute();
          stmt.close();
      } catch (SQLException sqle) {
          throw new RuntimeException(sqle);
      }
  }
    
}
