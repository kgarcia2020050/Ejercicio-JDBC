/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import beans.Persona;
import dao.PersonaIDAO;
import db.Conexion;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @Autor: Kenneth Garcia
 * @Fecha: Jun 1, 2022, 12:23:37 PM
 */
public class PersonaJDBC implements PersonaIDAO {

    private static final String SELECT = "select * from cliente";
    private static final String INSERT = "insert into cliente (nombre,apellido,email,telefono,saldo) values(?,?,?,?,?)";
    private static final String GETBYID = "select * from cliente where id_cliente=?";
    private static final String UPDATE = "update cliente set nombre=?,apellido=?,email=?,telefono=?,saldo=?";
    private static final String DELETE = "delete from cliente where id_cliente=?";

    @Override
    public List<Persona> mostrar() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Persona cliente = null;
        List<Persona> clientes = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SELECT);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");

                cliente = new Persona(idCliente, nombre, apellido, email, telefono, saldo);
                clientes.add(cliente);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.cerrarRs(rs);
            Conexion.cerrarPstmt(pstmt);
            Conexion.cerrarConn(conn);
        }

        return clientes;

    }

    @Override
    public int agregar(Persona persona) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, persona.getNombre());
            pstmt.setString(2, persona.getApellido());
            pstmt.setString(3, persona.getEmail());
            pstmt.setString(4, persona.getTelefono());
            pstmt.setDouble(5, persona.getSaldo());
            registros = pstmt.executeUpdate();

        } catch (SQLException ex) {
        } finally {
            Conexion.cerrarPstmt(pstmt);
            Conexion.cerrarConn(conn);
        }
        return registros;

    }

    @Override
    public int editar(Persona persona) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, persona.getNombre());
            pstmt.setString(2, persona.getApellido());
            pstmt.setString(3, persona.getEmail());
            pstmt.setString(4, persona.getTelefono());
            pstmt.setDouble(5, persona.getSaldo());
            registros = pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.cerrarPstmt(pstmt);
            Conexion.cerrarConn(conn);
        }
        return registros;

    }

    @Override
    public int eliminar(Persona persona) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, persona.getIdCliente());
            registros = pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.cerrarPstmt(pstmt);
            Conexion.cerrarConn(conn);
        }
        return registros;

    }

    @Override
    public Persona encontrar(Persona persona) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(GETBYID);
            pstmt.setInt(1, persona.getIdCliente());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");

                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEmail(email);
                persona.setTelefono(telefono);
                persona.setSaldo(saldo);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.cerrarRs(rs);
            Conexion.cerrarPstmt(pstmt);
            Conexion.cerrarConn(conn);

        }
        return persona;

    }

}
