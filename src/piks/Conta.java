package piks;

import java.util.ArrayList;

public class Conta {
    private int id; private String chavePiks; private double saldo; private Cliente cliente; private ArrayList<Lancamento> lancamentos;

    // const original
    public Conta(int id, String chavePiks, double saldo, Cliente cliente) {
        this.id = id; this.chavePiks = chavePiks; this.saldo = saldo;
        this.cliente = cliente; this.lancamentos = new ArrayList<>();
    }

    // const sem cliente* mudança depois 
    public Conta(int id, String chavePiks, double saldo) {
        this.id = id; this.chavePiks = chavePiks;
        this.saldo = saldo; this.lancamentos = new ArrayList<>();
    }

    public void creditar(double valor) { this.saldo += valor;}

    public void debitar(double valor) { this.saldo -= valor;}

    public int getId() {return id;}

    public String getChavePiks() {return chavePiks;}

    public double getSaldo() {return saldo;}

    public Cliente getCliente() { return cliente;}

    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    public ArrayList<Lancamento> getLancamentos() {return lancamentos;}

    public void setSaldo(double saldo) {this.saldo = saldo;}

    public void setChavePiks(String chavePiks) {this.chavePiks = chavePiks;}

    public void adicionar(Lancamento lanc) {this.lancamentos.add(lanc);}

    public void transferir(double valor, Conta destino) {this.debitar(valor); destino.creditar(valor);
    }
}
