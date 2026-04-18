package padraostate.atm.estados;

import padraostate.atm.CaixaEletronico;
import padraostate.atm.CaixaEstado;

public class EstadoAguardandoSenha extends CaixaEstado {

    private EstadoAguardandoSenha() {};
    private static EstadoAguardandoSenha instance = new EstadoAguardandoSenha();
    public static EstadoAguardandoSenha getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Aguardando Senha";
    }

    public boolean digitarSenha(CaixaEletronico caixa) {
        caixa.setEstado(EstadoAutenticado.getInstance());
        return true;
    }

    public boolean ejetarCartao(CaixaEletronico caixa) {
        caixa.setEstado(EstadoAguardandoCartao.getInstance());
        return true;
    }

}
