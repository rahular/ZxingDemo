package com.zxing.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	protected static final int REQUEST_CODE = 1;
	Button scanButton;
	TextView scannedString;

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				scannedString.setText(data.getStringExtra("result"));
			}
			if (resultCode == RESULT_CANCELED) {
				Toast.makeText(this.getApplicationContext(), "Action Cancelled",
						Toast.LENGTH_LONG).show();
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		scanButton = (Button) findViewById(R.id.btn_scan);
		scannedString = (TextView) findViewById(R.id.scanned_string);
		
		scanButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivityForResult(new Intent(getBaseContext(),
						ScannerActivity.class), REQUEST_CODE);
			}
		});
	}

}
