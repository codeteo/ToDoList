package org.codeteo.todolist;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class TopFragment extends Fragment {
	
	  private OnItemAddedListener newItemListener;
	  
	  public interface OnItemAddedListener {
		  public void onNewItemAdded(String newItem);	//one method to pass data to the MainActivity
	  }

	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		  
	    View v = inflater.inflate(R.layout.top_fragment, container, false);

	    final EditText myEditText = (EditText)v.findViewById(R.id.myEditText1);

	    myEditText.setOnEditorActionListener(new OnEditorActionListener() {
	        @Override
	        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
	            boolean handled = false;
	            if (actionId == EditorInfo.IME_ACTION_SEND) {
	                String newItem = myEditText.getText().toString();
	                newItemListener.onNewItemAdded(newItem);
	                myEditText.setText("");
	                handled = true;
	            }
	            return handled;
	        }
	    });

	    return v;
	  }
	  

	  @Override
	  public void onAttach(Activity activity) {
	    super.onAttach(activity);
	      
	    try {
	    	newItemListener = (OnItemAddedListener)activity;
	    } catch (ClassCastException e) {
	      throw new ClassCastException(activity.toString() + 
	                " must implement OnItemAddedListener");
	    }
	  }


}
