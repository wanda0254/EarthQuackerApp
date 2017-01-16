package xyz.fatahillah.earthquackerapp;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.net.URL;
import java.util.ArrayList;

import xyz.fatahillah.earthquackerapp.adapter.EarthQuakeAdapter;
import xyz.fatahillah.earthquackerapp.model.Earthquake;

public class MainActivity extends AppCompatActivity {
    EarthQuakeAdapter adapter;
    ArrayList<Earthquake>earthquakes;
    ListView earthQuakeListView;
    private static final String USGS_REQUEST_URL = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=4&limit=30";

    private class DownloadTaskEarthQuake extends AsyncTask<Void,Void,ArrayList<Earthquake>> {

        @Override
        protected ArrayList<Earthquake> doInBackground(Void... voids) {

            //set up URL
            URL url = QueryUtils.createURL(USGS_REQUEST_URL);

            //membuat http request ke URL dan menerima response JSON
            String jsonResponse = null;

            jsonResponse = QueryUtils.makeHttoRequest(url);

            // convert respone dalam bentuk jason menjadi array list
            ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes(jsonResponse);

            //return list
            return earthquakes;

        }

        @Override
        protected void onPostExecute(ArrayList<Earthquake> earthQuakes) {
            super.onPostExecute(earthQuakes);
            //add eartquake ke list view
            for(int i = 0;i < earthQuakes.size(); i++){
                adapter.add(earthQuakes.get(i));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DownloadTaskEarthQuake().execute();

        // Create a fake list of earthquakes.
        /**ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();**/

        //membuat data dummy dari eartquake
        ArrayList<Earthquake> earthQuakes = new ArrayList<Earthquake>();

        //listview
        earthQuakeListView = (ListView) findViewById(R.id.list);

        //membuat adapter
        adapter = new EarthQuakeAdapter(this,earthQuakes);

        //set Adapter
        earthQuakeListView.setAdapter(adapter);

        earthQuakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //mendapatkan data eratquke
                Earthquake currentEarthQuake = adapter.getItem(position);

                //convert String url menjadi URI object
                Uri earthQuakeUri = Uri.parse(currentEarthQuake.getmUrl());

                //create new intent untuk membuka halaman website dari eartquake
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthQuakeUri);

                //mengirim intent untuk membuka website
                startActivity(websiteIntent);
            }
        });

    }
}
