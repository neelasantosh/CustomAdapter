package com.example.cutomadapter;

import java.util.ArrayList;
import java.util.zip.Inflater;

import com.example.cutomadapter.R.layout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class HomeActivity extends Activity {
	ListView listViewCartoons;
	ArrayList<Cartoon> listCartoons = new ArrayList<Cartoon>();
	CartoonAdapter adapter;
	CheckBox checkCartoon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		listViewCartoons = (ListView) findViewById(R.id.listView1);
		checkCartoon=(CheckBox) findViewById(R.id.checkBox1);
		// intialize arraylist with some cartoon objects
		Cartoon c1 = new Cartoon("Jerry", true, R.drawable.micky);
		Cartoon c2 = new Cartoon("Donald", true, R.drawable.donald);
		Cartoon c3 = new Cartoon("Pickachu", true, R.drawable.picka);
		Cartoon c4 = new Cartoon("Tom", true, R.drawable.tom);
		
		listCartoons.add(c1);
		listCartoons.add(c2);
		listCartoons.add(c3);
		listCartoons.add(c4);
		// create and set adapter with listview

		adapter = new CartoonAdapter();
		listViewCartoons.setAdapter(adapter);

	}// eof oncreate

	class CartoonAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listCartoons.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return listCartoons.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			// load UI for Item
			LayoutInflater inflate = getLayoutInflater();
			View itemView = inflate.inflate(R.layout.item_view, null);

			// fill itemView with cartoon data
			final Cartoon c = listCartoons.get(position);

			ImageView imageViewCartoon = (ImageView) itemView
					.findViewById(R.id.imageView1);

			imageViewCartoon.setImageResource(c.getImageId());
			
			final TextView textViewCartoon = (TextView) itemView.findViewById(R.id.textView1);
			
			textViewCartoon.setText(c.getTitle());
			
			CheckBox checkViewCartoon = (CheckBox) itemView.findViewById(R.id.checkBox1);
			
			checkViewCartoon.setChecked(c.isSelected());
			
			checkViewCartoon.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					c.setSelected(isChecked);
					if(isChecked)
					{
						textViewCartoon.setTextColor(Color.GREEN);
					}
					else
					{
						textViewCartoon.setTextColor(Color.GRAY);
					}
					
				}
			});
			return itemView;
		}

	}

}// eof activity
