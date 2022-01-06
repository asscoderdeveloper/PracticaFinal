/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicafinal;

/**
 *
 * @author alexsanchez
 */
public class ProgramaPrueba {
    public static void main(String []args)throws Exception{
        clasePrincipal mimi = new clasePrincipal();
        int menu = 0;
        
        menu = mimi.menu();
        if(menu == 1){
            mimi.menu2();
        }
        mimi.nombre();
        mimi.numTurnos();
        mimi.generacionArrays();
        mimi.visualizarCaracteres();
        mimi.visualizarNumeros();
    }
}
