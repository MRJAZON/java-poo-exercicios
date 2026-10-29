package ingressos;

public final class Familia extends Ingresso {

    private int numeroPessoas;

    public Familia(double valorIngresso, String nomeFilme, boolean dublado, int numeroPessoas) {
        super(valorIngresso, nomeFilme, dublado);
        if (numeroPessoas <= 0) {
            throw new IllegalArgumentException("O número de pessoas deve ser maior que 0");
        }
        this.numeroPessoas = numeroPessoas;
    }

    @Override
    public double getValorReal() {
        if (numeroPessoas <= 3) {
            return (this.getValorIngresso() * numeroPessoas);
        } else {
            return (this.getValorIngresso() * numeroPessoas) * 0.95;
        }
    }
}
