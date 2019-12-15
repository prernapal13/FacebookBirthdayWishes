pipeline {
   stage('SCM Checkout'){
    // Clone repo
	git 'https://github.com/prernapal13/FacebookBirthdayWishes'
	}
  stage('compile'){
	def mvnHome = tool name: 'maven_def', type: 'maven'
	  sh "${mvnHome}/bin/mvn package"
	}
}
