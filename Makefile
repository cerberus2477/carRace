

SOURCES=CarRace.java \
	view/Car.java \
	view/MainWindow.java \
	view/Track.java \
	view/ButtonPanel.java \
	view/DisplayPanel.java \
	controller/Controller.java

all:
	javac $(SOURCES)

CLASSES=CarRace.class \
	view/*.class \
	controller/*.class

JARFILE=CarRace.jar
MANIFEST=manifest.mf

jar:
	jar cvfm $(JARFILE) $(MANIFEST) $(CLASSES)

run:
	java -jar $(JARFILE)

clean:
	find . -name "*.class" -exec rm -f {} \;