
package practicafinal;

import java.io.FileReader;
import java.util.Random;

public class FichasScrabble {
    
    //DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE
    //variable de clase que indica la cantidad de fichas que son repartidas
    private static final int NUMEROFICHAS = 11;
    //variable de clase que indica la cantidad de letras del abecedario
    private static final int CANTIDAD_FICHAS = 26;
    //
    private static Ficha[] fichas = new Ficha[CANTIDAD_FICHAS];
    //variable de clase que establece una conexión de lectura con el fichero
    //que contiene las fichas y sus propiedades
    private static FileReader fichero1;
    //variable de clase que indica la última letra leída a la hora de leer el
    //fichero de fichas
    private static int letraLeida = ' ';
    //
    private Random numeroAleatorio;
    //variable de clase que indica el carácter del tabulador
    private static final char TABULADOR = '\t';
    //variable de clase que indica el carácter del salto de línea
    private static final char SALTO_DE_LINEA = '\n';
    
    //DECLARACIÓN DE LOS ATRIBUTOS DE OBJETO
    //variable de objeto que guarda la cantidad de fichas que se pueden repartir
    //con el mismo orden posicional que los carácteres dados al ser repartidas
    private int numeroAparicionesControlar[] = new int[CANTIDAD_FICHAS];
    
    //metodo constructor
    public  FichasScrabble(){

    }
    
    //METODO ENCARGADO DE LEER EL FICHERO Y OBTENER LAS LETRAS, SUS APARICIONES Y PUNTUACIONES
    public static void lector() throws Exception{
        fichero1 = new FileReader("ficheroFichas.txt");
        
        while(letraLeida != (int)SALTO_DE_LINEA){
            letraLeida = fichero1.read();
        }
        
        for(int indice = 0; indice<CANTIDAD_FICHAS;indice++){            
            int [] digitos = new int [10];
            int indiceNums;
            char caracter;
            int cantidad, valor;
            
            letraLeida = fichero1.read();
            caracter = (char) letraLeida;
            
            buscarSiguiente();
            
            for(indiceNums = 0; letraLeida != (int)TABULADOR;indiceNums++){
                digitos[indiceNums] = letraLeida - '0';
                letraLeida = fichero1.read();
            }
            cantidad = juntarDigitos(digitos, indiceNums);
            
            buscarSiguiente();
            
            for(indiceNums = 0; letraLeida != (int)'\r' && letraLeida != (int)SALTO_DE_LINEA && letraLeida != -1;indiceNums++){
                digitos[indiceNums] = letraLeida - '0';
                letraLeida = fichero1.read();
            }
            valor = juntarDigitos(digitos, indiceNums);
            
            fichas[indice] = new Ficha(caracter, cantidad, valor);
            
            while(letraLeida != (int)SALTO_DE_LINEA && letraLeida != -1){
                letraLeida = fichero1.read();
            }
        }
        
        fichero1.close();
    }
    
    //METODO ENCARGADO SORTEAR LAS 11 FICHAS ALEATORIAMENTE
    public char [] sorteadorFichas(){
        //
        char [] fichas = new char [NUMEROFICHAS];
        numeroAleatorio = new Random();
        int indiceAbecedario = 0;
        numeroAparicionesControlar = numeroApariciones.clone();
        //
        for(int indice = 0; indice<NUMEROFICHAS; indice++){
            indiceAbecedario = numeroAleatorio.nextInt(CANTIDAD_FICHAS + 1);
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
    //MÉTODO QUE JUNTA UNA CANTIDAD DEFINIDA DE DÍGITOS DE UN ARRAY
    private static int juntarDigitos(int[] digitos, int size){
        
        int resultado = 0;
        for (int i = size-1,iteraciones = 1; i >= 0; i--,iteraciones *= 10)
        {
            resultado += digitos[i] * iteraciones;
        }
        
        return resultado;
    }
    //MÉTODO QUE REALIZA UNA LECTURA CONTINUADA DEL FICHERO DE FICHAS MIENTRAS
    //LEA EL CARÁCTER TABULADOR
    private static void buscarSiguiente() throws Exception
    {
        letraLeida = fichero1.read();
        while (letraLeida == TABULADOR)
        {            
            letraLeida = fichero1.read();
        }
    }
    //
    public static void visualizadorCaracteres(){
        for(int indice = 0; indice< abecedarioCastellano.length; indice++){
            System.out.print(abecedarioCastellano[indice]+",");
        }
    }
    //
    public static void visualizadorNumeros(){
        for(int indice = 0; indice< puntuacionLetras.length; indice++){
            System.out.print(puntuacionLetras[indice]+",");
        }
    }
}
