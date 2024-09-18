package org.example.dao;

import org.example.DatabaseConfig;
import org.example.entities.Cliente;
import org.example.enums.Genero;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImplementada implements ClienteDao {


    private final DatabaseConfig db;


    public ClienteDaoImplementada(DatabaseConfig db) {
        this.db = db;
    }

    @Override
    public void create(Cliente cliente) {
        String sql = "INSERT INTO T_DAI_CLIENTE(id_cliente, nm_cliente, ds_email, nr_telefone, ds_endereco, ds_idade, ds_genero, nr_cpf) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            db.dummyException();
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cliente.getId());
            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getTelefone());
            pstmt.setString(5, cliente.getEndereco());
            pstmt.setLong(6, cliente.getIdade());
            pstmt.setString(7, cliente.getGenero().name());
            pstmt.setString(8, cliente.getCpf());
            pstmt.executeUpdate();
            connection.close();
        } catch (SQLException | IOException e) {
            //TODO;
        }
    }

    @Override
    public List<Cliente> read() {
        List<Cliente> result = new ArrayList<>();
        String sql = "SELECT * FROM T_DAI_CLIENTE";
        try {
            Connection connection = db.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("endereco");
                Long idade = rs.getLong("idade");
                Genero genero = Genero.valueOf(rs.getString("genero"));
                String cpf = rs.getString("cpf");
                LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();
                result.add((new Cliente(id, nome, email, telefone, endereco, idade, genero, cpf)));
            }
        } catch (SQLException e) {
            //TODO;
        }
        return result;
    }

    public void update(Cliente cliente) {
        String sql = "UPDATE T_DAI_CLIENTE SET nm_cliente = ?, ds_email = ?, nr_telefone = ?, ds_endereco = ?, ds_idade = ?, ds_genero = ?, nr_cpf = ? WHERE id_cliente = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setLong(5, cliente.getIdade());
            pstmt.setString(6, cliente.getGenero().name());
            pstmt.setString(7, cliente.getCpf());
            pstmt.setLong(8, cliente.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            //TODO;
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE T_DAI_CLIENTE WHERE id = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            //TODO;
        }
    }
}