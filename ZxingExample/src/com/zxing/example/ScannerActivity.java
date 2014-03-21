package com.zxing.example;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;

import com.google.zxing.Result;
import com.google.zxing.client.android.CaptureActivity;

public class ScannerActivity extends CaptureActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scanner);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	}

	@Override
	public void handleDecode(Result rawResult, Bitmap barcode) {
		Intent returnIntent = new Intent();
		returnIntent.putExtra("result", rawResult.getText());
		setResult(RESULT_OK, returnIntent);
		finish();
	}
}