pipeline{

agent any
 stages{
      stage(Get Source Code){
      steps{
      
         git'https://github.com/Avanishsingh879/Maven_BDD_Automation.git'
                echo 'Hello World''
      }
      }
      stage('Build code'){
      steps{
      
         bat script:'mvn complie'
      }
      }
      
      stage('Run Test'){
      steps{
       
         bat script: 'mvn test -Dbrowser=localchrome'
      
      }
      }
      
      stage('Publish Report'){
      steps{
      
      allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
      }
      }
      
      stage('Email Notification'){
      steps{
      
      steps{
                
               mail bcc: '', body: '''Hi Welcome to Jenkins Email Alerts

Thanks
Avanish''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'avanishsinghqa1@gmail.com'
      
      }
      }
 
 }
}



