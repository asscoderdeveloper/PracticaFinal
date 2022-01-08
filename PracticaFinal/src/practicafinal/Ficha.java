/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicafinal;

/**
 *
 * @author tonif
 */
public class Ficha {
    //DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE
    //variable de objeto que representa el carácter alfabético de la ficha
    private char caracter;
    //variable de objeto que representa la cantidad total de esa ficha
    private int cantidad;
    //variable de objeto que representa el valor de puntuación de la ficha
    private int valor;
    
    //MÉTODO CONSTRUCTOR
    public Ficha(char car, int can, int val)
    {
        caracter = car;
        cantidad = can;
        valor = val;
    }
    
    //MÉTODO ENCARGADO DE DEVOLVER EL CARÁCTER
    public char getCaracter()
    {
        return caracter;
    }
    
    //MÉTODO ENCARGADO DE DEVOLVER LA CANTIDAD DE LA FICHA
    public int getCantidad()
    {
        return cantidad;
    }
    
    //MÉTODO ENCARGADO DE DEVOLVER EL VALOR
    public int getValor()
    {
        return valor;
    }
    
    //MÉTODO ENCARGADO DE DEVOLVER UNA COPIA DEL OBJETO FICHA
    public Ficha copiar()
    {
        Ficha ficha = new Ficha(caracter, valor, valor);
        return ficha;
    }
    
}
