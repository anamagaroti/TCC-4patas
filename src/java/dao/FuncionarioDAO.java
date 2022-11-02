package dao;

import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
        
        public class FuncionarioDAO implements DAOGenerica{
            
      
        private final Connection conexao;
        public FuncionarioDAO()throws SQLException, ClassNotFoundException  {
         conexao = Conexao.abrirConexao();
        }

    @Override
    public void cadastrar(Object objeto) throws SQLException {
    String sql = "call cadastrarfuncionario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       Funcionario funcionario = (Funcionario) objeto;
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.setString(2, funcionario.getNomeImg());
            stmt.setString(3, funcionario.getNomePessoa());
            stmt.setString(4,funcionario.getCpfPessoa());
            stmt.setString(5,funcionario.getDataNascimentoPessoa());
            stmt.setString(6, funcionario.getCepPessoa());
            stmt.setString(7, funcionario.getCidadePessoa());
            stmt.setString(8, funcionario.getBairroPessoa());
            stmt.setString(9, funcionario.getRuaPessoa());
            stmt.setString(10, funcionario.getNumeroPessoa());
            stmt.setString(11, funcionario.getComplementoPessoa());
            stmt.setString(12, funcionario.getEstadoPessoa());
            stmt.setString(13, funcionario.getTelefonePessoa());
            stmt.setString(14, funcionario.getEmailPessoa());
            stmt.setString(15, funcionario.getGeneroPessoa());
            stmt.setString (16, funcionario.getSenhaPessoa());                   
            stmt.setString (17, funcionario.getLogouPessoa());
            stmt.setString (18, funcionario.getCargo());

            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao gravar funcionario");
            } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public Object consultar(int codigo) throws SQLException {
        String sql = "select * from funcionario where idpessoa = ?";
                Funcionario funcionario = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;
                try {
                    stmt = conexao.prepareStatement(sql);
                    stmt.setInt(1, codigo);
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        funcionario = new Funcionario(rs.getInt("idpessoa"), rs.getString("nomeimg"), rs.getString("nomepessoa"), rs.getString("cpfpessoa"), rs.getString("datanascimentopessoa"), rs.getString("ceppessoa"), rs.getString("cidadepessoa"), rs.getString("bairropessoa"), rs.getString("ruapessoa"), rs.getString("numeropessoa"), rs.getString("complementopessoa"), rs.getString("estadopessoa"), rs.getString("telefonepessoa"), rs.getString("emailpessoa"),  rs.getString("generopessoa"), rs.getString("cargo"));
                    }
                } catch (SQLException ex) {
                    throw new SQLException("Erro ao consultar funcionário");
                } finally {
                    Conexao.encerrarConexao(conexao, stmt, rs);
                }
                return funcionario;   
    }

    @Override
    public List<Object> listar() throws SQLException {
        String sql = "select * from funcionario";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> listaFuncionario = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario(rs.getInt("idpessoa"), rs.getString("nomeimg"),  rs.getString("nomepessoa"), rs.getString("cpfpessoa"), rs.getString("emailpessoa"), rs.getString("generopessoa"), rs.getString("cargo"));
                listaFuncionario.add(funcionario);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar funcionário");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return listaFuncionario;
    }

    @Override
    public void excluir(int codigo) throws SQLException {
       String sql = "delete from funcionario where idpessoa = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao excluir Funcionário");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }
    }

    
        
       
        
        
