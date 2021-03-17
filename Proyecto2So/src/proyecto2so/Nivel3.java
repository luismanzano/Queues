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
public class Nivel3 {
    
    Nodo primero = null ;
    public int dimension = 0;
    
    public boolean esVacioNivel(){
        return primero == null;
    }
    
    public void insertarPrimeroNivel(int id){
        
        Nodo nuevo = new Nodo(id);
        
        if(esVacioNivel()){
            
            primero = nuevo;
            
        }else{
            
            nuevo.siguiente = primero;
            primero = nuevo;
            
        }
        
        dimension ++;
    }
    
    public void insertarUltimoNivel(int id){
        
        Nodo nuevo = new Nodo(id);
        
        if(esVacioNivel()){
            primero = nuevo;
        }else{
           
           Nodo temp = primero;
           
           while(temp.siguiente != null){
               temp = temp.siguiente;
           }
           
           temp.siguiente = nuevo;
        }
        
        dimension ++;
    }
    
    public int ObtenerValorDe(int n){ // Modificar ////////////////////////
        if(primero==null){
            return -1;
        }else{
            Nodo temp = primero;
            int cont = 0;
            while(cont<n && temp.siguiente!=null){
                temp = temp.siguiente;
                cont++;
            }
            if(cont != n){
                return -1;
                
            }else return temp.id ;
            
        }
    }
    
    public void imprimirNivel(){
        
        for (int i = 0; i < dimension; i++) {
            System.out.println(this.ObtenerValorDe(i));
        }
    }
    
    public void eliminarPrimero(){
        
        if(primero != null){
            
        Nodo prim = primero;
        primero = primero.siguiente;
        prim.siguiente = null;
        dimension--;
            
        }
        
    }
    
}
