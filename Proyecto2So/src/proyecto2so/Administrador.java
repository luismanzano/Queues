/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2so;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.table.DefaultTableModel;

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
    private Interfaz interfaz;

    public Administrador(Interfaz interfaz) {
        this.interfaz = interfaz;

    }

    public void actualizarEtiquetas() {

        //ACTUALIZACION DE LA COLA 1
        Nodo temp1 = cola1.primero;
        Nodo temp2 = cola2.primero;
        Nodo temp3 = cola3.primero;
        Nodo temp4 = cola4.primero;
        
        DefaultTableModel modelo1 = new DefaultTableModel();
        DefaultTableModel modelo2 = new DefaultTableModel();
        DefaultTableModel modelo3 = new DefaultTableModel();
        DefaultTableModel modelo4 = new DefaultTableModel();
        modelo1.addColumn("Cola1");
        modelo2.addColumn("Cola2");
        modelo3.addColumn("Cola3");
        modelo4.addColumn("Mantenimiento");

        if (temp1 != null) {
            System.out.println("IMPRIMIENDO COLA 1");
            Object[] info = new Object[1];

            do {

                String p1 = "ID: " + temp1.id + "Contador: " + String.valueOf(temp1.contador);
                System.out.println("!!!!!!!!!!!!!" + p1);
                info[0] = p1;
                modelo1.addRow(info);
                temp1 = temp1.siguiente;
            } while (temp1 != null);
            this.interfaz.tablaP1.setModel(modelo1);

        } else {
            Object[] info = new Object[1];
            info[0] = "Vacio";
            modelo1.addRow(info);
        }
        if (temp2 != null) {
            System.out.println("IMPRIMIENDO COLA 2");
            do {

                String p2 = "ID: " + temp2.id + "Contador: " + String.valueOf(temp2.contador);
                System.out.println("!!!!!!!!!!!!!" + p2);
                Object[] info = new Object[1];
                info[0] = p2;
                modelo2.addRow(info);
                temp2 = temp2.siguiente;
            } while (temp2 != null);
            this.interfaz.tablaP2.setModel(modelo2);

        } else {
            Object[] info = new Object[1];
            info[0] = "Vacio";
            modelo2.addRow(info);
        }

        if (temp3 != null) {
            System.out.println("IMPRIMIENDO COLA 3");
            do {
                String p3 = "ID: " + temp3.id + "Contador: " + String.valueOf(temp3.contador);
                System.out.println("!!!!!!!!!!!!!" + p3);
                Object[] info = new Object[1];
                info[0] = p3;
                modelo3.addRow(info);
                temp3 = temp3.siguiente;
            } while (temp3 != null);
            this.interfaz.tablaP3.setModel(modelo3);
        } else {
            Object[] info = new Object[1];
            info[0] = "";
            modelo3.addRow(info);
        }

        if (temp4 != null) {
            System.out.println("IMPRIMIENDO COLA 4");
            do {

                String p4 = "ID: " + temp4.id + "Contador: " + String.valueOf(temp4.contador);
                System.out.println("!!!!!!!!!!!!!" + p4);
                Object[] info = new Object[1];
                info[0] = p4;
                modelo4.addRow(info);
                temp4 = temp4.siguiente;
            } while (temp4 != null);
            this.interfaz.tablaMantenimiento.setModel(modelo4);
        } else {
            Object[] info = new Object[1];
            info[0] = "";
            modelo4.addRow(info);
        }

    }

    public void programa() {
        // TODO code application logic here

        Robot robot = new Robot();
        Mantenimiento mantenimiento = new Mantenimiento();
        Timer temporizador = new Timer();

        TimerTask tareaRobot = new TimerTask() {
            @Override
            public void run() {

                if (!cola1.esVacio()) {
                    System.out.println("COLA 1");
                    robot.revisarConsola(cola1, cola4);

                } else if (!cola2.esVacio()) {
                    System.out.println("COLA 2");
                    robot.revisarConsola(cola2, cola4);

                } else if (!cola3.esVacio()) {
                    System.out.println("COLA 3");
                    robot.revisarConsola(cola3, cola4);

                }

                cola1.actualizarContador();
                cola2.actualizarContador();
                cola3.actualizarContador();
                aumentarNivel(cola1, cola2, cola3);
                mantenimiento.listoParaRevision(cola4);
                actualizarEtiquetas();
            }
        };

        TimerTask tareaAdministrador = new TimerTask() {
            @Override
            public void run() {
                crearConsola();
            }
        };

        temporizador.schedule(tareaRobot, 0, 3000);
        temporizador.schedule(tareaAdministrador, 0, 4000);

    }

    public void crearConsola() {

        aleatorio = (int) (Math.random() * 10 + 1);

        if (aleatorio < 8) {
            aleatorio = (int) (Math.random() * 9 + 1);

            if (aleatorio < 4) {

                contadorId++;
                cola1.insertarPrimero(contadorId, 1);

            } else if (aleatorio > 3 && aleatorio < 7) {

                contadorId++;
                cola2.insertarPrimero(contadorId, 2);

            } else {

                contadorId++;
                cola3.insertarPrimero(contadorId, 3);

            }
            System.out.println("Creando nueva consola id: " + contadorId);
            actualizarEtiquetas();
        }

    }

    public void aumentarNivel(Nivel1 cola1, Nivel2 cola2, Nivel3 cola3) {

        if (!cola2.esVacio()) {

            Nodo temp = cola2.primero;

            do {

                if (temp.contador > 14) {
                    System.out.println("El contador es: " + temp.contador);
                    temp.contador = 0;
                    cola2.subirNivel1(cola1, temp);
                    actualizarEtiquetas();

                }

                temp = (temp.siguiente != null) ? temp.siguiente : temp;
            } while (temp.siguiente != null);

        }

        if (!cola3.esVacio()) {

            Nodo temp = cola3.primero;

            do {

                if (temp.contador > 14) {
                    System.out.println("El contador es: " + temp.contador);
                    temp.contador = 0;
                    cola3.subirNivel2(cola2, temp);
                    actualizarEtiquetas();

                }

                temp = (temp.siguiente != null) ? temp.siguiente : temp;
            } while (temp.siguiente != null);

        }

    }

    public Interfaz getInterfaz() {
        return interfaz;
    }

    public void setInterfaz(Interfaz interfaz) {
        this.interfaz = interfaz;
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
