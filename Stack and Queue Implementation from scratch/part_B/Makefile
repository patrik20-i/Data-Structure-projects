all:
	javac -d ../classes/ -cp ../classes/ EmptyStackException.java
	javac -d ../classes/ -cp ../classes/ StackInterface.java
	javac -d ../classes/ -cp ../classes/ Stack.java
	javac -d ../classes/ -cp ../classes/ StackTester.java
	javac -d ../classes/ -cp ../classes/ FabricBreakup.java
	java -cp ../classes/ FabricBreakup sampleInputFile.txt > myoutfile.txt
	java -cp ../classes/ StackTester

clean:
	rm ../classes/EmptyStackException.class ../classes/StackInterface.class ../classes/Stack.class ../classes/StackTester.class ../classes/FabricBreakup.class
