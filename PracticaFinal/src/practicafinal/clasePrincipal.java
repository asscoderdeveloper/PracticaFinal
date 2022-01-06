//
package practicafinal;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class clasePrincipal {
    
    //DECLARACION DE LOS ATRIBUTOS DE LA CLASE
    //variable de clase que indica cuantos turnos se deberán jugar al elegir la
    //opción de jugar
    private static int turnos;
    //variable de clase que indica cuál es el nombre que escogerá el jugador al
    //elegir la opción de jugar
    private static String nombreJugador;
    //variable de objeto que indica la puntuación que ha conseguido el jugador
    //tras una partida
    private static int puntuacion;
    //
    FichasScrabble fichas = new FichasScrabble();

    
    //METODO CONSTRUCTOR
    public clasePrincipal(){
        
    }
    
    //METODO ENCARGADO DE VISUALIZAR UN MENÚ PRINCIPAL
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
    
    //METODO ENCARGADO DE VISUALIZAR EL MENÚ AL ESCOGER JUGAR UNA PARTIDA
    public int menuJugar(){
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
        System.out.println("\n\n");
        return turnos;
    }      
        
    //METODO ENCARGADO DE LA GENERACION DE LOS ARRAYS ABECEDARIO, PUNTUACIONES Y NUMERO DE APARICIONES
    public void generacionArrays()throws Exception{
        FichasScrabble.lector();
    }
      
    //METODO ENCARGADO DE SORTEAR LAS LETRAS QUE LE TOCAN AL JUGADOR
    public void sorteador(){
        fichas.sorteadorFichas();
    }       
    //
    public void visualizarCaracteres(){
        FichasScrabble.visualizadorCaracteres();
    }
    //
    public void visualizarNumeros(){
        FichasScrabble.visualizadorNumeros();
    }
}
