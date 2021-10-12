tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = false
}

tasks.getByName<Jar>("jar"){
    enabled = true
    baseName = "sample-core"
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.boot:spring-boot-starter-web")
    api("com.fasterxml.jackson.module:jackson-module-kotlin")
    api("org.jetbrains.kotlin:kotlin-reflect")
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    api("org.mybatis.spring.boot:mybatis-spring-boot-starter:1.3.2")

    api("org.modelmapper:modelmapper:2.3.0")

    api("org.mapstruct:mapstruct:1.4.1.Final")
    kapt("org.mapstruct:mapstruct-processor:1.4.1.Final")

    api("com.fasterxml.jackson.core:jackson-databind:2.12.5")
    api("com.google.code.gson:gson:2.8.5")
    api("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.register("prepareKotlinBuildScriptModel") {}