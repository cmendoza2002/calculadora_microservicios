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
     }
}