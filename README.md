# androidExamples


## Gradle setup
Includes the following: 
- Espresso (UI Instrementation Testing Framework)
- Junit 
- Android Fest for better assertions (assertThat)
- Robolectric (Unit level testing in the JVM for Android components)

```
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    
    androidTestCompile 'com.android.support.test.espresso:espresso-core:2.0'
    androidTestCompile 'com.android.support.test:testing-support-lib:0.1'

    testCompile 'junit:junit:4.12'
    testCompile 'com.squareup:fest-android:1.0.8'
    testCompile('org.robolectric:robolectric:3.0-rc2') {
        exclude group: 'commons-logging', module: 'commons-logging'
        exclude group: 'org.apache.httpcomponents', module: 'httpclient'
    }
}
```

## Imports
Android Fest
```
import static org.assertj.android.api.Assertions.assertThat;
```
