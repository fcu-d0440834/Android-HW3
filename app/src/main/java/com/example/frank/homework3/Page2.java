package com.example.frank.homework3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Page2 extends AppCompatActivity {


    private EditText input;

    public static final String KEY_input = "KEY_input" ;

    private View.OnClickListener backpage = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent i = new Intent();
            i.putExtra(KEY_input, input.getText().toString());

            setResult(RESULT_OK, i);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        input = (EditText)findViewById(R.id.etinput);
        Button backbt=(Button) findViewById(R.id.backbtn);
        backbt.setOnClickListener(backpage);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
