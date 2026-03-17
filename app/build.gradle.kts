plugins {
    /*alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)*/
//    alias(libs.plugins.kotlin.compose)
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id(libs.plugins.daggerHilt.get().toString())
    id(libs.plugins.ksp.get().toString())
}

android {
    namespace = libs.plugins.mainNamespace.get().toString()
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = libs.plugins.mainNamespace.get().toString()
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk =libs.versions.compileSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        jvmTarget = libs.versions.jvmTarget.get()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerVersion.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

//   implementation(libs.androidx.material3.android)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
//    implementation(libs.androidx.material3.android)
//    implementation(libs.icons.extended)
//    implementation(libs.material3IconsExtended)


    /* implementation(libs.androidx.core.ktx)
       implementation(libs.androidx.lifecycle.runtime.ktx)
       implementation(libs.androidx.activity.compose)
       implementation(platform(libs.androidx.compose.bom))
       implementation(libs.androidx.compose.ui)
       implementation(libs.androidx.compose.ui.graphics)
       implementation(libs.androidx.compose.ui.tooling.preview)
       implementation(libs.androidx.compose.material3)
       testImplementation(libs.junit)
       androidTestImplementation(libs.androidx.junit)
       androidTestImplementation(libs.androidx.espresso.core)
       androidTestImplementation(platform(libs.androidx.compose.bom))
       androidTestImplementation(libs.androidx.compose.ui.test.junit4)
       debugImplementation(libs.androidx.compose.ui.tooling)
       debugImplementation(libs.androidx.compose.ui.test.manifest)
   */

    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    //region D.I Dependencies
    ksp(libs.hilt.compiler)
    ksp(libs.hilt.ksp.compiler)
    implementation(libs.hilt.core)
    //endregion

    //region Compose Dependencies
    implementation(libs.compose.activity)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.ui.tooling.preview)
//    implementation(libs.compose.ui.material)

    androidTestImplementation(platform(libs.compose.bom))
    //endregion

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)

    ksp(libs.room.compiler)

    //region Core Dependencies
    implementation(libs.appcompat)
    implementation(libs.android.core)
    implementation(libs.lifecycle.viewmodel.compose)
    //endregion

    implementation(libs.lifecycle.ktx)

}