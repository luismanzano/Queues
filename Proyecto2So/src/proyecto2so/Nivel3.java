/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2so;

/**
 *
 * @author leonp
 */
public class Nivel3 extends Cola {
    
    public void subirNivel2(Cola cola, Nodo nodo){
        
        //ENCONTRAR EL NODO QUE QUIERO 
        //MANDARLO A LA NUEVA COLA 
        //DESENCOLAR EL NODO QUE QUIERO 
        cola.encolar(nodo);
        
        Nodo temp = nodo.anterior;
        
        temp.siguiente = nodo.siguiente;
        
        nodo.siguiente.anterior = temp;
        
        nodo.siguiente = null;
        nodo.anterior = null;
    }
    
}
