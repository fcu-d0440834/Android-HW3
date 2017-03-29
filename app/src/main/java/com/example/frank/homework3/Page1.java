package com.example.frank.homework3;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Page1 extends AppCompatActivity {

    private Button next_page;
    public static final int set_name = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        next_page=(Button) findViewById(R.id.hello_btn);
        next_page.setOnClickListener(nextpage);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private View.OnClickListener nextpage = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(Page1.this,Page2.class);
            startActivityForResult(intent,set_name);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(item.getItemId()) {
            //noinspection SimplifiableIfStatement
            case R.id.action_settings:

            break;
            case R.id.action_web:
                        Uri uri = Uri.parse("https://www.google.com.tw");
                        Intent intent_uri = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent_uri);
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){

       if(intent ==null)
           return;
        super.onActivityResult(requestCode, resultCode, intent);
        switch(requestCode){

            case set_name:
                String input_str = intent.getStringExtra(Page2.KEY_input);
                Toast t = Toast.makeText(Page1.this,"Hello   "+input_str, Toast. LENGTH_LONG);
                t.show();

        }

    }
}