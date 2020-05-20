JFLAGS = -g
JC = javac
JVM = java
.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES =\
	Graphviz/Grafos.java\
	ArbolB/ArbolB.java\
	ArbolB/ControladorArbolB.java\
	ArbolB/Nodo.java\
	ArbolB/Split.java\
	Entrada/ManejadorEntrada.java\
	Grafos/Camino.java\
	Grafos/ControladorDeRutas.java\
	Grafos/ControladorGrafos.java\
	Grafos/Ruta.java\
	Grafos/Ubicacion.java\
	Grafos/Camino.java\
	ui/InfoRuta.java\
	ui/MenuPrincipal.java\
	GPS.java
	
	
MAIN =GPS

default: classes\
	run
	
classes:	$(CLASSES:.java=.class)


run:$(MAIN).class
	$(JVM) $(MAIN)
clean:
	$(RM) *.class
