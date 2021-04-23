(cd question-mark-ui/question-mark/src/app && ng build)
mvn clean install
cd question-mark-backend/target && java -jar question-mark-backend-0.0.1-SNAPSHOT.jar
