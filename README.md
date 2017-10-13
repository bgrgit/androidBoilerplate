# Android Boiler plate

Basic useful feature list:

 1. AlertDialog with one button and two button
 2. BottomSheet
 3. Access Network state

### Download

Download via gradle
Add it in your build.gradle
```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add it in your build.gradle (dependencies)

```groovy
    compile 'com.github.bgrgit:androidBoilerplate:2.0'
```

or Download via Maven

```Maven
<dependency>
	    <groupId>com.github.bgrgit</groupId>
	    <artifactId>androidBoilerplate</artifactId>
	    <version>2.0</version>
</dependency>
 ```

### Usage


----------


#### Alert dialog



```java
public class MainActivity extends AppCompatActivity implements OnDialogListner
```
Used to create a two button alert dialog builder

```java
AlertDialogBuilder.getInstance().showTwoButtonDialog("Title", "Message", "Cancel", "OK", "WhichDialog", this, this);
```

Used to create a single button alert dialog builder

```java        
AlertDialogBuilder.getInstance().showSingleButtonDialog("Title","Message","OK",this);
```

#### Network connection check
In Android Manifest
```xml        
 <uses-permission android:name="android.permission.INTERNET"/>
 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
```
In your Activity
```java
if(NetworkCheck.getInstance(this).isNetworkConnectionAvailable()) {
Toast.makeText(this, "Network Connected", Toast.LENGTH_SHORT).show();
} else {
Toast.makeText(this, "Network not connected", Toast.LENGTH_SHORT).show();
}
```
#### Bottom Sheet

In your activity
```java
private ModalBottomSheetWithCustomLayout mMdlBtmShtWithCustomLyt;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mMdlBtmShtWithCustomLyt = ModalBottomSheetWithCustomLayout.newInstance(getCustomViewForModalDialog());
        mMdlBtmShtWithCustomLyt.show(getSupportFragmentManager(), mMdlBtmShtWithCustomLyt.getTag());
        }
```
Build this function for generating custom view for Bottom sheet.
Implement your layout want to inflate in bottom sheet 

***for example***
```java
 public View getCustomViewForModalDialog() {
        View view = View.inflate(this, R.layout.fragment_modal_bottom_sheet_with_custom_layout, null);
        TextView cancelButton = (TextView) view.findViewById(R.id.tv_cancel_bottomsheet);
        TextView titleText = (TextView) view.findViewById(R.id.tv_title_bottomsheet);
        TextView bodyText = (TextView) view.findViewById(R.id.tv_body_bottomsheet);
        cancelButton.setText("Dismiss");
        titleText.setText("Bottom Sheet header");
        bodyText.setText("Bottom Sheet body");
        cancelButton.setOnClickListener(this);
        return view;
    }
```

