package hk.edu.cityu.appslab.calweatherapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    // for example
    TextView xml;


    // Data Source
    List<Weather> data;

    // Adapter
    WeatherAdapter weatherAdapter;

    private ListView weatherList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private View emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewCompat.setElevation(toolbar, getResources().getDimension(R.dimen.elevation));

        weatherList = (ListView) findViewById(R.id.weather_list);
        
        new WeatherQueryTask().execute();

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
        

        return super.onOptionsItemSelected(item);
    }

    private class WeatherQueryTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            weatherList.setAdapter(null);
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            // 1. Populate the Data Source
            String xml = YWeatherAPI.getForecastXml();

            // 1.1 Convert the xml to List of Weather Object
            try {
                WeatherParser parser = new WeatherParser(xml);
                data = parser.getWeatherForecastList();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            // 2. Fill the adapter with 

            // 3. Setup the ListView
            
        }
    }
}
