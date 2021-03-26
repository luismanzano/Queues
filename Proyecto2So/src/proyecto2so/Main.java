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
public class Main {
    
    public static void main(String[] args) {
        
        Main m = new Main();
        m.app();
        
    }
    
    public void app(){
        Interfaz interfaz = new Interfaz();
        Administrador administrador = new Administrador(interfaz);
        administrador.setInterfaz(interfaz);
        administrador.getInterfaz().setVisible(true);
        administrador.programa();
    }
}
