plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id ("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
    id ("com.google.dagger.hilt.android")
    id ("kotlin-kapt")
}

android {
    namespace = "com.rapidor.shoppingmart"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rapidor.shoppingmart"
        minSdk = 21
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        //noinspection DataBindingWithoutKapt
        dataBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // Glide
    implementation ("com.github.bumptech.glide:glide:4.14.2")
    kapt ("com.github.bumptech.glide:compiler:4.14.2")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    // GSON
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.2")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:2.8.2")

    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.2")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Timber for logging
    implementation ("com.jakewharton.timber:timber:5.0.1")

    // Http Logging Interceptor
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.1")

    // Room Dependencies
    implementation("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    implementation("androidx.room:room-common:2.6.1")

    // Hilt
    implementation ("com.google.dagger:hilt-android:2.50")
    kapt ("com.google.dagger:hilt-compiler:2.50")

    // Lottie Animations
    implementation ("com.airbnb.android:lottie:5.2.0")

    // Shimmer Effect
    implementation ("com.facebook.shimmer:shimmer:0.5.0")

    // KoIn
    implementation("io.insert-koin:koin-android:3.6.0-wasm-alpha2")
    implementation(platform("io.insert-koin:koin-bom:3.6.0-wasm-alpha2"))
    implementation("io.insert-koin:koin-core")

    implementation ("androidx.multidex:multidex:2.0.1")
}