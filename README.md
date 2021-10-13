### Projeto BackEnd que codifica as regras de negócio para oferecer: Listagem de lanches de um cardápio; Listagem de ingredientes; e o cálculo de preços e promoções, de acordo com o selecionado pelo usuário no FrontEnd.   

Para o desesenvolvimento do projeto foi utilizado o Java 11, juntamente com o framework SpringBoot na versão 2.5.5. O framework foi o selecionado devido a simplicidade oferecida para a criação das APIs.

Foram criadas as classes:
Cardapio => Responsável por fazer a montagem e retorno da lista de lanches prontos.
CardapioController => Oferece a rota /cardapio e devolve para o frontend a listagem dos lanches para o cardápio.

Ingrediente => Representa um ingrediente oferecido. Possui as propriedades Nome, Valor e Quantidade.
IngredientesController => Oferece a rota /ingredientes e devolve para o frontend a listagem dos ingredientes e seus valores.

Lanche => Representa um lanche. Possui as propriedades Nome, Ingredientes(Lista) e Valor. A classe representa tanto um lanche já montado, quanto um personalizado. Na montagem do objeto, realiza o cálculo para atribuir o valor total do lanche. Quando é um personalizado, realiza os cálculos de acordo com as regras de promoção.

LanchePersonalizadoController => Oferece a rota /calcularTotalLanchePersonalizado e devolve o valor calculado do lanche, de acordo com a seleção de itens feita pelo usuário. 

Promocao => Classe que contém a regra de negócio para o cálculo do lanche personalizado. Contém as regras que definem o preço de acordo com a promoção a que o lanche se enquadra.

CorsConfiguration => Classe de configuração para habilitar o acesso devido ao bloqueio CORS.

### Foram implementados testes automatizados utilizando o JUnit.

Para rodar o projeto, basta executar a classe HamburgueriaApplication como Java Application.
O projeto rodará na porta 8080.

