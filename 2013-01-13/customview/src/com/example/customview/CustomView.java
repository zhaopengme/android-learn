package com.example.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Bitmap.Config;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View {

	float preX;
	float preY;
	private Path path;
	public Paint paint = null;
	final int VIEW_WIDTH = 320;
	final int VIEW_HEIGHT = 480;
	Bitmap cacheBitmap = null;
	Canvas cacheCanvas = null;

	public CustomView(Context context, AttributeSet set) {
		super(context, set);
		cacheBitmap = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,
				Config.ARGB_8888);
		cacheCanvas = new Canvas();
		cacheCanvas.setBitmap(cacheBitmap);
		path = new Path();
		paint = new Paint(Paint.DITHER_FLAG);
		paint.setColor(Color.RED);//画笔颜色
		paint.setStyle(Paint.Style.STROKE);//设置为实心
		paint.setStrokeWidth(5);//画笔大小
		paint.setAntiAlias(true);// 防锯齿
		paint.setDither(true);// 防抖动
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			path.moveTo(x, y);
			preX = x;
			preY = y;
			break;
		case MotionEvent.ACTION_MOVE:
			path.quadTo(preX, preY, x, y);
			preX = x;
			preY = y;
			break;
		case MotionEvent.ACTION_UP:
			cacheCanvas.drawPath(path, paint);
			path.reset();
			break;
		}
		invalidate();
		return true;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint bmpPaint = new Paint();
		canvas.drawBitmap(cacheBitmap, 0, 0, bmpPaint);
		canvas.drawPath(path, paint);
	}
}