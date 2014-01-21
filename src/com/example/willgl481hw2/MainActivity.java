package com.example.willgl481hw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	// define the key, it needs to "be" something, duh!
	// need to define the key, later the next activity will use it to find the "extras"
	public final static String EXTRA_MESSAGE = "com.example.willgl481hw2.MESSAGE";
	
	/** Called when the user clicks the Send button */
	// we need to define what "sendMessage" does!
	public void sendMessage(View view) {
		// intents provide runtime binding of two activities
		// takes in a "context" and a "class" (i.e. the activity that needs to be started)
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		// grab the EditText by its id
		EditText editText = (EditText) findViewById(R.id.edit_message);		// "edit_message" is the name of my text box
		// get the string from it
		String message = editText.getText().toString();
		// pass it to the intent as an "extra"
		// "extras" are key-value pairs that intents can carry!
		intent.putExtra(EXTRA_MESSAGE, message);
		// start the next activity
		startActivity(intent);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// just display some text
		TextView text = new TextView(this);		// "this" refers to the current context, where you want it,
		text.setText("Hello World1");			// this is already taken care of by the XML as well lol
		setContentView(R.layout.activity_main);		// set the activity to a certain view
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
