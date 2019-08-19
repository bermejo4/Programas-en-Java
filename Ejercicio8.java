/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.Tema5;

/**
 *
 * @author Jaime Bermejo
 */
import java.io.*;

public class Ejercicio8 {
    public static void main(String[] args) {
        int contador=0, posicion =-1;
        System.out.println("Introduzca la longitud que desea en la cadena aleatoria generada:");
        try{
            BufferedReader consola=new BufferedReader(new InputStreamReader(System.in));
            int longitud=Integer.parseInt(consola.readLine());
            System.out.println("La Cadena Aleatoria producida es:");
            String cadena=producircadenaaleatoria(longitud);
            System.out.println(cadena);
            System.out.println("El numero de genes en la cadena es de: "+contador(cadena, contador, posicion));
        }catch(IOException ex){
            
        }
    }
    public static String producircadenaaleatoria(int longitud){
        String cadena="";
        int i=0;
        do{
            int opcion=(int)(Math.random()*10);
            switch(opcion%4){
                case 0: cadena=cadena+"A";break;
                case 1: cadena=cadena+"C";break;
                case 2: cadena=cadena+"G";break;
                case 3: cadena=cadena+"T";break;
            }
            i++;
        }while(i!=longitud);
        return cadena;
    }
    public static int contador(String cadena, int contador, int posicion){
        posicion++;
        String subcadena=cadena.substring(posicion,(posicion+3));
        if(subcadena.equals("ATG")&&posicion<(cadena.length()-3)){
            contador++;
            contador=contador(cadena,contador,posicion);
        }
        else if(subcadena.equals("ATG")==false&&posicion<(cadena.length()-3)){
            contador=contador(cadena,contador,posicion);
        }
        else{
            return contador;
        }
        return contador;
    }
}
