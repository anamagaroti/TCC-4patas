package dao;
import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {
    
    private Connection conexao;
    
    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        this.conexao = Conexao.abrirConexao();
    }
    
    public Usuario realizarLogin(String emailUsuario, String senhaUsuario) throws SQLException {
        String sql = "select * from usuario where emailusuario = ? and senhausuario = ?";
        Usuario usuario = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, emailUsuario);
            stmt.setString(2, senhaUsuario);

            rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(rs.getInt("idusuario"), 
                        rs.getString("emailusuario"),  
                        rs.getString("senhausuario"));
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao logar usuário");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return usuario;
    }
}