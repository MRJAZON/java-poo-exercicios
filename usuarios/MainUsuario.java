package usuarios;

public class MainUsuario {
    public static void main(String[] args) {
        Gerente g = new Gerente("Ana", "ana@email.com", "123");
        Vendedor v = new Vendedor("Bia", "bia@email.com", "456");
        Atendente a = new Atendente("Caio", "caio@email.com", "789");

        // deslogado: tudo deve recusar
        v.realizarVenda(2);
        a.receberPagamentos(50);

        // vendedor
        v.realizarLogin("bia@email.com", "456");
        v.realizarVenda(2);
        v.realizarVenda(3);
        v.realizarVenda(-1);            // recusa: valor inválido

        // atendente
        a.realizarLogin("caio@email.com", "789");
        a.receberPagamentos(50);
        a.receberPagamentos(25.5);
        a.fecharCaixa();                // mostra R$ 75,50 e zera
        a.alterarSenha("789", "nova");
        a.realizarLogoff();
        a.realizarLogin("caio@email.com", "789");   // recusa: senha antiga
        a.realizarLogin("caio@email.com", "nova");  // aceita

        // gerente
        g.gerarRelatorioFinanceiro(new Vendedor[]{v});  // recusa: deslogado
        g.realizarLogin("ana@email.com", "123");
        g.gerarRelatorioFinanceiro(new Vendedor[]{v});  // Bia com 5 vendas

        // polimorfismo: variável do tipo Usuario
        Usuario[] usuarios = {g, v, a};
        for (Usuario u : usuarios) {
            System.out.println(u.getNome() + " é admin? " + u.isAdministrador());
        }
    }
}
