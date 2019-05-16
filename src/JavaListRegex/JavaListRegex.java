/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JavaListRegex;

import javax.swing.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author sala203
 */
public class JavaListRegex {
    
    public static Nodo cabeza;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        int option = 0;
        String cadena, menu="MENU\n1.Ingresar datos\n0.salir\nDigite la opcion";

        do{
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch(option){
                    case 1: 
                        validarInformacion();
                        break;
                    case 0:
                        break;
                }
            }catch(Exception e){
                break;
            }
        }while(option != 0);
    }
    
    public static void validarInformacion() {
        boolean bandera = false;
        Pattern patronCedula = Pattern.compile("\\d{7,10}");
        Pattern patronNombre = Pattern.compile("^([A-Z][a-z]+(\\s){0,1}){2,}");
        Pattern patronDireccion = Pattern.compile("^(Carrera|Calle)(\\s)[0-9]{1,3}[A-Za-z]{0,1}(\\s)(#)(\\s)[0-9]{1,3}[A-Za-z]{0,1}(\\s)[0-9]{1,3}");
        Pattern patronTelefono = Pattern.compile("^(2|3|4|5|6)[0-9]{6}");
        Pattern patronCorreo = Pattern.compile("([A-Za-z]+(_){0,1}){2}[0-9]{5}(@elpoli.edu.co)");
        Pattern patronEstatura = Pattern.compile("^[1-2](.)[0-9]{2}");
        Pattern patronFechaNacimiento = Pattern.compile("[1-31](/)[1-12](/)[1950-2050]");
        
        String cedula = null;
        String nombre = null;
        String direccion = null;
        String telefono = null;
        String correo = null;
        String estatura = null;
        String fechaNacimiento = null;
        
        Matcher matCedula;
        Matcher matNombre;
        Matcher matDireccion;
        Matcher matTelefono;
        Matcher matCorreo;
        Matcher matEstatura;
        Matcher matFechaNacimiento;

        while(!bandera) {
            cedula = JOptionPane.showInputDialog("Ingrese la cédula");
            matCedula = patronCedula.matcher(cedula);
            if(!matCedula.matches()) {
                JOptionPane.showMessageDialog(null, "Cédula invalida");
            }else {
                bandera = true;
            }
        }
        
        bandera = false;
        
        while(!bandera) {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            matNombre = patronNombre.matcher(nombre);
            if(!matNombre.matches()) {
                JOptionPane.showMessageDialog(null, "Nombre invalido");
            }else {
                bandera = true;
            }
        }
        
        bandera = false;
        
        while(!bandera) {
            direccion = JOptionPane.showInputDialog("Ingrese la dirección");
            matDireccion = patronDireccion.matcher(direccion);
            if(!matDireccion.matches()) {
                JOptionPane.showMessageDialog(null, "Dirección invalida");
            }else {
                bandera = true;
            }
        }
        
        bandera = false;
        
        while(!bandera) {
            telefono = JOptionPane.showInputDialog("Ingrese el teléfono");
            matTelefono = patronTelefono.matcher(telefono);
            if(!matTelefono.matches()) {
                JOptionPane.showMessageDialog(null, "Teléfono invalido");
            }else {
                bandera = true;
            }
        }
        
        bandera = false;
        
        while(!bandera) {
            correo = JOptionPane.showInputDialog("Ingrese el correo");
            matCorreo = patronCorreo.matcher(correo);
            if(!matCorreo.matches()) {
                JOptionPane.showMessageDialog(null, "Correo invalido");
            }else {
                bandera = true;
            }
        }
        
        bandera = false;
        
        while(!bandera) {
            correo = JOptionPane.showInputDialog("Ingrese la estatura");
            matEstatura = patronEstatura.matcher(correo);
            if(!matEstatura.matches()) {
                JOptionPane.showMessageDialog(null, "Estatura invalida");
            }else {
                bandera = true;
            }
        }
        
        bandera = false;
        
        while(!bandera) {
            correo = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento");
            matFechaNacimiento = patronFechaNacimiento.matcher(correo);
            if(!matFechaNacimiento.matches()) {
                JOptionPane.showMessageDialog(null, "Fecha de nacimiento invalida");
            }else {
                bandera = true;
            }
        }
            
        if(cedula != null && nombre != null && direccion != null && telefono != null && correo != null){
            Person persona = new Person(cedula, nombre, direccion, telefono, correo, estatura, fechaNacimiento);
            Nodo nodo = new Nodo(persona);
            // Insertamos en la lista
            if(cabeza == null){
                cabeza = nodo; 
            }else{
                Nodo cabezaAuxiliar = cabeza;
                while(cabezaAuxiliar.getNodoSgte() != null){
                    cabezaAuxiliar = cabezaAuxiliar.getNodoSgte();
                }
                cabezaAuxiliar.setNodoSgte(nodo);
            }
            // Mostrar personas
            if(cabeza == null){
                System.out.println("No existen personas.");
            }else{
                Nodo cabezaAuxiliar = cabeza;
                while(cabezaAuxiliar != null){
                    System.out.println(cabezaAuxiliar.getPersona().getNombre());
                    cabezaAuxiliar = cabezaAuxiliar.getNodoSgte();
                }
            }
            bandera = true;
        }
    }
    
}
