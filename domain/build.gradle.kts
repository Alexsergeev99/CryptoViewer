plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    implementation(platform(libs.koin.bom))
    testImplementation(libs.junit)
    implementation(libs.koin.core)
    implementation(libs.kotlinx.coroutines.core)

}