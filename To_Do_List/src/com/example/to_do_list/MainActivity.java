package com.example.to_do_list;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	private EditText one, two, three, four;
	private String stringPassword=null;
	private SharedPreferences sh_Pref; 
	private static MessageDigest md;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		// Bottom lines make connection each xml elements with java.
		one = (EditText)findViewById(R.id.one);
		two = (EditText)findViewById(R.id.two);
		three = (EditText)findViewById(R.id.three);
		four = (EditText)findViewById(R.id.four);

		// If last password is inserted, then it checks whether or not it is 
		// right password automatically, using addTextChangedListener.
		four.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(four.length()==1){
					stringPassword = one.getText().toString() + two.getText().toString() +
							three.getText().toString() + four.getText().toString();
					boolean check = isRightPassword();
					
					// If it is right password, go main page.
					if (check) {
						
						Intent intent = new Intent(MainActivity.this, MainPage.class);
						startActivity(intent);
						
					}
					// If it is no right password, initialize each EditText and
					// re-focus on first password.
					else {
						one.setText(""); two.setText("");
						three.setText(""); four.setText("");
						
						one.requestFocus();
					}
				}
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			@Override
			public void afterTextChanged(Editable s) {}
		});
	
	}

	
	
	
	/**
	 * 	Method 'isRightPassword' checks whether or not this password is correct password.
	 * 	@param	No Input.
	 * 	@return true / false
	 */
	private boolean isRightPassword () {
		sh_Pref = getSharedPreferences ("Login Credentials", MODE_PRIVATE);

		// If there is a password what user had been stored.
		if (sh_Pref != null && sh_Pref.contains("Password")) {
			// Get password what was stored.
			String pw = sh_Pref.getString("Password","none");

			// If Password correct, return true.
			// Compare encrypted password with inserted password.
			// And inserted password become encrypt to compare with stored password.
			if (pw.compareTo(encryptPassword(stringPassword)) == 0 ) {
				return true;
			}
			else {
				Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		// If there is no password what user had been stored,
		// then compare inserted password with default password '0000'.
		else {
			if (stringPassword.compareTo("0000") == 0) {
				return true;
			}
			else {
				Toast.makeText(this,"Default Password is 0000", Toast.LENGTH_SHORT).show();
				return false;
			}
		}
	}

	/**
	 * 	Method 'encryptPassword' encrypt password what user is inserted for compare with
	 * 	stored password in device�셲 private memory area.
	 *	@param password
	 * 	@return encrypted password
	 */
	private static String encryptPassword (String password){
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = password.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<digested.length;i++){
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		return null;
	}

	/*
	 * �샃�뀡�뿉 留뚮뱾�뼱�씪.
	public void sharedPrefernces() {
		sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE); 
		toEdit = sh_Pref.edit();
		toEdit.putString("Password", encryptPassword); 
		toEdit.commit();
	}

	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
