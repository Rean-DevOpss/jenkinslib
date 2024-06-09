def call( Integer TAGS) {
    def dockerfileContent = libraryResource 'next.dockerfile'
    writeFile file: 'Dockerfile', text: dockerfileContent
    sh 'docker build -t nexttest:$TAGS .'

}
