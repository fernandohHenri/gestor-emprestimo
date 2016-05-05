# gestor-emprestimo
Sistema de gerenciamento de empréstimo

	O sistema possui dois tipos de usuário o administrador e o usuário comum. O administrador pode alterar as 
informações de todas as tabelas(exceto a navegacao que ficará registrado todas as navegações no sistema), o usuário 
comum poderá alterar as informações somente da tabela

COMPONENTES
 - dialog
 - datatable
 - inputMask
 - inputText
 
Bibliotecas
 - Primefaces
 - Omnifaces(conversor de objetos)
 - EclipseLink e EclipsePersistence JPA (Persistencia ao Banco)
 - Servidor Glassfish Caminho mais fácil de configuração

Nota de execução: Para executar apenas alterar as configurações em Paginas Web/WEB-ING/glassfish-resources.xml
nas linhas:
	<property name="serverName" value="endereço servidor"/> <-- endereço IP
        <property name="portNumber" value="porta"/> <-- Porta

        <property name="User" value="root"/> <-- Usuário
        <property name="Password" value="olliver89632"/> <-- Senha
        <property name="URL" value="jdbc:mysql://localhost:3306/emprestimo"/> <-- URL
	
No banco apenas
