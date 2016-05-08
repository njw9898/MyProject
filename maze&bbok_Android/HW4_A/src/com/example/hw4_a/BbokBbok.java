package com.example.hw4_a;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class BbokBbok extends View {

	private int c_x=0, c_y=0;
	private boolean[][] check;
	private Bitmap on, pop;
	private int screenWidth, screenHeight;
	private boolean finish;
	
	public BbokBbok(Context c) {
		super(c);
		init();
		
		Display display = ((WindowManager)c.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		screenWidth = display.getWidth();
		screenHeight = display.getHeight();
	}

	public BbokBbok(Context c, AttributeSet a) {
		super(c, a);
		
		init();
		
		Display display = ((WindowManager)c.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		screenWidth = display.getWidth();
		screenHeight = display.getHeight();
	}
	
	public void init()
	{
		check = new boolean[6][10];
		finish = false;
		
		for(int i = 0; i<6; i++)
			for(int j = 0; j<10; j++)
				check[i][j] = true;
	
		Resources res = getResources();
		on = BitmapFactory.decodeResource(res, R.drawable.on);
	    pop = BitmapFactory.decodeResource(res, R.drawable.pop);	
	}
	
	protected void onDraw(Canvas canvas)
	{
		if(finish)
			Toast.makeText(getContext(), "Finish!!", Toast.LENGTH_LONG).show();
		
		for(int x=0; x<6; x++)
		{
			for(int y=0; y<10; y++)
			{
				if((c_x < screenWidth/6 + x*on.getWidth() && c_x > x*on.getWidth()) 
						&& (c_y < screenHeight/10 + y*on.getHeight() && c_y > y*on.getHeight()))
				{
					check[x][y] = false;
					canvas.drawBitmap(pop, x*on.getWidth(), y*on.getHeight(), null);
					canvas.save();
				}
				else
				{
					if(check[x][y])
						canvas.drawBitmap(on, x*on.getWidth(), y*on.getHeight(), null);
					else
						canvas.drawBitmap(pop, x*on.getWidth(), y*on.getHeight(), null);
				}
			}
		}
	}
	
	public boolean onTouchEvent(MotionEvent event)
	{
		c_x = (int)event.getX();
		c_y = (int)event.getY();
		
		if(event.getAction() == MotionEvent.ACTION_UP)
		{
			if(checkEnd())
				finish = true;
			invalidate();
		}
		return true;
	}
	
	private boolean checkEnd()
	{
		for(int i=0; i<6; i++)
		{
			for(int j=0; j<10; j++)
			{
				if(check[i][j])
					return false;
			}
		}
		
		return true;
	}
	
}
