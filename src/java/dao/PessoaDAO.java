package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pessoa;
import utils.Conexao;
        
        public class PessoaDAO{
            
      
        private final Connection conexao;
        public PessoaDAO()throws SQLException, ClassNotFoundException  {
         conexao = Conexao.abrirConexao();
        }
        
    public Object adotar(int codigoCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   public Object consultar(String codigo) throws SQLException {
        String sql = "select * from pessoa where pessoa.emailpessoa = ? ";
                Pessoa pessoa = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;
                try {
                    stmt = conexao.prepareStatement(sql);
                    stmt.setString(1, codigo);
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        pessoa = new Pessoa(rs.getInt("idpessoa"), rs.getString("nomeimg"), 
                          rs.getString("nomepessoa"), rs.getString("cpfpessoa"), 
                          rs.getString("datanascimentopessoa"), rs.getString("ceppessoa"), 
                          rs.getString("cidadepessoa"), rs.getString("bairropessoa"),
                          rs.getString("ruapessoa"), rs.getString("numeropessoa"), 
                          rs.getString("complementopessoa"), rs.getString("estadopessoa"), 
                          rs.getString("telefonepessoa"), rs.getString("emailpessoa"),  
                          rs.getString("generopessoa"), rs.getString("senhapessoa"), 
                          rs.getString("logoupessoa"));
                    }
                } catch (SQLException ex) {
                    throw new SQLException("Esses dados não estão cadastrados!");
                } finally {
                    Conexao.encerrarConexao(conexao, stmt, rs);
                }
                return pessoa;   
    }
}
    

    
        
       
        
        
