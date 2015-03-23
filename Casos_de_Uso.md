|<a href='http://code.google.com/p/icards/'>Home</a> |<a href='http://code.google.com/p/icards/wiki/Equipe_do_Sistema'>Equipe</a> |<a href='http://code.google.com/p/icards/wiki/Descricao_do_Sistema'>Descrição do Sistema</a>|<a href='http://code.google.com/p/icards/wiki/Requisitos'>Requisitos</a>| **Casos de Uso** |<a href='http://code.google.com/p/icards/wiki/Diagramas'>Diagramas</a>|<a href='http://code.google.com/p/icards/wiki/Links'>Links</a>|
|:---------------------------------------------------|:---------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------|:-----------------------------------------------------------------------|:-----------------|:---------------------------------------------------------------------|:-------------------------------------------------------------|

# Especificação de Casos de Uso #

Um caso de uso representa uma parte discreta da interação entre um usuário (humano ou máquina) e o sistema. Cada caso de uso tem uma descrição a qual descreve sua funcionalidade.


---


## UC01 - Cadastrar Cliente ##

| **Objetivo** | Cadastrar cliente. |
|:-------------|:-------------------|
| **Descrição** | Uma pessoa interessada em adquirir o serviço iCards deverá fazer o cadastro para ter uma conta de usuário. |
| **Ator** | Administrador. |
| **Prioridade** | Alta. |
| **Pré-condição** | Definir tipo de usuário. O sistema deve estar em condições para executar esta função. |
| **Pós-condições** | O usuário será cadastrado com sucesso. |

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 - No cadastro, o usuário solicitante do serviço, deverá fornecer as seguintes informações: Nome,Data de Nascimento, CPF, Email, Nacionalidade,Endereço, Telefone, Senha, Tipo de Usuário(dependendo do tipo, deverá fornecer o CPF do Dependente) e senha. |

| **Fluxos alternativos** |
|:------------------------|
| 1.1 - Se ao tentar cadastrar e algum campo estiver vazio, o sistema retornará a seguinte mensagem: "<i><b>Existem campos vazios.</b></i>"|



---


## UC02 - Login Usuário ##

| **Objetivo** | Ter acesso ao sistema. |
|:-------------|:-----------------------|
| **Descrição** | O Usuário deverá entrar com o número do iCard ,com a senha e selecionar o tipo de Usuário, para ter acesso as informações restritas de acordo com o tipo do usuário. |
| **Ator** | Titular ou Dependente. |
| **Prioridade** | Alta. |
| **Pré-condição** | O Usuário deverá ter cadastro. (UC01) |
| **Pós-condições** |O Usuário tem acesso ao sistema.|

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 – Se o usuário número da conta e a senha estiverem corretos, possuirá o controle da conta. |
| **Fluxos alternativos** |
| 1.1 – Se o usuário número da conta e/ou a senha estiverem errados, o sistema retornará o seguinte erro: "<i><b>Erro ao digitar número do cartão ou senha.</b></i>"|


---


## UC03 - Visualizar Histórico e Saldo ##

| **Objetivo** | Visualizar crédito e histórico de compras. |
|:-------------|:---------------------------------------------|
| **Descrição** | Após o acesso ao sistema (UC02), o usuário poderá visualizar informações como o histórico de suas compras (lugar da compra, data, e valor da compra)e o saldo de crédito referente a conta de usuário. |
| **Ator** | Titular ou Dependente. |
| **Prioridade** | Média. |
| **Pré-condição** | O Usuário deve ter acesso ao sistema. (UC02)  |
| **Pós-condições** | O usuário terá acesso ao histórico das compras e ao saldo de crédito. |

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 - Ao acessar a sua conta o usuário terá acesso a todas as informações de compras referentes à conta de usuário, como lugar onde a compra foi realizada, data, horário e valor da compra.|



---


## UC04 - Alterar Senha ##

| **Objetivo** | Alterar a senha de usuário. |
|:-------------|:-----------------------------|
| **Descrição** |Caso o usuário sinta a necessidade de mudar a senha ele terá a opção (UC04).  |
| **Ator** | Titular. |
| **Prioridade** | Média. |
| **Pré-condição** | O Usuário deve ter acesso ao sistema. (UC02) |
| **Pós-condições** | Terá alterado a senha de usuário. |

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 - Ao acessar o sistema como Titular, o usuário poderá clicar no botão "Alterar senha" para alterar sua senha de acesso ao sistema. Deverá informar senha atual e nova senha. |

| **Fluxos alternativos** |
|:------------------------|
| 1.1 Ao digitar a senha atual e depois tentar concluir a alteração, se ela não estiver correta o sistema retornará a mensagem de erro: "<i><b>Senha incorreta.</b></i>"  |


