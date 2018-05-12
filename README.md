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

### US.2 - Busca de livros
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