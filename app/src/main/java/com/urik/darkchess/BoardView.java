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
    protected static int GRID_WIDTH = 120;
    protected static int GRID_START = 100;
    public BoardView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        GRID_START = h / 2 - GRID_ROWS * GRID_WIDTH / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.DKGRAY);
        {
            Paint paintRect = new Paint();
            paintRect.setColor(Color.WHITE);
            paintRect.setStrokeWidth(4);
            paintRect.setStyle(Paint.Style.STROKE);
            for (int i = 0; i<GRID_COLUMS; i++){
                for (int j = 0; j<GRID_ROWS; j++) {
                    int left = i * GRID_WIDTH + GRID_START;
                    int top = j * GRID_WIDTH + GRID_START;
                    int right = left + GRID_WIDTH;
                    int bottom = top + GRID_WIDTH;
                    canvas.drawRect(left, top, right, bottom, paintRect);
                }
            }
            paintRect.setStrokeWidth(10);
            canvas.drawRect(GRID_START, GRID_START, GRID_START+GRID_COLUMS*GRID_WIDTH, GRID_START+GRID_ROWS*GRID_WIDTH, paintRect);
        }
    }
}
