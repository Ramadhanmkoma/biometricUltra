plugins {
	java
	id("org.springframework.boot") version "3.1.1"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "io.techswahili"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
//	implementation("org.springframework.boot:spring-boot-starter-webflux")
//	developmentOnly("org.springframework.boot:spring-boot-devtools")
//	implementation("org.springframework.security:spring-security-oauth2-client")
//	implementation("org.springframework.security:spring-security-oauth2-jose")
//	implementation("io.jsonwebtoken:jjwt:0.11.5")
//	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
//	implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
//	implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")
//	implementation("io.springfox:springfox-boot-starter:3.0.0")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
