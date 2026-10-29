package usuarios;

public final class Vendedor extends Usuario{
    private int quantidadeVendas;
    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha, false);
    }

    public void realizarVenda(int vendas){
        if(!isLogado()){
            System.out.println("VOCÊ ESTÁ DESLOGADO");
            return;
        }
        if(vendas<=0){
            System.out.println("VALOR INVÁLIDO");
            return;
        }
        quantidadeVendas += vendas;
        System.out.printf("Vendas realizadas! Total de vendas: %d%n", quantidadeVendas);
    }

    public int consultarVendas(){
        return quantidadeVendas;
    }
}