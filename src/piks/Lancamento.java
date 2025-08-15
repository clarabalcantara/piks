package piks;

import java.time.LocalDateTime;

public class Lancamento {
    private LocalDateTime datahora; private double valor; private Character tipo; // tipo = + ou -

    public Lancamento(double valor, Character tipo) {
        this.datahora = LocalDateTime.now(); this.valor = valor; this.tipo = tipo; 
    }
}
