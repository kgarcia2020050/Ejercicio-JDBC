/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import beans.Persona;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gerar
 */
public interface PersonaIDAO {

    public List<Persona> mostrar() throws SQLException;
    
    public Persona encontrar(Persona persona)throws SQLException;

    public int agregar(Persona persona) throws SQLException;

    public int editar(Persona persona) throws SQLException;

    public int eliminar(Persona persona) throws SQLException;

}
