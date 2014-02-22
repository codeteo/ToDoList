package org.codeteo.todolist;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TaskListFragment extends ListFragment {
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

    	View view = inflater.inflate(R.layout.list_fragment, null);
    	return view;
    }
}
