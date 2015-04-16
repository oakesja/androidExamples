# Instrumentation Frameworks
Any testing frameworks that uses the ActivityInstrumentationTestCase or ActivityInstrumentationTestCase2 and are required to be ran on an actual Android device or emulator. These types of tests are incapable of being unit tests due to the complexity of the Android Activity life cycle. Instead these types of tests should be used for testing UI elements or integration between multiple activities. Due to this high level of testing, mocking should generally be avoided. An exception to this would be producing error cases for an external API. 

##[Robotium](https://code.google.com/p/robotium/)

###Pros

###Cons

###Gradle
```
compile 'com.jayway.android.robotium:robotium-solo:5.2.1'
```

##[Espresso](https://code.google.com/p/android-test-kit/wiki/Espresso)#

###Pros

###Cons

###Gradle
```
androidTestCompile 'com.android.support.test.espresso:espresso-core:2.0'
androidTestCompile 'com.android.support.test:testing-support-lib:0.1'
```

# Comparisons

Framework  | Speed
---------- | -----
Robotium  |  
Espresso  | 
