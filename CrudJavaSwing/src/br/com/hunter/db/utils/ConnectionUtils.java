/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hunter.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author edson
 */
public class ConnectionUtils {

    private static final String user = "root";
    private static final String pass = "";

    // Endereço de conexão com o banco de dados
    private static final String url = "jdbc:mysql://localhost:3306/crud?useTimezone=true&serverTimezone=UTC";
    private static final String driver = "com.mysql.jdbc.Driver";

    public static Statement stm;
    public static ResultSet rs;

    public static Connection connection;

    // Conectar ao banco de dados
    public Connection getConnection() throws SQLException {
        // Conexão para abertura e fechamento
        connection = null;

        // Propriedades para armazenamento de usuário e senha
        Properties properties = new Properties();
        properties.put("user", user);
        properties.put("password", pass);

        // Realiza a conexão com o banco
        System.setProperty("jdbc.Drivers", driver);
        connection = DriverManager.getConnection(url, properties);

        // Retorna a conexão
        return connection;
    }

    public void executeQuery(String query) {
        try {
            // Váriavel utilizada para conseguir usar comando de sql no java
            stm = connection.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            // Váriavel utilizada para executar um comando sql (query)
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

}
