dependencies {
    api(projects.lib.stoveTestingE2e)
    implementation(libs.spring.boot)
}

dependencies {
    testAnnotationProcessor(libs.spring.boot.get3x().annotationProcessor)
    testImplementation(libs.spring.boot.get3x().autoconfigure)
    testImplementation(libs.slf4j.simple)
}