---


## UC05 - Bloquear cartão ##

| **Objetivo** | Bloquear o cartão para qualquer atividade de movimento de dinheiro. |
|:-------------|:---------------------------------------------------------------------|
| **Descrição** | O Titular bloqueia o uso do cartão através da senha de acesso total.|
| **Ator** | Titular. |
| **Prioridade** | Alta. |
| **Pré-condição** | O Usuário deve ter acesso ao sistema. (UC02) |
| **Pós-condições** | O uso do cartão estará bloqueado. |

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 - Ao acessar o sistema, o Titular tem a opção de bloquear o cartão através de botão na tela. |

| **Fluxos alternativos** |
|:------------------------|
| 1.1 - Se o Dependente tiver acesso ao sistema, a opção de bloquear cartão será desabilitada.|



---



## UC06 - Imprimir extrato ##

| **Objetivo** | Imprimir arquivo com informações da conta.  |
|:-------------|:----------------------------------------------|
| **Descrição** | O sistema gerará um arquivo .PDF com informações de Histórico de Compras e Saldo. Além de visualizar o cliente poderá imprimir. |
| **Ator** | Titular ou Dependente. |
| **Prioridade** | Média. |
| **Pré-condição** | O Usuário deve ter acesso ao sistema.(UC02) |
| **Pós-condições** | O sistema gerará arquivo .PDF com informações sobre a conta e poderá imprimi-lo. |

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 - O cliente selecionará o item "Gerar Extrato", e o sistema gerará o arquivo .PDF com as últimas informações de saldo e histórico de compras da conta.|



---



## UC07 - Adicionar Crédito ##

| **Objetivo** | Adicionar crédito a alguma conta. |
|:-------------|:-----------------------------------|
| **Descrição** | O sistema permite que qualquer pessoa adicione crédito a alguma conta, através no número da conta da mesma. |
| **Ator** | Terceiros. |
| **Prioridade** | Alta. |
| **Pré-condição** | Ter o número da conta de algum usuário validado. |
| **Pós-condições** | Após a transação, o crédito será depositado na conta do usuário correspondente ao número da conta. |

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 - Um usuário sem estar logado no sistema poderá adicionar crédito a conta de algum usuário informando o valor do crédito e o número da conta/cartão e a sua identificação.|

| **Fluxos alternativos** |
|:------------------------|
| 1.1 Ao tentar adicionar crédito a alguma conta, se o número da conta do usuário não existir o sistema retornará a mensagem de erro: "<i><b>Número de conta de usuário não existente.</b></i>" |



---



## UC08 - Cadastrar Cartão ##

| **Objetivo** | Cadastrar um novo cartão.  |
|:-------------|:----------------------------|
| **Descrição** | O administrador cadastra um novo cartão para ser disponível para um cliente cadastrado. |
| **Ator** | Administrador. |
| **Prioridade** | Alta. |
| **Pré-condição** | O sistema deve estar em condições para executar esta função. |
| **Pós-condições** | Informações cadastradas com sucesso. |

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 - Ao cadastrar, o Administrador digita um novo ID Cartão e uma senha.|

| **Fluxos alternativos** |
|:------------------------|
| 1.1 - Se ao tentar cadastrar um novo cartão e o ID Cartão digitado já for existente, o sistema retornará a mensagem de erro: "<i><b>ID Cartão já cadastrado.</b></i>"|



---



## UC09 - Cadastrar estabelecimento ##

| **Objetivo** | Cadastrar estabelecimento. |
|:-------------|:---------------------------|
| **Descrição** | O administrador deverá fazer o cadastro de estabelecimento para então fazer cadastro de usuário. |
| **Ator** | Administrador. |
| **Prioridade** | Média. |
| **Pré-condição** | O sistema deve estar em condições para executar esta função. |
| **Pós-condições** | O estabelecimento será cadastrado com sucesso, UC02. |


## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 - No cadastro, o administrador deverá fornecer as seguintes informações: Nome do estabelecimento, CNPJ , Endereço e Telefone. |

| **Fluxos alternativos** |
|:------------------------|
| 1.1 - Se ao tentar cadastrar estabelecimento e algum campo estiver vazio, o sistema retornará a seguinte mensagem: "<i><b>Existem campos vazios.</b></i>"|



---



## UC010 - Login Estabelecimento ##

