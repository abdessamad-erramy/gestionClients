/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Client;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    public List<Client> findAll() throws SQLException {
        List<Client> list = new ArrayList<>();
        String sql = "SELECT * FROM client ORDER BY idClt DESC";

        try (Connection cn = DBUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("idClt");
                String nom = rs.getString("nomClt");
                String ville = rs.getString("villeClt");

                list.add(new Client(id, nom, ville));
            }
        }
        return list;
    }

    public void insert(Client c) throws SQLException {
        String sql = "INSERT INTO client(nomClt, villeClt) VALUES (?, ?)";

        try (Connection cn = DBUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, c.getNomClt());
            ps.setString(2, c.getVilleClt());
            ps.executeUpdate();
        }
    }

    public void delete(int idClt) throws SQLException {
        String sql = "DELETE FROM client WHERE idClt=?";

        try (Connection cn = DBUtil.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, idClt);
            ps.executeUpdate();
        }
    }
    public void update(int idClt, String nomClt, String villeClt) throws SQLException {

        String sql = "UPDATE client SET nomClt=?, villeClt=? WHERE idClt=?";

        try (Connection cn = DBUtil.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, nomClt);
            ps.setString(2, villeClt);
            ps.setInt(3, idClt);

            ps.executeUpdate();
        }
    }
}
