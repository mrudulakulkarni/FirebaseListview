package com.example.admin.firebaselistview;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    final static  String DB_URL= "https://fir-listview-ff170.firebaseio.com/";
    EditText nameeditText,urleditText;
    Button btnsave;
    ListView listView;
    FirebaseClient firebaseClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=(ListView)findViewById(R.id.listview);
        firebaseClient= new FirebaseClient(this, DB_URL,listView);
        firebaseClient.refreshdata();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayDialog();

            }
        });
    }

    private void displayDialog()
    {
        Dialog d= new Dialog(this);
        d.setTitle("SaveData");
        d.setContentView(R.layout.customdialog_layout);
        nameeditText= (EditText)d.findViewById(R.id.nameEditText);
        urleditText=(EditText)d.findViewById(R.id.urlEditText);
        btnsave= (Button)d.findViewById(R.id.saveBtn);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseClient.savedata(nameeditText.getText().toString(),urleditText.getText().toString());

                nameeditText.setText("");
                urleditText.setText("");
            }
        });

        d.show();

    }




}
