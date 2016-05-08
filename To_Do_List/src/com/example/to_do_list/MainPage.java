package com.example.to_do_list;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MainPage extends Activity {

	public static WindowManager wm;
	public static Display d;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);

		
		//---get thecurrent displayinfo---
		wm = getWindowManager();
		d = wm.getDefaultDisplay();	

		if (d.getWidth() > d.getHeight())
		{
			LinearLayout t = (LinearLayout)findViewById(R.id.taskFragment);
			t.setVisibility(View.VISIBLE);
		}
		else
		{
			LinearLayout t = (LinearLayout)findViewById(R.id.taskFragment);
			t.setVisibility(View.GONE);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.closeApp) {
			
		}
		return super.onOptionsItemSelected(item);
	}
}
