Descrição
A aplicação define duas rotas principais:

Rota Timer: Executa uma ação a cada 5 segundos, imprimindo “Hello World from Apache Camel!” no console.

Rota REST: Responde ao caminho /hello via HTTP REST, retornando “Hello World from Apache Camel via REST!” para requisições GET na porta 8080.​

Como executar
Certifique-se de ter o Java instalado.

Importe o arquivo HelloWorldCamel.java em sua IDE (ex: IntelliJ, Eclipse).

Execute a classe principal. O CamelContext será iniciado, rodando rotas timer e REST automaticas.

Para testar o endpoint REST, use Postman ou acesse http://localhost:8080/hello no navegador.​

Estrutura dos arquivos
HelloWorldCamel.java: Código fonte principal.

Dependências geradas pelo Maven (pom.xml, target/), caso tenha usado build automático.

Autor
Projeto criado por [Cadu], para fins de prática e aprendizado sobre integração em Java com Apache Camel.
