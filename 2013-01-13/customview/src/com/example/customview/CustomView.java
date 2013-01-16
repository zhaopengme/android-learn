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
				Config.ARGB_8888);// 构建一个图像对象，图片质量为ARGB_8888，最高
		cacheCanvas = new Canvas();// 创建一个画布
		cacheCanvas.setBitmap(cacheBitmap);// 将图像对象画到画布上面
		path = new Path();// 创建一个路径对象
		paint = new Paint();// 创建一个画笔对象
		paint.setColor(Color.RED);// 画笔颜色
		paint.setStyle(Paint.Style.STROKE);// 设置为实心
		paint.setStrokeJoin(Paint.Join.ROUND);
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeWidth(25);// 画笔大小
		paint.setAntiAlias(true);// 防锯齿
		paint.setDither(true);// 防抖动
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();// 事件发生的x坐标
		float y = event.getY();// 事件发生的y坐标
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:// 按下
			path.moveTo(x, y);// path移动到x.y
			preX = x;// 记录此时的x坐标
			preY = y;// 记录此时的y坐标
			break;
		case MotionEvent.ACTION_MOVE:// 移动
			path.quadTo(preX, preY, x, y);// 画曲线 从最近的preX,preY画曲线到x,y
			preX = x;// 记录此时的x坐标
			preY = y;// 记录此时的y坐标
			break;
		case MotionEvent.ACTION_UP:// 抬起
			cacheCanvas.drawPath(path, paint);// 将path路径画到画布上面
			path.reset();// 重置path
			break;
		}
		invalidate();// 绘制刷新view
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