/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2so;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
 
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
        
        
        public static void actualizarEtiquetas(){
            JLabel nodos1[] = new JLabel[]{Interfaz.Nivel1_1, Interfaz.Nivel1_2, Interfaz.Nivel1_3, Interfaz.Nivel1_4, Interfaz.Nivel1_5, Interfaz.Nivel1_6};
            JLabel nodos2[] = new JLabel[]{Interfaz.Nivel2_1, Interfaz.Nivel2_2, Interfaz.Nivel2_3, Interfaz.Nivel2_4, Interfaz.Nivel2_5, Interfaz.Nivel2_6};
            JLabel nodos3[] = new JLabel[]{Interfaz.Nivel3_1, Interfaz.Nivel3_2, Interfaz.Nivel3_3, Interfaz.Nivel3_4, Interfaz.Nivel3_5, Interfaz.Nivel3_6};
            JLabel nodos4[] = new JLabel[]{Interfaz.Mantenimiento_1, Interfaz.Mantenimiento_2, Interfaz.Mantenimiento_3, Interfaz.Mantenimiento_4, Interfaz.Mantenimiento_5, Interfaz.Mantenimiento_6};
           
            
            Nodo temp1 = cola1.primero;
            Nodo temp2 = cola2.primero;
            Nodo temp3 = cola3.primero;
            Nodo temp4 = cola4.primero;
            
            for (int i = 0; i < 6; i++) {
                //ACTUALIZACION DE LA COLA 1
                if (temp1 != null) {
                nodos1[i].setText("ID: " + temp1.id + "\n" + "Contador: "+ String.valueOf(temp1.contador));
                temp1 = (temp1.siguiente != null) ? temp1.siguiente : null;
            } else {
                    nodos1[i].setText("No hay");
                }
                
                
                 //ACTUALIZACION DE LA COLA 2
                if (temp2 != null) {
                nodos2[i].setText("ID: " + temp2.id + "\n" + "Contador: "+ String.valueOf(temp2.contador));
                temp2 = (temp2.siguiente != null) ? temp2.siguiente : null;
            } else {
                    nodos2[i].setText("No hay");
                }
                
                
                 //ACTUALIZACION DE LA COLA 3
                if (temp3 != null) {
                nodos3[i].setText("ID: " + temp3.id + "\n" + "Contador: "+ String.valueOf(temp3.contador));
                temp3 = (temp3.siguiente != null) ? temp3.siguiente : null;
            } else {
                    nodos3[i].setText("No hay");
                }
                
               //ACTUALIZACION DE MANTENIMIENTO
                if (temp4 != null) {
                nodos4[i].setText("ID: " + temp4.id + "\n" + "Contador: "+ String.valueOf(temp4.contador));
                temp4 = (temp4.siguiente != null) ? temp4.siguiente : null;
            } else {
                    nodos4[i].setText("No hay");
                }
                
                
            }
            
        }
        
    public static void programa(){
        // TODO code application logic here
        
        Administrador admin = new Administrador();
        Robot robot = new Robot();
        
        Timer temporizador = new Timer();
        
        TimerTask tareaRobot = new TimerTask() {
            @Override
            public void run() {
                if(!cola1.esVacio()){
                    System.out.println("COLA 1");
                    robot.revisarConsola(cola1, cola4);
                    cola1.actualizarContador();
                    
                    actualizarEtiquetas();
                    
                }else if(!cola2.esVacio()){
                    System.out.println("COLA 2");
                    robot.revisarConsola(cola2, cola4);
                    
                    cola2.actualizarContador();
                    actualizarEtiquetas();
                    
                }else if(!cola3.esVacio()){
                    System.out.println("COLA 3");
                    robot.revisarConsola(cola3, cola4);
                    
                    cola3.actualizarContador();
                    actualizarEtiquetas();
                    
                }
                
                admin.aumentarNivel(cola1, cola2, cola3);
                actualizarEtiquetas();
            }
        };
        
        TimerTask tareaAdministrador = new TimerTask() {
            @Override
            public void run() {
                admin.crearConsola();
            }
        };
        
        temporizador.schedule(tareaRobot, 0, 3000);
        temporizador.schedule(tareaAdministrador, 0, 4000);
        
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
                actualizarEtiquetas();

            }else{

                contadorId++;
                cola3.insertarPrimero(contadorId);
                actualizarEtiquetas();

            }
        }
        
        actualizarEtiquetas();
        
    }

    public void aumentarNivel(Nivel1 cola1, Nivel2 cola2, Nivel3 cola3){ ////////////FALTA COMPLETAR CON MARAVILLOSA IDEA DE LUIS ////////////
        
        if(!cola2.esVacio()){
            
            Nodo temp = cola2.primero;
            
            do { 
                
                if(temp.contador > 14){
                    System.out.println("SUBIENDO A COLA 1");
                    temp.contador = 0; 
                    cola2.subirNivel1(cola1, temp);
                    
                    actualizarEtiquetas();
                }
           
                temp = (temp.siguiente != null) ? temp.siguiente : temp;
            } while (temp.siguiente != null);
            
        }
        
        
        if(!cola3.esVacio()){
            
            Nodo temp = cola3.primero;
            
            do { 
                
                if(temp.contador > 14){
                        System.out.println("SUBIENDO A COLA 2");
                        temp.contador = 0;
                       cola3.subirNivel2(cola2,temp);
                       actualizarEtiquetas();
//                    cola3.subirNivel2(cola2, temp);
                        




/*
nodo.anterior.siguiente
*/
                    
                }
           
                temp = (temp.siguiente != null) ? temp.siguiente : temp;
            } while (temp.siguiente != null);
            
            
        }
        actualizarEtiquetas();
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