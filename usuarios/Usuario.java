package usuarios;

public sealed abstract class Usuario permits Gerente, Vendedor, Atendente{
    private String nome;
    private String email;
    private String senha;
    private boolean administrador;
    private boolean logado;

    public Usuario(String nome, String email, String senha, boolean administrador) {
        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome inválido");
        }
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("Email inválido");
        }
        if(senha == null || senha.isBlank()){
            throw new IllegalArgumentException("Senha inválida");
        }
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.administrador = administrador;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean isLogado() {
        return logado;
    }

    public void realizarLogin(String loginEmail, String loginSenha) {
        if (logado) {
            System.out.println("Você já está logado");
            return;
        }
        if(!email.equals(loginEmail) || !senha.equals(loginSenha)){
            System.out.println("Login ou senha incorreto");
            return;
        }
        logado = true;
        System.out.println("Login realizado");
    }

    public void realizarLogoff(){
        if(!logado){
            System.out.println("Você não está logado");
            return;
        }
        logado = false;
        System.out.println("Deslogado!");
    }

    public void alterarSenha(String senhaAtual, String novaSenha){
        if(!logado){
            System.out.println("VOCÊ ESTÁ DESLOGADO");
            return;
        }
        if(!senha.equals(senhaAtual)){
            System.out.println("Senha incorreta");
            return;
        }
        if(novaSenha == null || novaSenha.isBlank()){
            System.out.println("VALOR INVÁLIDO");
            return;
        }
        this.senha = novaSenha;
        System.out.println("Senha alterada com sucesso");
    }

    public void alterarDados(String novoNome, String novoEmail){
        if(!logado){
            System.out.println("VOCÊ ESTÁ DESLOGADO");
            return;
        }
        if (novoNome == null || novoNome.isBlank()){
            System.out.println("NOME INVÁLIDO");
            return;
        }
        if(novoEmail == null || novoEmail.isBlank()){
            System.out.println("EMAIL INVÁLIDO");
            return;
        }
        nome = novoNome;
        email = novoEmail;
        System.out.println("Dados alterados com sucesso!");
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
