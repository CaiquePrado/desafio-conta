package conta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import conta.models.ContaInvestimento;

class ContaInvestimentoTest {

  @Test
  void testDepositoValido() {
      ContaInvestimento conta = new ContaInvestimento(1500.0);
      conta.depositar(500.0);
      assertEquals(2000.0, conta.getSaldo(), 0.001);
  }

  @Test
  void testDepositoComValorZero() {
      ContaInvestimento conta = new ContaInvestimento(1500.0);
      assertThrows(RuntimeException.class, () -> conta.depositar(0.0));
  }

  @Test
  void testDepositoComValorNegativo() {
      ContaInvestimento conta = new ContaInvestimento(1500.0);
      assertThrows(RuntimeException.class, () -> conta.depositar(-500.0));
  }

  @Test
  void testSaqueAntesDeUmDia() {
      ContaInvestimento conta = new ContaInvestimento(1500.0);
      assertThrows(RuntimeException.class, () -> conta.sacar(500.0));
  }
}