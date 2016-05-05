# gestor-emprestimo
Sistema de gerenciamento de empréstimo

O sistema possui dois tipos de usuário o administrador e o usuário comum. O administrador pode alterar as 
informações de todas as tabelas(exceto a navegacao que ficará registrado todas as navegações no sistema), o usuário 
comum poderá alterar as informações somente da tabela

COMPONENTES UTILIZADOS
 - dialog
 - datatable
 - inputMask
 - inputText
 - calendar
 - selectOneMenu
 - outputlabel
 - panelgrid
 - panelgroup
 - layout, layoutunit
 - messages, growl
 - confirmDIalog
 - commandButton
 
BIBLIOTECAS
 - Primefaces
 - Omnifaces(conversor de objetos)
 - EclipseLink e EclipsePersistence JPA (Persistencia ao Banco)
 - Servidor Glassfish Caminho mais fácil de configuração
 - Mysql
 - JSF

Nota de execução: Para executar apenas alterar as configurações em Paginas Web/WEB-ING/glassfish-resources.xml
nas linhas:
	<property name="serverName" value="endereço servidor"/> <-- endereço IP
        <property name="portNumber" value="porta"/> <-- Porta

        <property name="User" value="root"/> <-- Usuário
        <property name="Password" value="olliver89632"/> <-- Senha
        <property name="URL" value="jdbc:mysql://localhost:3306/emprestimo"/> <-- URL
	
Na primeira execução deverá existir o banco "emprestimo" no MysqlServer com isso o JPA já fará a criação das tabelas
e a inserção dos dados iniciais desde que não haja erros nas configurações ditas acima.

ALUNOS:
FERNANDO HENRIQUE SANTOS SOUZA
KETELEM LEMES DE CAMPOS
DANIEL PRADO
