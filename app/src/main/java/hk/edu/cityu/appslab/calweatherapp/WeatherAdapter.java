package hk.edu.cityu.appslab.calweatherapp;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WeatherAdapter extends BaseAdapter {

    private List<Weather> weatherList;

    public WeatherAdapter(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return weatherList.size();
    }

    @Override
    public Weather getItem(int position) {
        // TODO Auto-generated method stub
        return weatherList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1. create a new ViewHolder
        WeatherHolder holder;
        //2. init ViewHolder
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
        } else {
            
        }
        //3. update content
        Weather weather = weatherList.get(position);
        

        //4. return the view
        return convertView;
    }

    static class WeatherHolder {

        TextView day;
        TextView date;
        TextView high;
        TextView text;
        ImageView icon;

    }

}
