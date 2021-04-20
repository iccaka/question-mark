# Run it from root directory
# Run the script: <pwsh build_all_files.ps1>

Push-Location -Path "question-mark-ui/question-mark/src/app"
ng build --prod
Pop-Location
mvn clean install
Push-Location -Path "question-mark-backend/target"
java -jar question-mark-backend-0.0.1-SNAPSHOT.jar
Pop-Location