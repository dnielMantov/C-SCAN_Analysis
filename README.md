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

Para comparações com entradas lineares, mudanças nas características do disco e mais detalhes a respeito do algoritmo e da implementação, acesse o relatório do projeto.

# Utilização

Para executar o algoritmo, acesse a classe `./src/cscan/RunCSCAN.java`, modifique os parâmetros do disco e do sorteio randômico de requisições a seu critério e em seguida execute a
função `main`.

O algoritmo consegue suportar até uma faixa de 14000 setores requisitados ao mesmo tempo. Para testar, modifique o parâmetro `int number` na classe `RunCSCAN` para esse valor
(não recomendado, utilize valores menores).

> Caso a execução fique em loop infinito, muito provavelmente os valores fornecidos como parâmetros não estão corretos ou o usuário quis se aventurar com mais requisições do que permitido.

## Saída formatada

A saída no terminal segue o modelo mostrado abaixo, exibindo as requisições sorteadas, a ordem de acesso a cada setor com base nos parâmetros de disco e o tempo total em milisegundos
de toda a requisição.

```
Requests:
[20, 14, 30, 1, 21, 15, 8, 11, 35, 13, 16, 15, 16, 27, 16, 3, 20, 34, 7, 26]

Accessed sectors:
[21, 13, 14, 15, 15, 16, 16, 16, 20, 20, 34, 35, 26, 27, 30, 7, 8, 11, 1, 3]
13,1 ms
```

