
package practicafinal;

import java.util.Random;

public class FichasScrabble {
    
    //DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE
    //variable de clase que indica la cantidad de fichas que son repartidas
    private static final int FICHAS_REPARTIR = 11;
    //variable de clase que indica la cantidad de letras del abecedario
    private static final int CANTIDAD_FICHAS = 26;
    //variable de clase que representa las fichas base y sus características
    //al ser leidas
    private static Ficha[] fichas = new Ficha[CANTIDAD_FICHAS];

    private static FicheroFichasLectura fichero1;
    
    //variable de clase usado para generar un número aleatorio al repartir las
    //fichas
    private static Random numeroAleatorio;
    
    //DECLARACIÓN DE LOS ATRIBUTOS DE OBJETO
    //variable de objeto que guarda la cantidad de fichas que se pueden repartir
    //con el mismo orden posicional que los carácteres dados al ser repartidas
    private int numeroAparicionesControlar[] = new int[CANTIDAD_FICHAS];
    
    //metodo constructor
    public  FichasScrabble(){
    }
    
    //MÉTODO ENCARGADO DE LEER EL FICHERO Y OBTENER LAS LETRAS, SUS APARICIONES Y PUNTUACIONES
    public static void lectorFichas() throws Exception{
        fichero1 = new FicheroFichasLectura("ficheroFichas.txt");
                
        for(int indice = 0; indice<CANTIDAD_FICHAS;indice++){            
            char caracter = ' ';
            int cantidad = 0, valor = 0;
            
            if (fichero1.EncontrarLetra())
            {
                caracter = fichero1.LeerLetra();
            }
            
            if (fichero1.EncontrarNumero())
            {
                cantidad = fichero1.LeerNumeros();
            }
            
            if (fichero1.EncontrarNumero())
            {
                valor = fichero1.LeerNumeros();
            }
            
            fichas[indice] = new Ficha(caracter, cantidad, valor);            
        }
        
        fichero1.CerrarEnlace();
    }
    
    //METODO ENCARGADO SORTEAR LAS 11 FICHAS ALEATORIAMENTE
    public Ficha[] sorteadorFichas(){
        //
        Ficha [] nuevasFichas = new Ficha[FICHAS_REPARTIR];
        numeroAleatorio = new Random();
        int indiceAbecedario = 0;
        
        for (int indice = 0; indice < nuevasFichas.length; indice++) {
            numeroAparicionesControlar[indice] = fichas[indice].getCantidad();
        }

        //
        for(int indice = 0; indice<FICHAS_REPARTIR; indice++){
            indiceAbecedario = numeroAleatorio.nextInt(CANTIDAD_FICHAS + 1);
            if(numeroAparicionesControlar[indiceAbecedario] > 0){
                numeroAparicionesControlar[indiceAbecedario]--;
                nuevasFichas[indice] = fichas[indiceAbecedario].copiar();
            }
            else{
                indice--;
            }
        }
        return nuevasFichas;
    }
    //
    public static void visualizadorCaracteres(){
        System.out.println("Carácteres de fichas:");
        
        for(int indice = 0; indice< CANTIDAD_FICHAS; indice++){
            System.out.print(fichas[indice].getCaracter()+",");
        }
        
        System.out.println("");
    }
    //
    public static void visualizadorNumeros(){
        System.out.println("Cantidad de cada ficha:");
        
        for(int indice = 0; indice< CANTIDAD_FICHAS; indice++){
            System.out.print(fichas[indice].getCantidad()+",");
        }
        
        System.out.println("");
    }
}