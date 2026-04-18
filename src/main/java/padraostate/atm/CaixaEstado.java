package padraostate.atm;

public abstract class CaixaEstado {

    public abstract String getEstado();

    public boolean inserirCartao(CaixaEletronico caixa) {
        return false;
    }

    public boolean digitarSenha(CaixaEletronico caixa) {
        return false;
    }

    public boolean sacar(CaixaEletronico caixa) {
        return false;
    }

    public boolean ejetarCartao(CaixaEletronico caixa) {
        return false;
    }

    public boolean retirarNotas(CaixaEletronico caixa) {
        return false;
    }
}
