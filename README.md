# curriculoLattes

Sistema que representa o curriculo Lattes, por meio da composição de diferentes classes.

O sistema é responsável por armazenar e manipular as informações de Pesquisadores, Artigos e Projetos.
Essas interações com o sistema são feitas por meio de uma interface de texto, a qual lista as funcionalidades
disponíveis e solicita ao usuário que escolha uma delas.

Dentre as funcionalidades disponíveis, estão as de criar e listar as entidades (pesquisador, artigo ou projeto).
O menu de funcionalidades fica em loop até que o usuário escolha a opção de sair do sistema.

## Como executar

O sistema começa em `interacoes.inicio.main()`. Para executar o sistema, basta executar essa função.
Esta função é responsável por chamar `interacoes.InterfaceUsuario.menu()`, que é a função que contém o menu de funcionalidades.
O menu então, lista as funcionalidades como já foi dito, e solicita ao usuário que escolha uma delas.
Cada uma das opções que o usuário pode escolher, representa um método da `InterfaceUsuario`, que por sua vez, cria ou busca
os objetos das *entidades* (Pesquisador, Artigo e Projeto) e os delega a parte da funcionalidade para eles.

## melhorias futuras

- [X] fazer funcionalidade 10 retornar uma lista linear de pessoas, sem repetir os nomes
- [ ] Segmentar a Interface de dados em outras classes
- [ ] Criar uma classe que unifique as funcionalidades de artigo e projeto
- [ ] fazer artigo e projeto herdar de uma classe abstrata
