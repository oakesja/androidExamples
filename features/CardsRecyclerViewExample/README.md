# Gradle setup
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
Setting cardUseCompatPadding to true makes sure that the padding is consistent. Making cardPreventCornerOverlap false makes the cropping of the corners of the card view intersecting with content consistent. 
### Examples
**cardUseCompatPadding set to false**
![API 21 padding](https://github.com/oakesja/androidExamples/blob/master/features/CardsRecyclerViewExample/images/api21UseCompatPaddingFalse.png) 
![API 19 padding](https://github.com/oakesja/androidExamples/blob/master/features/CardsRecyclerViewExample/images/api21UseCompatPaddingFalse.png)

**cardPreventCornerOverlap set to true**
![API 21 corners](https://github.com/oakesja/androidExamples/blob/master/features/CardsRecyclerViewExample/images/api21PreventCornerOverlapTrue.png) 
![API 19 corners](https://github.com/oakesja/androidExamples/blob/master/features/CardsRecyclerViewExample/images/api19PreventCornerOverlapTrue.png)


# Useful links
* https://developer.android.com/training/material/lists-cards.html
* https://github.com/codepath/android_guides/wiki/Using-the-RecyclerView



