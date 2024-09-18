package org.example.dao;

import org.example.DatabaseConfig;
import org.example.entities.Oficina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OficinaDaoImplementada implements OficinaDao {

    private final DatabaseConfig db;

    public OficinaDaoImplementada(DatabaseConfig db) {
        this.db = db;
    }

    @Override
    public void create(Oficina oficina) {
        String sql = "INSERT INTO OFICINA(id, nome, email, telefone, endereco, cnpj, razao_social) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = db.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, oficina.getId());
            pstmt.setString(2, oficina.getNome());
            pstmt.setString(3, oficina.getEmail());
            pstmt.setString(4, oficina.getTelefone());
            pstmt.setString(5, oficina.getEndereco());
            pstmt.setString(6, oficina.getCnpj());
            pstmt.setString(7, oficina.getRazaoSocial());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            //TODO;
        }
    }

    @Override
    public List<Oficina> read() {
        List<Oficina> result = new ArrayList<>();
        String sql = "SELECT * FROM OFICINA";
        try (Connection connection = db.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("endereco");
                String cnpj = rs.getString("cnpj");
                String razaoSocial = rs.getString("razao_social");

                Oficina oficina = new Oficina(id, nome, email, telefone, endereco, cnpj, razaoSocial);
                result.add(oficina);
            }
        } catch (SQLException e) {
            //TODO;
        }
        return result;
    }

    @Override
    public void update(Oficina oficina) {
        String sql = "UPDATE OFICINA SET nome = ?, email = ?, telefone = ?, endereco = ?, cnpj = ?, razao_social = ? WHERE id = ?";
        try (Connection connection = db.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, oficina.getNome());
            pstmt.setString(2, oficina.getEmail());
            pstmt.setString(3, oficina.getTelefone());
            pstmt.setString(4, oficina.getEndereco());
            pstmt.setString(5, oficina.getCnpj());
            pstmt.setString(6, oficina.getRazaoSocial());
            pstmt.setLong(7, oficina.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            //TODO;
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM OFICINA WHERE id = ?";
        try (Connection connection = db.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            //TODO;
        }
    }
}