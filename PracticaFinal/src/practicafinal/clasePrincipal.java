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
    private static final int NUMEROFICHAS = 11;
    private static final int CANTIDADLETRAS = 26;
    private static char abecedarioCastellano[];
    private static int numeroApariciones [];
    private int numeroAparicionesControlar[];
    private static int puntuacionLetras [];
    private FileReader fichero1;
    private int letraLeida;
    private Random numeroAleatorio;
    //
    FichasScrabble fichas = new FichasScrabble();

    
   //METODO CONSTRUCTOR
    public clasePrincipal(){
        
    }
   //METODO ENCARGADO DE VISUALIZAR UN MENU
   public int menu(){
       int dato;
       
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
      public int menu2(){
       int dato;
       
       System.out.println("\t \tMENU");
       System.out.println("1 --> Jugar una partida solo"
               + "\n"
               + "2 --> Jugar contra el cerebro superior"
               + "\n");
       dato = LT.readInt();
       return dato;
   }

   //METODO ENCARGADO DE SOLICITAR EL NOMBRE DEL JUGADOR
      public void nombre(){
          System.out.println("Introduce tu nombre: ");
          nombreJugador = LT.readLine();
      }
      
    //METODO ENCARAGADO DE SOLICITAR EL NUMERO DE TURNOS QUE DESEA JUGAR
        public int numTurnos(){
          System.out.println("Introduce el numero de turnos que deseas jugar: ");
          turnos = LT.readInt();
          return turnos;
      }      
        
    //METODO ENCARGADO DE LA GENERACION DE LOS ARRAYS DICCIONARIO, PUNTUACIONES Y NUMERO DE APARICIONES
      public void generacionArrays()throws Exception{
          fichas.lector();
      }
      
    //METODO ENCARGADO SORTEAR LAS LETRAS QUE LE TOCAN AL JUGADOR
      public void sorteador(){
          fichas.sorteadorFichas();
      }       
    //
      public void visualizarCaracteres(){
          fichas.visualizadorCaracteres(abecedarioCastellano);
      }
    //
      public void visualizarNumeros(){
          fichas.visualizadorNumeros(puntuacionLetras);
      }
      
}
