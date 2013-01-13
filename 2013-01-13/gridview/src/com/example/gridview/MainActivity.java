package com.example.gridview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		GridView gv = (GridView) findViewById(R.id.gridView1);
		gv.setAdapter(new GridAdapter(this, getItems()));
	}

	private List<String> getItems() {
		List<String> items = new ArrayList<String>();
		items.add("a");
		items.add("a");
		items.add("a");
		items.add("a");
		items.add("a");
		items.add("a");
		items.add("a");
		items.add("a");
		items.add("a");
		items.add("a");
		items.add("a");
		items.add("a");
		return items;
	}

}
