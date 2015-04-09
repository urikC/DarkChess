package com.urik.darkchess;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class BoardView extends View{
    protected static int GRID_COLUMS = 4;
    protected static int GRID_ROWS = 8;
    protected static int GRID_SIZE = 80;
    protected static int GRID_START = 30;

    public ImageButton a1, a2, a3, a4, a5, a6, a7, a8;
    public ImageButton b1, b2, b3, b4, b5, b6, b7, b8;
    public ImageButton c1, c2, c3, c4, c5, c6, c7, c8;
    public ImageButton d1, d2, d3, d4, d5, d6, d7, d8;



    public BoardView(Context context, AttributeSet attrs){
        super(context, attrs);
        initButton();

    }

    private void initButton() {
        a1 = (ImageButton) findViewById(R.id.a1);
        a2 = (ImageButton) findViewById(R.id.a2);
        a3 = (ImageButton) findViewById(R.id.a3);
        a4 = (ImageButton) findViewById(R.id.a4);
        a5 = (ImageButton) findViewById(R.id.a5);
        a6 = (ImageButton) findViewById(R.id.a6);
        a7 = (ImageButton) findViewById(R.id.a7);
        a8 = (ImageButton) findViewById(R.id.a8);

        b1 = (ImageButton) findViewById(R.id.b1);
        b2 = (ImageButton) findViewById(R.id.b2);
        b3 = (ImageButton) findViewById(R.id.b3);
        b4 = (ImageButton) findViewById(R.id.b4);
        b5 = (ImageButton) findViewById(R.id.b5);
        b6 = (ImageButton) findViewById(R.id.b6);
        b7 = (ImageButton) findViewById(R.id.b7);
        b8 = (ImageButton) findViewById(R.id.b8);

        c1 = (ImageButton) findViewById(R.id.c1);
        c2 = (ImageButton) findViewById(R.id.c2);
        c3 = (ImageButton) findViewById(R.id.c3);
        c4 = (ImageButton) findViewById(R.id.c4);
        c5 = (ImageButton) findViewById(R.id.c5);
        c6 = (ImageButton) findViewById(R.id.c6);
        c7 = (ImageButton) findViewById(R.id.c7);
        c8 = (ImageButton) findViewById(R.id.c8);

        d1 = (ImageButton) findViewById(R.id.d1);
        d2 = (ImageButton) findViewById(R.id.d2);
        d3 = (ImageButton) findViewById(R.id.d3);
        d4 = (ImageButton) findViewById(R.id.d4);
        d5 = (ImageButton) findViewById(R.id.d5);
        d6 = (ImageButton) findViewById(R.id.d6);
        d7 = (ImageButton) findViewById(R.id.d7);
        d8 = (ImageButton) findViewById(R.id.d8);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        GRID_SIZE = w / 6;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /* * 畫底色 * */
        canvas.drawColor(Color.DKGRAY);

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

            /* * 畫4個X * */
            canvas.drawLine(GRID_START, GRID_START+2*GRID_SIZE, GRID_START+GRID_SIZE, GRID_START+3*GRID_SIZE, paint);
            canvas.drawLine(GRID_START+GRID_SIZE, GRID_START+2*GRID_SIZE, GRID_START, GRID_START+3*GRID_SIZE, paint);

            canvas.drawLine(GRID_START, GRID_START+5*GRID_SIZE, GRID_START+GRID_SIZE, GRID_START+6*GRID_SIZE, paint);
            canvas.drawLine(GRID_START+GRID_SIZE, GRID_START+5*GRID_SIZE, GRID_START, GRID_START+6*GRID_SIZE, paint);

            canvas.drawLine(GRID_START+3*GRID_SIZE, GRID_START+2*GRID_SIZE, GRID_START+4*GRID_SIZE, GRID_START+3*GRID_SIZE, paint);
            canvas.drawLine(GRID_START+4*GRID_SIZE, GRID_START+2*GRID_SIZE, GRID_START+3*GRID_SIZE, GRID_START+3*GRID_SIZE, paint);

            canvas.drawLine(GRID_START+3*GRID_SIZE, GRID_START+5*GRID_SIZE, GRID_START+4*GRID_SIZE, GRID_START+6*GRID_SIZE, paint);
            canvas.drawLine(GRID_START+4*GRID_SIZE, GRID_START+5*GRID_SIZE, GRID_START+3*GRID_SIZE, GRID_START+6*GRID_SIZE, paint);
            paint.setStrokeWidth(10);

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
