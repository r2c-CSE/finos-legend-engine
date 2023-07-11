pipeline {
  agent any
    environment {
      // The following variable is required for a Semgrep Cloud Platform-connected scan:
      SEMGREP_APP_TOKEN = credentials('SEMGREP_APP_TOKEN')
      SEMGREP_BASELINE_REF = "origin/main"
      SEMGREP_BRANCH = "${BRANCH_NAME}"
      SEMGREP_COMMIT = "${GIT_COMMIT}"
      SEMGREP_REPO_URL = env.GIT_URL.replaceFirst(/^(.*).git$/,'$1')
      SEMGREP_REPO_NAME = env.GIT_URL.replaceFirst(/^https:\/\/github.com\/(.*).git$/, '$1')
      SEMGREP_PR_ID = "${env.CHANGE_ID}"
    }
    stages {

      stage ('Generate-LockFile') {
        steps {
            withMaven(maven: 'maven') {
              sh "mvn dependency:tree -DoutputFile=maven_dep_tree.txt"
            }
        }
      }
      
      stage('Semgrep-Scan') {
        steps {
                script {
                    if (env.GIT_BRANCH == 'main') {
                          sh '''docker pull returntocorp/semgrep && \
                            docker run \
                            -e SEMGREP_APP_TOKEN=$SEMGREP_APP_TOKEN \
                            -e SEMGREP_REPO_NAME=$SEMGREP_REPO_NAME \
                            -v "$(pwd):$(pwd)" --workdir $(pwd) \
                            returntocorp/semgrep semgrep ci '''
                    }  else {
                        sh "git fetch origin +ref/heads/*:refs/remotes/origin/*" 
                        sh '''docker pull returntocorp/semgrep && \
                                  docker run \
                                  -e SEMGREP_APP_TOKEN=$SEMGREP_APP_TOKEN \
                                  -e SEMGREP_BASELINE_REF=$SEMGREP_BASELINE_REF \
                                  -e SEMGREP_REPO_URL=$SEMGREP_REPO_URL \
                                  -e SEMGREP_BRANCH=$SEMGREP_BRANCH \
                                  -e SEMGREP_JOB_URL=$SEMGREP_JOB_URL \
                                  -e SEMGREP_COMMIT=$SEMGREP_COMMIT \
                                  -e SEMGREP_PR_ID=$SEMGREP_PR_ID \
                                  -e SEMGREP_REPO_NAME=$SEMGREP_REPO_NAME \
                                  -v "$(pwd):$(pwd)" --workdir $(pwd) \
                                  returntocorp/semgrep semgrep ci'''
                    }
                }
            }
        }
    }
}
