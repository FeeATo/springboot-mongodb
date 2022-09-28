# API RESTful com Spring Boot e MongoDB
Esta é uma aplicação em que podem ser postados **Posts**, estes posts têm **Autores** (autores são **usuários**) e também contêm **Comentários** feitos por **Usuários**.
Foi elaborada uma API Restful com Java utilizando o framework Spring Boot, acessando e alterando dados em um banco de dados NoSQL MongoDB.

## Funcionalidades da API
Nota: é importante salientar que a porta utilizada para acessar os dados varia de acordo com as configurações do servidor criado na sua máquina. Nos exemplos, utilizarei a porta 8080.
### Acessando dados - Método GET
#### Acessando Posts

- **Todos os Posts**: Usa-se a requisição *"htt<span>p://loca</span>lhost:8080/posts/"* para retornar **todos os posts**, isto é, todo o seu conteúdo, autor e comentários.
<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192591449-9ac2307c-70d8-4137-bfc3-fe096bc84a3d.png" width=600px /> 
</p>

- **Por ID do Post**: Usa-se a requisição *"htt<span>p://localhos</span>t:8080/posts/**<id_do_post>**"* para retornar um post com base em seu ID. Seu conteúdo, autor e comentários são retornados.
<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192593534-061c1dd9-f788-4707-9cef-c12d36d23663.png" width=600px />
</p>

- **Por título**: Usa-se a requisição *"htt<span>p://localhost:80</span>80/posts/**titlesearch?text=<p<span>a</span>lavra>**"* para retornar os posts que contêm uma palavra/frase passada como parâmetro. Seu conteúdo, autor e comentários são retornados.
<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192624424-9cda9fa6-8822-4262-9ac9-44cbc1e4279e.png"  width=600px />
</p>

- **Pesquisa customizada**: A pesquisa customizada busca posts contendo um dado string em qualquer lugar (no título, corpo ou comentários do post) e em um dado	intervalo de datas.<br/> 
Usa-se a requisição *"htt<span>p://localhos</span>t:8080/posts/**customsearch?text=<palavra/frase>&maxDate=<data_máxima>&minDate=<data_mínima>**"*.

<p align="center">
 <sub><i>Exemplo de requisição</i></sub><br/>
 <img src="https://user-images.githubusercontent.com/54337305/192626940-58927c91-8971-4c83-bebf-ae86a302c061.png" width=800px />
</p>

- **Por ID do Usuário**: Usa-se a requisição *"ht<span>tp://localho</span>st:8080/**users/<id_do_usuário>/posts**"* para retornar os posts de um usuário de acordo com seu ID.
<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192664520-1694742e-073d-4e3b-a0a2-206234f5bb69.png"  width=600px />
</p>

#### Acessando Comentários dos Posts
- Usa-se a requisição *"htt<span>p://localhost:80</span>80/posts/**<id_do_post>/comments**"* para retornar os comentários de um post com base em seu ID.
<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192621764-09685907-19ed-44ad-b4eb-cff5dbf0d472.png" width=600px />
</p>

#### Acessando Usuários

- **Todos os Usuários**: Usa-se a requisição *"htt<span>p://localho</span>st:8080/users/"* para retornar todos os usuários cadastrados.
<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192664852-9f7e5953-00cd-4c2f-b44a-a742f0d77679.png" width=600px />
</p>

- **Por ID do Usuário**: Usa-se a requisição *"ht<span>tp://localho</span>st:8080/users/**<id_do_usuário>**"* para retornar o usuário com base em seu ID.
<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192665267-b255e11d-0a33-48a9-b8c7-34b3cfb308b0.png" width=600px />
</p>

### Inserindo dados - Método POST

#### Inserindo Usuários
Usa-se a requisição *"htt<span>p://localhos</span>t:8080/users/"* junto com um corpo de requisição parecido com o seguinte modelo para inserir um novo usuário: 
`{    
    "name": "<nome do usuário>",
    "email": "<email do usuário>"
}`. Seu ID é gerado automaticamente pelo banco de dados.

<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192669587-a220cc6b-0252-4cf6-ad24-6ba69685f3a4.png" width=600px />
</p>

<p align="center">
  <sub><i>Exemplo de corpo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192669709-b841284e-8c0a-47e6-ab8c-999c6f24dd62.png" width=350px />
</p>

#### Inserindo um Post
Usa-se a requisição *"htt<span>p://localhos</span>t:8080/posts/"* junto com um corpo de requisição parecido com: `{    
    "date": "<data ex:2022-09-27>",
    "title": "<título>",
    "body": "<corpo>",
    "author": {
        "id": "<id do usuário>",
       "name": "<nome do usuário>"
    }
}`. O ID do Post é gerado automaticamente pelo banco de dados.

<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192671723-dba48103-09bd-4109-bab6-e1ef3cf7c133.png" width=600px />
</p>

<p align="center">
  <sub><i>Exemplo de corpo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192671752-e16804df-98fa-49b5-9bc9-50f7d6cc84ed.png" width=350px />
</p>

#### Inserindo um Comentário - ATENÇÃO
Para inserir um novo comentário, o que na verdade é feito é uma atualização na lista de comentários que um Post possui. Por isso usa-se o método HTTP *PUT*.
Modelo de requisição: *"ht<span>tp://localho</span>st:8080/posts/**<id do post>/comments**"*. 
  Modelo do corpo da requisição: `{
    "text": "<texto do comentário>",
    "date": "<data ex:2018-03-23>",
    "author": {
        "id": "<id do usuário>",
        "name": "<nome do usuário>"
    }
}`

<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192671399-797e0130-7ca4-4e88-aba5-319fa6b5279b.png" width=600px />
</p>

<p align="center">
  <sub><i>Exemplo de corpo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192671538-245726f1-9e42-47f5-9ed4-b0167c711e61.png" width=350px />
</p>

### Atualizando dados - Método PUT
#### Atualizando Usuário
Usa-se a requisição *"h<span>ttp://localhost:8</span>080/users/**<id_do_usuário>**"* junto com um corpo de requisição parecido com: `{    
    "name": "<nome atualizado>",
    "email": "<email atualizado>"
}`   
  
  
<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192676057-2c3b65ab-1ca8-4599-a139-a6aac97ff23d.png" width=600px />
</p>

<p align="center">
  <sub><i>Exemplo de corpo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192676168-f89ece17-b9ca-404a-bf08-e0d78d292833.png" width=350px />
</p>
  
#### Atualizando Post
Usa-se a requisição *"ht<span>tp://localhost:80</span>80/posts/**<id_do_post>**"* junto com um corpo de requisição parecido com: `{    
    "title": "<título atualizado>",
    "body": "<corpo atualizado>"
}` 
  
<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192677270-ad707dcb-f834-4ff8-a579-9ed3b91447a1.png" width=600px />
</p>

<p align="center">
  <sub><i>Exemplo de corpo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192677378-70be7926-7524-4833-8c0a-28ce3bd488dd.png" width=350px />
</p>
  
 ### Deletando dados - Método DELETE
 #### Deletando Usuários
 Usa-se a requisição *"ht<span>tp://localhost:80</span>80/users/**<id_do_usuário>**"* para deletar um Usuário com base em seu ID.
  
 #### Deletando Posts
 Usa-se a requisição *"ht<span>tp://localhost:80</span>80/posts/**<id_do_post>**"* para deletar um Post com base em seu ID.
  
