
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:1.3.2")

    //developmentOnly("org.springframework.boot:spring-boot-devtools")
    // Gson
    api("com.google.code.gson:gson:2.8.5")
    implementation("com.h2database:h2")
    // ModelMapper
    //implementation("org.modelmapper:modelmapper:2.3.0")
    // MapStruct
    implementation("org.mapstruct:mapstruct:1.4.1.Final")
    kapt("org.mapstruct:mapstruct-processor:1.4.1.Final")

    api("com.fasterxml.jackson.core:jackson-databind:2.12.5")
    //runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR12")
    }
}

tasks.register("prepareKotlinBuildScriptModel") {}