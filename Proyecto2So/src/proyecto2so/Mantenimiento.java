/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2so;

import static proyecto2so.Administrador.cola3;
import static proyecto2so.Administrador.cola2;
import static proyecto2so.Administrador.cola1;

/**
 *
 * @author leonp
 */
public class Mantenimiento extends Cola {
    
    public void listoParaRevision(Cola cola){
        double prob = Math.random();
        if(cola.primero != null){
            if (prob > 0.44) {
                System.out.println("Regresando consola " + cola.primero.id + " a la cola: " + cola.primero.prioridad );
            switch(cola.primero.prioridad){
                case 1:
                    System.out.println("CASO 1 ENTRA");
                    cola1.encolar(cola.primero, cola.primero.prioridad);
                    break;
                case 2:
                    System.out.println("CASO 2 ENTRA");
                    cola2.encolar(cola.primero, cola.primero.prioridad);
                    break;
                case 3:
                    System.out.println("CASO 3 ENTRA");
                    cola3.encolar(cola.primero, cola.primero.prioridad);
                    break;
            }
        cola.eliminarPrimero();
        }
        }
        
        
        
        
    }
    
}
