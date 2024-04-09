package conta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import conta.models.Usuario;

class UsuarioTest {

  @Test
  void testCriarConta() {
    Usuario usuario = new Usuario();
    usuario.criarConta("corrente", 1000.0);
    assertNotNull(usuario.getConta("corrente"));
    assertEquals(1000.0, usuario.getConta("corrente").getSaldo());
}

  @Test
  void testFecharConta() {
    Usuario usuario = new Usuario();
    usuario.criarConta("corrente", 1000.0);
    usuario.fecharConta("corrente");
    assertNull(usuario.getConta("corrente"));
  }

  @Test
  void testTransferir() {
    Usuario usuario = new Usuario();
    usuario.criarConta("corrente", 1000.0);
    usuario.criarConta("poupanca", 500.0);
    usuario.transferir("corrente", "poupanca", 500.0);
    assertEquals(500.0, usuario.getConta("corrente").getSaldo());
    assertEquals(1000.0, usuario.getConta("poupanca").getSaldo());
  }

  @Test
  void testGetSaldoTotal() {
    Usuario usuario = new Usuario();
    usuario.criarConta("corrente", 1000.0);
    usuario.criarConta("poupanca", 500.0);
    assertEquals(1500.0, usuario.getSaldoTotal());
  }
}
