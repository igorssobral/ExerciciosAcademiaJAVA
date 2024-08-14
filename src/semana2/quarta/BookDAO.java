package semana2.quarta;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void create(Book book) {
        String querySQL = "INSERT INTO livros (titulo, autor, ano_publicacao) VALUES (?,?,?)";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(querySQL)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getReleaseYear());

            statement.executeUpdate();
            System.out.println("\n---Livro Cadastrado com Sucesso---");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> readAll() {
        List<Book> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("titulo"));
                book.setAuthor(resultSet.getString("autor"));
                book.setReleaseYear(resultSet.getInt("ano_publicacao"));

                livros.add(book);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }

    public void update(Book book) {
        String sql = "UPDATE livros SET titulo = ?, autor = ?, ano_publicacao = ? WHERE id = ?";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getReleaseYear());
            statement.setInt(4, book.getId());

            statement.executeUpdate();
            System.out.println("Livro Editado com Sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM livros WHERE id = ?";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Livro deletado com sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

