val springBootVersion = "2.1.8.RELEASE"

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))

    compile("org.springframework.boot:spring-boot-devtools")
    compile("org.springframework.boot:spring-boot-starter-web")
    
    testCompile("org.junit.jupiter:junit-jupiter-api")
    testRuntime("org.junit.jupiter:junit-jupiter-engine")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}