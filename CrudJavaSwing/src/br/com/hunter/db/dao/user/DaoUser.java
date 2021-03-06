/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hunter.db.dao.user;

import br.com.hunter.db.utils.ConnectionUtils;
import br.com.hunter.models.user.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author edson
 */
public class DaoUser {

    // Instanciando a classe que faz a conexão com o banco de dados
    ConnectionUtils conex = new ConnectionUtils();
    PreparedStatement pst;
    ResultSet rs;

    // Metódo de cadastrar cliente (recebendo por parâmetro o cliente que será cadastrado)
    public String createUser(User user) throws SQLException {
        String reply = null;

        try {
            String query = "insert into tb_user"
                    + "(UserName, Name, Birth, Password)"
                    + "VALUE (?, ?, ?, ?)";

            pst = conex.getConnection().prepareStatement(query);

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getName());
            pst.setString(3, user.getBirth());
            pst.setString(4, user.getPassword());

            pst.execute();
        } catch (Exception e) {
            reply = e.toString();
        }

        return reply;
    }

    public ArrayList<User> getUsers() throws SQLException {
        String query = "select * from tb_user";
        ArrayList users = new ArrayList();

        pst = conex.getConnection().prepareStatement(query);
        rs = pst.executeQuery(query);
        while (rs.next()) {
            User user = new User();
            user.setId(Integer.valueOf(rs.getString("ID")));
            user.setUsername(rs.getString("UserName"));
            user.setName(rs.getString("Name"));
            user.setBirth(rs.getString("Birth"));
            user.setPassword(rs.getString("Password"));
            users.add(user);
        }

        return users;
    }

    public User searchUsername(String username) {
        User search = new User();
        try {
            String query = "select * from tb_user where UserName like '%" + username + "%'";
            pst = conex.getConnection().prepareStatement(query);
            rs = pst.executeQuery(query);
            rs.first();
            search.setId(Integer.valueOf(rs.getString("ID")));
            search.setUsername(rs.getString("UserName"));
            search.setName(rs.getString("Name"));
            search.setBirth(rs.getString("Birth"));
            return search;
        } catch (Exception e) {
            return null;
        }

    }

}
