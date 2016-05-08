package com.example.pedest;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{
	Button alert;
	BluetoothAdapter mAdapter = null;
	ArrayList<DeviceItem> deviceItemList;
	ArrayList<String> deviceMAClist;
	
	static final String LOG_TAG = "Bluetooth progressive";
	static final String MACAddr = "";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		alert=(Button)findViewById(R.id.alert);
		alert.setOnClickListener(this);
		
		mAdapter = BluetoothAdapter.getDefaultAdapter();
		// BT Adapter binding  ��ü ����
		
		// �׳� ���� ���ִ°�
		if(!mAdapter.isEnabled()) {
			Intent enableIntent = new Intent (BluetoothAdapter.ACTION_REQUEST_ENABLE);
		}
		
		Log.d("DEVICELIST", "Super called for DeviceListFragment onCreate\n");
	    // ����̽� ������ ������  DeviceItem ������ �����ϴ� ��� ����Ʈ
		deviceItemList = new ArrayList<DeviceItem>();
		deviceMAClist = new ArrayList<String>();
	 
	    String tempString = mAdapter.getAddress();

	    Log.d(LOG_TAG, " :: " + tempString);
	    
//	    if (pairedDevices.size() > 0) {
//	        for (BluetoothDevice device : pairedDevices) {
//	            DeviceItem newDevice= new DeviceItem(device.getName(),device.getAddress());
//	            deviceItemList.add(newDevice);
//	        }
//	    }

	    
	}
	public void onClick(View view){
		if(view==alert){
			doPopUpScreen();
		}
	}
	
	public void doPopUpScreen() {
		new AlertDialog.Builder(this)
		.setTitle("ġ��ȯ�� �̸� : ȫ�浿")
		.setMessage("��ȣ�� �ڵ������� ��ȭ����")
		.setNeutralButton("�ݱ�",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dlg, int sumthin) {
				// �⺻������ â�� ������ �߰� �۾��� ����(�����鼭 �������� ��)
			}
		})
		.show();
	}
	
	private BroadcastReceiver BTReceiver = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // Create a new device item
                DeviceItem newDevice = new DeviceItem(device.getName(), device.getAddress());
                // Add it to our adapter
                if(newDevice.getDeviceName().equalsIgnoreCase(MACAddr)) {
                	// �˾� â ���� 
                	doPopUpScreen();
                }
            }
        }

	};
}
