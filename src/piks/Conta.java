package piks;

import java.util.ArrayList;

public class Conta {
    private int id; private String chavePiks; private double saldo; private Cliente cliente; private ArrayList<Lancamento> lancamentos;

    // construtor
    public Conta(int id, String chavePiks, double saldo, Cliente cliente) {
        this.id = id; this.chavePiks = chavePiks; this.saldo = saldo; this.cliente = cliente; this.lancamentos = new ArrayList<>();
    }
    // metodos
    public void creditar(double valor) { this.saldo += valor; }
    public void debitar(double valor) { this.saldo -= valor; }
    public int getId() { return id; }
    public String getChavePiks() { return chavePiks; }
    public double getSaldo() { return saldo; }
    public Cliente getCliente() { return cliente; }
    public ArrayList<Lancamento> getLancamentos() { return lancamentos; }
    public void setSaldo (double saldo) { this.saldo = saldo; }
    public void setChavePiks (String chavePiks) { this.chavePiks = chavePiks; }
    public void adicionar (Lancamento lanc){ this.lancamentos.add(lanc); }
    public void transferir (double valor, Conta destino) {// usar metodo creditar e debitar}
    }
}      
 