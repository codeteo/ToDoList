package org.codeteo.todolist;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomItemView extends TextView {
	 
	 private Rect mRect;
	 private Paint mPaint;
	   
	 private int attrTextColor;
     private int attrBGColor;

	  
	  
	 public CustomItemView(Context context) {
	  super(context);
	 }
	 
	 public CustomItemView(Context context, AttributeSet attrs) {
	  super(context, attrs);
	   
	  TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomItemView);
	     attrTextColor = ta.getInteger(R.styleable.CustomItemView_attr_textcolor, 0xFF9966FF);
	     attrBGColor = ta.getInteger(R.styleable.CustomItemView_attr_bgcolor, 0xFFC0C0C0);
	     ta.recycle();
	     
	     init();
	 }
	 
	 public void init() {
	   
		  mRect = new Rect();
		  mPaint = new Paint();
		  mPaint.setStyle(Paint.Style.FILL);
		  mPaint.setColor(attrTextColor);    //get value from attr
		  
	 }
	  
	  
	 @Override
	 protected void onDraw(Canvas canvas) {
	  int count = getLineCount();
	   
	  canvas.drawColor(attrBGColor); 
	  
	  Rect r = mRect;
	  Paint p = mPaint;
	   
	   
		 for(int i=0; i< count; i++)  {
			 int baseline = getLineBounds(i, r);
			 canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, p);
		  }
	   
		  super.onDraw(canvas);
	 }
	  
}
