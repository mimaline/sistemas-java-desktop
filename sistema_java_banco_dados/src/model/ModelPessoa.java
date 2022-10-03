package model;

public class ModelPessoa {

    private int codigo;
    private String nome;
    private String endereco;
    private String cpf;

    // Inicia vazio para quando nao necessitar passar parametros
    public ModelPessoa (){

    }

    public ModelPessoa(int codigo, String nome, String endereco, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo > 0) {
            this.codigo = codigo;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 0) {
            this.nome = nome;
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco.length() > 0) {
            this.endereco = endereco;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.length() > 0) {
            this.cpf = cpf;
        }
    }
}
