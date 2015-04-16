# Instrumentation Frameworks
Instrumentation testing frameworks are required to be ran on an actual Android device or emulator. These types of tests should not be used as unit tests due to the complexity of the Android Activity life cycle, and the amount of time required to run them. Instead these types of tests should be used for testing UI elements, integration between multiple activities, or acceptance testing. Due to this high level of testing, mocking should generally be avoided. An exception to this would be producing error cases for an external API. 

##[Robotium](https://code.google.com/p/robotium/)

###Pros
* Small learning curver
* Flexible to UI changes as long as string resource IDs do not change for views
* Android Studio plugin, [Robotium Recorder](http://robotium.com/products/robotium-recorder), to record interactions and create Robotium tests from these 

###Cons
* Lack of documentation and samples
* Limited feature set and assertions for testing
* Ambiguous assertion errors due to lack of assertions

###Gradle
Add to dependencies
```
compile 'com.jayway.android.robotium:robotium-solo:5.2.1'
```

##[Espresso](https://code.google.com/p/android-test-kit/wiki/Espresso)#

###Pros
* Flexible to UI changes as long as view IDs do not change
* Elegant syntax
* Better UI testing capabilities
* Built in assertions 
* Useful debugging error messages for failed assertions

###Cons
* Requires more effort for Gradle and test setup
* The static imports required are more of a pain to setup

###Gradle
Add to dependencies
```
androidTestCompile 'com.android.support.test.espresso:espresso-core:2.0'
androidTestCompile 'com.android.support.test:testing-support-lib:0.1'
```
Add to android section
```
packagingOptions{
        exclude 'LICENSE.txt'
    }
```
Add to default config section to change to correct instrumentation test runner
```
testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
```

Full example build.gradle
```
android {
    compileSdkVersion 21
    buildToolsVersion "21.1.2"

    defaultConfig {
        applicationId "com.example.joakes.espressotest"
        minSdkVersion 16
        targetSdkVersion 21
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    packagingOptions{
        exclude 'LICENSE.txt'
    }
}

dependencies {
    androidTestCompile 'com.android.support.test.espresso:espresso-core:2.0'
    androidTestCompile 'com.android.support.test:testing-support-lib:0.1'
}
```
## [Calabash](http://calaba.sh/)
Calabash was not explored since it is aimed for both Android and Iphone applications and is written in ruby so there is a higher learning curve and setup.

# Comparisons
To get a better understanding of these testing frameworks, a simple appication was created to evaluate and compare each. This application consists of two activities, in which three tests were written. The first test is an integration test to ensure that clicking a button in the main activity takes the user to the second activity. The second test verifies that the correct dialog is opened when clicking on a menu item in the action bar on the first activity. The third test checks to be sure that the listview in the second activity is populated with the correct data. 

## Speed - Winner Espresso
Each test was ran in Android Studio individually three times and the average time was taken for comparison. All times are in seconds. 

Framework  | Test 1 Speed | Test 2 Speed | Test 3 Speed
---------- | ------------ | ------------ | ------------
Robotium  |  9.9 | 8.2 | 5.7
Espresso  | 3.3 | 3.6 | 2.5
