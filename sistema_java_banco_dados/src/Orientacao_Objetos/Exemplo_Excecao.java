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
public class Exemplo_Excecao {
    public static void main(String[] args) {
        int x=0;
        try {
            int y = 100/x;
            System.out.println("Resultado: " + y);
        } catch(ArithmeticException e){
            System.out.println("Operação Inválida!");
            System.out.println("\nDetalhes do erro: " + e.getMessage());
        } finally {
            System.out.println("Finalizando!!");
        }
    }
    
}
