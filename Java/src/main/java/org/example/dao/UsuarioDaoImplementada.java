package org.example.dao;

import org.example.DatabaseConfig;
import org.example.entities.Cliente;
import org.example.entities.Usuario;
import org.example.entities.Veiculo;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImplementada implements UsuarioDao{

    private final DatabaseConfig db;
    public UsuarioDaoImplementada(DatabaseConfig db) {
        this.db = db;
    }

    @Override
    public void create(Usuario usuario) {
        String sql = "INSERT INTO T_DAI_USUARIO(ID, NOME, EMAIL,  TELEFONE,  ENDEREÇO) VALUES (?,?,?,?,?)";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, usuario.getId());
            pstmt.setString(2, usuario.getNome());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getTelefone());
            pstmt.setString(5, usuario.getEndereco());
            pstmt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            //TODO
        }
    }

    @Override
    public List<Usuario> read() {
        List<Usuario> result = new ArrayList<>();
        String sql = "SELECT * FROM T_DAI_USUARIO";
        try {
            Connection connection = db.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Mapeando as linhas para objetos concretos (Cliente neste caso)
            while (rs.next()) {
                Long id = rs.getLong("ID");
                String nome = rs.getString("NOME");
                String email = rs.getString("EMAIL");
                String telefone = rs.getString("TELEFONE");
                String endereco = rs.getString("ENDEREÇO");

                // Criando um objeto Cliente ao invés de Usuario anônimo
                result.add(new Usuario(id, nome, email, telefone, endereco) {
                    @Override
                    public void adicionarVeiculo(Veiculo veiculo) {
                        //
                    }

                    @Override
                    public void removerVeiculo(Veiculo veiculo) {
                        //
                    }
                });
            }
        } catch (SQLException e) {
            //TODO;
        }

        return result;
    }


    @Override
    public void update(Usuario usuario) {

        String sql = "UPDATE T_DAI_USUARIO SET NOME= ?, EMAIL= ?, TELEFONE= ?, ENDEREÇO= ? WHERE id= ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getTelefone());
            pstmt.setString(4, usuario.getEndereco());
            pstmt.setLong(5, usuario.getId());
            pstmt.executeUpdate();


        } catch (SQLException e) {
            //TODO
        }

    }

    @Override
    public void delete(Long id) {


        String sql = "DELETE T_DAI_USUARIO WHERE id = ?";

        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e){
            //TODO
        }

    }
}