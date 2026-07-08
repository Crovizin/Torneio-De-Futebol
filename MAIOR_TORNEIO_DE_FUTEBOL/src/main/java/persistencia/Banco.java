package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

    private static final String URL = "jdbc:mysql://localhost:3307/torneio";
    private static final String USUARIO = "root";
    private static final String SENHA = "root123";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}