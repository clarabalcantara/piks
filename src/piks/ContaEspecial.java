package piks;

public class ContaEspecial extends Conta {
    private double limite;

    // const original
    public ContaEspecial(int id, String chavePiks, double saldo, Cliente cliente, double limite) {
        super(id, chavePiks, saldo, cliente); this.limite = limite;
    }

    // const sem cliente* mudança depois 
    public ContaEspecial(int id, String chavePiks, double saldo, double limite) {
        super(id, chavePiks, saldo); this.limite = limite;
    }

    @Override
    public void debitar(double valor) {
        if (getSaldo() + this.limite >= valor) {
            setSaldo(getSaldo() - valor);
        }
    }

    public double getLimite() {return limite;}
}
