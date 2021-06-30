pipeline {
	agent any

	stages {
		stage("Build") {
		    steps {
			    withMaven(maven: 'mvn') {
				    sh "mvn clean install ${browser} ${environment}"
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