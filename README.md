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
<p align="center">
  <sub><i>Exemplo de resposta da requisição anterior</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192592068-7e06c037-9ef0-451b-9562-cfc8e42025d0.png" width=600px />
</p>

- **Por ID do Post**: Usa-se a requisição *"htt<span>p://localhos</span>t:8080/posts/**<id_do_post>**"* para retornar um post com base em seu ID. Seu conteúdo, autor e comentários são retornados.
<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192593534-061c1dd9-f788-4707-9cef-c12d36d23663.png" width=600px />
</p>

<p align="center">
  <sub><i>Exemplo de resposta da requisição anterior</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192620134-37f17e69-28d8-4bc3-b482-d5b6187b7aeb.png" width=600px />
</p>

- **Por título**: Usa-se a requisição *"htt<span>p://localhost:80</span>80/posts/**titlesearch?text=<p<span>a</span>lavra>**"* para retornar os posts que contêm uma palavra passada como parâmetro. Seu conteúdo, autor e comentários são retornados.
<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192624424-9cda9fa6-8822-4262-9ac9-44cbc1e4279e.png"  width=600px />
</p>

<p align="center">
  <sub><i>Exemplo de resposta da requisição anterior</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192628303-efaa28d1-8315-4fe7-a41a-cfcdd70722c7.png" width=400px />
</p>

- **Pesquisa customizada**: A pesquisa customizada busca posts contendo um dado string em qualquer lugar (no título, corpo ou comentários do post) e em um dado	intervalo de datas.<br/> 
Usa-se a requisição *"htt<span>p://localhos</span>t:8080/posts/**customsearch?text=<palavra/frase>&maxDate=<data_máxima>&minDate=<data_mínima>**"*.

<p align="center">
 <sub><i>Exemplo de requisição</i></sub><br/>
 <img src="https://user-images.githubusercontent.com/54337305/192626940-58927c91-8971-4c83-bebf-ae86a302c061.png" width=800px />
</p>

<p align="center">
  <sub><i>Exemplo de resposta da requisição anterior</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192628659-72490f1f-7002-4add-80d4-c5fbd87697cf.png" width=600px />
</p>

#### Acessando Comentários dos Posts
- Usa-se a requisição *"htt<span>p://localhost:80</span>80/posts/**<id_do_post>/comments**"* para retornar os comentários de um post com base em seu ID.
<p align="center">
  <sub><i>Exemplo de requisição</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192621764-09685907-19ed-44ad-b4eb-cff5dbf0d472.png" width=600px />
</p>

<p align="center">
  <sub><i>Exemplo de resposta da requisição anterior</i></sub><br/>
  <img src="https://user-images.githubusercontent.com/54337305/192622167-e28248c8-1326-487d-847b-0eb409c5b5f7.png" width=400px />
</p>
