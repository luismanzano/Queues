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
public class Nivel2 extends Cola{
    
    public Nivel2 (){
        
    }
    
    public void subirNivel1(Cola cola, Nodo nodo){
        
        cola.encolar(nodo);
//        eliminarNodo(nodo);
    }
    
}
