buildscript {
    extra["gradleVersion"]  = "0.20.0"
    extra["kotlinVersion"]  = "1.3.61"
    
    repositories {
        jcenter()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", version = "${extra["kotlinVersion"]}"))
	classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra["kotlinVersion"]}")
    }
}

plugins {
    kotlin("js") version "${extra["kotlinVersion"]}"
}

kotlin {
    target {
	browser {
	}
    }
}

group = "minichain"

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js:${extra["kotlinVersion"]}")

    testImplementation("org.jetbrains.kotlin:kotlin-test-js:${extra["kotlinVersion"]}")
}

