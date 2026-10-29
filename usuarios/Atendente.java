package usuarios;

public final class Atendente extends Usuario{
    private double valorEmCaixa = 0;
    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha, false);
    }
    public void receberPagamentos(double valorPagamento){
        if(!isLogado()){
            System.out.println("VOCÊ ESTÁ DESLOGADO");
            return;
        }
        if(valorPagamento<=0){
            System.out.println("DIGITE UM VALOR VÁLIDO");
            return;
        }
        valorEmCaixa += valorPagamento;
        System.out.printf("Pagamento Recebido. Total em caixa: R$ %.2f%n", valorEmCaixa);
    }

    public double getValorEmCaixa() {
        return valorEmCaixa;
    }

    public void fecharCaixa(){
        if(!isLogado()){
            System.out.println("VOCÊ NÃO ESTÁ LOGADO");
            return;
        }
        if (valorEmCaixa == 0) {
            System.out.println("Caixa vazio, nada a fechar");
            return;
        }
        System.out.printf("VALOR TOTAL DO CAIXA: R$ %.2f%n", valorEmCaixa);
        System.out.println("CAIXA FECHADO.");
        valorEmCaixa = 0;
    }
}