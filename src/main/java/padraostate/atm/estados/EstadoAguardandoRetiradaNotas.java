package padraostate.atm.estados;

import padraostate.atm.CaixaEstado;

public class EstadoAguardandoRetiradaNotas extends CaixaEstado {

    private EstadoAguardandoRetiradaNotas() {};
    private static EstadoAguardandoRetiradaNotas instance = new EstadoAguardandoRetiradaNotas();
    public static EstadoAguardandoRetiradaNotas getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Aguardando Retirada de Notas";
    }

}
