pipeline {
	agent any

	stages {
		stage("Build") {
			steps {
				sh "mvn clean install ${browser} ${environment}"
			}
		}
	}

	post {
		always {
			cleanWs()
		}
	}
}