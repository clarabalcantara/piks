package piks;

import java.util.ArrayList;

public class Conta {
    private int id;
    private String chavepiks;
    private double saldo;
    private Conta conta;
    private ArrayList<Lancamento> lancamentos = new ArrayList<>();

    public Conta(int id, String chavepiks, double saldo) {
        this.id = id; this.chavepiks = chavepiks; this.saldo = saldo;
    }
    public int getId() {
        return id;
    }
    public void creditar(valor:double){
        return
    }
    public void debitar(valorÇ:double){
        return 
    }

    public String getChavepiks() {
        return chavepiks;
    }
    public double getSaldo() {
        return saldo;
    }
    public Cliente getCliente() {
        return conta;
    }
    public void setCliente(){

    }
    public void setSalto(){

    }
    public void setChavePiks(){

    }
    public void adicionarLancamento(Lancamento lancamento){
        lancamentos.add(lancamento);
    }
    public void transferir (valor:double, destino:Conta) {
        return
    }
}
