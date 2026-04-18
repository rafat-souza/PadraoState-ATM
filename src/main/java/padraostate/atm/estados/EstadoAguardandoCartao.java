package padraostate.atm.estados;

import padraostate.atm.CaixaEletronico;
import padraostate.atm.CaixaEstado;

public class EstadoAguardandoCartao extends CaixaEstado {

    private EstadoAguardandoCartao() {};
    private static EstadoAguardandoCartao instance = new EstadoAguardandoCartao();
    public static EstadoAguardandoCartao getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Aguardando Cartão";
    }

    public boolean inserirCartao(CaixaEletronico caixa) {
        caixa.setEstado(EstadoAguardandoSenha.getInstance());
        return true;
    }

}
