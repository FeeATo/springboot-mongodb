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

- **Por título**: Usa-se a requisição *"htt<span>p://localhost:80</span>80/posts/**titlesearch?text=<p<span>a</span>lavra>**"* para retornar os posts que contêm uma palavra passada como parâmetro. Seu conteúdo, autor e comentários são retornados.
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

