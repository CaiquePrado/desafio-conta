package conta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import conta.models.Conta;
import conta.models.ContaCorrente;

class ContaCorrenteTest {

  @Test
  void testDepositoValido() {
    Conta conta = new ContaCorrente(500.0);
    conta.depositar(500.0);
    assertEquals(1000.0, conta.getSaldo());
  }

  @Test
  void testDepositoInvalido() {
    Conta conta = new ContaCorrente(500.0);
    assertThrows(RuntimeException.class, () -> conta.depositar(-500.0));
  }

  @Test
  void testSaqueNaoPermitido() {
    Conta conta = new ContaCorrente(500.0);
    assertThrows(RuntimeException.class, () -> conta.sacar(1001.0));
  }
}