package piks;

public class ContaEspecial extends Conta {
    private double limite;
    public ContaEspecial(int id, String chavePiks, double saldo, Cliente cliente, double limite) {
        super(id, chavePiks, saldo, cliente);
        this.limite = limite;
    }
    public void debitar(double valor) {
        if (getSaldo() + this.limite >= valor) {
            setSaldo(getSaldo() - valor);
        }
    }
    // metodo 
    public double getLimite() { return limite; }

}
