package com.example.mrwang.nbademo2019.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mrwang.nbademo2019.R;
import com.example.mrwang.nbademo2019.model.Point;
import com.example.mrwang.nbademo2019.model.Race;

import java.util.List;

public class PointAdapter extends BaseAdapter {
    private List<Point> points = null;
    private LayoutInflater inflater;
    private TextView point1,point2,point3,point4,point5;
    private Context context;
    public PointAdapter(List<Point> points, Context context) {
        this.points = points;
        this.context = context;
    }

    @Override
    public int getCount() {
        return points==null?0:points.size();
    }

    @Override
    public Object getItem(int position) {
        return points.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position,  View convertView, ViewGroup viewGroup) {

        View view = View.inflate(context,R.layout.playerpoint , null);
        Point points = (Point) getItem(position);

        point1 = (TextView)view.findViewById(R.id.point1);
        point2 = (TextView)view.findViewById(R.id.point2);
        point3 = (TextView)view.findViewById(R.id.point3);
        point4 = (TextView)view.findViewById(R.id.point4);
        point5 = (TextView)view.findViewById(R.id.point5);

        point1.setText(points.getPlayername());
        point2.setText(points.getPlayerteam());
        point3.setText(points.getPlayerscore());
        point4.setText(points.getPlayershotIn());
        point5.setText(points.getPlayerthreeIn());
        return view;
    }
}
