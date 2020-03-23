buildscript {
    extra["assertjVersion"] = "3.10.0"
    extra["gradleVersion"]  = "0.20.0"
    extra["jacocoVersion"]  = "0.8.1"
    extra["junitVersion"]   = "4.12"
    extra["kotlinVersion"]  = "1.3.61"
    extra["mockitoVersion"] = "2.12.0"
    extra["moshiVersion"]   = "1.4.0"
    extra["okhttpVersion"]  = "4.4.0"
    extra["okioVersion"]  = "2.4.3"
    extra["http4kVersion"]  = "3.239.0"
    
    repositories {
        jcenter()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", version = "${extra["kotlinVersion"]}"))
	classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra["kotlinVersion"]}")
        classpath("com.github.ben-manes:gradle-versions-plugin:${extra["gradleVersion"]}")
    }
}

plugins {
    kotlin("js") version "${extra["kotlinVersion"]}"
//    application
 //   "com.github.ben-manes.versions"
}

kotlin {
    target {
	browser {
	}
    }
}

kotlin {
    sourceSets["main"].dependencies {
        implementation(npm("react", "16.12.0"))
        implementation(npm("react-dom", "16.12.0"))
    }
}
group = "minichain"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${extra["kotlinVersion"]}")
    implementation("com.squareup.moshi:moshi:${extra["moshiVersion"]}")
    implementation("com.squareup.okio:okio:${extra["okioVersion"]}")

    implementation("org.http4k:http4k-core:${extra["http4kVersion"]}")
    implementation("org.http4k:http4k-multipart:${extra["http4kVersion"]}")
    implementation("org.http4k:http4k-testing-hamkrest:${extra["http4kVersion"]}")
    implementation("org.http4k:http4k-server-jetty:${extra["http4kVersion"]}")
    implementation("org.http4k:http4k-client-okhttp:${extra["http4kVersion"]}")
    implementation("org.http4k:http4k-client-apache:${extra["http4kVersion"]}")

    implementation("org.http4k:http4k-format-argo:${extra["http4kVersion"]}")
    implementation("org.http4k:http4k-format-gson:${extra["http4kVersion"]}")
    implementation("org.http4k:http4k-format-jackson:${extra["http4kVersion"]}")

    implementation("com.beust:klaxon:5.0.1")

    testImplementation(kotlin("test-js"))
//    testImplementation("junit:junit:${extra["junitVersion"]}")
//    testImplementation("org.mockito:mockito-core:${extra["mockitoVersion"]}")
//    testImplementation("com.squareup.okhttp3:mockwebserver:${extra["okhttpVersion"]}")
//    testImplementation("org.assertj:assertj-core:${extra["assertjVersion"]}")
}

//application {
//    mainClassName = "io.ipfs.kotlin.MainKt"
//}
