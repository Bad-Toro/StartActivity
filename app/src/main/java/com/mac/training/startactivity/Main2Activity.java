package com.mac.training.startactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    EditText txtName;
    TextView bckTxt;
    String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtName = ((EditText) findViewById(R.id.myLbl));
        bckTxt = (TextView) findViewById(R.id.backTxt) ;

        Intent i = getIntent();
        txtName.setText(i.getStringExtra("Name"));
    }

    @Override
    public void onBackPressed() {

        doIt();
        super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("TheName",bckTxt.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        bckTxt.setText(savedInstanceState.getString("TheName","Default"));
    }

    public void onGD(View view) {
        doIt();
        finish();
    }

    private void doIt() {
        Intent i = new Intent();
        i.putExtra("Name", bckTxt.getText().toString());
        setResult(RESULT_OK, i);
    }

    public void onSet(View view) {
        bckTxt.setText(txtName.getText().toString());
    }
}
