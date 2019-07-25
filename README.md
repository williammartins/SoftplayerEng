# SoftplayerEng

### Este é um projeto dividido em dois exercícios:
* Exercício 1: Simula uma entrada de dados de um sistema externo, com processamento com as regras de domínio interna e saída de dados.
* Exercício 2: Efetua o cálculo de custo de insumos e serviços a partir de uma lista recebida.

### Decisões tomadas no exercício 1:
* Dividi os testes em duas classes, uma com os testes da funcinalidade antiga e a outra com os testes da nova funcionalidade.
* Utilizei JUnit para fazer os testes.
* Efetuei algumas correções na funcionalidade antiga:
  - Correção de nome da constante "umaNota".
  - Criei uma constante para as várias notas.
  - Nos métodos geraObservacao e retornaCodigos coloquei o tipo Integer na lista que recebe como parâmetro.
  - Criei testes para o cenário de sucesso com uma nota, sucesso com uma lista de notas e com a lista vazia.
* Na nova funcionalidade:
  - Criei uma classe para representar a Nota Fiscal.
  - Criei um formatador de moeda.
  - Criei um contador para somar o total final.
  - Criei testes para o cenário de sucesso com uma nota, sucesso com uma lista de notas e com a lista vazia.
  
### Decisões tomadas no exercício 2:
* Utilizei json-simple para fazer a leitura do arquivo JSON.
* Criei um método para converter string para double.
* Criei uma classe para representar o serviço dentro do pacote "dto".
* Criei uma classe service dentro do pacote "service".
* Criei algumas constantes.
* Decidi seguir o seguinte roteiro:
  - A classe Main chama o serviço responsável por fazer todo o processo.
  - Criei um método onde faz a leitura do arquivo JSON e cria uma lista com todos os serviços.
  - Depois outro método que tem um foreach para percorrer a lista e calcular o valor unitário * quantidade composição, caso seja do tipo Composição, é chamado outro método onde são agrupados os itens que fazem parte dessa composição e calculado o seu total.
  - Em seguida é chamado outro método onde é calculado o total de cada grupo e adicionado o grupo na lista de retorno.
  - A classe Main recebe esse resultado e é mostrado a lista final.
