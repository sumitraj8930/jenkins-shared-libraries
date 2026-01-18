def call(String Project, String ImageTag, String dockerhubuser) {
    withCredentials([usernamePassword(
        credentialsId: "dockerHubCred",
        usernameVariable: "dockerHubUser",
        passwordVariable: "dockerHubPass"
    )]) {

        sh "echo ${dockerHubPass} | docker login -u ${dockerHubUser} --password-stdin"
        sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
    }
}
