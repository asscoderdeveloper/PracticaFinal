//
package practicafinal;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class clasePrincipal {
    
    //DECLARACION DE LOS ATRIBUTOS DE LA CLASE
    private int turnos;
    private String nombreJugador;
    private int puntuacion;
    private final int NUMEROFICHAS = 11;
    private final int CANTIDADLETRAS = 26;
    private char abecedarioCastellano[];
    private int numeroApariciones [];
    private int numeroAparicionesControlar[];
    private int puntuacionLetras [];
    private FileReader fichero1;
    private int letraLeida;
    private Random numeroAleatorio;
    
   //METODO CONSTRUCTOR
   //METODO ENCARGADO DE VISUALIZAR UN MENU
   public int menu(int dato){
       System.out.println("\t \tMENU");
       System.out.println("1 --> Jugar una partida"
               + "\n"
               + "2 --> Visualizar el historial de partidas"
               + "\n"
               + "3 --> Salir"
               + "\n");
       dato = LT.readInt();
       return dato;
   }
   //METODO ENCARGADO DE VISUALIZAR EL SEGUNDO MENU
      public int menu2(int dato){
       System.out.println("\t \tMENU");
       System.out.println("1 --> Jugar una partida solo"
               + "\n"
               + "2 --> Jugar contra el cerebro superior"
               + "\n");
       dato = LT.readInt();
       return dato;
   }
   //METODO ENCARAGADO DE SOLICITAR EL NUMERO DE TURNOS QUE DESEA JUGAR
      public int numTurnos(){
          System.out.println("Introduce el numero de turnos que deseas jugar: ");
          turnos = LT.readInt();
          return turnos;
      }
   //METODO ENCARGADO DE SOLICITAR EL NOMBRE DEL JUGADOR
      public void nombre(){
          System.out.println("Introduce tu nombre: ");
          nombreJugador = LT.readLine();
      }
   //METODO ENCARGADO LEER EL FICHERO Y OBTENER LAS LETRAS, SUS APARICIONES Y PUNTUACIONES
      public void lector()throws Exception{
        fichero1 = new FileReader("ficheroFichas");
        letraLeida = fichero1.read();
        while(letraLeida != (int)'\n'){
            letraLeida = fichero1.read();
        }
        letraLeida = fichero1.read();                
        for(int indice = 0; indice<CANTIDADLETRAS;indice++){
            abecedarioCastellano[indice] = (char) letraLeida;
            letraLeida = fichero1.read();   
            letraLeida = fichero1.read();
            
            numeroApariciones[indice] = letraLeida; 
            letraLeida = fichero1.read();
            letraLeida = fichero1.read();
            
            puntuacionLetras[indice] = letraLeida;
            letraLeida = fichero1.read();
            letraLeida = fichero1.read();
        }
      }
    //METODO ENCARGADO SORTEAR LAS LETRAS QUE LE TOCAN AL JUGADOR
      public char [] sorteadorLetras(){
          
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
      
    
}
