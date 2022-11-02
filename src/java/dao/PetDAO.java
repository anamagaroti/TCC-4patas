package dao;

import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pet;

public class PetDAO implements DAOGenerica {

    private final Connection conexao;

    public PetDAO() throws SQLException, ClassNotFoundException {
        conexao = Conexao.abrirConexao();
    }

    @Override
    public void cadastrar(Object objeto) throws SQLException {
        String sql = "CALL cadastrarpet(?,?,?,?,?,?,?,?,?,?)";
        Pet pet = (Pet) objeto;
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, pet.getIdPet());
             stmt.setString(2, pet.getNomeImg());
            stmt.setString(3, pet.getNomePet());
            stmt.setString(4, pet.getRacaPet());
            stmt.setString(5, pet.getIdadePet());
            stmt.setString(6, pet.getEspeciePet());
            stmt.setString(7, pet.getCoresPet());
            stmt.setString(8, pet.getSexoPet());
            stmt.setString(9, pet.getPortePet());
            stmt.setString(10, pet.getObservacoes());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao gravar pet");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public Object consultar(int codigo) throws SQLException {
       String sql = "select * from pet where idpet = ?";
        Pet pet = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                pet = new Pet(rs.getInt("idpet"), rs.getString("nomeimg"), rs.getString("nomepet"), rs.getString("racapet"), rs.getString("idadepet"), rs.getString("especiepet"), rs.getString("corespet"),  rs.getString("sexopet"),  rs.getString("portepet"),rs.getString("observacoes"));
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao consultar pet");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return pet;
    }

    @Override
    public List<Object> listar() throws SQLException {
        String sql = "select * from pet ";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pet pet = new Pet(rs.getInt("idpet"), rs.getString("nomeimg"), rs.getString("nomepet"), rs.getString("racapet"), rs.getString("idadepet"), rs.getString("especiepet"), rs.getString("corespet"), rs.getString("sexopet"), rs.getString("portepet"), rs.getString("observacoes"));
                lista.add(pet);               
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar Pets");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return lista;
    }
    
    public List<Object> listarCachorro() throws SQLException {
        String sql = "select * from pet where especiepet = 'cachorro'";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pet pet = new Pet(rs.getInt("idpet"), rs.getString("nomeimg"), rs.getString("nomepet"), rs.getString("racapet"), rs.getString("idadepet"), rs.getString("especiepet"), rs.getString("corespet"), rs.getString("sexopet"), rs.getString("portepet"), rs.getString("observacoes"));
                lista.add(pet);               
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar Pets");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return lista;
    }
    
    public List<Object> listarGato() throws SQLException {
        String sql = "select * from pet where especiepet = 'gato'";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pet pet = new Pet(rs.getInt("idpet"), rs.getString("nomeimg"), rs.getString("nomepet"), rs.getString("racapet"), rs.getString("idadepet"), rs.getString("especiepet"), rs.getString("corespet"), rs.getString("sexopet"), rs.getString("portepet"), rs.getString("observacoes"));
                lista.add(pet);               
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar Pets");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return lista;
    }

    @Override
    public void excluir(int codigo) throws SQLException {
        String sql = "delete from pet where idpet = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao excluir Pet");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }
}