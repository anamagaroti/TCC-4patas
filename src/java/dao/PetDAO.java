package dao;

import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pessoa;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pet;

public class PetDAO implements DAOGenerica {

    private final Connection conexao;

    public PetDAO() throws SQLException, ClassNotFoundException {
        conexao = Conexao.abrirConexao();
    }

    @Override
    public void cadastrar(Object objeto) throws SQLException {
        String sql = "CALL cadastrarpet(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Pet pet = (Pet) objeto;
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, pet.getIdPet());
            stmt.setInt(2, pet.getPessoa().getIdPessoa());
            stmt.setString(3, pet.getNomeImg());
            stmt.setString(4, pet.getNomePet());
            stmt.setString(5, pet.getRacaPet());
            stmt.setString(6, pet.getIdadePet());
            stmt.setString(7, pet.getEspeciePet());
            stmt.setString(8, pet.getCoresPet());
            stmt.setString(9, pet.getSexoPet());
            stmt.setString(10, pet.getPortePet());
            stmt.setString(11, pet.getObservacoes());
            stmt.setBoolean(12, pet.isAdocao());
            stmt.setBoolean(13, pet.isDoar());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao gravar pet");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public Object consultar(int codigo) throws SQLException {
        String sql = "select p.idpet, p.nomeimg, p.nomepet, p.racapet, p.idadepet, p.especiepet,p.corespet, p.sexopet, p.portepet, p.observacoes, p.adocao, p.doado,\n"
                + "pe.idpessoa, pe.nomeimg, pe.nomepessoa, pe.cpfpessoa, pe.datanascimentopessoa, pe.ceppessoa, pe.telefonepessoa, pe.emailpessoa, pe.generopessoa\n"
                + "from pet p inner join pessoa pe ON pe.idpessoa = p.idpessoa where p.idpet = ?";
        Pet pet = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                pet = new Pet(rs.getInt("idpet"),
                        (Pessoa) new PessoaDAO().adotar(rs.getInt("idpessoa")),
                        rs.getString("nomeimg"), rs.getString("nomepet"), rs.getString("racapet"),
                        rs.getString("idadepet"), rs.getString("especiepet"),
                        rs.getString("corespet"), rs.getString("sexopet"),
                        rs.getString("portepet"), rs.getString("observacoes"),
                        rs.getBoolean("adocao"), rs.getBoolean("doado")
                );
                Pessoa pessoa = new Pessoa();
                pessoa.getNomeImg(rs.getString("nomeimg"));
                pessoa.getNomePessoa(rs.getString("nomepessoa"));
                pessoa.getCpfPessoa(rs.getString("cpfpessoa"));
                pessoa.getDataNascimentoPessoa(rs.getString("datanascimentopessoa"));
                pessoa.getCepPessoa(rs.getString("ceppessoa"));
                pessoa.getTelefonePessoa(rs.getString("telefonepessoa"));
                pessoa.getEmailPessoa(rs.getString("emailpessoa"));
                pessoa.getGeneroPessoa(rs.getString("generopessoa"));
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao consultar pet");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return pet;
    }

    @Override
    public List<Object> listar() throws SQLException {
        String sql = "select p.idpet, p.nomeimg, p.nomepet, p.racapet, p.idadepet, p.especiepet, p.corespet, p.sexopet, p.portepet,\n"
                + "p.observacoes, p.adocao, p.doado, pessoa.idpessoa, pessoa.nomepessoa\n"
                + "from pet p inner join pessoa ON pessoa.idpessoa = p.idpessoa;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pet pet = new Pet(rs.getInt("idpet"),
                        (Pessoa) new PessoaDAO().adotar(rs.getInt("idpessoa")),
                        rs.getString("nomeimg"),
                        rs.getString("nomepet"), rs.getString("racapet"),
                        rs.getString("idadepet"), rs.getString("especiepet"),
                        rs.getString("corespet"), rs.getString("sexopet"),
                        rs.getString("portepet"), rs.getString("observacoes"),
                        rs.getBoolean("adocao"), rs.getBoolean("doado")
                );
                Pessoa pessoa = new Pessoa();
                pessoa.getNomePessoa(rs.getString("nomepessoa"));
                lista.add(pet);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar Pets");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Pet pet = new Pet(rs.getInt("idpet"), rs.getString("nomeimg"),
                        rs.getString("nomepet"), rs.getString("racapet"),
                        rs.getString("idadepet"), rs.getString("especiepet"),
                        rs.getString("corespet"), rs.getString("sexopet"),
                        rs.getString("portepet"), rs.getString("observacoes"));
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
                Pet pet = new Pet(rs.getInt("idpet"), rs.getString("nomeimg"),
                        rs.getString("nomepet"), rs.getString("racapet"),
                        rs.getString("idadepet"), rs.getString("especiepet"),
                        rs.getString("corespet"), rs.getString("sexopet"),
                        rs.getString("portepet"), rs.getString("observacoes"));
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
