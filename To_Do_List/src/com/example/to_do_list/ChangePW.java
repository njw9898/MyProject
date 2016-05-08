package com.example.to_do_list;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePW extends Activity {


	private EditText one, two, three, four;
	private String stringPassword=null;
	private SharedPreferences sh_Pref; 
	private static MessageDigest md;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_pw);

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
						String encryptedPW = encryptPassword(stringPassword);
						sh_Pref = getSharedPreferences ("Login Credentials", MODE_PRIVATE);
						SharedPreferences.Editor editor = sh_Pref.edit();
						editor.putString("Password", encryptedPW);
						editor.commit();

						Toast.makeText(getApplicationContext(), "Password is changed <"+stringPassword+">", Toast.LENGTH_SHORT).show();
						finish();
					}
					else {
						one.setText(""); two.setText("");
						three.setText(""); four.setText("");
						Toast.makeText(getApplicationContext(), "Password is same as before", Toast.LENGTH_SHORT).show();
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
				Toast.makeText(this, "Inserted Password is a Same Password Before", Toast.LENGTH_SHORT).show();
				return false;
			}
		}		
		return true;
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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.change_pw, menu);
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
	
	*/
}
