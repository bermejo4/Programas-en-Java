/**
 *
 * @author Jaime Bermejo
 */
 
//Cada tres bases de una cadena de ADN codifican un aminoácido de una proteína.
//Existe una secuencia especial de bases de la cadena, ATG, que es una especie
//de “marca” del principio de un gen, esto es, una secuencia de bases que
//codifica una determinada proteína. También existen tres secuencias diferentes
//de fin de gen. Podemos a partir de una cadena de ADN contar cuántos genes
//tiene contando el número de veces que ocurre la tripleta ATG.

 //Este programa genera una cadena aleatoria de ADN de una longitud introducida
 //por el usuario. Posteriormente busca entre esa cadena de ADN generada
 // aleatoriamente la cantidad de genes que se encuentran en ella.

import java.io.*;

public class BuscadorDeGenes {
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
