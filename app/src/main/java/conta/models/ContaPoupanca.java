package conta.models;

import java.util.logging.Logger;

import javax.management.RuntimeErrorException;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void depositar(Double valor) {
        if (valor > 0) {
            super.depositar(valor);
        } else {
            throw new RuntimeException("Valor de depósito inválido.");
        }
    }

    @Override
    public void sacar(Double valor) {
        if (getSaldo() >= valor) {
            super.depositar(-valor);
        } else {
            throw new RuntimeException("Saldo insuficiente para saque.");
        }
    }

    @Override
    public Double getSaldo() {
        return super.getSaldo();
    }
}