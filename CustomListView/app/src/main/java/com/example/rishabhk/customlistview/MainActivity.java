package com.example.rishabhk.customlistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //created methods which will be called to interface with the listview created

        //will call populatelistview() to let the adapter take the values from the array
        //and fit it acording to our listview
        populateListView();
        //this will fetch the listview data if any row is clicked and parse it using a toast
        giveFeedbackonitemClick();
    }

    private void giveFeedbackonitemClick() {
        //create a listview and linking it with custom list layout
        ListView list = (ListView)findViewById(R.id.listView_data);
        //setting onclick listener to listen if any row is clicked
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                TextView tv = (TextView) view;
                String message = "You clicked "+ position + "which is " + tv.getText().toString();
                Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateListView() {
        //creating the static data that is to be stored into the listview using the adapter
        String[] myItems = {"Blue", "green", "Purple", "red"};

        //creating listviewadapter which is an array for storing the data and linking it according to the
        //custom listview

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(this, R.layout.da_items, myItems);
        //linking the listview with our adapter to present data
        ListView Lv = (ListView)findViewById(R.id.listView_data);
        Lv.setAdapter(listViewAdapter);
    }
}
