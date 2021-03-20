/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2so;

import static proyecto2so.Administrador.cola3;

/**
 *
 * @author leonp
 */
public class Mantenimiento extends Cola {
    
    public void listoParaRevision(){
        double prob = Math.random();
        if(primero != null){
            if (prob > 0.44) {
            cola3.encolar(primero);
        
        eliminarPrimero();
        }
        }
        
        
        
        
    }
    
}
