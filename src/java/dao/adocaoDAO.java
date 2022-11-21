package dao;

import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Adocao;
import model.Pessoa;
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
            stmt.setInt(2, adocao.getPessoa().getIdPessoa());
            stmt.setInt(3, adocao.getPet().getIdPet());

            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao adotar");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public Object consultar(int codigo) throws SQLException {
        String sql = "select adocao.idadocao, adocao.idpessoa, adocao.idpet, p.nomeimg, p.nomepet, p.racapet, p.idadepet, p.especiepet,\n"
                + "p.corespet, p.sexopet, p.portepet, p.observacoes,\n"
                + "pe.nomeimg, pe.nomepessoa, pe.cpfpessoa, pe.datanascimentopessoa, pe.ceppessoa, pe.telefonepessoa, pe.emailpessoa, pe.generopessoa\n"
                + "from adocao inner join pet p on p.idpet = adocao.idpet \n"
                + "inner join pessoa pe on pe.idpessoa = adocao.idpessoa where adocao.idadocao = ? ";
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
                        (Pessoa) new PessoaDAO().adotar(rs.getInt("idpessoa")),
                        (Pet) new PetDAO().consultar(rs.getInt("idpet"))
                );
                Pet pet = new Pet();
                pet.getPessoa(rs.getInt("idpessoa"));
                pet.getNomeImg(rs.getString("nomeimg"));
                pet.getNomePet(rs.getString("nomepet"));
                pet.getRacaPet(rs.getString("racapet"));
                pet.getIdadePet(rs.getString("idadepet"));
                pet.getEspeciePet(rs.getString("especiepet"));
                pet.getCoresPet(rs.getString("corespet"));
                pet.getSexoPet(rs.getString("sexopet"));
                pet.getPortePet(rs.getString("portepet"));
                pet.getObservacoes(rs.getString("observacoes"));
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
        } catch (SQLException | ClassNotFoundException ex) {
            throw new SQLException("Erro ao visualizar adoção");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return adocao;
    }

    @Override
    public List<Object> listar() throws SQLException {
        String sql = "select adocao.idadocao, adocao.idpessoa, adocao.idpet, p.nomeimg, p.nomepet, pe.idpessoa, pe.nomepessoa\n"
                + "from adocao inner join pet p on p.idpet = adocao.idpet \n"
                + "inner join pessoa pe on pe.idpessoa = p.idpessoa";
        List<Object> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Adocao adocao = new Adocao(
                        rs.getInt("idadocao"),
                        (Pessoa) new PessoaDAO().adotar(rs.getInt("idpessoa")),
                        (Pet) new PetDAO().consultar(rs.getInt("idpet"))
                );
                Pet pet = new Pet();
                pet.getNomeImg(rs.getString("nomeimg"));
                pet.getNomePet(rs.getString("nomepet"));
                Pessoa pessoa = new Pessoa();
                pessoa.getNomePessoa(rs.getString("nomepessoa"));
                lista.add(adocao);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar adoções");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(adocaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return lista;
    }

    @Override
    public void excluir(int adotar) throws SQLException {
        String sql = "delete from adocao where idadocao = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, adotar);
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao excluir adoção");
        } finally {
            Conexao.encerrarConexao(conexao, stmt);
        }
    }
}
