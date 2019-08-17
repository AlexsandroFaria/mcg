/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcg.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import br.com.mcg.jdbc.ConnectionFactory;
import br.com.mcg.model.Usuario;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import br.com.mcg.view.TelaLoginUsuario;
import br.com.mcg.view.TelaPrincipal;
import java.util.ArrayList;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author alafaria
 */
public class UsuarioDao {
    
    private ResultSet rs;
    private Statement st;
    private PreparedStatement stmt;
    private Connection con;
    private final ArrayList<Usuario> lista = new ArrayList<>();
    
    public UsuarioDao() {
        this.con = new ConnectionFactory().getConnection();
    }    
    
    public void logar(String usuario, String senha) {
        try {
            String sql = "select * from tb_usuarios where usuario = ? and senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Mestre!! Seja bem Vindo");
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
                new TelaLoginUsuario().setVisible(true);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Houve um erro na conexão, tente novamente mais tarde!");
            throw new RuntimeException(erro);
        }
    }

    public void lembrarSenha() {
        try {
            String contra_senha = JOptionPane.showInputDialog("Informe a contrasenha:");
            String sql = "select * from tb_usuarios where contra_senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, contra_senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String contraSenha = rs.getString("contra_senha");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                if (contra_senha.equals(contraSenha)) {
                    JOptionPane.showMessageDialog(null, "Seu usuário é : " + usuario + " e sua senha é " + senha + ".");
                }  
            }else{
                JOptionPane.showMessageDialog(null, "Usuário e senha não encontrado. Tente novamente!");
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Houve um erro na conexão, tente novamente mais tarde!");
            throw new RuntimeException(erro);
        }
    }
    
    public ArrayList<Usuario> listarUsuario(){
        String sql = "select * from tb_usuarios";
        ArrayList<Usuario>lista = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);           
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdLogin(rs.getInt("id_login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setContraSenha(rs.getString("contra_senha"));
                                
                lista.add(usuario);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a consulta de usuários!");
            throw new RuntimeException(erro);
        }
       return lista; 
    }
    
    public void adicionarUsuario(Usuario usuario){
        String sql = "insert into tb_usuarios (nome, email, usuario, senha, contra_senha)values (?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getUsuario());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getContraSenha());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados!");
            throw new RuntimeException(erro);
        }
    }
    
    
    public void excluir(String nome) {
        String sql = "delete from tb_usuarios where nome = " + "'" + nome + "'";
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
            JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir! Tente Novamente.");
            throw new RuntimeException(sqle);
        }
    }
    
    public void alterarUsuario(Usuario usuario) {
        String sql = "update tb_usuarios set email=?, usuario = ?, senha = ?, contra_senha = ? where nome = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getContraSenha());
            stmt.setString(5, usuario.getNome());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }
    
    
    public ArrayList<Usuario> listarUsuarioPorNome(String nome){
        String sql = "select * from tb_usuarios where nome like '%" + nome + "%'";
        try {            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                
                usuario.setIdLogin(rs.getInt("id_login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setContraSenha(rs.getString("contra_senha"));
                        
                lista.add(usuario);
            }
                        
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na consulta. Tente novamente ou contacte o Administrador do SIstema!");
            throw new RuntimeException(erro);
        }
        return lista;
    }
}
