# Run it from root directory
# Run the script: <pwsh run_project.ps1>

Push-Location -Path "question-mark-ui/question-mark/src/app"
ng build
Pop-Location
mvn clean install
Push-Location -Path "question-mark-backend/target"
java -jar question-mark-backend-0.0.1-SNAPSHOT.jar
Pop-Location