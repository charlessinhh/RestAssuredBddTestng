// Browser without head

pipeline {
    agent any
    
    parameters {
        choice(name: 'Browser', choices: ['chrome', 'edge'], description: 'Browser to use for testing')
    }

    stages {
        stage('git checkout') {
            steps {
                git branch: 'browser_with_headless_mode', url: 'https://github.com/charlessinhh/RestAssuredBddTestng.git'
            }
        }
        
        stage('Compile') {
            steps {
                bat "mvn clean compile"
            }
        }
        
        stage('test') {
            steps {
                bat "mvn test -DBrowser=${Browser}"
            }
        }
    }
    

    post {
        success {
            emailext (
                subject: "SUCCESS: ${env.JOB_NAME} ${env.BUILD_NUMBER}",
                body: """<p>Good news! The build was successful.</p>
                        <p>Job: ${env.JOB_NAME}</p>
                        <p>Build Number: ${env.BUILD_NUMBER}</p>
                        <p>Check console output at ${env.BUILD_URL} to view the results.</p>""",
                to: 'emailsetupjenkins@gmail.com',
                attachLog: true
            )
        }
        failure {
            emailext (
                subject: "FAILURE: ${env.JOB_NAME} ${env.BUILD_NUMBER}",
                body: """<p>Unfortunately, the build failed.</p>
                        <p>Job: ${env.JOB_NAME}</p>
                        <p>Build Number: ${env.BUILD_NUMBER}</p>
                        <p>Check console output at ${env.BUILD_URL} to view the results and take necessary actions.</p>""",
                to: 'emailsetupjenkins@gmail.com',
                attachLog: true
            )
        }
    }

    
    
}
