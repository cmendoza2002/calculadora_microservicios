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

          stage("Docker Build Images") {
             steps {
                sh " ./gradlew dockerBuildImage"
             }
          }

          stage("Docker Push Images") {
             steps {
               sh "cat password_registry.txt | docker login --username developer --password-stdin registry.reinventarlarueda.com:8123"
               sh "docker push registry.reinventarlarueda.com:8123/discovery:0.01"
               sh "docker push registry.reinventarlarueda.com:8123/suma-service:0.01"
               sh "docker push registry.reinventarlarueda.com:8123/resta-service:0.01"
               sh "docker push registry.reinventarlarueda.com:8123/mult-service:0.01"
               sh "docker push registry.reinventarlarueda.com:8123/gateway:0.01"
               sh "docker push registry.reinventarlarueda.com:8123/evluador:0.01"
               sh "docker push registry.reinventarlarueda.com:8123/config-server:0.01 "
             }
          }
     }
}