# Getting Started — Clone & Run on Android Studio

A step-by-step guide for anyone who wants to clone and run this Android project locally.

---

## Prerequisites

Make sure the following tools are installed on your machine before cloning.

| Tool | Required Version |
|------|-----------------|
| Android Studio | Ladybug (2024.2.1) or later |
| Android SDK | API 36 (Android 16) |
| Min SDK Support | API 21 (Android 5.0) |
| JDK | 11 |
| Git | Any recent version |

---

## Step 1 — Install Android Studio

1. Download Android Studio from the [official site](https://developer.android.com/studio)
2. Run the installer and follow the setup wizard
3. During setup, make sure **Android SDK** and **Android Virtual Device (AVD)** are checked
4. Complete the installation and launch Android Studio

---

## Step 2 — Install the Required SDK

1. Open Android Studio
2. Go to **Settings** → **Languages & Frameworks** → **Android SDK**
   - On macOS: **Android Studio** → **Settings**
   - On Windows/Linux: **File** → **Settings**
3. Under **SDK Platforms**, check **Android 16 (API 36)**
4. Under **SDK Tools**, make sure the following are installed:
   - Android SDK Build-Tools
   - Android Emulator
   - Android SDK Platform-Tools
5. Click **Apply** → **OK**

---

## Step 3 — Clone the Repository

Open a terminal and run:

```bash
git clone https://github.com/jirapatchookleeb/kotlin-android-starter.git
```

Then navigate into the project folder:

```bash
cd kotlin-android-starter
```

---

## Step 4 — Open the Project in Android Studio

1. Launch **Android Studio**
2. Click **Open** (or **File** → **Open**)
3. Navigate to the cloned folder and select it
4. Click **OK**
5. Wait for Android Studio to **sync Gradle** — this may take a few minutes on first open

> ⚠️ If you see a **Gradle sync failed** error, see the [Troubleshooting](#troubleshooting) section below.

---

## Step 5 — Set Up a Device

### Option A — Use an Emulator (Recommended for beginners)

1. Go to **Device Manager** (icon in the right toolbar or **View** → **Tool Windows** → **Device Manager**)
2. Click **Create Device**
3. Choose a device (e.g. **Pixel 8**) → Click **Next**
4. Select a system image with **API 36** → Download if needed → Click **Next**
5. Click **Finish**
6. Press ▶ to start the emulator

### Option B — Use a Physical Device

1. On your Android phone, go to **Settings** → **About Phone**
2. Tap **Build Number** 7 times to enable **Developer Options**
3. Go to **Settings** → **Developer Options** → Enable **USB Debugging**
4. Connect your phone via USB
5. Accept the **Allow USB Debugging** prompt on your phone
6. Your device should appear in the device selector in Android Studio

---

## Step 6 — Build & Run the App

1. Select your device (emulator or physical) from the toolbar dropdown
2. Click **Run ▶** or press `Shift + F10` (Windows/Linux) / `Ctrl + R` (macOS)
3. Android Studio will build the project and install the app on your device
4. The app will launch automatically

---

## Project Configuration Reference

This project uses the following `build.gradle.kts` setup:

```kotlin
plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 21
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
```

---

## Troubleshooting

### Gradle Sync Failed
- Go to **File** → **Invalidate Caches** → **Invalidate and Restart**
- Make sure your internet connection is active (Gradle needs to download dependencies)
- Check that **Android SDK API 36** is installed (see Step 2)

### SDK Not Found
- Go to **File** → **Project Structure** → **SDK Location**
- Make sure the **Android SDK location** path is set correctly

### Device Not Detected
- Try a different USB cable or USB port
- Re-enable **USB Debugging** on your device
- Run `adb devices` in terminal to check if the device is recognized

### JDK Version Mismatch
- Go to **File** → **Project Structure** → **SDK Location** → **JDK Location**
- Make sure it points to **JDK 11**
- You can download JDK 11 from [Adoptium](https://adoptium.net/)

---

## Useful Links

- [Android Studio Download](https://developer.android.com/studio)
- [Android Developer Guides](https://developer.android.com/guide)
- [Navigation Component Docs](https://developer.android.com/guide/navigation)
- [ViewBinding Docs](https://developer.android.com/topic/libraries/view-binding)
- [Adoptium JDK 11](https://adoptium.net/temurin/releases/?version=11)
