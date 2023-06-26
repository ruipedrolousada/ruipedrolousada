pessoas= source/Pessoas/Pessoa.java \
	source/Pessoas/Cliente.java \
	source/Pessoas/Gestor.java \
	source/Pessoas/FuncionarioBalcao.java \
	source/Pessoas/FuncionarioReparacao.java \
	source/Pessoas/ReadLoadPessoas.java\
	source/Pessoas/ReadLoadClientes.java\

phases= source/Menu/Phases/Phase.java \
	source/Menu/Phases/Phase1.java \
	source/Menu/Phases/Phase2.java \
	source/Menu/Phases/Phase3.java \
	source/Menu/Phases/Phase4.java\
	source/Menu/Phases/Phase5.java\
	source/Menu/Phases/Phase6.java\
	source/Menu/Phases/Phase7.java\
	source/Menu/Phases/Phase8.java\
	source/Menu/Phases/Phase9.java\
	source/Menu/Phases/Phase10.java\
	source/Menu/Phases/Phase11.java\


pedidos= source/Pedido/Pedido.java \
	source/Pedido/Plano.java \
	source/Pedido/PlanoExpress.java \
	source/Pedido/ReadLoadPedidos.java\
	source/Pedido/ReadLoadPedidosFinalizados.java\

default:
	javac -d . \
	$(pessoas) \
	$(pedidos) \
	$(phases) \
	source/Controller.java \
	source/Menu/ShowMenu.java \
	source/Menu/Interpreter.java \
	source/Main.java
clean:
	rm bin/*.class
app:
	java bin.Main
# Esta linha é necessario pois ao adicionar argumentos extra na make
# Não queremos que eles sejam executados
%:
	@: