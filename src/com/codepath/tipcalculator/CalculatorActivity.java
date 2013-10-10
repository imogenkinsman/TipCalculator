package com.codepath.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class CalculatorActivity extends Activity {
	private EditText etTransaction;
	private TextView tvTipValue;
	private SeekBar sbTipPercent;
	private TextView tvTipPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        etTransaction = (EditText) findViewById(R.id.etTransaction);
        tvTipValue = (TextView) findViewById(R.id.tvTipValue);
        sbTipPercent = (SeekBar) findViewById(R.id.sbTipPercent);
        tvTipPercent = (TextView) findViewById(R.id.tvTipPercent);
        
        etTransaction.setImeOptions(EditorInfo.IME_ACTION_DONE);
        
        addActionListeners();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }

    private void addActionListeners() {
    	
        sbTipPercent.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				tvTipPercent.setText(String.valueOf(progress) + '%');
				
				if (!TextUtils.isEmpty(etTransaction.getText().toString())) {
					updateTipValue();
				}
			}
        });
        
        etTransaction.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				updateTipValue();
			}
		});
    }
    
    private void updateTipValue() {
		float transaction = Float.parseFloat(etTransaction.getText().toString());
		float percent = sbTipPercent.getProgress();
		tvTipValue.setText("$" + String.format("%.2f", transaction * percent / 100));
    }
        
}
