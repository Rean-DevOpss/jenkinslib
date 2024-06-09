def nextWithDocker(DOCKER_TAG) {
    def dockerfileContent = libraryResource 'next.dockerfile'
    writeFile file: 'Dockerfile', text: dockerfileContent
    sh "docker build -t nexttest:${DOCKER_TAG} ."
    sh "echo ${DOCKER_TAG}"
}