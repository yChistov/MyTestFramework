pipeline {
	agent any

	stages {
		stage("Build") {
		    steps {
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