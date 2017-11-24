![Cabecalho](../../ReadMe-Anexos/Cabecalho.png)

[Home](../../ReadMe.md) :: [Módulo Financeiro](../Modulo-Financeiro.md) :: [FU-Consulta Lançamentos](FU-Consulta-Lancamentos.md)


# Funcionalidade: Consulta Lançamentos

## Descrição

Consulta de Lançamento de Contas Mensais.

## Funcionalidades Impactadas

| Funcionalidade | Descrição |
|----------------|-----------|
| N.H.           | N.H.      |

## Regras de Negócios

| Regra de Negócios | Descrição |
|-------------------|-----------|
| N.H.              | N.H.      |

## Casos de Uso

**NOTA AO DESENVOLVEDOR:** No momento, este projeto não possui interfaces gráficas com interação entre atores e sistema. Sendo assim, ainda não possui casos de uso especificados.

## Web Services

**[WSDL](Web-Services/WSDL.md)**

| Web Service                                                                                  | Descrição                                                  |
|----------------------------------------------------------------------------------------------|------------------------------------------------------------|
| [WS-Pesquisar Lancamentos por Período](Web-Services/WS-Pesquisar-Lancamentos-Por-Periodo.md) | Pesquisa de lançamentos por período de tempo (dia/mês/ano) |
| [WS-Pesquisar Lancamentos por Nome](Web-Services/WS-Pesquisar-Lancamentos-Por-Nome.md)       | Pesquisa de lançamentos por parte do nome do lançamento    |
| [WS-Pesquisar Lancamentos por Tipo](Web-Services/WS-Pesquisar-Lancamentos-Por-Tipo.md)       | Pesquisa de lançamentos por tipo de lançamento             |


## Estrutura de Classes

**NOTA AO DESENVOLVEDOR:** Coloque aqui as classes relacionadas a funcionalidade, ordenadas alfabeticamente de A->Z pelo nome da classe

| Pacote                                  | Classe             | Descrição                                                                                    |
|-----------------------------------------|--------------------|----------------------------------------------------------------------------------------------|
| br.com.logic.trilhajeesql.DAO           | ConexaoDAO         | Classe responsável pela conexão com a base de dados                                          |
| br.com.logic.trilhajeesql.DAO           | LancamentoDAO      | Classe responsável pela manipulação de dados na base de dados                                |
| br.com.logic.trilhajeesql.EJB.Bean      | LancamentoBean     | Classe responsável pela gerência das regras de negócio e controle dos métodos do projeto     |
| br.com.logic.trilhajeesql.EJB.Interface | LancamentoLocal    | Classe Interface responsável pelos métodos de controle do projeto                            |
| br.com.logic.trilhajeesql.Model         | Lancamento         | Classe responsável pelo modelo de negócio dos lançamentos de contas                          |
| br.com.logic.trilhajeesql.Model         | TipoLancamentoEnum | Classe responsável por classificar o tipo de operação do lançamento de contas                |
| br.com.logic.trilhajeesql.UTIL          | LancamentoUtil     | Classe abstrata responsável pelos métodos de validação das operações de lançamento de contas |

**NOTA AO DESENVOLVEDOR:** Preencha o diagrama abaixo com especificação das classes da funcionalidade e seus relacionamentos. Devem ser informados todos os elementos da classe: seus atributos e métodos publicos, privados e estáticos. Bem como seus relacionamentos com outras classes.

_Diagrama UML: [UML-Classes-Consulta-Lancamentos.asta](FU-Consulta-Lancamentos-Anexos/UML-Classes-Consulta-Lancamentos.asta)_

## Estrutura de Entidades

**NOTA AO DESENVOLVEDOR:** É fornecida abaixo a especificação da entidades, atributos e seus relacionamentos, não sendo necessário evolução pelo desenvolvedor.

| Banco/Schema   | Entidade       | Descrição                                               |
|----------------|----------------|---------------------------------------------------------|
| sistema/public | Lancamento     | Despesas Mensais Lançadas                               |
| sistema/public | TipoLancamento | Normalização dos Tipo de Lançamento para Contas Mensais |

_Diagrama DER: [DER-Consulta-Lancamentos.asta](FU-Consulta-Lancamentos-Anexos/DER-Consulta-Lancamentos.asta)_

## Diagramas Técnicos Opcionais

**NOTA AO DESENVOLVEDOR:** Se o desenv entender como necessário, pode sem criados diagramas técnicos especificando algum comportamento ou característica da funcionaldiade

