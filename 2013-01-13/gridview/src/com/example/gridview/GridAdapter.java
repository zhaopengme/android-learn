package com.example.gridview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
	private Context context;
	private List<String> items;

	public GridAdapter(Context context, List<String> items) {
		this.context = context;
		this.items = items;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(this.context).inflate(
					R.layout.item, null);
			ItemViewCache item = new ItemViewCache();
			item.tv = (TextView) convertView.findViewById(R.id.itemText);
			convertView.setTag(item);
		}
		ItemViewCache ivc = (ItemViewCache) convertView.getTag();
		ivc.tv.setText(items.get(position));
		return convertView;
	}

}
