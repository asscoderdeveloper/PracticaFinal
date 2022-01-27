package practicafinal;

import java.io.BufferedReader;
import java.io.FileReader;

public class FicheroFichasLectura {
        
    private BufferedReader fichero;
    
    //variable de clase que indica la última letra leída a la hora de leer el
    //fichero de fichas
    private int codigoLeido = ' ';
    //variable de clase que indica el código de final de fichero
    private static final int FINAL_SECUENCIA = -1;
    
    public FicheroFichasLectura(String rutaFichero) throws Exception
    {
        fichero = new BufferedReader(new FileReader(rutaFichero));
    }
    
    public boolean EncontrarLetra() throws Exception
    {
        while (!EsLetra((char)codigoLeido))
        {            
            codigoLeido = fichero.read();
        }
        
        return codigoLeido != FINAL_SECUENCIA;
    }
    
    public boolean EncontrarNumero() throws Exception
    {
        while (!EsNumero((char)codigoLeido))
        {            
            codigoLeido = fichero.read();
        }
        
        return codigoLeido != FINAL_SECUENCIA;
    }
    
    public boolean EsLetra(char caracter)
    {   
        return (int)caracter >= (int)'a' && (int)caracter <= (int)'z';
    }
    
    public boolean EsNumero(char caracter)
    {
        return (int)caracter >= (int)'0' && (int)caracter <= (int)'9';
    }
    
    public char LeerLetra()
    {
        return (char)codigoLeido;
    }
    
    public int LeerNumeros() throws Exception
    {
        int[] digitos = new int[9];
        int medida = 0;
        
        while (EsNumero((char)codigoLeido))
        {            
            digitos[medida] = codigoLeido - '0';
            medida++;
            codigoLeido = fichero.read();
        }
        
        return juntarDigitos(digitos, medida);
    }
    
    private int juntarDigitos(int[] digitos, int size){
        
        int resultado = 0;
        for (int i = size-1,iteraciones = 1; i >= 0; i--,iteraciones *= 10)
        {
            resultado += digitos[i] * iteraciones;
        }
        
        return resultado;
    }
    
    public void CerrarEnlace() throws Exception
    {
        fichero.close();
    }
}