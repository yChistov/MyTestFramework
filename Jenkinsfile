pipeline {
	agent any

	stages {
		stage("Build") {
			steps {
				sh "mvn -version"
				sh "mvn clean install -Dbrowser=chrome -Denvironment=docker"
			}
		}
	}

	post {
		always {
			cleanWs()
		}
	}
}