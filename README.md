# SoftplayerEng

### Este é um projeto dividido em dois exercícios:
* Exercício 1: Simula uma entrada de dados de um sistema externo, com processamento com as regras de domínio interna e saída de dados.
* Exercício 2: Efetua o cálculo de custo de insumos e serviços a partir de uma lista recebida.

### Decisões tomadas no exercício 1:
* Dividi os testes em duas classes, uma com os testes da funcinalidade antiga e a outra com os testes da nova funcionalidade.
* Para fazer os teste utilizei JUnit.
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
  * Infelizmente não consegui fazer esse exercício, pois tive problemas com "json simple", biblioteca que eu decidi utilizar para 
  efetuar a leitura do arquivo JSON e com isso não deu tempo.
