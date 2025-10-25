androidApplication {
    namespace = "org.example.app"

    dependencies {
        // Jetpack Compose (aligned with Kotlin 2.0.21 and compose-compiler ~1.5.12)
        implementation("androidx.compose.ui:ui:1.6.8")
        implementation("androidx.compose.runtime:runtime:1.6.8")
        implementation("androidx.compose.foundation:foundation:1.6.8")
        implementation("androidx.compose.foundation:foundation-layout:1.6.8")
        implementation("androidx.compose.ui:ui-tooling-preview:1.6.8")
        implementation("androidx.compose.material3:material3:1.2.1")
        implementation("androidx.activity:activity-compose:1.9.3")
        implementation("androidx.navigation:navigation-compose:2.7.7")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.6")

        // Room (compiler as implementation due to DCL constraints)
        implementation("androidx.room:room-runtime:2.6.1")
        implementation("androidx.room:room-ktx:2.6.1")
        implementation("androidx.room:room-compiler:2.6.1")

        // Icons and AppCompat
        implementation("androidx.compose.material:material-icons-extended:1.6.8")
        implementation("androidx.appcompat:appcompat:1.7.0")
    }
}
