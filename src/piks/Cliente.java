package piks;

public class Cliente {
    private int cpf; private String nome; private Conta conta;

    public Cliente(int cpf, String nome) { this.cpf = cpf; this.nome = nome; }

    public void setConta(Conta cta) { this.conta = cta;}
    public Conta getConta() { return this.conta; }
}
