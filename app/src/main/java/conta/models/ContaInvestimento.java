package conta.models;

import java.util.logging.Logger;

import javax.management.RuntimeErrorException;

//- Para a conta de investimento:
//  - Só pode ser aberta com depósito inicial de R$ 1000,00.
//  - Só é permitido sacar dinheiro se o primeiro depósito foi realizado há mais de 1 dia e não pode sacar mais que o total de crédito na conta.
// - Ao visualizar o saldo, o valor deve ser acrescido de 10% para cada dia desde o primeiro depósito.

public class ContaInvestimento extends Conta{

  private static final Logger log = Logger.getLogger(ContaInvestimento.class.getName());
  private static final Double DEPOSITO_ININICAL = 1000.0D; 

  public ContaInvestimento( Double saldo) {
    super(saldo);
    if(saldo < DEPOSITO_ININICAL){
      throw new RuntimeErrorException(null, "O valor mínimo deve ser R$1000");
    }
}

  @Override
  public void deposito(Double valor) {
    setSaldo(getSaldo() + valor);
  }

  @Override
  public void saque(Double valor) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saque'");
  }

  @Override
  public Double saldo() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saldo'");
  }
}