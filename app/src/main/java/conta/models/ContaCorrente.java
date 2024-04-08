package conta.models;

import java.util.logging.Logger;

public class ContaCorrente extends Conta {

  private static final Logger log = Logger.getLogger(ContaCorrente.class.getName());

  public ContaCorrente( Double saldo) {
    super(saldo);
  }

  @Override
  public void deposito(Double valor) {
    setSaldo(getSaldo() + valor);
  }

  @Override
  public Double saldo() {
    return getSaldo();
  }

  @Override
  public void saque(Double valor) {
   if(getSaldo() - valor < -500.0D){
    log.info("Valor superior ao limite da sua conta.");

   }
   else if (getSaldo() - valor >= -500.0D){
     setSaldo(getSaldo() - valor);
     }
  }
}


//Para a conta corrente:
//  - Pode ser aberta sem depósito inicial.
//  - Permite saques e pode ficar negativa até R$ -500,00.
//  - Ao visualizar o saldo, deve mostrar o saldo total sem alteração.

                       
