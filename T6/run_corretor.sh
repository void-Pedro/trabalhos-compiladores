cd ./curriculo-gen
mvn clean package
java -jar .\target\curriculo-gen-1.0-SNAPSHOT-jar-with-dependencies.jar ..\teste\curriculo.txt ..\teste\saida.pdf
