package carro;

public class MainCarro {
    public static void main(String[] args) {
        Carro carro = new Carro();

        carro.virarEsquerda();          // recusa: desligado
        carro.ligar();
        carro.acelerar();               // recusa: ponto morto
        carro.virarEsquerda();          // recusa: velocidade 0

        carro.trocarMarcha(1);
        for (int i = 0; i < 20; i++) {
            carro.acelerar();           // sobe até 20 km/h
        }
        carro.virarDireita();           // aceita: 20 km/h

        carro.trocarMarcha(3);          // recusa: pulou a 2ª marcha
        carro.trocarMarcha(2);          // aceita: 20 km/h cabe na 2
        for (int i = 0; i < 25; i++) {
            carro.acelerar();           // trava em 40 km/h
        }

        carro.trocarMarcha(3);          // aceita: 40 km/h cabe na 3
        carro.acelerar();               // 41 km/h
        carro.virarEsquerda();          // recusa: acima de 40 km/h

        System.out.println("Velocidade final: " + carro.getVelocidade());
    }
}

