# Pixelbooks

Ambiente de auxílio a leitores , que visa ajudar no controle de gastos, gerenciamento da coleção, entre outros. 


## Ideia inicial
Utilizar da API de busca de produtos da Amazon, disponível para seus associados, para que a cada busca o meu próprio banco seja populado o meu próprio banco de dados.


## Backlog

### US.1 - Busca de livros
Como usuário quero buscar por livros no ambiente do pixelbooks.

#### Requisitos de aceitação
- A busca deve ser feita utilizando qualquer um das seguintes caracteristicas:
    - Nome do livro
    - ISBN
    - ASIN
    - Nome do Autor
    - Nome da Editora
- O resultado deverá exibir em um grid com, todos os livros encontrados na busca
- O grid deverá conter a miniatura dos itens encontrados. 
- Caso seja encontrado nenhum resultado para os parametros de busca passados deverá ser exibido a mensagem "Nenhum item foi encontrado"

### US.2 - Preenchimento do BD
Como sistema quero popular o banco de dados a partir das consultas feitas à API da Amazon.

#### Requisitos de aceitação
- A consulta deve ser feita primeiro ao BD e se não houver resultado a consulta deverá ser repassada à Amazon.
- Tendo sido encontrado algum item na consulta realizada à Amazon o sistema deve persistir o livro guardando as seguintes informaçÕes: 
    - Nome do livro
    - ISBN
    - ASIN
    - Nome do Autor
    - Nome da Editora
    - Genêro
    - foto miniatura
- Não deverá existir itens duplicados no BD
- Caso nada seja encontrado, nada deverá ser persistido

### US.3 -Estante Virtual
Como usuário ter uma estante virtual.  

#### Requisitos de aceitação
- Quero utilizar conceitos do real para modelar a estante virtual. 
   - A estante deve conter Parateleiras.
   - As Prateleiras podem conter livros ou estarem vazias.
   - Esse conceito pode ser apenas visual

### US.4 -Adicionar um livro a Estante Virtual
Como usuário quero adicionar os livros que possuo a minha estante virtual. 

#### Requisitos de aceitação
- A adição dos livros na minha estante será atravéz da busca.
- Ao buscar um livro deve aparecer uma opção de adicioná-lo à estante.
- Se o livro buscado já fizer parte da minha estante devo sinalizá-lo, identificar que já está incluso. 
- Só deve aparecer a opção de adicioná-lo à estante caso o livro não tenha sido adicionado previamente.

### US.5 - Retirar um livro da Estante Virtual
Como usuário quero remover livros da minha estante virtual. 

#### Requisitos de aceitação
- A adição dos livros na minha estante será atravéz da busca.
- Ao buscar um livro deve aparecer uma opção de adicioná-lo à estante.
- Se o livro buscado já fizer parte da minha estante devo sinalizá-lo, identificar que já está incluso. 
- Só deve aparecer a opção de adicioná-lo à estante caso o livro não tenha sido adicionado previamente.
