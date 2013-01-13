package com.example.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private String[] texts = new String[] { "天气", "我团", "背景" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(new TextListAdapter(this));
	}

	private class TextListAdapter extends BaseAdapter {
		private Context context;

		public TextListAdapter(Context c) {
			this.context = c;
		}

		@Override
		public int getCount() {
			return texts.length;
		}

		@Override
		public Object getItem(int position) {
			return texts[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.list, null);
				ItemViewCache ivc = new ItemViewCache();
				ivc.tv = (TextView) convertView.findViewById(R.id.ItemTitle);
				convertView.setTag(ivc);
			}
			ItemViewCache cache = (ItemViewCache) convertView.getTag();
			cache.tv.setText(texts[position]);
			return convertView;
		}

	}

	private static class ItemViewCache {
		public TextView tv;
	}

	private List<String> getList() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		return list;
	}

}
