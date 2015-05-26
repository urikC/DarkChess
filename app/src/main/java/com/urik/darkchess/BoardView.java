package com.urik.darkchess;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BoardView extends View{
    protected static int GRID_COLUMS = 4;
    protected static int GRID_ROWS = 8;
    protected static int GRID_SIZE = 120;
    protected static int GRID_START = 40;

    public BoardView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

/*
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        GRID_SIZE = w / 6;
    }*/

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /* * 畫底色 * */
        canvas.drawColor(Color.rgb(112, 108, 88));

        /* * 畫棋盤 * */
        {
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(4);
            paint.setStyle(Paint.Style.STROKE);
            for (int i = 0; i<GRID_COLUMS; i++){
                for (int j = 0; j<GRID_ROWS; j++) {
                    int left = i * GRID_SIZE + GRID_START;
                    int top = j * GRID_SIZE + GRID_START;
                    int right = left + GRID_SIZE;
                    int bottom = top + GRID_SIZE;
                    canvas.drawRect(left, top, right, bottom, paint);
                }
            }

            /* * 畫外框 * */
            canvas.drawRect(GRID_START, GRID_START, GRID_START+GRID_COLUMS*GRID_SIZE, GRID_START+GRID_ROWS*GRID_SIZE, paint);

            /* * 畫死棋區第一格 * */
            canvas.drawRect(2*GRID_START+4*GRID_SIZE, GRID_START, 2*GRID_START+5*GRID_SIZE, GRID_START+3*GRID_SIZE, paint);

            /* * 畫reset按鈕區 * */
            canvas.drawRect(2*GRID_START+4*GRID_SIZE, 2*GRID_START+3*GRID_SIZE, 2*GRID_START+5*GRID_SIZE, 5*GRID_SIZE, paint);

            /* * 畫死棋區第二格 * */
            canvas.drawRect(2*GRID_START+4*GRID_SIZE, GRID_START+5*GRID_SIZE, 2*GRID_START+5*GRID_SIZE, GRID_START+GRID_ROWS*GRID_SIZE, paint);
        }
    }
}
