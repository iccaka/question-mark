(cd question-mark-ui/question-mark/src/app && ng build --prod)
cd question-mark-backend && mvn clean install
cd target && java -jar question-mark-backend-0.0.1-SNAPSHOT.jar
