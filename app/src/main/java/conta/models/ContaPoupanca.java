package conta.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ContaPoupanca extends Conta {
    private LocalDateTime dataDeAbertura;

    public ContaPoupanca(Double saldoInicial) {
        super(saldoInicial);
        this.dataDeAbertura = LocalDateTime.now();
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
        long diasDesdePrimeiroDeposito = ChronoUnit.DAYS.between(this.dataDeAbertura, LocalDateTime.now());
        return super.getSaldo() * Math.pow(1.05, diasDesdePrimeiroDeposito);
    }

    public LocalDateTime getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(LocalDateTime dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }
}