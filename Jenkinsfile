pipeline {
	agent any
        tools {
            jdk "11"
        }
	stages {
		stage("Build") {
		    tools {
                jdk "jdk-11.0.1"
            }
		    steps {
		        sh 'java -version'
			    withMaven(maven: 'mvn') {
				    sh "mvn clean install -Dbrowser=${browser} -Denvironment=${environment}"
			    }
		    }
		}
	}

	post {
		always {
			cleanWs()
		}
	}
}