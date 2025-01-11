plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id ("com.google.devtools.ksp")
}

android {
    namespace = "com.zopipo.iaipromo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.zopipo.iaipromo"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("org.mindrot:jbcrypt:0.4")
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    // Convertisseur Gson pour la sérialisation/désérialisation JSON
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp pour le client HTTP
    implementation ("com.squareup.okhttp3:okhttp:4.10.0")

    // Logging Interceptor (facultatif, pour déboguer les requêtes HTTP)
    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")

}