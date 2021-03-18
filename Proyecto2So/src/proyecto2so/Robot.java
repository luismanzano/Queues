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
    
    public void revisarConsola(Nodo consola, Nivel1 cola1, Nivel2 cola2, Nivel3 cola3, Mantenimiento cola4){
        
        probabilidad = (int)(Math.random()*10+1);
        
        if(probabilidad < 4){
            
        }else if(probabilidad > 3 && probabilidad < 9){
            
        }else{
            
        }
        
    }
    
}