| **Objetivo** | O estabelecimento ter acesso ao sistema. |
|:-------------|:-----------------------------------------|
| **Descrição** | O funcionário do estabelecimento deverá entrar com o número do CNPJ e com a senha para ter acesso as informações do estabelecimento |
| **Ator** | Estabelecimento(Funcionário) |
| **Prioridade** | Alta. |
| **Pré-condição** | O estabelecimento deverá ter cadastro. (UC09) |
| **Pós-condições** |O estabelecimento tem acesso ao sistema.|

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 – Se o CNPJ e a senha digitados estiverem corretos, possuirá o controle da conta. |
| **Fluxos alternativos** |
| 1.1 – Se o CNPJ  do estabelecimento e/ou a senha estiverem errados, o sistema retornará o seguinte erro: "<i><b>Erro ao digitar CNPJ ou senha.</b></i>"|



---



## UC011 - Debitar ##

| **Objetivo** | Debitar crédito do cartão quando o pagamento for solicitado. |
|:-------------|:---------------------------------------------------------------|
| **Descrição** | Quando a compra através do cartão for feita e o saldo for verificado como positivo, o pagamento é debitado da conta. |
| **Ator** | Vendedor. |
| **Prioridade** | Alta. |
| **Pré-condição** | Definir tipo de usuário, O sistema deve estar em condições para executar esta função. Verificar se há saldo suficiente disponível na conta. |
| **Pós-condições** | O pagamento e o débito serão realizados. |

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 - O usuário fez a solicitação de pagamento, o sistema verifica o crédito e, se positivo, debita a quantia referente da conta. |

| **Fluxos alternativos** |
|:------------------------|
| 1.1 - Ao verificar, o saldo ser insuficiente e retornar valor negativo, impossibilitando o débito. Retornando o erro: "<i><b>Você não possui saldo suficiente para a operação. Por favor, recarregue seu cartão.</b></i>" |



---



## UC012 - Visualizar Receita Total ##

| **Objetivo** |Mostra as informações de receita. |
|:-------------|:-----------------------------------|
| **Descrição** | Ao acessar o sistema, o estabelecimento terá a informação de receita total. |
| **Ator** | Estabelecimento |
| **Prioridade** | Média. |
| **Pré-condição** | Ter acesso ao sistema. |
| **Pós-condições** | Informação de receita total visualizada. |

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 - Ao efetuar login, o sistema exibira informações de receita total do estabelecimento.|



---



## UC013 - Deletar Cliente ##

| **Objetivo** | Excluir dados cadastrais de um cliente. |
|:-------------|:----------------------------------------|
| **Descrição** | O solicitante do serviço poderá cancelar o serviço. |
| **Ator** | Administrador. |
| **Prioridade** | Média. |
| **Pré-condição** | O cliente deve possuir um cadastro. |
| **Pós-condições** | Os dados cadastrais do cliente são excluídos com sucesso. |

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 - Ao excluir, o Administrador acessa as informações do cliente e cancela a conta do mesmo a través do CPF. Todos os dados serão excluídos.|

| **Fluxos alternativos** |
|:------------------------|
| 1.1 - Se ao tentar excluir as informações do cliente informando o CPF incorreto, o sistema retornará a mensagem de erro: "<i><b>CPF inválido.</b></i>"|



---



## UC14 - Deletar Cartão ##

| **Objetivo** | Excluir informações referentes a um cartão cadastrado.  |
|:-------------|:-----------------------------------------------------------|
| **Descrição** | O administrador exclui informações referentes a um cartão cadastrado. |
| **Ator** | Administrador. |
| **Prioridade** | Média. |
| **Pré-condição** | Cartão cadastrado. |
| **Pós-condições** | Informações cadastradas excluídas com sucesso. |

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 - Ao excluir, o Administrador digita o ID Cartão referente ao cartão e cancela a existência do mesmo. Todos os dados serão excluídos.|

| **Fluxos alternativos** |
|:------------------------|
| 1.1 - Se ao tentar excluir as informações do cartão informando, e o ID Cartão digitado não existir,o sistema retornará a mensagem de erro: "<i><b>ID Cartão inválido.</b></i>"|



---



## UC015 - Deletar estabelecimento ##

| **Objetivo** | Excluir informações referentes a um estabelecimento cadastrado.  |
|:-------------|:-------------------------------------------------------------------|
| **Descrição** | O administrador exclui informações referentes a um estabelecimento cadastrado. |
| **Ator** | Administrador. |
| **Prioridade** | Média. |
| **Pré-condição** | Estabelecimento cadastrado. |
| **Pós-condições** | Informações cadastradas excluídas com sucesso. |

## Cenários principais de sucesso ##

| **Usuário** |
|:-------------|
| 1 - Ao excluir, o Administrador digita o CNPJ referente ao estabelecimento e cancela a existência do mesmo. Todos os dados serão excluídos.|

| **Fluxos alternativos** |
|:------------------------|
| 1.1 - Se ao tentar excluir as informações do estabelecimento informando, e o CNPJ digitado não existir,o sistema retornará a mensagem de erro: "<i><b>CNPJ inválido.</b></i>"|



---
