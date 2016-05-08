package com.example.to_do_list;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class ListFragment extends Fragment {

	public static final String fileName = "myXML.xml";
	public static ListView ls=null;

	public static String selectedWord;
	public static int selectedWordId=0;
	public static List<Entry> list;
	public static ArrayAdapter<String> aa;
	ArrayList<String> getList = null;

	EditText title;
	EditText date;
	EditText content;
	RatingBar star;

	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//---Inflate the layout for this fragment---
		return inflater.inflate( R.layout.activity_list_fragment, container, false);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	public void onStart () {
		super.onStart();	

		title = (EditText) getActivity().findViewById(R.id.taskTitle);
		date = (EditText) getActivity().findViewById(R.id.dueDate);
		content = (EditText) getActivity().findViewById(R.id.contents);
		star = (RatingBar) getActivity().findViewById(R.id.star);
		getList = new ArrayList<String>();

		//Parsing
		try {			
			InputStream in = getActivity().openFileInput(fileName);

			Parser p = new Parser();
			list = p.Parsing(in);

			in.close();

			// 불러온 목록에서 타이틀만 빼서 getList에 집어 넣는다.
			for (int i=0 ; i<list.size() ; i++) {
				getList.add(list.get(i).getTitle());
			}
		} catch (java.io.FileNotFoundException e) {
			// that's OK, we probable haven't created it yet
		} catch (Throwable e) {
			Toast.makeText(getActivity(), "Exception: "+e.toString(), 10000).show();
		}

		//getList를 ArrayAdapter에 등록시킨다.
		ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getList);

		// listView Object를 생성한다.
		ls = (ListView)getActivity().findViewById(R.id.my_list);
		// listView를 ContextMenu에 등록시킨다.
		registerForContextMenu(ls);

		// listView에 ArrayAdapter를 넣는다.
		ls.setAdapter(aa);

		// ListView Click Event
		ls.setOnItemClickListener( new OnItemClickListener () {
			@Override
			public void onItemClick ( AdapterView<?> av, View v, int position, long id) {

				for (int i=0 ; i<list.size() ; i++) {
					if (getList.get(position).compareTo(list.get(i).getTitle()) == 0) {
						//해당되는 데이터를 TaskFragment집어넣는다.

						// 데이터를 집어 넣는다.
						title.setText(list.get(i).getTitle());
						date.setText(list.get(i).getDate());
						content.setText(list.get(i).getContent());
						star.setNumStars(Integer.parseInt(list.get(i).getLevel()));

						//---get thecurrent displayinfo---
						MainPage.wm = getActivity().getWindowManager();
						MainPage.d = MainPage.wm.getDefaultDisplay();	

						// 폰이 세로일 때 Task Fragment만 보여준다.
						if (MainPage.d.getWidth() < MainPage.d.getHeight()) {

							LinearLayout t1 = (LinearLayout)getActivity().findViewById(R.id.listFragment);
							t1.setVisibility(View.GONE);
							LinearLayout t2 = (LinearLayout)getActivity().findViewById(R.id.taskFragment);
							t2.setVisibility(View.VISIBLE);	
						}
					}
				}
			}
		});
	}

	@Override
	public void onCreateContextMenu(ContextMenu contextMenu, View v, ContextMenu.ContextMenuInfo menuInfo) {

		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

		selectedWord = ((TextView) info.targetView).getText().toString();
		selectedWordId = (int)info.id;

		contextMenu.setHeaderTitle(selectedWord);
		contextMenu.add(0, 0, 0, "Modify");
		contextMenu.add(0, 1, 1, "Delete");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) { 
		return(applyMenuOption(item) || super.onContextItemSelected(item) );
	}

	private boolean applyMenuOption(MenuItem item) {
		int id = item.getItemId();

		//0이면 modify, 1이면 delete
		//xml에서 지워줘야 한다.

		//Modify
		if (id == 0) {

			title.setText(list.get(selectedWordId).getTitle());
			date.setText(list.get(selectedWordId).getDate());
			content.setText(list.get(selectedWordId).getContent());
			star.setNumStars(Integer.parseInt(list.get(selectedWordId).getLevel()));

			//---get thecurrent displayinfo---
			MainPage.wm = getActivity().getWindowManager();
			MainPage.d = MainPage.wm.getDefaultDisplay();	

			// 폰이 세로일 때 Task Fragment만 보여준다.
			if (MainPage.d.getWidth() < MainPage.d.getHeight()) {

				LinearLayout t1 = (LinearLayout)getActivity().findViewById(R.id.listFragment);
				t1.setVisibility(View.GONE);
				LinearLayout t2 = (LinearLayout)getActivity().findViewById(R.id.taskFragment);
				t2.setVisibility(View.VISIBLE);	
			}	

			//list.get(selectedWordId);

		}
		//Delete
		else if ( id == 1) {
			list.remove(selectedWordId);

			//다시 적어줘야 한다.

		}



		return false;
	}





	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);		

		// Inflate the menu; this adds items to the action bar if it is present.
		getActivity().getMenuInflater().inflate(R.menu.list, menu);	
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		switch (item.getItemId()) {

		case R.id.add:

			// 아무것도 없는 화면을 보여주기 위해 초기화한다.
			title.setText("");
			date.setText("");
			content.setText("");
			star.setNumStars(0);	

			//---get thecurrent displayinfo---
			MainPage.wm = getActivity().getWindowManager();
			MainPage.d = MainPage.wm.getDefaultDisplay();	

			// 폰이 세로일 때 Task Fragment만 보여준다.
			if (MainPage.d.getWidth() < MainPage.d.getHeight()) {

				LinearLayout t1 = (LinearLayout)getActivity().findViewById(R.id.listFragment);
				t1.setVisibility(View.GONE);
				LinearLayout t2 = (LinearLayout)getActivity().findViewById(R.id.taskFragment);
				t2.setVisibility(View.VISIBLE);	
			}

			break;

		case R.id.changePW:
			Intent intent = new Intent(getActivity(), ChangePW.class);
			startActivity(intent);
			break;
		}


		return super.onOptionsItemSelected(item);
	}

}
