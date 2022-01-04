package practicafinal;

public class Palabra {

    //DECLARACION DE LOS ATRIBUTOS DE CLASE PARA LOS OBJETOS PALABRA
    private static final int MAXIMO_NUMERO_CARACTERES = 20;
    private static final char FINAL_SECUENCIA = '.';
    private static final char ESPACIO = ' ';
    private static char caracter=ESPACIO;
    private char[] caracteres = new char[MAXIMO_NUMERO_CARACTERES];
    private int numeroCaracteres = 0;
    
    //METODO CONSTRUCTOR
    public Palabra(){
        numeroCaracteres=0;
    }
    
    //METODO BUSCAR PALABRA(lo llamamos de hayPalabras)
    private static void  buscarPalabra(){
        while(caracter==ESPACIO){
            caracter = LT.readChar();
        }
    }
    
    //METODO BOOLEAN HAYPALABRAS
    public static boolean hayPalabras(){
        //BUSCAR PALABRA
        buscarPalabra();
        return (caracter!=FINAL_SECUENCIA);
    }
    
    //METODO LECTURA
    //NOTA: ESTE METODO SOLO SERA LLAMADO CUANDO EL METODO HAY PALABRA A VERIFICADO QUE 
    //HAY ALMENOS 1 PALABRA EN LA SECUENCIA
    public void lectura(){
        //inicializacion del atributo numeroCaracteres 
        numeroCaracteres=0;
        while((caracter!=FINAL_SECUENCIA) && (caracter!=ESPACIO)){
            caracteres[numeroCaracteres]= caracter;
            numeroCaracteres++;
            caracter= LT.readChar();
        }
    }
    
    //METODO TOSTRING
    @Override
    public String toString(){
        String resultado= "";
        for (int indice = 0; indice < numeroCaracteres; indice++) {
            resultado= resultado+caracteres[indice];
        }
        return resultado;
    }
    
    //METODO BOOLEAN QUE VERIFICA SI UNA PALABRA TIENE LOS CARACTERES PAR
    public boolean numeroParDeCaracteres(){
        return numeroCaracteres%2==0;
    }
    
    //METODO TIENE VOCALES
    public boolean tieneVocales(){
        for (int indice = 0; indice < numeroCaracteres; indice++) {
            if (esVocal(caracteres[indice])) {
                return true;
            }
        }
        return false;
        
    }
    
    //METODO ES VOCAL
    private boolean esVocal(char c){
        return c=='a' || c =='e' || c=='i' || c=='o' || c=='u';
    }
    
    //METODO QUE OBTIENE EL ULTIMO CARACTER DE UNA PALABRA
    public char getUltimoCaracter(){
        return caracteres[numeroCaracteres-1];
    }
    
    //METODO COPIAR
    public static void copiar(Palabra pal1, Palabra pal2){
        pal2.numeroCaracteres=pal1.numeroCaracteres;
        for (int indice = 0; indice < pal1.numeroCaracteres; indice++) {
            pal2.caracteres[indice]=pal1.caracteres[indice];
        }
    }
    
    //METODO QUE CUENTA SI TIENE UN NUMERO PAR DE VOCALES
    public boolean numeroParVocales(){
        //variable que guarda el numero de vocales
        int contador = 0;
        for (int indice = 0; indice < numeroCaracteres; indice++){
            if(esVocal(caracteres[indice])){
                contador ++;
            }
        }
        return contador%2==0;
    }
    
    //METODO QUE CUENTA SI TIENE UN NUMERO PAR DE CONSONANTES
    public boolean numeroParConsonantes(){
        //variable que guarda el numero de vocales
        int contadorVocales = 0;
        for (int indice = 0; indice < numeroCaracteres; indice++){
            if(esVocal(caracteres[indice])){
                contadorVocales ++;
            }
        }
        return (numeroCaracteres-contadorVocales)%2== 0;
    }
    //METODO QUE CUENTA LAS VOCALES DE UNA PALABRA
    public int numeroVocales(){
        //variable que guarda el numero de vocales
        int contadorVocales = 0;
        for (int indice = 0; indice < numeroCaracteres; indice++){
            if(esVocal(caracteres[indice])){
                contadorVocales ++;
            }
        }
        return contadorVocales;
    }
    //METODO QUE CUENTA LAS CONSONANTES DE UNA PALABRA
    public int numeroConsonates(){
        //variable que guarda el numero de vocales
        int contadorVocales = 0;
        for (int indice = 0; indice < numeroCaracteres; indice++){
            if(esVocal(caracteres[indice])){
                contadorVocales ++;
            }
        }
        return (numeroCaracteres-contadorVocales);
    }
    
