cd ./alguma-lexico
mvn clean package
java -jar ../compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar  "java -jar ./target/alguma-lexico-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc ../temp/ ../test_cases "804071, 791085" t1