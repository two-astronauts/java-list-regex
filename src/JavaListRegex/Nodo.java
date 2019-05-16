/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaListRegex;

/**
 *
 * @author sala203
 */
public class Nodo {
    private Nodo nodoSgte;
    private Person persona;
    
    public Nodo(Person persona){
        this.persona = persona;
    }

    public Nodo getNodoSgte() {
        return nodoSgte;
    }

    public void setNodoSgte(Nodo nodoSgte) {
        this.nodoSgte = nodoSgte;
    }

    public Person getPersona() {
        return persona;
    }

    public void setPersona(Person persona) {
        this.persona = persona;
    }
    
    
}
