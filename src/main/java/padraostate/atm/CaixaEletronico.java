package padraostate.atm;

public class CaixaEletronico {

    private CaixaEstado estado;

    public CaixaEletronico() {
        this.estado = EstadoAguardandoCartao.getInstance();
    }

    public void setEstado(CaixaEstado estado) {
        this.estado = estado;
    }

    public boolean inserirCartao() {
        return estado.inserirCartao(this);
    }

    public boolean digitarSenha() {
        return estado.digitarSenha(this);
    }

    public boolean sacar() {
        return estado.sacar(this);
    }

    public boolean ejetarCartao() {
        return estado.ejetarCartao(this);
    }

    public boolean retirarNotas() {
        return estado.retirarNotas(this);
    }

}
