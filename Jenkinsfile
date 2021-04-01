pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        build(job: 'test', quietPeriod: 2, wait: true)
      }
    }

  }
}