| Diagrama           | Descrição             |
|--------------------|-----------------------|
| Link-para-Diagrama | Descrição do diagrama |

## Cenários de Teste Manuais

**NOTA AO DESENVOLVEDOR:** No momento, este projeto não possui interfaces gráficas com interação entre atores e sistema. Sendo assim, ainda não possui cenários de teste manuais.

## Cenários de Teste Automáticos

| Classe / Teste                                                                  | Descrição                                                                                                                         |
|---------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| CL-ConexaoTest-testConexaoBD                                                    | Teste que realiza a validação da conexão com a base de dados                                                                      |
| CL-LancamentoBeanAlterarTest-testAlterarLancamentoErroData                      | Teste que identifica Erro quando a data foi informada incorretamente                                                              |
| CL-LancamentoBeanAlterarTest-testAlterarLancamentoErroNome                      | Teste que identifica Erro quando o nome foi informado incorretamente                                                              |
| CL-LancamentoBeanAlterarTest-testAlterarLancamentoErroTipo                      | Teste que identifica Erro quando o tipo de lançamento foi informado incorretamente                                                |
| CL-LancamentoBeanAlterarTest-testAlterarLancamentoErroValor                     | Teste que identifica Erro quando o valor foi informado incorretamente                                                             |
| CL-LancamentoBeanAlterarTest-testAlterarLancamentoIdInvalido                    | Teste que identifica Erro quando o Id do lançamento informado é inexistente na base de dados                                      |
| CL-LancamentoBeanAlterarTest-testAlterarLancamentoSucesso                       | Teste que valida a alteração de lançamento                                                                                        |
| CL-LancamentoBeanConsultarTest-testConsultarLancamentoPorData                   | Teste que realiza a validação da consulta de lançamento de contas filtrados por data                                              |
| CL-LancamentoBeanConsultarTest-testConsultarLancamentoPorDataInvalida           | Teste que identifica Erro quando a data informada tem o formato invalido                                                          |
| CL-LancamentoBeanConsultarTest-testConsultarLancamentoPorNome                   | Teste que realiza a validação da consulta de lançamento de contas filtrados por nome                                              |
| CL-LancamentoBeanConsultarTest-testConsultarLancamentoPorNomeInvalido           | Teste que identifica Erro quando o nome informado tem o formato inválido                                                          |
| CL-LancamentoBeanConsultarTest-testConsultarLancamentoPorTipoLancamento         | Teste que realiza a validação da consulta de lançamento de contas filtrados por Tipo de Lançamento                                |
| CL-LancamentoBeanConsultarTest-testConsultarLancamentoPorTipoLancamentoInvalido | Teste que identifica Erro quando o Tipo de Lançamento informado é inválido                                                        |
| CL-LancamentoBeanConsultarTest-testConsultarLancamentoSemRegistro               | Teste que identifica Erro quando não há registros retornados na Consulta                                                          |
| CL-LancamentoBeanExcluirTest-testExcluirLancamentoIdInvalido                    | Teste que identifica Erro quando o id informado é inválido na exclusão de Lançamento de contas                                    |
| CL-LancamentoBeanExcluirTest-testExcluirLancamentoSucesso                       | Teste que realiza a validação da exclusão de Lançamento de contas da base de dados                                                |
| CL-LancamentoBeanInserirTest-testInserirLancamentoInserirErroData               | Teste que identifica erro quando a data informada tem o formato inválido na inserção de Lançamento de contas na base de dados     |
| CL-LancamentoBeanInserirTest-testInserirLancamentoInserirErroNome               | Teste que identifica erro quando nome informado tem o formato inválido na inserção de Lançamento de contas na base de dados       |
| CL-LancamentoBeanInserirTest-testInserirLancamentoInserirErroTipo               | Teste que identifica erro quando tipo de Lançamento informado tem é inválido na inserção de Lançamento de contas na base de dados |
| CL-LancamentoBeanInserirTest-testInserirLancamentoInserirErroValor              | Teste que identifica erro quando o valor informado tem o formato inválido na inserção de Lançamento de contas na base de dados    |
| CL-LancamentoBeanInserirTest-testInserirLancamentoInserirSucesso                | Teste que realiza a validação da inserção de Lançamento de Contas na base de dados                                                |



_[Sobre o Portal de Documentação](../../About/About.md)_


![Rodape](../../ReadMe-Anexos/Rodape.png)
