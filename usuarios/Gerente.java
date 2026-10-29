package usuarios;

public final class Gerente extends Usuario{

    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha, true);
    }

    public int consultarVendas(Vendedor vendedor){
        if(!isLogado()){
            System.out.println("VOCÊ ESTÁ DESLOGADO");
            return 0;
        }
        return vendedor.consultarVendas();
    }

    public void gerarRelatorioFinanceiro(Vendedor[] vendedores){
        if(!isLogado()){
            System.out.println("VOCÊ ESTÁ DESLOGADO");
            return;
        }
        for(int i = 0; i<vendedores.length; i++){
            System.out.printf("VENDEDOR: %s | VENDAS: %d%n", vendedores[i].getNome(), vendedores[i].consultarVendas());
        }
    }
}