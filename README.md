# Simulador de embarque

Modelo didático com avião, voo, passageiro, tripulante e bagagem. Demonstra interface, herança, enum, composição e validação antes da alteração de estado.

## Executar e testar

Requisitos: JDK 17 ou superior com `java` e `javac` disponíveis no PATH, e PowerShell. Sem bibliotecas externas.

Na pasta deste projeto:

```powershell
.\build.ps1 -Test
.\build.ps1 -Run
```

`-Test` compila fontes e testes com UTF-8, todos os avisos habilitados e avisos tratados como erro. Os testes usam um programa Java de regressão, sem depender de JUnit ou downloads. Os arquivos de teste ficam em `build/`, ignorado pelo Git.

Os parâmetros `-Test` e `-Run` também podem ser usados juntos. A pasta `src/` contém o programa e `tests/` contém as verificações. Cada pasta de projeto pode virar um repositório independente.

## Regras

- A capacidade de assentos limita a quantidade de passageiros. Tripulantes não entram nessa contagem.
- Assentos são identificadores textuais livres, como `1A`; espaços nas pontas e diferenças de maiúsculas são normalizados. Dois passageiros não podem usar o mesmo identificador. Não há mapa físico de assentos.
- O peso máximo é a soma de passageiros, tripulantes e bagagens; igualdade com o limite é permitida.
- `obterPesoBagagem()` soma somente bagagens. `obterPesoTotal()` soma todos os itens.
- Pesos e limites devem ser positivos e finitos. Nulos, tipos não suportados e o mesmo objeto embarcado duas vezes são recusados.
- Os itens são imutáveis e a lista retornada não permite modificações. Um embarque recusado não muda o voo.

`Main` mostra embarques aceitos e um assento duplicado recusado, usando dados fictícios. Os testes cobrem capacidade, assento, peso, contagem, valores inválidos e preservação do estado.

É um exercício de programação, sem regras operacionais de aviação. Origem: `prova2_daniel`.
