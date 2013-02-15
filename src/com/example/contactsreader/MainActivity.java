 package com.example.contactsreader;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LinearLayout layout = (LinearLayout)findViewById(R.id.ll);
//		Uri mContactUri = ContactsContract.Contacts.CONTENT_URI;
//		String[] projection = new String[] { ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME, ContactsContract.RawContacts.Data.DATA1 };
		Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, ContactsContract.Contacts.DISPLAY_NAME);
        while (phones.moveToNext())
        {
	        String Name=phones.getString(phones.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
	        Name += "\n" + phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
	        Button myButton = new Button(this);
	        myButton.setText(Name);
	        layout.addView(myButton);
        }
	}
	
	public void getNames(){
		LinearLayout layout = (LinearLayout)findViewById(R.id.ll);
		Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, ContactsContract.Contacts.DISPLAY_NAME);
        while (phones.moveToNext())
        {
	        String Name=phones.getString(phones.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
	        Name += "\n" + phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
	        Button myButton = new Button(this);
	        myButton.setText(Name);
	        layout.addView(myButton);
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}