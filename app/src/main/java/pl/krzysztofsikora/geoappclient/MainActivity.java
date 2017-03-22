package pl.krzysztofsikora.geoappclient;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static pl.krzysztofsikora.geoappclient.R.color.colorAccent;
import static pl.krzysztofsikora.geoappclient.R.color.customAccent;
import static pl.krzysztofsikora.geoappclient.R.id.parent;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private String[] activities;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        listView = (ListView) findViewById(R.id.listView);

        initResources();
        initActivitiesListView();


    }


    private void initResources() {
        Resources resources = getResources();
        activities = resources.getStringArray(R.array.activities);
    }

    private void initActivitiesListView() {
//        listView.setAdapter(new ArrayAdapter<String>(
//                getApplicationContext(),
//                android.R.layout.simple_list_item_1,
//                activities
//
//        ) );
        /* set color list view */
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, activities){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);

            /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                textView.setBackgroundColor(getResources().getColor(R.color.customAccent));
                return view;
            }
        };


        listView.setAdapter(adapter);
        listView.setBackgroundColor(getResources().getColor(R.color.customPrimary));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                click(position);
            }
        });







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

    public void click(int pos) {

        Intent intent;


        switch (pos) {

            case 0:
                intent = new Intent(MainActivity.this, AboutActivity.class);
                break;
//            case 1:
//                intent = new Intent(ToysActivity.this, CountdownActivity.class);
//                break;
//            case 2:
//                intent = new Intent(ToysActivity.this, PrimeNumberActivity.class);
//                break;
//            case 3:
//                intent = new Intent(ToysActivity.this, LevelActivity.class);
//                break;
//            case 4:
//                intent = new Intent(ToysActivity.this, DrawActivity.class);
//                break;
//            case 5:
//                intent = new Intent(ToysActivity.this, CameraActivity.class);
//                break;
            default:
                intent = new Intent(MainActivity.this, AboutActivity.class);
                break;

        }
        startActivity(intent);
    }

}
