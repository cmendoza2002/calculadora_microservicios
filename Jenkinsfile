pipeline {
     agent any
     stages {
          stage("Checkout") {
               steps {
                    git url: 'https://github.com/cmendoza2002/calculadora_microservicios.git'
               }
          }

          stage("Compile") {
               steps {
                    sh "./gradlew compileJava"
               }
          }

          stage("Unit test") {
               steps {
                    sh "./gradlew test"
               }
          }

          stage("Code Analisis") {
               steps {
                    sh "./gradlew -Dsonar.host.url=http://192.168.7.126:9001 -Dsonar.login=admin  -Dsonar.password=admin sonarqube"
               }
          }
     }
}