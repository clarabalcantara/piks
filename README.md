# 💱 Sistema PIKS
> IFPB/JP – TSI – Programação Orientada a Objetos (Prof. Fausto Ayres). Projeto 2.

### Objetivo: Implementar o sistema de transferência bancária PIKS.
---
## ➡️ Requisito de Dados (classes)
```mermaid
classDiagram
    class Repositorio {
        - TreeMap~String, Conta~ contasPIKS
        - TreeMap~Integer, Cliente~ clientesCPF
        + adicionarConta(cta: Conta) void
        + removerConta(cta: Conta) void
        + localizarConta(chavepiks: String) Conta
        + adicionarCliente(cli: Cliente) void
        + removerCliente(cli: Cliente) void
        + localizarCliente(cpf: int) Cliente
        + getContas() ArrayList~Conta~
        + getClientes() ArrayList~Cliente~
        + gravarObjetos() void
        + lerObjetos() void
    }

    class Conta {
        - int id
        - String chavepiks
        - double saldo
        - Cliente cliente
        - ArrayList~Lancamento~ lancamentos
        + creditar(valor: double) void
        + debitar(valor: double) void
        + getId() int
        + getChavePiks() String
        + getSaldo() double
        + getCliente() Cliente
        + setCliente(cli: Cliente) void
        + getLancamentos() ArrayList~Lancamento~
        + setSaldo(valor: double) void
        + setChavePiks(chave: String) void
        + adicionar(lanc: Lancamento) void
        + transferir(valor: double, destino: Conta) void
    }

    class ContaEspecial {
        - double limite
        + debitar(valor: double) void
    }

    class Cliente {
        - int cpf
        - String nome
        - Conta conta
        + setConta(cta: Conta) void
        + getConta() Conta
    }

    class Lancamento {
        - LocalDateTime datahora
        - double valor
        - String tipo
    }

    Repositorio --> Conta
    Repositorio --> Cliente
    Conta --> "1" Cliente : pertence a
    Cliente --> "1" Conta : possui
    Conta --> "*" Lancamento : registra
    ContaEspecial --|> Conta
``` 
