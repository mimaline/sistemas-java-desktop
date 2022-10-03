
package Orientacao_Objetos;

/**
 *
 * @author yasmim.roeder
 */
public class Principal {
    
    public static void main(String[] args) {
     
        Pessoa pessoa = new Pessoa();
        
        // set de dados
        pessoa.setCodigo(1);
        pessoa.setNome("Julieta");
        
//        System.out.println("Pessoa código: " + pessoa.getCodigo());
//        System.out.println("Pessoa nome: " + pessoa.getNome());
        
        imprimeDadosPessoa(pessoa);
        
        Calculadora calc = new Calculadora();
        System.out.println("1 + 9 = " + calc.soma(1, 9));
        System.out.println("1 + 9.0F = " + calc.soma(1, 9.0F));
        int num [] = {1, 3, 6};
        System.out.println("1 + 3 + 6 = " + calc.soma(num));
        System.out.println("1 + 3 + 4 = " + calc.soma(1, 3, 4));
        
    }
        
    static void imprimeDadosPessoa(Pessoa pessoa) {
        
        System.out.println("Pessoa código: " + pessoa.getCodigo());
        System.out.println("Pessoa nome: " + pessoa.getNome());
   
    }
    
}
