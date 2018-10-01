
all: compile

compile: stackMachine/parser/StkmScanner.java stackMachine/Main.java
	javac -cp . stackMachine/Main.java
	

stackMachine/parser/StkmScanner.java: stackMachine/parser/stkm.flex
	java -jar JFlex.jar --nobak stackMachine/parser/stkm.flex

	
compileAll: 
	find . -name '*.java' > slist.txt
	javac -cp .:beaver-rt-0.9.11.jar @slist.txt
	rm -f slist.txt


cleanclass: 
	find -name "*.class" -delete
	
cleanParser: 
	rm -f  stackMachine/parser/StkmScanner.java

clean: cleanclass cleanParser


dist: compile
	jar cfm stackVM.jar Manifest.txt .
	
