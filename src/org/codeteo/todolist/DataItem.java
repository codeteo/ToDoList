package org.codeteo.todolist;

public class DataItem {
	
	String todo;

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	  public DataItem(String _todo) {
		    todo = _todo;
		}
	
	
	  @Override
	  public String toString() {
	    return todo;
	  }
	

}

