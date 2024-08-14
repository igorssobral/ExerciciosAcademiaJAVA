package semana2.quarta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "9945";

    private ConnectionDB() {
    }

    public static synchronized Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null || !connection.isClosed()) {
            connection.close();
            connection = null;
            System.out.println("Conexão fechada com Sucesso!");
        }
    }
}
