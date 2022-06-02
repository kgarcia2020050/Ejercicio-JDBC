/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import beans.Persona;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import jdbc.PersonaJDBC;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @Autor: Kenneth Garcia
 * @Fecha: Jun 1, 2022, 12:31:12 PM
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "eliminar":
                    eliminarCliente(request, response);
                    break;
                case "obtener":
                    obtenerCliente(request, response);
                    break;
                default:
                    this.cargarDatos(request, response);
            }

        } else {
            this.cargarDatos(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String parametro = request.getParameter("accion");

        if (parametro != null) {
            switch (parametro) {
                case "insertar":
                    insertarCliente(request, response);
                    break;
                case "modificar":
                    actualizarCliente(request, response);
                    break;
                default:
                    cargarDatos(request, response);

            }
        } else {
            cargarDatos(request, response);
        }

    }

    private void cargarDatos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Persona> personas = new PersonaJDBC().mostrar();
        HttpSession sesion = request.getSession();

        sesion.setAttribute("listado", personas);
        sesion.setAttribute("totalClientes", personas.size());
        sesion.setAttribute("sumaSaldos", sumaSaldos());
        response.sendRedirect("clientes.jsp");
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String saldoStr = request.getParameter("saldo");
        double saldo = 0.0;

        if ((saldoStr != null) && (!saldoStr.equals(""))) {

            saldo = Double.parseDouble(request.getParameter("saldo"));

        }

        Persona persona = new Persona(nombre, apellido, email, telefono, saldo);

        int nuevoCliente = new PersonaJDBC().agregar(persona);

        cargarDatos(request, response);

    }

    private void obtenerCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        Persona persona = new PersonaJDBC().encontrar(new Persona(idCliente));

        System.out.println("entrando al metodo para obtener: " + persona);

        request.setAttribute("idObtenido", persona);
        request.getRequestDispatcher("editar-persona.jsp").forward(request, response);

    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        Persona persona = new Persona(idCliente);

        int borrarPersona = new PersonaJDBC().eliminar(persona);

        cargarDatos(request, response);

    }
    
    private void actualizarCliente(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        
        int idCliente=Integer.parseInt(request.getParameter("idCliente"));
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String email =request.getParameter("email");
        String telefono=request.getParameter("telefono");
        String validarSaldo=request.getParameter("saldo");
        double saldo=0;
        
        if(validarSaldo!=null &&!validarSaldo.equals("")){
            saldo=Double.parseDouble(request.getParameter("saldo"));
        }
        
        Persona cambiarInformacion=new Persona(idCliente,nombre,apellido,email,telefono,saldo);
        
        int personaEditada=new PersonaJDBC().editar(cambiarInformacion);
        System.out.println(personaEditada);
        
        cargarDatos(request, response);
        
    }

    private double sumaSaldos() {
        double total = 0;
        List<Persona> personas = new PersonaJDBC().mostrar();

        for (int i = 0; i < personas.size(); i++) {
            total = total + personas.get(i).getSaldo();
        }

        return total;
    }

}
