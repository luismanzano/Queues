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
        
        if (primero == null) {
            insertarPrimero(nodo.id);
        
        }else if(primero.siguiente == null){
        
            primero.siguiente = nodo;
            
        }else{
            
         Nodo temp = primero;
           
           while(temp.siguiente != null){
               temp = temp.siguiente;
           }
           
           temp.siguiente = nodo;
           nodo.siguiente = null;
           nodo.anterior = temp;
        }
        
        
    }
    
    public void desencolar(int id) {
        
        Nodo temp = primero;
        
        while(temp.siguiente != null){
            if (temp.id == id) {
                break;
            }else{
               temp = temp.siguiente;
            }
            
            temp.anterior.siguiente = temp.siguiente;
            temp.siguiente.anterior = temp.anterior;
            
            temp.siguiente = null;
            temp.anterior = null;
            
           }
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
//        primero.anterior = null;
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
        //cola.eliminarPrimero();
        
    } /////////////////////// FALTA COMPLETAR /////////////////////////////
    
    public void actualizarContador(){
        
        if(!esVacio()){
            Nodo temp = primero;
            
            while (temp.siguiente != null){                
                
                temp.contador +=1;
                temp = temp.siguiente;
                
            }
            
            if(primero.siguiente == null){
             
                temp.contador += 15;
            }
            
            //CODIGO DE LEO 
//            do {                
//                
//                temp.contador +=1;
//                temp = temp.siguiente;
//                
//            } while (temp.siguiente != null);
//        }
    }
    
}
}