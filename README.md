# API RESTful com Spring Boot e MongoDB

Esta é uma aplicação em que podem ser postados **Posts**, estes posts têm **Autores** (autores são **usuários**) e também contêm **Comentários** feitos por **Usuários**.
Foi elaborada uma API Restful com Java utilizando o framework Spring Boot, acessando e alterando dados em um banco de dados NoSQL MongoDB.

## Funcionalidades da API
Nota: é importante salientar que a porta utilizada para acessar os dados varia de acordo com as configurações do servidor criado na sua máquina. Nos exemplos, utilizarei a porta 8080.
### Acessando dados - Método GET
#### Acessando Posts
Usa-se a requisição **"htt<span>p://loca</span>lhost:8080/posts/"** para retornar **todos os posts**, isto é, todo o seu conteúdo, autor e comentários.

<sub color="gray">*Exemplo de requisição*</sub><br/>
<img src="https://user-images.githubusercontent.com/54337305/192591449-9ac2307c-70d8-4137-bfc3-fe096bc84a3d.png" width=600px /> 

<sub>*Exemplo de resposta*</sub><br/>
<img src="https://user-images.githubusercontent.com/54337305/192592068-7e06c037-9ef0-451b-9562-cfc8e42025d0.png" width=800px />

Usa-se a requisição **"http://localhost:8080/posts/<id_do_post>"** para retornar um post com base em seu ID. Seu conteúdo, autor e comentários são retornados.
<img src="https://user-images.githubusercontent.com/54337305/192593534-061c1dd9-f788-4707-9cef-c12d36d23663.png" 
