package carro;

public class Carro {
    private boolean ligado;
    private int velocidade;
    private int marcha;

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0;
    }
    public void ligar(){
        if(ligado){
            System.out.println("O carro já está ligado");
            return;
        }
        ligado = true;
        System.out.println("Carro ligado");
    }
    public void desligar(){
        if(!ligado){
            System.out.println("O carro já está desligado");
            return;
        }
        if(marcha != 0 || velocidade != 0){
            System.out.println("O carro deve estar parado e em ponto morto para ser desligado");
            return;
        }
        ligado = false;
        System.out.println("Carro desligado");
    }
    public void acelerar(){
        if(!ligado){
            System.out.println("O carro está desligado. Ligue o carro");
            return;
        }
        if(marcha == 0){
            System.out.println("O carro está em ponto morto, passe a marcha");
            return;
        }
        int limite = 0;
        switch(marcha){
            case 1:
                limite = 20;
                break;
            case 2:
                limite = 40;
                break;
            case 3:
                limite = 60;
                break;
            case 4:
                limite = 80;
                break;
            case 5:
                limite = 100;
                break;
            case 6:
                limite = 120;
                break;
        }
        if(velocidade>=limite){
            System.out.println("Velocidade Máxima atingida, troque a marcha");
            return;
        }
        velocidade++;
        System.out.println("Velocidade: "+velocidade+ " Km/h");
    }
    public void trocarMarcha(int novaMarcha){
        if(!ligado){
            System.out.println("O carro está desligado. Ligue o carro");
            return;
        }
        if(novaMarcha<0 || novaMarcha > 6){
            System.out.println("Marcha inválida");
            return;
        }
        if(novaMarcha != marcha+1 && novaMarcha != marcha-1){
            System.out.println("Passe uma marcha por vez!");
            return;
        }
        int minimo = 0;
        int maximo = 0;

        //mínimo = máximo da marcha anterior, para permitir a troca.
        //(O enunciado tem um furo entre 20 e 21km/h)

        switch (novaMarcha){
            case 1:
                maximo = 20;
                break;
            case 2:
                minimo = 20;
                maximo = 40;
                break;
            case 3:
                minimo = 40;
                maximo = 60;
                break;
            case 4:
                minimo = 60;
                maximo = 80;
                break;
            case 5:
                minimo = 80;
                maximo = 100;
                break;
            case 6:
                minimo = 100;
                maximo = 120;
                break;

        }
        if(novaMarcha != 0 && (velocidade<minimo || velocidade >maximo)){
            System.out.println("Velocidade incompatível com essa marcha");
            return;
        }
        marcha = novaMarcha;
        System.out.println("Marcha alterada para "+marcha +" marcha");
    }
    public void diminuirVelocidade(){
        if(!ligado){
            System.out.println("O carro está desligado. Ligue o carro");
            return;
        }
        if(velocidade == 0){
            System.out.println("O carro está parado.");
            return;
        }
        int minimo = 0;
        switch (marcha){
            case 1:
                minimo = 0;
                break;
            case 2:
                minimo = 20;
                break;
            case 3:
                minimo = 40;
                break;
            case 4:
                minimo = 60;
                break;
            case 5:
                minimo = 80;
                break;
            case 6:
                minimo = 100;
                break;
        }
        if(velocidade -1 <minimo){
            System.out.println("Diminua a marcha!");
            return;
        }
        velocidade--;
        System.out.println("Velocidade atual: "+velocidade+" km/h");
    }
    private void virar(String lado){
        if(!ligado){
            System.out.println("O carro está desligado. Ligue o carro");
            return;
        }
        if(velocidade < 1 || velocidade > 40){
            System.out.println("Velocidade inválida para mudar a direção");
            return;
        }
        System.out.printf("Virando para a %s%n", lado);
    }

    public void virarEsquerda(){
        virar("Esquerda");
    }
    public void virarDireita(){
        virar("Direita");
    }

    public int getVelocidade() {
        return velocidade;
    }
}

