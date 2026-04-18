package atmtestes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import padraostate.atm.CaixaEletronico;

import static org.junit.jupiter.api.Assertions.*;

public class CaixaEletronicoTest {
    private CaixaEletronico caixa;

    @BeforeEach
    public void setUp() {
        caixa = new CaixaEletronico();
    }

    // testes de transação bem sucedida

    @Test
    public void deveIniciarNoEstadoAguardandoCartao() {
        assertEquals("Aguardando Cartão", caixa.getNomeEstado());
    }

    @Test
    public void deveRealizarFluxoCompleto() {
        assertTrue(caixa.inserirCartao());
        assertEquals("Aguardando Senha", caixa.getNomeEstado());

        assertTrue(caixa.digitarSenha());
        assertEquals("Autenticado", caixa.getNomeEstado());

        assertTrue(caixa.sacar());
        assertEquals("Aguardando Retirada de Notas", caixa.getNomeEstado());

    }

    @Test
    public void devePermitirEjetarCartaoNoEstadoAguardandoSenha() {
        caixa.inserirCartao();

        assertTrue(caixa.ejetarCartao());
        assertEquals("Aguardando Cartão", caixa.getNomeEstado());
    }

    // testes de ações inválidas por estado

    @Test
    public void deveBloquearAcoesInvalidasEmAguardandoCartao() {
        assertFalse(caixa.digitarSenha());
        assertFalse(caixa.sacar());
        assertFalse(caixa.retirarNotas());
        assertFalse(caixa.ejetarCartao());

        assertEquals("Aguardando Cartão", caixa.getNomeEstado());
    }

    @Test
    public void deveBloquearAcoesInvalidasEmAguardandoSenha() {
        caixa.inserirCartao();

        assertFalse(caixa.inserirCartao());
        assertFalse(caixa.sacar());
        assertFalse(caixa.retirarNotas());

        assertEquals("Aguardando Senha", caixa.getNomeEstado());
    }

    @Test
    public void deveBloquearAcoesInvalidasEmAutenticado() {
        caixa.inserirCartao();
        caixa.digitarSenha();

        assertFalse(caixa.inserirCartao());
        assertFalse(caixa.digitarSenha());
        assertFalse(caixa.retirarNotas());

        assertEquals("Autenticado", caixa.getNomeEstado());
    }

    @Test
    public void deveBloquearAcoesInvalidasEmAguardandoRetirada() {
        caixa.inserirCartao();
        caixa.digitarSenha();
        caixa.sacar();

        assertFalse(caixa.inserirCartao());
        assertFalse(caixa.digitarSenha());
        assertFalse(caixa.sacar());
        assertFalse(caixa.ejetarCartao());

        assertEquals("Aguardando Retirada de Notas", caixa.getNomeEstado());
    }

}
