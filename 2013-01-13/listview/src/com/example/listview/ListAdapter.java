package com.example.listview;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

	private List<String> textList;
	private Context context;

	public ListAdapter(List<String> textList, Context context) {
		this.textList = textList;
		this.context = context;
	}

	@Override
	public int getCount() {
		return textList.size();
	}

	@Override
	public Object getItem(int position) {
		return textList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView tv = null;
		if (convertView == null) {
			tv = new TextView(context);
			tv.setText(position);
		} else {
			tv = (TextView) convertView;
		}
		return convertView;
	}

}
