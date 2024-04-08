package conta.models;

import java.util.logging.Logger;

import javax.management.RuntimeErrorException;

public class ContaPoupanca extends Conta {

  private static final Logger log = Logger.getLogger(ContaPoupanca.class.getName());
  private static final Double DEPOSITO_ININICAL = 50.0D;

  public ContaPoupanca(Double saldo) {
    super(saldo);
    if (saldo < DEPOSITO_ININICAL) {
      throw new RuntimeErrorException(null, "O valor mínimo deve ser R$50");
    }
  }

  @Override
  public void saque(Double valor) {
    if (getSaldo() - valor > 0) {
      setSaldo(getSaldo() - valor);
    } else
      log.info("Saldo insuficiente para realizar saque");
  }

  @Override
  public Double saldo() {
    throw new UnsupportedOperationException("Unimplemented method 'saldo'");
  }

  public void deposito(Double valor) {
    setSaldo(getSaldo() + valor);
  }
}
