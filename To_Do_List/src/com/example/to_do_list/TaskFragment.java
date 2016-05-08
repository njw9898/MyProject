package com.example.to_do_list;

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

public class TaskFragment extends Fragment {

	Button confirmBtn;
	List<Entry> list;

	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//---Inflate the layout for this fragment---

		return inflater.inflate( R.layout.activity_task_fragment, container, false);
	}

	public void onStart() {
		super.onStart();

		confirmBtn = (Button)getActivity().findViewById(R.id.confirmButton);


		confirmBtn.setOnClickListener(new OnClickListener () {

			@Override
			public void onClick (View v) {

				EditText title = (EditText) getActivity().findViewById(R.id.taskTitle);
				EditText date = (EditText) getActivity().findViewById(R.id.dueDate);
				EditText content = (EditText) getActivity().findViewById(R.id.contents);
				RatingBar star = (RatingBar) getActivity().findViewById(R.id.star);

				int index=0;

				Log.i("DO",Boolean.toString(ListFragment.list.isEmpty()));
				
				// List에 있는 데이터 중에서 타이틀이 같은 것을 찾아서 수정해준다.
				for (index=0 ; index<ListFragment.list.size() ; index++) {
					if ( ListFragment.list.get(index).getTitle().compareTo(title.getText().toString()) == 0)  {
						Log.i("DO","Same Title Found");
						Entry tempEn = new Entry(title.getText().toString(), date.getText().toString(),
								Integer.toString(star.getNumStars()), content.getText().toString());
						//Reset Data
						ListFragment.list.set(index, tempEn);
						break;
					}
				}

				// 만약 같은 이름이 없다면 새롭게 ADD되는 Task이기 때문에 List에 추가해준다.	
				if ( index == ListFragment.list.size()) {
					Entry tempEn = new Entry(title.getText().toString(), date.getText().toString(),
							Integer.toString(star.getNumStars()), content.getText().toString());
					ListFragment.list.add(tempEn);
					Log.i("DO","HELLO");
				}




				//여기서 데이터를 다시 써줘라.
				try {
					OutputStreamWriter out = new OutputStreamWriter( getActivity().openFileOutput(ListFragment.fileName, 0));

					StringBuffer buf = new StringBuffer();

					buf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
					buf.append("<list>");
					for (int i=0 ; i<ListFragment.list.size() ; i++) {
						buf.append("<task>");
						buf.append("<title>" + ListFragment.list.get(i).getTitle() + "</title>");
						buf.append("<dueDate>" + ListFragment.list.get(i).getDate() + "</dueDate>");
						buf.append("<level>" + ListFragment.list.get(i).getLevel() + "</level>");
						buf.append("<content>" + ListFragment.list.get(i).getContent() + "</content>");
						buf.append("</task>");
					}
					buf.append("</list>");

					out.write(buf.toString());
					out.close();

				} catch ( Throwable t) {
					Toast.makeText(getActivity(), "Exception: "+t.toString(), 2000).show();
				}



				// Change Fragment
				// 이때 반드시 ListFragment도 업데이트 시켜줘야 한다.
				// listFragment의 onStart에서 자동으로 업데이트를 시켜줄까 ?
				//Parsing

				ArrayList<String> getList = new ArrayList<String>();
				
				for (int i=0 ; i<ListFragment.list.size() ; i++) {
					getList.add(ListFragment.list.get(i).getTitle());
				}

				//getList를 ArrayAdapter에 등록시킨다.
				ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getList);

				// listView에 ArrayAdapter를 넣는다.
				ListFragment.ls.setAdapter(aa);



				//---get thecurrent displayinfo---
				MainPage.wm = getActivity().getWindowManager();
				MainPage.d = MainPage.wm.getDefaultDisplay();	

				// 폰이 세로일 때 List Fragment만 보여준다. 즉 다시 List Fragment로 돌아가는 것이다.
				if (MainPage.d.getWidth() < MainPage.d.getHeight()) {

					LinearLayout t1 = (LinearLayout)getActivity().findViewById(R.id.listFragment);
					t1.setVisibility(View.VISIBLE);
					LinearLayout t2 = (LinearLayout)getActivity().findViewById(R.id.taskFragment);
					t2.setVisibility(View.GONE);	
				}
			}
		});
	}


	/*
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_fragment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.task, menu);
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
