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
           nodo.siguiente = null;
        
    }
    
    public Nodo ObtenerValorDe(int n){ 
        if(primero==null){
            return null;
        }else{
            Nodo temp = primero;
            int cont = 0;
            while(cont<n && temp.siguiente!=null){
                temp = temp.siguiente;
                cont++;
            }
            if(cont != n){
                return null;
                
            }else return temp;
            
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
    
//    public void eliminarNodo(int id){ //////////////////// FALTA COMPLETAR /////////////////////
//        
//        if(primero==null){
//            
//        }else{
//            Nodo temp = primero;
//            int cont = 0;
//            while(cont<id && temp.siguiente!=null){
//                temp = temp.siguiente;
//                cont++;
//            }
//            if(cont != id){
//             
//                
//            }
//        }   
//    } ///////////////////////////////// FALTA COMPLETAR //////////////////////////
    
    public void encolarMantenimiento(Cola cola, Nodo nodo){ ////////////////////////// FALTA COMPLETAR /////////////////////
        
        cola.encolar(nodo);
        cola.eliminarPrimero();
        
    } /////////////////////// FALTA COMPLETAR /////////////////////////////
    
    public void actualizarContador(){
        
        if(!esVacio()){
            Nodo temp = primero;
            
            do {                
                
                temp.contador +=1;
                temp = temp.siguiente;
                
            } while (temp.siguiente != null);
        }
    }
    
}
