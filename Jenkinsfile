pipeline {
	agent any
	stages{
		stage('SCM Checkout'){
			steps{
			// Clone repo
			git 'https://github.com/prernapal13/FacebookBirthdayWishes'
			}
		}
		stage('compile'){
			steps{
			def mvnHome = tool name: 'maven_def', type: 'maven'
			sh "${mvnHome}/bin/mvn package"
			}
		}
	}
}
