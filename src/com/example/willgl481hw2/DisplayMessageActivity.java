package com.example.willgl481hw2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {
	// when u make an activity, u always have to declare it in the "manifest" as well, which if ur using Eclipse it does it for u!

	// Since "actionbar" only works on API 11 and higher, we need to suppress lint
	@SuppressLint("NewApi")
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// "onCreate" is always where you set up all your components and define the layout using "setcontentview"
		super.onCreate(savedInstanceState);
		
		// "actionbar" needs API 11 or higher so make sure it is!
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			// do what you would've done
			// the "up" button is the "go back" button at the top of the screen you see on Android phones
			// Show the Up button in the action bar.
			getActionBar().setDisplayHomeAsUpEnabled(true);
//			setupActionBar();
		}
		
		// now we have to receive the intent that we send from the main activity
		// make the "intent" on this activity first
		Intent intent = getIntent();
		// now grab the string out of it lol
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		// let's create a TextView to display the text that we just grabbed
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(message);	// sets the new text we just grabbed for the textView!
		setContentView(textView);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