    //METODO ENCARGADO DE BUSCAR LAS PALABRAS QUE TENGAN LA VOCAL A
    public boolean vocalA(){
        //variables
        boolean x = false;
        for(int indice = 0; indice < numeroCaracteres; indice++){
            if(esVocal(caracteres[indice])&&(caracteres[indice]=='a')){
                x = true;
            }
        }
        return x;
    }
    //METODO ENCARGADO DE BUSCAR LAS PALABRAS QUE TENGAN LA VOCAL E Y O
    public boolean vocalesEO(){
        //variables
        boolean x = false, y = false;
        for(int indice = 0; indice<numeroCaracteres; indice++){
            if(esVocal(caracteres[indice])&&(caracteres[indice]=='e')){
                x = true;
            }
            if(esVocal(caracteres[indice])&&(caracteres[indice])=='o'){
                y = true;
            }
        }
        return (x)&&(y);
    }
    //METODO ENCARGADO DE CONTAR EL PESO DE CADA PALABRA
    public int peso(){
        //variables 
        int peso = 0;
        for(int indice = 0; indice<numeroCaracteres; indice++){
            peso += caracteres[indice];
        }
        return peso;
    }
    //METODO ENCARGADO DE BUSCAR PALINDROMOS
    public boolean palindromo(){
        //variables
        boolean x = false;
        int help = numeroCaracteres-1;
        int contador = 0;
        //algoritmo
        for(int indice = 0; indice<numeroCaracteres; indice++){
            if((caracteres[indice])==(caracteres[help])){
                contador++;
            }
            help--;
        }
        return (contador)==(numeroCaracteres);
    }
    //METODO ENCARGADO DE VER SI TODAS LOS CARACTERES DE UNA PALABRA SON VOCALES
    public boolean todoVocales(){
        //variables
        int contador = 0;
        //algoritmo
        for(int indice = 0; indice<numeroCaracteres; indice++){
            if(esVocal(caracteres[indice])){
                contador++;
            }
        }
        return contador == numeroCaracteres;
    }
    //METODO QUE GUARDA LOS CARACTERES DE UNA PALABRA
    public int getNumeroCaracteres(){
        return numeroCaracteres;
    }
    
    //METODO ENCARGADO DE DAR EL PRIMER CARACTER DE UNA PALABRA
    public char getPrimerCaracter(){
        return caracteres[0];
    }
    //METODO ENCARGADO DE GUARDAR LAS VOCALES QUE TIENE UNA PALABRA
    public int [] getVocales(){
        //variable encargada de guardar las vocales
        int [] vocales = new int [5];
        for(int indice = 0; indice<numeroCaracteres; indice++){
            if(esVocal(caracteres[indice])){
                switch(caracteres[indice]){
                    case 'a':
                        vocales[0]++;
                        break;
                    case 'e':
                        vocales[1]++;                        
                        break;
                    case 'i':
                        vocales[2]++;
                        break;
                    case 'o':
                        vocales[3]++;
                        break;
                    case 'u':
                        vocales[4]++;
                        break;
                }
            }
        }
        return vocales;
    }  
    //METODO ENCARGADO DE INVERTIR PALABRAS
    public char [] inversor(){
        //variables
        char [] palabraInvertida = new char [numeroCaracteres];
        for(int indice = 0; indice<numeroCaracteres; indice++){
            palabraInvertida[indice] = caracteres[(numeroCaracteres-1)-indice];
        }
        return palabraInvertida;
    }
    //METODO ENCARGADO DE TRANSFORMAR LOS CARACTERES A MAYUSCULA
    public char [] getMayusc(){
        char [] palabraGrande = new char [numeroCaracteres];
        int ayuda = 0; 
        for(int indice = 0; indice<numeroCaracteres; indice++){
            ayuda = caracteres[indice]-32;
            palabraGrande[indice] = (char)ayuda;
        }
        return palabraGrande;
    }
    //METODO ENCARGADO DE DEVOLVER EL CARACTER INICIAL Y FINAL EN MAYUSCULAS 
    public char[] inicialFinal(){
        char palabraTransformada [] = new char [numeroCaracteres];
        int ayuda = 0;
        for(int indice = 0; indice<numeroCaracteres; indice++){
            if(indice == 0 || indice == numeroCaracteres-1){
                ayuda = caracteres[indice]-32;
                palabraTransformada[indice] = (char)ayuda;
            }
            else{
                palabraTransformada[indice] = caracteres[indice];
            }
        }
        return palabraTransformada;
    } 
        //MÉTODO adicionCaracter LLEVA A CABO LA ADICIÓN DE UN CARACTER DADO POR PARÁMETRO
    //EN UN OBJETO Palabra
    public void adicionCaracter(char caracter) {
        //almacenar el caracter dado en la primera componente libre del atributo
        //caracteres del objeto Palabra. El índice de dicha componente coincide
        //con el valor del atributo numeroCaracteres del mismo objeto Palabra
        caracteres[numeroCaracteres]=caracter;
        //incrementar el atributo numeroCaracteres del objeto Palabra para que
        //tenga en cuenta el caracter que acabamos de añadir en la palabra
        numeroCaracteres++;
    }
    
    //MÉTODO obtenerCaracter LLEVA A CABO LA OBTENCIÓN DEL CARACTER DE UNA
    //PALABRA QUE ESTÁ ALMACENADO EN LA POSICIÓN DADA DENTRO DEL ATRIBUTO
    //caracteres DE DICHO OBJETO Palabra
    public char obtenerCaracter(int posicion) {
        //devolver el caracter del objeto Palabra que está en la posición
        //dada dentro del atributo array caracteres
        return (caracteres[posicion]);
    }
    //METODO QUE DEVUELVE UN ARRAY CON TODOS LOS COMPONENTES DE UNA PALABRA
    public char[] arrayCaracteres(){
        char arrayCaracteres []  = new char [numeroCaracteres];
        for(int indice = 0; indice<numeroCaracteres;indice++){
            arrayCaracteres[indice] = caracteres[indice];
        }
        return arrayCaracteres;
    }
    
}
