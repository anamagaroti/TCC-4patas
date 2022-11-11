package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Reclamacao;
import utils.Conexao;


public class ReclamacaoDAO{
    
        private final Connection conexao;
        public ReclamacaoDAO()throws SQLException, ClassNotFoundException  {
         conexao = Conexao.abrirConexao();
        }
        
    public void cadastrar(Object objeto) throws SQLException {
    String sql = "call cadastrarReclamacao(?,?,?)";
       Reclamacao reclamacao = (Reclamacao) objeto;
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, reclamacao.getIdReclamacao());
            stmt.setString(2, reclamacao.getReclamacao());
            stmt.setInt(3, reclamacao.getCliente().getIdCliente());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao gravar reclamação");
            } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }

    public List<Object> listar() throws SQLException, ClassNotFoundException {
        String sql = "select r.idreclamacao idre, r.reclamacao re, r.idcliente idcli, p.nomepessoa nome, p.telefonepessoa telefone "
                      + "from reclamacao r \n" +
"                     inner join cliente c on c.idcliente = r.idcliente \n" +
"                     inner join pessoa p on p.idpessoa = c.idcliente";
        List<Object> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
               Reclamacao reclamacao = new Reclamacao(
                        rs.getInt("idre"),
                        rs.getString("re"),
                        (Cliente) new ClienteDAO().consultar(rs.getInt("idcli")));
                Cliente cliente =  new Cliente();
                cliente.getNomePessoa(rs.getString("nome"));
                cliente.getTelefonePessoa(rs.getString("telefone"));
                
                lista.add(reclamacao);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar reclamação");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return lista;   
    }

    public void excluir(int codigo) throws SQLException {
        String sql = "delete from reclamacao where idreclamacao = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao excluir reclamação");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }
    
}
