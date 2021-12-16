/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import biblioteca.VentanaPrincipal;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author José
 */
public class TablaHash {

    static String [] arreglo;
    static int tamanio, contador;

    public TablaHash(int tam){
        tamanio = tam;
        arreglo = new String[tam];
        Arrays.fill(arreglo, "-1");
    }
    public static void rec(){
        for(int j=0; j<arreglo.length; j++){
                String a = arreglo[j];                  //Se muestran los datos
                if(a != "-1"){
                    VentanaPrincipal.ta.append(a+"\n");
                }
            }
    }
    
    public static void funcionHash(String elem){
            String cla = elem.substring(0, 5);//Se extrae la clave
            String ele = elem.substring(6, elem.length()- 5);//Se extrae el resto de la cadena
            
            //Se calcula la posición donde se 
            //ingresará el elemento y se guarda en indiceArreglo
            int indiceArreglo = Integer.parseInt(cla)%(tamanio-1);
            
            System.out.println("El índice es "+indiceArreglo+" para el elemento "+ ele);
            
            /*
            Se verifica que la casilla esté vacía, si no tiene
            un -1 significa que está ocupada
            */
            int i=0;
            while(arreglo[indiceArreglo]!="-1" && i<arreglo.length){
                indiceArreglo++;//Se aumenta en uno el índice para avanzar a la siguiente  posición 
                System.out.println("Ocurrió una colisión en el índice "+(indiceArreglo-1)+" cambiar al índice "+indiceArreglo);
                indiceArreglo %= tamanio;
                i++;
            }
            arreglo[indiceArreglo] = elem;//Se guarda la información en la posición que se calculó con la función
            rec();
    }
    
    public static void elim(String elem){
            String cla = elem;
            
            //Se calcula la posición donde se 
            //ingresará el elemento y se guarda en indiceArreglo
            int indiceArreglo = Integer.parseInt(cla)%(tamanio-1);
            
            int clav = Integer.parseInt(cla);
            int i=0;
            String cll = arreglo[indiceArreglo].substring(0, 5);
            while(arreglo[indiceArreglo]!="-1" && i<arreglo.length){
                if(cll.equals(cla)){
                    arreglo[indiceArreglo] = "-1";
                    System.out.println("Se eliminó "+clav);
                    JOptionPane.showMessageDialog(null,"Se eliminó "+clav);
                }else{
                    indiceArreglo++;
                    if(cll.equals(cla)){
                        arreglo[indiceArreglo] = "-1";
                        System.out.println("Ocurrió una colisión en el índice "+(indiceArreglo-1)+" se eliminó "+indiceArreglo);
                    }
                }
                indiceArreglo %= tamanio;
                i++;
            }
            
            rec();
    }
    
}
