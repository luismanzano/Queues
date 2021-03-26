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
        
        //ENCONTRAR EL NODO QUE QUIERO 
        //MANDARLO A LA NUEVA COLA 
        //DESENCOLAR EL NODO QUE QUIERO 
        desencolar(nodo.id);
        cola.encolar(nodo, 1);
        
        System.out.println("Se subio a nivel 1: " + nodo.id);
//        if (nodo.anterior == null) {
//            
//            
//        }
//        if(nodo.anterior != null){
//        
//        Nodo temp = nodo.anterior;
//        
//             temp.siguiente = (nodo.siguiente != null) ? nodo.siguiente : null;
//        
//       
//            nodo.siguiente.anterior = (nodo.siguiente.anterior != null) ? temp : null;
//        nodo.siguiente = null;
//        nodo.anterior = null;
//        
//        
//            }
    }

    }
