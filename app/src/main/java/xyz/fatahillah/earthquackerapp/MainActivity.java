package xyz.fatahillah.earthquackerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //membuat data dummy
        ArrayList<String> earthQuake = new ArrayList<String>();
        earthQuake.add("Garut");
        earthQuake.add("Bandung");
        earthQuake.add("Jakarta");
        earthQuake.add("Surabaya");
        earthQuake.add("Yogyakarta");
        earthQuake.add("Medan");

        //find list view
        ListView earthQuakeListView = (ListView) findViewById(R.id.list);

        //create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,earthQuake);

        //set adapter
        earthQuakeListView.setAdapter(adapter);

    }


}
