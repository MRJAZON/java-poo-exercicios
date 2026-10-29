# Exercícios de POO em Java

Exercícios de Programação Orientada a Objetos feitos durante o 2º semestre de Ciência da Computação (UCB). O foco é **encapsulamento**, **herança**, **polimorfismo** e **validação de regras de negócio**.

## Conteúdo

| Pasta | O que é | Conceitos praticados |
|---|---|---|
| [`carro`](carro) | Simulação de um carro com marchas e velocidade | Encapsulamento, construtor, validação de estado, métodos privados |
| [`ingressos`](ingressos) | Tipos de ingresso de cinema | Herança, classe abstrata, polimorfismo, `sealed`, imutabilidade |
| [`usuarios`](usuarios) | Tipos de usuário de um sistema (Gerente, Vendedor, Atendente) | Herança, classe abstrata, `sealed`, login/logoff, proteção de dados sensíveis |

## 1. Carro

Controle das funções de um carro: ligar, desligar, acelerar, diminuir a velocidade, trocar de marcha, virar e verificar a velocidade.

**Regras implementadas**
- O carro nasce desligado, em ponto morto e com velocidade 0.
- Desligado, ele não executa nenhuma função.
- Só pode ser desligado parado e em ponto morto.
- São 6 marchas, e não é permitido pular marchas.
- Cada marcha tem uma faixa de velocidade, e a velocidade acelera e diminui de 1 em 1 km/h (máximo de 120).
- Só vira para a esquerda ou direita entre 1 e 40 km/h.

**Encapsulamento**
- Todos os atributos são `private`. A velocidade só muda por `acelerar()` e `diminuirVelocidade()`, que validam as regras antes de alterar qualquer coisa.
- O método `virar(String lado)` é `private`: quem usa a classe só enxerga `virarEsquerda()` e `virarDireita()`, então não existe como mandar um lado inválido.

**Observação sobre o enunciado:** a 1ª marcha vai até 20 km/h e a 2ª começa em 21 km/h, então o carro nunca conseguiria trocar da 1ª para a 2ª. Para resolver, usei o máximo da marcha anterior como mínimo da marcha seguinte (a 2ª marcha vai de 20 a 40 km/h, e assim por diante).

## 2. Ingressos

Hierarquia de ingressos de cinema com `Ingresso` (classe abstrata), `MeiaEntrada` e `Familia`.

- `MeiaEntrada`: o valor real é metade do valor do ingresso.
- `Familia`: o valor real é o valor multiplicado pelo número de pessoas, com 5% de desconto quando há mais de 3 pessoas.

**Conceitos**
- **Polimorfismo:** o método abstrato `getValorReal()` é implementado de forma diferente em cada filha, e o mesmo código funciona para qualquer tipo de ingresso.
- **`sealed`:** a hierarquia é restrita às duas classes permitidas.
- **Imutabilidade:** não há setters, então um ingresso não muda depois de criado.
- **Validação no construtor:** valor menor ou igual a zero e número de pessoas menor ou igual a zero lançam `IllegalArgumentException`.
- O áudio (dublado ou legendado) é um `boolean`, o que impede valores inválidos.

## 3. Usuários

Hierarquia de usuários com `Usuario` (classe abstrata), `Gerente`, `Vendedor` e `Atendente`.

| Classe | Atributo próprio | Métodos próprios |
|---|---|---|
| `Gerente` | (nenhum) | `consultarVendas`, `gerarRelatorioFinanceiro` |
| `Vendedor` | quantidade de vendas | `realizarVenda`, `consultarVendas` |
| `Atendente` | valor em caixa | `receberPagamentos`, `fecharCaixa` |

Login, logoff, alteração de dados e alteração de senha ficam na classe-mãe e são herdados pelas três.

**Conceitos**
- **Herança:** o que é comum a todos fica em `Usuario`, e cada filha só declara o que é dela.
- **Administrador fixo:** o valor não vem do construtor das filhas. O `Gerente` sempre passa `true` e as outras sempre `false`, então ninguém de fora decide isso.
- **Dados sensíveis protegidos:** a senha não tem getter e não aparece no `toString()`. Quem compara a senha é a própria classe.
- **Estado de login:** os métodos de ação recusam quando o usuário não está logado.
- **Valores controlados:** a quantidade de vendas e o valor em caixa não têm setter, e só mudam pelos métodos que aplicam as regras.

## Como rodar

Requer Java 17 ou superior (por causa do `sealed`).

Pelo IntelliJ, abra o projeto e execute o `main` de cada pasta (`MainCarro`, `MainIngresso`, `MainUsuario`).

Pelo terminal, na raiz do projeto:

```
javac carro/*.java
java carro.MainCarro

javac ingressos/*.java
java ingressos.MainIngresso

javac usuarios/*.java
java usuarios.MainUsuario
```

Cada `main` é um roteiro de teste, com comentários indicando o que deve ser aceito e o que deve ser recusado.