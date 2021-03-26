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
public class Nodo {
    
    
    public Nodo siguiente = null;
    public Nodo anterior = null;
    public int prioridad = 0;
    public int id;
    public int contador = 0;

    public Nodo(int id){
        this.id = id;
    }
        
        
    
}
