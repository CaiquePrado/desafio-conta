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
        if (ChronoUnit.DAYS.between(getDataDeAbertura(), LocalDateTime.now()) <= 1) {
            throw new RuntimeException(
                    "Não é permitido sacar dinheiro se o primeiro depósito foi realizado há menos de 1 dia.");
        }
        if (valor > getSaldo()) {
            throw new RuntimeException("Não é permitido sacar mais que o total de crédito na conta.");
        }
        super.sacar(valor);
    }

    @Override
    public Double getSaldo() {
        long diasDesdePrimeiroDeposito = ChronoUnit.DAYS.between(getDataDeAbertura(), LocalDateTime.now());
        return super.getSaldo() * Math.pow(1.10, diasDesdePrimeiroDeposito);
    }

    public LocalDateTime getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(LocalDateTime dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }
}