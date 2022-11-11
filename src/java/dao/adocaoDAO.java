package dao;

import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Adocao;
import model.Cliente;
import model.Pet;

public class adocaoDAO implements DAOGenerica {

    private final Connection conexao;

    public adocaoDAO() throws SQLException, ClassNotFoundException {
        conexao = Conexao.abrirConexao();
    }

    @Override
    public void cadastrar(Object objeto) throws SQLException {
        String sql = "call cadastrarAdocao(?,?,?)";
        Adocao adocao = (Adocao) objeto;
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, adocao.getIdAdocao());
            stmt.setInt(2, adocao.getPet().getIdPet());
            stmt.setInt(3, adocao.getCliente().getIdCliente());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao adotar");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public Object consultar(int codigo) throws SQLException {
        String sql = "select * from adocao where idadocao = ?";
        Adocao adocao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                adocao = new Adocao(
                        rs.getInt("idAdocao"),
                        (Pet) new PetDAO().consultar(rs.getInt("idPet")),
                        (Cliente) new ClienteDAO().consultar(rs.getInt("idCliente"))
                );
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new SQLException("Erro ao visualizar adoção");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return adocao;
    }

    @Override
    public List<Object> listar() throws SQLException {
        String sql = "select * from adocao";
        List<Object> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Adocao adocao = new Adocao(
                        rs.getInt("idAdocao"),
                        (Pet) new PetDAO().consultar(rs.getInt("idPet")),
                        (Cliente) new ClienteDAO().consultar(rs.getInt("idCliente"))
                );
                lista.add(adocao);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new SQLException("Erro ao listar adoções");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return lista;
    }

    @Override
    public void excluir(int codigo) throws SQLException {
        String sql = "delete from adocao where idAdocao = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao excluir adoção");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }
}
