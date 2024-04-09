package conta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import conta.models.Conta;
import conta.models.ContaPoupanca;

class ContaPoupancaTest {

  @Test
  void testDepositoValido() {
      Conta conta = new ContaPoupanca(100.0);
      conta.depositar(50.0);
      assertEquals(150.0, conta.getSaldo());
  }

  @Test
  void testDepositoInvalido() {
      Conta conta = new ContaPoupanca(100.0);
      assertThrows(RuntimeException.class, () -> conta.depositar(-50.0));
  }

  @Test
  void testSaqueNaoPermitido() {
      Conta conta = new ContaPoupanca(100.0);
      assertThrows(RuntimeException.class, () -> conta.sacar(150.0));
  }
}
