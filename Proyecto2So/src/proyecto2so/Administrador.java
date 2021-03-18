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
public class Administrador {
    
    private int aleatorio;
    Nivel1 consola1;
    Nivel2 consola2;
    Nivel3 consola3;
    private int contador = 0;
    
    public void crearConsola(){
        
        aleatorio = (int)(Math.random()*10+1);
        
        if(aleatorio < 4){
            
            contador++;
            consola1.insertarPrimero(contador);
            
        }else if(aleatorio > 3 && aleatorio < 7){
            
            contador++;
            consola2.insertarPrimero(contador);
            
        }else{
            
            contador++;
            consola3.insertarPrimero(contador);
            
        }
        
    }
    
}
