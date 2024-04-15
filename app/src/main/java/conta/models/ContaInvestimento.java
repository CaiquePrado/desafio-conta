package conta.models;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ContaInvestimento extends Conta {
    private LocalDateTime dataDeAbertura;

    public ContaInvestimento(Double saldoInicial) {
        super(saldoInicial);
        dataDeAbertura = LocalDateTime.now();
        if(saldoInicial <1000.0){
            throw new RuntimeException("O depósito inicial deve ser de pelo menos R$ 1000,00.");
        }
    }

    @Override
    public void sacar(Double valor) {
        if (dataDeAbertura != null && ChronoUnit.DAYS.between(dataDeAbertura, LocalDateTime.now()) >= 1) {
            if (valor > 0 && valor <= getSaldo()) {
                super.sacar(valor);
            } else {
                throw new RuntimeException("Valor de saque inválido ou saldo insuficiente.");
            }
        } else {
            throw new RuntimeException("Você só pode sacar após 1 dia do primeiro depósito.");
        }
    }

    @Override
    public Double getSaldo() {
        LocalDateTime hoje = LocalDateTime.now();
        long dias = ChronoUnit.DAYS.between(dataDeAbertura, hoje);
        return super.getSaldo() + (0.1 * dias);
    }
    public LocalDateTime getDataDeAbertura() {
        return dataDeAbertura;
    }
}