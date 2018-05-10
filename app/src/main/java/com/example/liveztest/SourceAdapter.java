package com.example.liveztest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SourceAdapter extends ArrayAdapter<LiveSource> {
    private int sourceId;
    private Context mContext;
    public SourceAdapter(Context context, int textViewResourceId, List<LiveSource> objects) {
        super(context,textViewResourceId,objects);
        sourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        final LiveSource source = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertview == null) {
            view = LayoutInflater.from(getContext()).inflate(sourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.sourceName = (TextView) view.findViewById(R.id.source_name);
            view.setTag(viewHolder);
            viewHolder.sourceName.setTag(position);
        } else {
            view = convertview;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.sourceName.setText(source.getSourceName());
        return view;
    }

    class ViewHolder {
        TextView sourceName;
    }
}
