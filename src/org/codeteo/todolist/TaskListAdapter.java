package org.codeteo.todolist;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TaskListAdapter extends ArrayAdapter<DataItem> {

  int resource;

  public TaskListAdapter(Context context, int resource, List<DataItem> items) {
	  super(context, resource, items);
	  this.resource = resource;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LinearLayout todoView;

    DataItem item = getItem(position);
    String taskString = item.getTodo();

    if (convertView == null) {
      todoView = new LinearLayout(getContext());
      String inflater = Context.LAYOUT_INFLATER_SERVICE;
      LayoutInflater li;
      li = (LayoutInflater)getContext().getSystemService(inflater);
      li.inflate(resource, todoView, true);
    } else {
      todoView = (LinearLayout) convertView;
    }

    TextView taskView = (TextView)todoView.findViewById(R.id.row);

    taskView.setText(taskString);

    return todoView;
  }
}