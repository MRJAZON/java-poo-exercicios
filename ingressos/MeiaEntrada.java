package ingressos;

public final class MeiaEntrada extends Ingresso{
    public MeiaEntrada(double valorIngresso, String nomeFilme, boolean dublado) {
        super(valorIngresso, nomeFilme, dublado);
    }

    @Override
    public double getValorReal() {
        return this.getValorIngresso()/2;
    }
}