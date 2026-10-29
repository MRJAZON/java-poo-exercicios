package ingressos;

    public class MainIngresso {
        public static void main(String[] args) {
            Ingresso meia = new MeiaEntrada(22.50, "Filme X", true);
            Ingresso familia3 = new Familia(20.0, "Filme Y", false, 3);
            Ingresso familia4 = new Familia(20.0, "Filme Y", false, 4);

            System.out.println(meia.getValorReal());      // 11.25
            System.out.println(familia3.getValorReal());  // 60.0
            System.out.println(familia4.getValorReal());  // 76.0 (5% de desconto)
            System.out.println(meia);
        }
    }
