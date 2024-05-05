# SSTF and C-SCAN Analysis

Repositório para versionamento de código utilizado no relatório da disciplina de Sistemas Operacionais sobre os algoritmos SSTF e C-SCAN.

Clique [aqui](https://docs.google.com/document/d/1yB46UXTxB3JjAze1ii0SP1VVJovRRW1g5hddzQgeCr4/edit?usp=sharing) para acessar o relatório.

# Implementação

Os algoritmos foram implementados na linguagem Java, seguindo conceitos de orientação a objetos e utilizando bibliotecas de estruturas de dados da linguagem como `java.util.ArrayList`.

Ambos os algoritmos foram implementados seguindo uma faixa fictícia de 200 setores em um disco (0 a 199).

O algoritmo C-SCAN segue o padrão à direita, buscando os setores realizando um movimento da esquerda para a direita.

Para viés de comparação e análise de desempenho, foi utilizado o somatório da diferença da distância entre cada setor percorrido ao longo do percurso do cabeçote de leitura e escrita.
Aqui, chamado de `seekDistance`.

# Utilização

Para rodar os dois algoritmos ao mesmo tempo e comparar a distância percorrida pelo cabeçote do disco e a sequência de setores acessados em uma mesma requisição,
execute a função `main` no arquivo `./src/Versus.java`, modificando os setores na requisição e a posição inicial do cabeçote `head` ao seu critério.

Para rodar cada algoritmo individualmente, execute a função `main` nos arquivos `./src/sstf/RunSSTF.java` ou `./src/cscan/RunCSCAN.java` seguindo os mesmos critérios
citados acima.
