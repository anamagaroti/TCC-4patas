package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pessoa;
import utils.Conexao;

public class PessoaDAO {

    private final Connection conexao;

    public PessoaDAO() throws SQLException, ClassNotFoundException {
        conexao = Conexao.abrirConexao();
    }

    public Object adotar(int codigoPessoa) throws SQLException {
        String sql = "select * from pessoa where pessoa.idpessoa = ? ";
        Pessoa pessoa = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigoPessoa);
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

    public void editar(Object objeto) throws SQLException {
        String sql = "select cadastrarpessoa(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Pessoa pe = (Pessoa) objeto;
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, pe.getIdPessoa());
            stmt.setString(2, pe.getNomeImg());
            stmt.setString(3, pe.getNomePessoa());
            stmt.setString(4, pe.getCpfPessoa());
            stmt.setString(5, pe.getDataNascimentoPessoa());
            stmt.setString(6, pe.getCepPessoa());
            stmt.setString(7, pe.getCidadePessoa());
            stmt.setString(8, pe.getBairroPessoa());
            stmt.setString(9, pe.getRuaPessoa());
            stmt.setString(10, pe.getNumeroPessoa());
            stmt.setString(11, pe.getComplementoPessoa());
            stmt.setString(12, pe.getEstadoPessoa());
            stmt.setString(13, pe.getTelefonePessoa());
            stmt.setString(14, pe.getEmailPessoa());
            stmt.setString(15, pe.getGeneroPessoa());
            stmt.setString(16, pe.getSenhaPessoa());
            stmt.setString(17, pe.getLogouPessoa());

            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao gravar cliente");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }
}
