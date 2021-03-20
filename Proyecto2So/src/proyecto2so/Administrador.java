/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2so;

import java.util.Timer;
import java.util.TimerTask;
 
/**
 *
 * @author leonp
 */
public class Administrador {

    /**
     * @param args the command line arguments
     */
    
    
        static Nivel1 cola1 = new Nivel1();
        static Nivel2 cola2 = new Nivel2();
        static Nivel3 cola3 = new Nivel3();
        static Mantenimiento cola4 = new Mantenimiento();
        private int contadorId = 0;
        private int aleatorio;
        
        
        
    public static void programa(){
        // TODO code application logic here
        
        Administrador admin = new Administrador();
        Robot robot = new Robot();
        
        Timer temporizador = new Timer();
        
        TimerTask tareaRobot = new TimerTask() {
            @Override
            public void run() {
                if(!cola1.esVacio()){
                    
                    robot.revisarConsola(cola1, cola4);
                    cola1.actualizarContador();
                    Interfaz.setNivel1(String.valueOf(cola1.dimension));
        Interfaz.setNivel2(String.valueOf(cola2.dimension));
        Interfaz.setNivel3(String.valueOf(cola3.dimension));
                    
                }else if(!cola2.esVacio()){
                    
                    robot.revisarConsola(cola2, cola4);
                    cola2.actualizarContador();
                    Interfaz.setNivel1(String.valueOf(cola1.dimension));
        Interfaz.setNivel2(String.valueOf(cola2.dimension));
        Interfaz.setNivel3(String.valueOf(cola3.dimension));
                    
                }else if(!cola3.esVacio()){
                    
                    robot.revisarConsola(cola3, cola4);
                    cola3.actualizarContador();
                    Interfaz.setNivel1(String.valueOf(cola1.dimension));
        Interfaz.setNivel2(String.valueOf(cola2.dimension));
        Interfaz.setNivel3(String.valueOf(cola3.dimension));
                    
                }
                
                admin.aumentarNivel(cola1, cola2, cola3);
                
            }
        };
        
        TimerTask tareaAdministrador = new TimerTask() {
            @Override
            public void run() {
                admin.crearConsola();
            }
        };
        
        temporizador.schedule(tareaRobot, 0, 7000);
        temporizador.schedule(tareaAdministrador, 0, 14000);
        
    }
    
    
    public void crearConsola(){
        
        
        aleatorio = (int)(Math.random()*10+1);
        
        if(aleatorio < 8){

            aleatorio = (int)(Math.random()*9+1);

            if(aleatorio < 4){

                contadorId++;
                cola1.insertarPrimero(contadorId);

            }else if(aleatorio > 3 && aleatorio < 7){

                contadorId++;
                cola2.insertarPrimero(contadorId);

            }else{

                contadorId++;
                cola3.insertarPrimero(contadorId);

            }
        }
        
        Interfaz.setNivel1(String.valueOf(cola1.dimension));
        Interfaz.setNivel2(String.valueOf(cola2.dimension));
        Interfaz.setNivel3(String.valueOf(cola3.dimension));

    }

    public void aumentarNivel(Nivel1 cola1, Nivel2 cola2, Nivel3 cola3){ ////////////FALTA COMPLETAR CON MARAVILLOSA IDEA DE LUIS ////////////
        
        if(!cola2.esVacio()){
            
            Nodo temp = cola2.primero;
            
            do { 
                
                if(temp.contador > 14){
                    
                    cola2.subirNivel1(cola1, temp);
                    
                    
                }
           
                temp = temp.siguiente;
            } while (temp.siguiente != null);
            
            Interfaz.setNivel1(String.valueOf(cola1.dimension));
        Interfaz.setNivel2(String.valueOf(cola2.dimension));
        Interfaz.setNivel3(String.valueOf(cola3.dimension));
        }
        
        
        if(!cola3.esVacio()){
            
            Nodo temp = cola3.primero;
            
            do { 
                
                if(temp.contador > 14){
                    
                       cola2.encolar(temp);
//                    cola3.subirNivel2(cola2, temp);
                        




/*
nodo.anterior.siguiente
*/
                    
                }
           
                temp = temp.siguiente;
            } while (temp.siguiente != null);
            Interfaz.setNivel1(String.valueOf(cola1.dimension));
        Interfaz.setNivel2(String.valueOf(cola2.dimension));
        Interfaz.setNivel3(String.valueOf(cola3.dimension));
            
            
        }
    }    
    
}


/*
 * 
 *  ROBOT
 * 
 *      Recibe los nintendos uno a uno para realizar las pruebas para determinar 
 *      si las consolas estan listas para salir al mercado o si requieren mejoras 
 *      las consolas se revisan por un perido de 7 segundo. En caso de que la consola  
 *      no este lista o deba mejorarse, se encola para esperar por una nueva revision
 *
        Por cada revison 
        la consola tiene una probailidad del 30% para salir al mercado 
        tiene una probabilidad del 50% de volver a encolarse para mas tiempo de revision     
        tiene una probabilidad del 20% para requerir de alguna mejora 
 
    Super Switch 

        Las consolas tienen un id entero unico y alguno de los 3 niveles de prioridad 
        
        Nivel 1
            Prioridad alta, si hay alguno dentro del sistema, debe pasar al robot 
            sobre las de otras prioridades
            
        Nivel 2
            Prioridad mediana, puede pasar al robot siempre y cuando no haya ninguna 
            consola de nivel 1 

        Nivel 3
            Prioridad baja, solo pasan al robot si no hay consolas de nivel 1 y 2 encolados 

        Para efectos de las reparaciones o mejoras, todos los nintendos sin importar 
        la prioridad son colocados en la misma cola y son despachados uno a uno 
        Por cada vez que se actualice las colas, existen 45% de probabilidades de que 
        la primera consola en esta salga y sea colocado en la cola de los carros 
        listos para la revision 

        Las consolas tienen un contador que muestra cuantas consolas distintas a 
        ellos ya han pasado por el robot. Cuando la consola le toca su turno de ser
        revisado, este contador pasa a cero. Si el contador llega a 15 la consola 
        es subida de nivel de prioridad y el contador se actualiza a 0 (solo aplica para nivel 2 y 3)
        
    Administrador 

        Actualiza las colas del sistemas y le inidca al robot la siguiente consola 
        que va a revisar. Cada dos ciclos de revision el administrador agrega un 
        nuevo carro a la cola de su nivel correspondiente. Este evento ocurre con 
        una probabilidad del 70% y la prioridad es completamente aleatoria 

    Simulacion 
        
        Comienza a ejecutarse y debe crear una consola. Una vez ahi comienza a 
        operar el robot, despues el administrador y asi sucesivamente

        Se debe mostrar en pantalla en todo momento las colas que mantiene el administrador
        con los id´s de las consolas en cada una en el orden en el cual esten, junto 
        con el id de la consola que se encuentra en revision
 */