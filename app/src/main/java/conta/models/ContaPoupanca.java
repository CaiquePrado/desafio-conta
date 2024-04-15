package conta.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContaPoupanca extends Conta {
    private LocalDate dataDeAbertura;

    public ContaPoupanca(Double saldoInicial) {
        super(saldoInicial);
        dataDeAbertura = LocalDate.now();
        if(saldoInicial <50.0){
            throw new RuntimeException("O depósito inicial deve ser de pelo menos R$ 50,00.");
        }
    }

    @Override
    public void sacar(Double valor) {
        if (getSaldo() >= valor) {
            super.sacar(valor);
        } else {
            throw new RuntimeException("A conta poupança não pode ficar negativa");
        }
    }

    @Override
    public Double getSaldo() {
        LocalDate hoje = LocalDate.now();
        long dias = ChronoUnit.DAYS.between(dataDeAbertura, hoje);
        return super.getSaldo() + (0.05 * dias);
    }
}