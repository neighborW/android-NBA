package com.example.mrwang.nbademo2019.model.adapter;

import android.content.Context;
import android.view.*;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mrwang.nbademo2019.R;
import com.example.mrwang.nbademo2019.RaceActivity;
import com.example.mrwang.nbademo2019.model.Race;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Race> races = null;
    private LayoutInflater inflater;
    private TextView title,title1,title2,title3;
    private Context context;
    @Override
    public int getCount() {
        return races==null?0:races.size();

    }
    public MyAdapter(List<Race> raceList, Context context){
        races = raceList;
        this.context = context;
    }
    @Override
    public Object getItem(int position) {
        return races.get(position);

    }
    @Override
    public long getItemId(int position) {
        return position;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = View.inflate(context,R.layout.race , null);
        Race races = (Race) getItem(position);
        title = (TextView)view.findViewById(R.id.title);
        title1 = (TextView)view.findViewById(R.id.title1);
        title2= (TextView)view.findViewById(R.id.title2);
        title3 = (TextView)view.findViewById(R.id.title3);


        title.setText(races.getRaceday());
        title1.setText(races.getRacetime());
        title2.setText(races.getHometeam());
        title3.setText(races.getGuestteam());
        return view;

    }

}
