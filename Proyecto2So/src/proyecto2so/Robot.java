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
public class Robot {
    
    private int probabilidad;
    
    public void revisarConsola(Cola cola, Cola mantenimiento){
        
        probabilidad = (int)(Math.random()*10+1);
        
        if(probabilidad < 4){
            
            System.out.println("Sale al mercado");
            
        }else if(probabilidad > 3 && probabilidad < 9){
            cola.primero.contador = -1;
            cola.encolar(cola.primero);
            
        }else{
            cola.primero.contador = 0;
            cola.encolarMantenimiento(mantenimiento, cola.primero);
            
        }
        
        cola.eliminarPrimero();
    }
    
}
