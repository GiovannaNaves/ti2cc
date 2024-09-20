package dao;

import model.Topico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TopicoDAO extends DAO {

    public boolean insert(Topico topico) {
        try {
            String sql = "INSERT INTO Topico (titulo, conteudo, imagem, categorias) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, topico.getTitulo());
            stmt.setString(2, topico.getConteudo());
            stmt.setString(3, topico.getImagem());
            stmt.setString(4, String.join(",", topico.getCategorias()));
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public List<Topico> getAll() {
        List<Topico> topicos = new ArrayList<>();
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Topico");
            while (rs.next()) {
                String[] categorias = rs.getString("categorias").split(",");
                Topico t = new Topico(rs.getInt("id"), rs.getString("titulo"),
                        rs.getString("conteudo"), rs.getString("imagem"), categorias);
                topicos.add(t);
            }
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return topicos;
    }
}
