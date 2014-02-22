package org.codeteo.todolist;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity  implements TopFragment.OnItemAddedListener {
	
	  private ArrayList<DataItem> todoItems;
	  private TaskListAdapter aa;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	      
	    // Get references to the Fragments
	    FragmentManager fm = getFragmentManager();
	    TaskListFragment todoListFragment = 
	    		(TaskListFragment)fm.findFragmentById(R.id.TaskListFragment);
	     
	    // Create the array list of to do items
	    todoItems = new ArrayList<DataItem>();
	     
	    // Create the array adapter to bind the array to the ListView
	    int resID = R.layout.tasklist_fragment; 		
	    aa = new TaskListAdapter(this, resID, todoItems);
	     
	    // Bind the array adapter to the ListView.
	    todoListFragment.setListAdapter(aa);
	  }
	  
	  public void onNewItemAdded(String newItem) {
	    DataItem newTodoItem = new DataItem(newItem);
	    todoItems.add(0, newTodoItem);
	    aa.notifyDataSetChanged();
	  }

}