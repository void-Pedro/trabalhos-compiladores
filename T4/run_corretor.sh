cd ./alguma-semantico
mvn clean package
java -jar ../corretor/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar  "java -jar ./target/alguma-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc ../corretor/temp/ ../corretor/casos-de-teste/ "804071, 791085" t4
