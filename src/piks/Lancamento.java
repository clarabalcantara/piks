package piks;

import java.time.LocalDateTime;

public class Lancamento {
    private LocalDateTime datahora; private double valor; private Character tipo; // tipo = + ou -

    // const original
    public Lancamento(double valor, Character tipo) {
        this.datahora = LocalDateTime.now(); this.valor = valor; this.tipo = tipo;
    }

    // const com data e hora
    public Lancamento(LocalDateTime datahora, double valor, Character tipo) {
        this.datahora = datahora; this.valor = valor; this.tipo = tipo;
    }

    public LocalDateTime getDatahora() {return datahora;}

    public double getValor() {return valor;}

    public Character getTipo() {return tipo;}
}
