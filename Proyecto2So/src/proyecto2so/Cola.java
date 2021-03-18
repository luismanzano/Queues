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
public class Cola {
    
     Nodo primero = null ;
    public int dimension = 0;
    
    public boolean esVacio(){
        return primero == null;
    }
    
    public void insertarPrimero(int id){
        
        Nodo nuevo = new Nodo(id);
        
        if(esVacio()){
            
            primero = nuevo;
            
        }else{
            
            nuevo.siguiente = primero;
            primero = nuevo;
            
        }
        
        dimension ++;
    }
    
    public void insertarUltimo(int id){
        
        Nodo nuevo = new Nodo(id);
        
        if(esVacio()){
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
    
    public void encolar(Nodo nodo){
        
         Nodo temp = primero;
           
           while(temp.siguiente != null){
               temp = temp.siguiente;
           }
           
           temp.siguiente = nodo;
        
        
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
    
    public void imprimirCola(){
        
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
    
    public void encolarMantenimiento(Cola cola, Nodo nodo){
        
        cola.encolar(nodo);
        
    }
    
}
