# Gradle
Add to dependencies
```
    compile 'com.android.support:cardview-v7:21.0.0'
    compile 'com.android.support:recyclerview-v7:21.0.0'
```

# AppCompat
## Consistency
For consistency between Android 21+ and pre-Android 21 add the following attributes to your card views 
```
    card_view:cardUseCompatPadding="true"
    card_view:cardPreventCornerOverlap="false"

```
Setting cardUseCompatPadding to true makes sure that the padding is consistent. 
Making cardPreventCornerOverlap false makes the cropping of the corners of the card view intersecting with content consistent. 
### Examples
cardUseCompatPadding set to false
21 vs 19

cardPreventCornerOverlap set to true
21 vs 19


# Links
https://developer.android.com/training/material/lists-cards.html
https://github.com/codepath/android_guides/wiki/Using-the-RecyclerView



