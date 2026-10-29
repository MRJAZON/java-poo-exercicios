package ingressos;

public sealed abstract class Ingresso permits MeiaEntrada, Familia {
    private double valorIngresso;
    private String nomeFilme;
    private boolean dublado;

    public Ingresso(double valorIngresso, String nomeFilme, boolean dublado) {
        if (valorIngresso <= 0){
            throw new IllegalArgumentException("O valor do ingresso deve ser maior que 0");
        }
        this.valorIngresso = valorIngresso;
        this.nomeFilme = nomeFilme;
        this.dublado = dublado;

    }

    public abstract double getValorReal();

    public double getValorIngresso() {
        return valorIngresso;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public boolean isDublado() {
        return dublado;
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "valorIngresso=" + valorIngresso +
                ", nomeFilme='" + nomeFilme + '\'' +
                ", dublado=" + dublado +
                '}';
    }
}