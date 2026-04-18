package padraostate.atm.estados;

import padraostate.atm.CaixaEletronico;
import padraostate.atm.CaixaEstado;

public class EstadoAutenticado extends CaixaEstado {

        private EstadoAutenticado() {};
        private static EstadoAutenticado instance = new EstadoAutenticado();
        public static EstadoAutenticado getInstance() {
            return instance;
        }

        public String getEstado() {
            return "Autenticado";
        }

        public boolean sacar(CaixaEletronico caixa) {
            caixa.setEstado(EstadoAguardandoRetiradaNotas.getInstance());
            return true;
        }

}
