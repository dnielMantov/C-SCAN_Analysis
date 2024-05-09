# C-SCAN Analysis

Repositório para versionamento de código utilizado no relatório da disciplina de Sistemas Operacionais sobre o algoritmo C-SCAN.
É possível fornecer as seguintes características do disco como parâmetros:

- Tamanho do setor
- Número de trilhas
- Número de setores por trilhas
- Taxa de transferência
- Tempo de busca (seek time)
- Tempo de rotação (rotation time)
- Setor inicial

Clique [aqui](https://docs.google.com/document/d/1yB46UXTxB3JjAze1ii0SP1VVJovRRW1g5hddzQgeCr4/edit?usp=sharing) para acessar o relatório.

# Implementação

O algoritmo foi implementado na linguagem Java, seguindo conceitos de orientação a objetos e utilizando bibliotecas de estruturas de dados da linguagem como `java.util.ArrayList`.
É utilizado o padrão à direita, buscando os setores realizando um movimento da esquerda para a direita.

Para comparações entre requisições randômicas e lineares e mais detalhes a respeito do funcionamento de um disco e do algoritmo, acesse o relatório do projeto.

# Utilização

Para executar o algoritmo, acesse a classe `./src/cscan/RunCSCAN.java`, modifique os parâmetros do disco e do sorteio randômico de requisições a seu critério e em seguida execute a
função `main`.

O algoritmo consegue suportar até uma faixa de 14000 setores requisitados ao mesmo tempo. Para testar, modifique os parâmetros do sorteio aleatório de requisições na classe `RunCSCAN`
(não recomendado, utilize valores menores).

> Caso a execução fique em loop infinito, muito provavelmente os valores fornecidos como parâmetros não estão corretos ou o usuário quis se aventurar com mais requisições do que o permitido.

## Saída formatada

A saída no terminal segue o modelo mostrado abaixo, exibindo as requisições sorteadas, a ordem de acesso a cada setor com base nos parâmetros de disco, a posição inicial do cabeçote
e o tempo total em milisegundos de toda a requisição.

```
Requests:
[29, 3, 0, 17, 12, 26, 11, 12, 18, 15, 35, 13, 25, 23, 10, 21, 29, 11, 19, 17]

Accessed sectors:
[35, 25, 26, 29, 29, 10, 11, 11, 0, 3, 15, 17, 17, 18, 19, 21, 23, 12, 12, 13]
Initial head position: 33
12,77 ms
```

