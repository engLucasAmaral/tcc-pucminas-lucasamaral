# TCC PUC MINAS (Arquitetua de Sistemas Distribuidos)
Utlizado Java EE com servidor de aplicação Payara Micro e React para o frontend!

Utlizado docker para criação do ambiente de forma completa.
Utilizado o traefik para balanceamento de carga.

Para executar o projeto, basta apenas seguir os passos:

# [Compilação]
  Na raiz, executar: docker-compose build    
# [Execução]
  Na raiz, executar: docker-compose up

Com apenas esses dois comandos, será gerado a versão da api-java, frontend, criação do banco de dados (mariadb).
O Projeto java só é iniciado após o banco de dados estar pronto e conectável.

# Para utilizar a aplicação web, basta acessar:
  http://tccpmbd.tech/portal

# Para consultar o swagger da api:
  http://tccpmbd.tech/pmbd/swagger

Caso queira trocar a URL, pode alterar no docker-compose.yml:
  traefik.frontend.rule=Host: URL_DOMINIO
e alterar a variável do projeto web URL_BASE_AMBIENTE no arquivo "base.js". para o mesmo poder se comunicar com a nova URL.
as
