public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String endereco;

    //garante que o usuário insira esses valores fazendo com que a classe seja inicializada corretamente
    public Cliente(int id, String nome, String cpf, String endereco) {
        //atributo da classe / ao parâmetro
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}