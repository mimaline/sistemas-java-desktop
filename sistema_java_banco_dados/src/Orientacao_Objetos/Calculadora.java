/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orientacao_Objetos;

/**
 *
 * @author yasmim.roeder
 */
public class Calculadora {
    public int soma (int a, int b) {
        return a + b;
    }
    public int soma(int a, int b, int c) {
        int resultado = this.soma(a,b) + c;
        return resultado;
    }
    public float soma (float a, float b) {
        return a + b;
    }
    public long soma (int[] numeros) {
        long resultado = 0;
        for (int i = 0; i < numeros.length; i++) {
            resultado += numeros[i];
            // += soma os numeros ao resultado
        }
        return resultado;
    }    
}
