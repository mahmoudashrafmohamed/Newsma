package com.mah.newsma;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.mah.newsma.dataprocess.DataEncap;
import com.mah.newsma.dataprocess.JsonParser;
import com.mah.newsma.recycler.AdapterNews;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    final static String api="https://newsapi.org/v1/articles?source=entertainment-weekly&sortBy=top&apiKey=6263d2038c204e1e87c19668148f5095";
    ArrayList<DataEncap> ar;

    JsonParser parser;
    private RecyclerView recyclerView;
    private AdapterNews adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Connector connector = new Connector();

        try {
            String json_File = connector.execute(api).get();

             parser = new JsonParser();

            ar = parser.JsonProcess(json_File);

            for (int i =0; i<ar.size(); i++){
                System.out.println(ar.get(i).getTitle());
            }

            recyclerMain();


        }catch (Exception e) {
            e.printStackTrace();
        }

        /*test
        try {
            String data = connector.execute(api).get();
            System.out.println(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/


       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);


    }

    private void recyclerMain() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdapterNews(parser.getlist(), getApplicationContext(), this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter.notifyDataSetChanged();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
