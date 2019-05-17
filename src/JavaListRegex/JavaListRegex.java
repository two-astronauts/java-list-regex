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
        String menu = "MENU\n1.Ingresar datos\n2.Mostrar personas\n3.Correos que terminen en co\n4.Mostrar estaturas"
            + "\n5.Reemplazar 'Avenida' por 'Carrera'\n6.Teléfonos que empiecen por 'x'\n7.Mostrar direcciones que contengan los números 'xx'"
            + "\n8.Reemplazar nombre weird\n9.Reemplazar en la fecha / por -\n0.salir\nDigite la opcion";

        do{
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch(option){
                    case 1:
                        validarInformacion();
                        break;
                    case 2:
                        showPeople();
                        break;
                    case 3:
                        showEmailsEndsWith();
                        break;
                    case 4:
                        showHeight();
                        break;
                    case 5:
                        replaceAvenueCareer();
                        break;
                    case 6:
                        phoneStartsWith();
                        break;
                    case 7:
                        addressWith();
                        break;
                    case 8:
                        replaceWeirdName();
                        break;
                    case 9:
                        changeDateFormat();
                        break;
                    case 0:
                        break;
                }
            }catch(Exception e) {
                break;
            }
        }while(option != 0);
    }
    
    /**
     * 
     */
    public static void validarInformacion() {
        boolean bandera = false;
        Pattern patronCedula = Pattern.compile("\\d{7,10}");
        Pattern patronNombre = Pattern.compile("^([A-Z][a-z]+(\\s){0,1}){2,}");
        Pattern patronDireccion = Pattern.compile("^(Carrera|Calle|Avenida|Transversal|Diagonal|Autopista)(\\s)[0-9]{1,3}[A-Za-z]{0,1}(\\s)(#)(\\s)[0-9]{1,3}[A-Za-z]{0,1}(\\s)[0-9]{1,3}");
        Pattern patronTelefono = Pattern.compile("^(2|3|4|5|6)[0-9]{6}");
        Pattern patronCorreo = Pattern.compile("^[a-zA-Z0-9._-]+(@)[a-zA-Z0-9.-_]+(.)[a-zA-Z]+");
        Pattern patronEstatura = Pattern.compile("^[1-2](.)[0-9]{2}");
        Pattern patronFechaNacimiento = Pattern.compile("([0-2][0-9]|3[0-1])(\\/)(0[1-9]|1[0-2])(\\/)(19|20)[0-9]{2}");
        
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
            estatura = JOptionPane.showInputDialog("Ingrese la estatura");
            matEstatura = patronEstatura.matcher(estatura);
            if(!matEstatura.matches()) {
                JOptionPane.showMessageDialog(null, "Estatura invalida");
            }else {
                bandera = true;
            }
        }
        
        bandera = false;
        
        while(!bandera) {
            fechaNacimiento = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento");
            matFechaNacimiento = patronFechaNacimiento.matcher(fechaNacimiento);
            if(!matFechaNacimiento.matches()) {
                JOptionPane.showMessageDialog(null, "Fecha de nacimiento invalida");
            }else {
                bandera = true;
            }
        }
            
        if(cedula != null && nombre != null && direccion != null && telefono != null && correo != null && estatura != null && fechaNacimiento != null){
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
            showPeople();
            bandera = true;
        }
    }
    
    /**
     * 
     */
    public static void showPeople() {
        // Mostrar personas
        if(cabeza == null) {
            System.out.println("No existen personas.");
        }else {
            Nodo cabezaAuxiliar = cabeza;
            System.out.println("*---------------------------------------------------------------------*");
            while(cabezaAuxiliar != null) {
                System.out.println(
                    "C: "+ cabezaAuxiliar.getPersona().getCedula() +" N: "+ cabezaAuxiliar.getPersona().getNombre()
                    +" D: "+ cabezaAuxiliar.getPersona().getDireccion() +" T: "+ cabezaAuxiliar.getPersona().getTelefono()
                    +" C: "+ cabezaAuxiliar.getPersona().getCorreo() +" E: "+ cabezaAuxiliar.getPersona().getEstatura()
                    +" F: "+ cabezaAuxiliar.getPersona().getFechaNacimiento()
                );
                cabezaAuxiliar = cabezaAuxiliar.getNodoSgte();
            }
            System.out.println("*---------------------------------------------------------------------*");
        }
    }
    
    /**
     * 
     */
    public static void showEmailsEndsWith() {
        if(cabeza == null){
            System.out.println("No existen personas.");
        }else{
            Nodo cabezaAuxiliar = cabeza;
            Pattern p;
            Matcher mat;
            System.out.println("*---------------------------------------------------------------------*");
            while(cabezaAuxiliar != null){
                p = Pattern.compile(".co$");
                mat = p.matcher(cabezaAuxiliar.getPersona().getCorreo());
                if(mat.find()) {
                    System.out.println("Cédula: "+ cabezaAuxiliar.getPersona().getCedula() +" Correo: "+ cabezaAuxiliar.getPersona().getCorreo());
                }
                cabezaAuxiliar = cabezaAuxiliar.getNodoSgte();
            }
            System.out.println("*---------------------------------------------------------------------*");
        }
    }
    
    /**
     * 
     */
    public static void showHeight() {
        if(cabeza == null) {
            System.out.println("No existen personas.");
        }else {
            Nodo cabezaAuxiliar = cabeza;
            Pattern p;
            System.out.println("*---------------------------------------------------------------------*");
            while(cabezaAuxiliar != null) {
                p = Pattern.compile("\\.");
                String[] estatura = p.split(cabezaAuxiliar.getPersona().getEstatura());
                System.out.println("La estatura de "+ cabezaAuxiliar.getPersona().getNombre() +" es de "+ estatura[0] +" Metro(s) con "+ estatura[1] +" Centimetros");
                cabezaAuxiliar = cabezaAuxiliar.getNodoSgte();
            }
            System.out.println("*---------------------------------------------------------------------*");
        }
    }
    
    /**
     * 
     */
    public static void replaceAvenueCareer() {
        if(cabeza == null) {
            System.out.println("No existen personas.");
        }else {
            Nodo cabezaAuxiliar = cabeza;
            Pattern p;
            Matcher mat;
            System.out.println("*---------------------------------------------------------------------*");
            while(cabezaAuxiliar != null) {
                p = Pattern.compile("Avenida");
                mat = p.matcher(cabezaAuxiliar.getPersona().getDireccion());
                String direccionNueva = mat.replaceAll("Carrera");
                cabezaAuxiliar.getPersona().setDireccion(direccionNueva);
                System.out.println(
                    "C: "+ cabezaAuxiliar.getPersona().getCedula() +" N: "+ cabezaAuxiliar.getPersona().getNombre()
                    +" D: "+ cabezaAuxiliar.getPersona().getDireccion() +" T: "+ cabezaAuxiliar.getPersona().getTelefono()
                    +" C: "+ cabezaAuxiliar.getPersona().getCorreo() +" E: "+ cabezaAuxiliar.getPersona().getEstatura()
                    +" F: "+ cabezaAuxiliar.getPersona().getFechaNacimiento()
                );
                cabezaAuxiliar = cabezaAuxiliar.getNodoSgte();
            }
            System.out.println("*---------------------------------------------------------------------*");
        }
    }
    
    /**
     * 
     */
    public static void phoneStartsWith() {
        if(cabeza == null) {
            System.out.println("No existen personas.");
        }else {
            Nodo cabezaAuxiliar = cabeza;
            Pattern p;
            Matcher mat;
            String numero = JOptionPane.showInputDialog("Ingrese el el número por el que quiere buscar");
            System.out.println("*---------------------------------------------------------------------*");
            while(cabezaAuxiliar != null) {
                p = Pattern.compile("^"+numero+"(\\d*)");
                mat = p.matcher(cabezaAuxiliar.getPersona().getTelefono());
                if(mat.matches()) {
                    System.out.println("Cédula: "+ cabezaAuxiliar.getPersona().getCedula() +" Teléfono: "+ cabezaAuxiliar.getPersona().getTelefono());
                }
                cabezaAuxiliar = cabezaAuxiliar.getNodoSgte();
            }
            System.out.println("*---------------------------------------------------------------------*");
        }
    }
    
    /**
     * 
     */
    public static void addressWith() {
        if(cabeza == null) {
            System.out.println("No existen personas.");
        }else {
            Nodo cabezaAuxiliar = cabeza;
            Pattern p;
            Matcher mat;
            String numero = JOptionPane.showInputDialog("Ingrese el el número que quiere buscar");
            System.out.println("*---------------------------------------------------------------------*");
            while(cabezaAuxiliar != null) {
                p = Pattern.compile(numero);
                mat = p.matcher(cabezaAuxiliar.getPersona().getDireccion());
                while(mat.find()) {
                    System.out.println("D: "+ cabezaAuxiliar.getPersona().getDireccion() +" Empieza "+ mat.start() +"-"+ mat.end() +" y su valor: "+ cabezaAuxiliar.getPersona().getDireccion().substring(mat.start(),mat.end()));
                }
                cabezaAuxiliar = cabezaAuxiliar.getNodoSgte();
            }
            System.out.println("*---------------------------------------------------------------------*");
        }
    }
    
    public static void replaceWeirdName() {
        if(cabeza == null) {
            System.out.println("No existen personas.");
        }else {
            Nodo cabezaAuxiliar = cabeza;
            Pattern p;
            Matcher mat;
            System.out.println("*---------------------------------------------------------------------*");
            while(cabezaAuxiliar != null) {
                p = Pattern.compile("(a|e|i|o|u)");
                mat = p.matcher(cabezaAuxiliar.getPersona().getNombre());
                String nombreNuevo = mat.replaceFirst("@");
                cabezaAuxiliar.getPersona().setNombre(nombreNuevo);
                System.out.println(" Nombre: "+ cabezaAuxiliar.getPersona().getNombre());
                cabezaAuxiliar = cabezaAuxiliar.getNodoSgte();
            }
            System.out.println("*---------------------------------------------------------------------*");
        }
    }
    
    public static void changeDateFormat() {
        if(cabeza == null) {
            System.out.println("No existen personas.");
        }else {
            Nodo cabezaAuxiliar = cabeza;
            System.out.println("*---------------------------------------------------------------------*");
            while(cabezaAuxiliar != null) {
                String fechaNueva = cabezaAuxiliar.getPersona().getFechaNacimiento().replace("/", "-");
                cabezaAuxiliar.getPersona().setFechaNacimiento(fechaNueva);
                System.out.println(" Nombre: "+ cabezaAuxiliar.getPersona().getFechaNacimiento());
                cabezaAuxiliar = cabezaAuxiliar.getNodoSgte();
            }
            System.out.println("*---------------------------------------------------------------------*");
        }
    }
    
}
