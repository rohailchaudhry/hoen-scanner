# Flightscry — Android flight itinerary

Skyscanner Forage Task 3 proof of concept. Kotlin, XML views, minimum Android
API 33, and Backpack Android 43.0.0, as specified in the task PDF.

The screen shows three Backpack cards: flight information (SK 204), departure
(LHR, 09:30), and arrival (EDI, 10:55). All information is fictional demonstration
data. Backpack text components and large card corners are used with BpkTheme.

## Open and run

Use Android Studio, JDK 17, Android SDK 34, and Gradle 8.2. This source archive
has no Gradle wrapper binary. The easiest setup is to create an Empty Views
Activity project in Android Studio named Flightscry, using Kotlin and minimum
SDK 33. Copy this archive's contents over that project while keeping its wrapper
scripts and wrapper JAR, then set gradle/wrapper/gradle-wrapper.properties to
use https://services.gradle.org/distributions/gradle-8.2-bin.zip.
Sync Gradle and run on an API 33 or newer emulator.

Alternatively, with Gradle 8.2 installed, run `gradle wrapper --gradle-version 8.2`
from this folder, then `./gradlew assembleDebug` (Windows: `gradlew.bat assembleDebug`).

## Checks

XML files were checked for well-formedness. Android compilation and emulator
rendering have not been verified in the preparation environment. Verify that all
three cards appear, scroll on a small screen, and show the correct flight number,
airport codes, and times. No backend or network permissions are needed.

## GitHub

Upload this entire flightscry folder to your repository, preserving its structure.
Source library: https://github.com/Skyscanner/backpack-android/tree/43.0.0
