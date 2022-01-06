
package practicafinal;

import java.io.FileReader;
import java.util.Random;

public class FichasScrabble {
   
    private int turnos;
    private String nombreJugador;
    private int puntuacion;
    private static final int NUMEROFICHAS = 11;
    private static final int CANTIDADLETRAS = 26;
    private static char abecedarioCastellano[] = new char[CANTIDADLETRAS];
    private static int numeroApariciones [] = new int[CANTIDADLETRAS];
    private int numeroAparicionesControlar[] = new int[CANTIDADLETRAS];
    private static int puntuacionLetras [] = new int [CANTIDADLETRAS];
    private FileReader fichero1;
    private int letraLeida;
    private Random numeroAleatorio;
    private int indiceNums;
    
    //metodo constructor
    public  FichasScrabble(){

    }
    
    //METODO ENCARGADO LEER EL FICHERO Y OBTENER LAS LETRAS, SUS APARICIONES Y PUNTUACIONES
      public void lector()throws Exception{
        fichero1 = new FileReader("ficheroFichas.txt");
        letraLeida = fichero1.read();
        while(letraLeida != (int)'\n'){
            letraLeida = fichero1.read();
            System.out.println((char)letraLeida);
        }
        letraLeida = fichero1.read();  
          System.out.println((char)letraLeida);
        for(int indice = 0; indice<CANTIDADLETRAS;indice++){
            //
            int [] nums =new int [3456789];
            
            abecedarioCastellano[indice] = (char) letraLeida;
            letraLeida = fichero1.read();
            System.out.println((char)letraLeida);

            letraLeida = fichero1.read();            
            for(indiceNums = 0; letraLeida != (int)'\t';indiceNums++){
            nums[indiceNums] = letraLeida;
            letraLeida = fichero1.read();
        }
            
            numeroApariciones[indice] = juntarDigitos(nums, indiceNums); 
            letraLeida = fichero1.read();
            
            letraLeida = fichero1.read();
            for(indiceNums = 0; letraLeida != (int)'\t';indiceNums++){
            nums[indiceNums] = letraLeida;
            letraLeida = fichero1.read();
        }
            
            puntuacionLetras[indice] = juntarDigitos(nums, indiceNums);
            letraLeida = fichero1.read();
            letraLeida = fichero1.read();
        }
      }
    //METODO ENCARGADO SORTEAR LAS LETRAS QUE LE TOCAN AL JUGADOR
      public char [] sorteadorFichas(){
          //
          char [] fichas = new char [NUMEROFICHAS];
          numeroAleatorio = new Random();
          int indiceAbecedario = 0;
          numeroAparicionesControlar = numeroApariciones.clone();
          //
          for(int indice = 0; indice<NUMEROFICHAS; indice++){
              indiceAbecedario = numeroAleatorio.nextInt(CANTIDADLETRAS + 1);
              if(numeroAparicionesControlar[indiceAbecedario] > 0){
                  numeroAparicionesControlar[indiceAbecedario] =-1;
                  fichas[indice] = abecedarioCastellano[indiceAbecedario];
              }
              else{
                  indice--;
              }
          }
          return fichas;
      } 
    //  
    private int juntarDigitos(int[] digitos, int size){
        
        int resultado = 0;
        for (int i = size-1,iteraciones = 1; i >= 0; i--,iteraciones *= 10)
        {
            resultado += digitos[i] * iteraciones;
        }
        
        return resultado;
    }
    //
    public void visualizadorCaracteres(char dato[]){
        for(int indice = 0; indice< dato.length; indice++){
            System.out.print(dato[indice]+",");
        }
    }
    //
    public void visualizadorNumeros(int dato []){
        for(int indice = 0; indice< dato.length; indice++){
            System.out.print(dato[indice]+",");
        }
    }
}

