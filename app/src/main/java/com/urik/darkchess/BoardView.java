package com.urik.darkchess;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;

public class BoardView extends View{
    protected static int GRID_COLUMS = 4;
    protected static int GRID_ROWS = 8;
    protected static int GRID_WIDTH = 80;
    protected static int GRID_START = 30;

    public ImageButton a1, a2, a3, a4, a5, a6, a7, a8;
    public ImageButton b1, b2, b3, b4, b5, b6, b7, b8;
    public ImageButton c1, c2, c3, c4, c5, c6, c7, c8;
    public ImageButton d1, d2, d3, d4, d5, d6, d7, d8;

    public BoardView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        GRID_WIDTH = w / 6;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.DKGRAY);
        /*
        * 畫棋盤
                * */
        {
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(4);
            paint.setStyle(Paint.Style.STROKE);
            for (int i = 0; i<GRID_COLUMS; i++){
                for (int j = 0; j<GRID_ROWS; j++) {
                    int left = i * GRID_WIDTH + GRID_START;
                    int top = j * GRID_WIDTH + GRID_START;
                    int right = left + GRID_WIDTH;
                    int bottom = top + GRID_WIDTH;
                    canvas.drawRect(left, top, right, bottom, paint);
                }
            }

            canvas.drawLine(GRID_START, GRID_START+2*GRID_WIDTH, GRID_START+GRID_WIDTH, GRID_START+3*GRID_WIDTH, paint);
            canvas.drawLine(GRID_START+GRID_WIDTH, GRID_START+2*GRID_WIDTH, GRID_START, GRID_START+3*GRID_WIDTH, paint);

            canvas.drawLine(GRID_START, GRID_START+5*GRID_WIDTH, GRID_START+GRID_WIDTH, GRID_START+6*GRID_WIDTH, paint);
            canvas.drawLine(GRID_START+GRID_WIDTH, GRID_START+5*GRID_WIDTH, GRID_START, GRID_START+6*GRID_WIDTH, paint);

            canvas.drawLine(GRID_START+3*GRID_WIDTH, GRID_START+2*GRID_WIDTH, GRID_START+4*GRID_WIDTH, GRID_START+3*GRID_WIDTH, paint);
            canvas.drawLine(GRID_START+4*GRID_WIDTH, GRID_START+2*GRID_WIDTH, GRID_START+3*GRID_WIDTH, GRID_START+3*GRID_WIDTH, paint);

            canvas.drawLine(GRID_START+3*GRID_WIDTH, GRID_START+5*GRID_WIDTH, GRID_START+4*GRID_WIDTH, GRID_START+6*GRID_WIDTH, paint);
            canvas.drawLine(GRID_START+4*GRID_WIDTH, GRID_START+5*GRID_WIDTH, GRID_START+3*GRID_WIDTH, GRID_START+6*GRID_WIDTH, paint);
            paint.setStrokeWidth(10);
            /*
            * 畫外框
            * */
            canvas.drawRect(GRID_START, GRID_START, GRID_START+GRID_COLUMS*GRID_WIDTH, GRID_START+GRID_ROWS*GRID_WIDTH, paint);
            /*
            * 畫死棋區第一格
            * */
            canvas.drawRect(2*GRID_START+4*GRID_WIDTH, GRID_START, 2*GRID_START+5*GRID_WIDTH, GRID_START+3*GRID_WIDTH, paint);
            /*
            * 畫reset按鈕區
            * */
            canvas.drawRect(2*GRID_START+4*GRID_WIDTH, 2*GRID_START+3*GRID_WIDTH, 2*GRID_START+5*GRID_WIDTH, 5*GRID_WIDTH, paint);
            /*
            * 畫死棋區第二格
            * */
            canvas.drawRect(2*GRID_START+4*GRID_WIDTH, GRID_START+5*GRID_WIDTH, 2*GRID_START+5*GRID_WIDTH, GRID_START+GRID_ROWS*GRID_WIDTH, paint);

        }
    }
}
