package com.urik.darkchess;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;


public class TraditionalMode extends ActionBarActivity {
    BoardView boardView;
    public ImageButton a1, a2, a3, a4, a5, a6, a7, a8;
    public ImageButton b1, b2, b3, b4, b5, b6, b7, b8;
    public ImageButton c1, c2, c3, c4, c5, c6, c7, c8;
    public ImageButton d1, d2, d3, d4, d5, d6, d7, d8;
    public ImageButton resetButton, temp, j;
    public ImageView x111, x112, x121, x122, x131, x132, x141, x142, x151, x152, x161, x162, x171, x172, x181, x182;
    public ImageView x211, x212, x221, x222, x231, x232, x241, x242, x251, x252, x261, x262, x271, x272, x281, x282;
    String piece_a1, piece_a2, piece_a3, piece_a4, piece_a5, piece_a6, piece_a7, piece_a8;
    String piece_b1, piece_b2, piece_b3, piece_b4, piece_b5, piece_b6, piece_b7, piece_b8;
    String piece_c1, piece_c2, piece_c3, piece_c4, piece_c5, piece_c6, piece_c7, piece_c8;
    String piece_d1, piece_d2, piece_d3, piece_d4, piece_d5, piece_d6, piece_d7, piece_d8;
    String swichKey, piece_temp;
    int turns, mode;
    public Random random = new Random();

    public static final int DARK = 15;
    public static final int EMPTY = 0;
    public static final int RED = 0;
    public static final int BLACK = 1;
    public static final int UNKNOWN = 2;
    public static final int MOVE = 0;
    public static final int FLIP = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initViews();
        initImage();
        initTags();
        initPiece();
        initOnClick();
    }

    private void initViews() {
        boardView = (BoardView) findViewById(R.id.board_view);

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

        x111 = (ImageView) findViewById(R.id.x111);
        x121 = (ImageView) findViewById(R.id.x121);
        x131 = (ImageView) findViewById(R.id.x131);
        x141 = (ImageView) findViewById(R.id.x141);
        x151 = (ImageView) findViewById(R.id.x151);
        x161 = (ImageView) findViewById(R.id.x161);
        x171 = (ImageView) findViewById(R.id.x171);
        x181 = (ImageView) findViewById(R.id.x181);
        x112 = (ImageView) findViewById(R.id.x112);
        x122 = (ImageView) findViewById(R.id.x122);
        x132 = (ImageView) findViewById(R.id.x132);
        x142 = (ImageView) findViewById(R.id.x142);
        x152 = (ImageView) findViewById(R.id.x152);
        x162 = (ImageView) findViewById(R.id.x162);
        x172 = (ImageView) findViewById(R.id.x172);
        x182 = (ImageView) findViewById(R.id.x182);

        x211 = (ImageView) findViewById(R.id.x211);
        x221 = (ImageView) findViewById(R.id.x221);
        x231 = (ImageView) findViewById(R.id.x231);
        x241 = (ImageView) findViewById(R.id.x241);
        x251 = (ImageView) findViewById(R.id.x251);
        x261 = (ImageView) findViewById(R.id.x261);
        x271 = (ImageView) findViewById(R.id.x271);
        x281 = (ImageView) findViewById(R.id.x281);
        x212 = (ImageView) findViewById(R.id.x212);
        x222 = (ImageView) findViewById(R.id.x222);
        x232 = (ImageView) findViewById(R.id.x232);
        x242 = (ImageView) findViewById(R.id.x242);
        x252 = (ImageView) findViewById(R.id.x252);
        x262 = (ImageView) findViewById(R.id.x262);
        x272 = (ImageView) findViewById(R.id.x272);
        x282 = (ImageView) findViewById(R.id.x282);

        resetButton = (ImageButton) findViewById(R.id.reset_button);
        j = (ImageButton) findViewById(R.id.j_button);
    }

    private void initImage() {
        a1.setImageResource(R.drawable.chess_back);
        a2.setImageResource(R.drawable.chess_back);
        a3.setImageResource(R.drawable.chess_back);
        a4.setImageResource(R.drawable.chess_back);
        a5.setImageResource(R.drawable.chess_back);
        a6.setImageResource(R.drawable.chess_back);
        a7.setImageResource(R.drawable.chess_back);
        a8.setImageResource(R.drawable.chess_back);

        b1.setImageResource(R.drawable.chess_back);
        b2.setImageResource(R.drawable.chess_back);
        b3.setImageResource(R.drawable.chess_back);
        b4.setImageResource(R.drawable.chess_back);
        b5.setImageResource(R.drawable.chess_back);
        b6.setImageResource(R.drawable.chess_back);
        b7.setImageResource(R.drawable.chess_back);
        b8.setImageResource(R.drawable.chess_back);

        c1.setImageResource(R.drawable.chess_back);
        c2.setImageResource(R.drawable.chess_back);
        c3.setImageResource(R.drawable.chess_back);
        c4.setImageResource(R.drawable.chess_back);
        c5.setImageResource(R.drawable.chess_back);
        c6.setImageResource(R.drawable.chess_back);
        c7.setImageResource(R.drawable.chess_back);
        c8.setImageResource(R.drawable.chess_back);

        d1.setImageResource(R.drawable.chess_back);
        d2.setImageResource(R.drawable.chess_back);
        d3.setImageResource(R.drawable.chess_back);
        d4.setImageResource(R.drawable.chess_back);
        d5.setImageResource(R.drawable.chess_back);
        d6.setImageResource(R.drawable.chess_back);
        d7.setImageResource(R.drawable.chess_back);
        d8.setImageResource(R.drawable.chess_back);


        x111.setImageResource(R.drawable.x_x);
        x121.setImageResource(R.drawable.x_x);
        x131.setImageResource(R.drawable.x_x);
        x141.setImageResource(R.drawable.x_x);
        x151.setImageResource(R.drawable.x_x);
        x161.setImageResource(R.drawable.x_x);
        x171.setImageResource(R.drawable.x_x);
        x181.setImageResource(R.drawable.x_x);
        x112.setImageResource(R.drawable.x_x);
        x122.setImageResource(R.drawable.x_x);
        x132.setImageResource(R.drawable.x_x);
        x142.setImageResource(R.drawable.x_x);
        x152.setImageResource(R.drawable.x_x);
        x162.setImageResource(R.drawable.x_x);
        x172.setImageResource(R.drawable.x_x);
        x182.setImageResource(R.drawable.x_x);

        x211.setImageResource(R.drawable.x_x);
        x221.setImageResource(R.drawable.x_x);
        x231.setImageResource(R.drawable.x_x);
        x241.setImageResource(R.drawable.x_x);
        x251.setImageResource(R.drawable.x_x);
        x261.setImageResource(R.drawable.x_x);
        x271.setImageResource(R.drawable.x_x);
        x281.setImageResource(R.drawable.x_x);
        x212.setImageResource(R.drawable.x_x);
        x222.setImageResource(R.drawable.x_x);
        x232.setImageResource(R.drawable.x_x);
        x242.setImageResource(R.drawable.x_x);
        x252.setImageResource(R.drawable.x_x);
        x262.setImageResource(R.drawable.x_x);
        x272.setImageResource(R.drawable.x_x);
        x282.setImageResource(R.drawable.x_x);
    }

    private void initTags() {
        a1.setTag(DARK);
        a2.setTag(DARK);
        a3.setTag(DARK);
        a4.setTag(DARK);
        a5.setTag(DARK);
        a6.setTag(DARK);
        a7.setTag(DARK);
        a8.setTag(DARK);

        b1.setTag(DARK);
        b2.setTag(DARK);
        b3.setTag(DARK);
        b4.setTag(DARK);
        b5.setTag(DARK);
        b6.setTag(DARK);
        b7.setTag(DARK);
        b8.setTag(DARK);

        c1.setTag(DARK);
        c2.setTag(DARK);
        c3.setTag(DARK);
        c4.setTag(DARK);
        c5.setTag(DARK);
        c6.setTag(DARK);
        c7.setTag(DARK);
        c8.setTag(DARK);

        d1.setTag(DARK);
        d2.setTag(DARK);
        d3.setTag(DARK);
        d4.setTag(DARK);
        d5.setTag(DARK);
        d6.setTag(DARK);
        d7.setTag(DARK);
        d8.setTag(DARK);

        x111.setTag(0);
        x112.setTag(0);
        x121.setTag(0);
        x122.setTag(0);
        x131.setTag(0);
        x132.setTag(0);
        x141.setTag(0);
        x142.setTag(0);
        x151.setTag(0);
        x152.setTag(0);
        x161.setTag(0);
        x162.setTag(0);
        x171.setTag(0);
        x172.setTag(0);
        x181.setTag(0);
        x182.setTag(0);

        x211.setTag(0);
        x212.setTag(0);
        x221.setTag(0);
        x222.setTag(0);
        x231.setTag(0);
        x232.setTag(0);
        x241.setTag(0);
        x242.setTag(0);
        x251.setTag(0);
        x252.setTag(0);
        x261.setTag(0);
        x262.setTag(0);
        x271.setTag(0);
        x272.setTag(0);
        x281.setTag(0);
        x282.setTag(0);
    }

    private void initPiece() {
        piece_a1 = "k1";
        piece_a2 = "m1";
        piece_a3 = "n1";
        piece_a4 = "p1";
        piece_a5 = "k2";
        piece_a6 = "m2";
        piece_a7 = "n2";
        piece_a8 = "p2";
        piece_b1 = "g1";
        piece_b2 = "r1";
        piece_b3 = "c1";
        piece_b4 = "p1";
        piece_b5 = "g2";
        piece_b6 = "r2";
        piece_b7 = "c2";
        piece_b8 = "p2";
        piece_c1 = "g1";
        piece_c2 = "r1";
        piece_c3 = "c1";
        piece_c4 = "p1";
        piece_c5 = "g2";
        piece_c6 = "r2";
        piece_c7 = "c2";
        piece_c8 = "p2";
        piece_d1 = "m1";
        piece_d2 = "n1";
        piece_d3 = "p1";
        piece_d4 = "p1";
        piece_d5 = "m2";
        piece_d6 = "n2";
        piece_d7 = "p2";
        piece_d8 = "p2";

        turns = UNKNOWN;
        mode = FLIP;

        for (int i=0; i<random.nextInt(300); i++){
            piece_temp = piece_a1;
            piece_a1 = piece_b1;
            piece_b1 = piece_c1;
            piece_c1 = piece_d1;
            piece_d1 = piece_temp;
            for (int j=0; j<random.nextInt(20); j++){
                piece_temp = piece_a1;
                piece_a1 = piece_a2;
                piece_a2 = piece_a3;
                piece_a3 = piece_a4;
                piece_a4 = piece_a5;
                piece_a5 = piece_a6;
                piece_a6 = piece_a7;
                piece_a7 = piece_a8;
                piece_a8 = piece_temp;
            }
            for (int j=0; j<random.nextInt(20); j++){
                piece_temp = piece_b8;
                piece_b8 = piece_b7;
                piece_b7 = piece_b6;
                piece_b6 = piece_b5;
                piece_b5 = piece_b4;
                piece_b4 = piece_b3;
                piece_b3 = piece_b2;
                piece_b2 = piece_b1;
                piece_b1 = piece_temp;
            }
            for (int j=0; j<random.nextInt(20); j++){
                piece_temp = piece_c1;
                piece_c1 = piece_c2;
                piece_c2 = piece_c3;
                piece_c3 = piece_c4;
                piece_c4 = piece_c5;
                piece_c5 = piece_c6;
                piece_c6 = piece_c7;
                piece_c7 = piece_c8;
                piece_c8 = piece_temp;
            }
            for (int j=0; j<random.nextInt(20); j++){
                piece_temp = piece_d8;
                piece_d8 = piece_d7;
                piece_d7 = piece_d6;
                piece_d6 = piece_d5;
                piece_d5 = piece_d4;
                piece_d4 = piece_d3;
                piece_d3 = piece_d2;
                piece_d2 = piece_d1;
                piece_d1 = piece_temp;
            }
        }
    }

    private void initOnClick() {
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(a1);
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(a2);
            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(a3);
            }
        });

        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(a4);
            }
        });

        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(a5);
            }
        });

        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(a6);
            }
        });

        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(a7);
            }
        });

        a8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(a8);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(b1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(b2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(b3);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(b4);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(b5);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(b6);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(b7);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(b8);
            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(c1);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(c2);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(c3);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(c4);
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(c5);
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(c6);
            }
        });

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(c7);
            }
        });

        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(c8);
            }
        });

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(d1);
            }
        });

        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(d2);
            }
        });

        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(d3);
            }
        });

        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(d4);
            }
        });

        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(d5);
            }
        });

        d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(d6);
            }
        });

        d7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(d7);
            }
        });

        d8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonOnClick(d8);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initImage();
                initTags();
                initPiece();
                resetButtonsBackground();
                resetButton.setBackgroundColor(Color.alpha(0));
            }
        });
    }

    private void imageButtonOnClick(ImageButton imageButton) {
        findOnClikKey(imageButton);
        switch ((int) imageButton.getTag()) {
        case DARK:
            if (mode == MOVE) {
                resetButtonsBackground();
                mode = FLIP;
                break;
            }
            switch (swichKey) {
                case "k1":
                    imageButton.setImageResource(R.drawable.chess_k1);
                    imageButton.setTag(1);
                    setTurns(imageButton);
                    break;
                case "k2":
                    imageButton.setImageResource(R.drawable.chess_k2);
                    imageButton.setTag(2);
                    setTurns(imageButton);
                    break;
                case "g1":
                    imageButton.setImageResource(R.drawable.chess_g1);
                    imageButton.setTag(3);
                    setTurns(imageButton);
                    break;
                case "g2":
                    imageButton.setImageResource(R.drawable.chess_g2);
                    imageButton.setTag(4);
                    setTurns(imageButton);
                    break;
                case "m1":
                    imageButton.setImageResource(R.drawable.chess_m1);
                    imageButton.setTag(5);
                    setTurns(imageButton);
                    break;
                case "m2":
                    imageButton.setImageResource(R.drawable.chess_m2);
                    imageButton.setTag(6);
                    setTurns(imageButton);
                    break;
                case "r1":
                    imageButton.setImageResource(R.drawable.chess_r1);
                    imageButton.setTag(7);
                    setTurns(imageButton);
                    break;
                case "r2":
                    imageButton.setImageResource(R.drawable.chess_r2);
                    imageButton.setTag(8);
                    setTurns(imageButton);
                    break;
                case "n1":
                    imageButton.setImageResource(R.drawable.chess_n1);
                    imageButton.setTag(9);
                    setTurns(imageButton);
                    break;
                case "n2":
                    imageButton.setImageResource(R.drawable.chess_n2);
                    imageButton.setTag(10);
                    setTurns(imageButton);
                    break;
                case "c1":
                    imageButton.setImageResource(R.drawable.chess_c1);
                    imageButton.setTag(11);
                    setTurns(imageButton);
                    break;
                case "c2":
                    imageButton.setImageResource(R.drawable.chess_c2);
                    imageButton.setTag(12);
                    setTurns(imageButton);
                    break;
                case "p1":
                    imageButton.setImageResource(R.drawable.chess_p1);
                    imageButton.setTag(13);
                    setTurns(imageButton);
                    break;
                case "p2":
                    imageButton.setImageResource(R.drawable.chess_p2);
                    imageButton.setTag(14);
                    setTurns(imageButton);
                    break;
            }
            break;
        case 1:
            if (mode == MOVE && (int) temp.getTag() % 2 != 1
                    && ((int) temp.getTag() - 1 <= 1 || (int) temp.getTag() == 14 || (int) temp.getTag() == 12))
                moveTo(imageButton);
            else if (mode == FLIP && turns == BLACK) {
                setTarget(imageButton);
            }
            break;
        case 2:
            if (mode == MOVE && (int) temp.getTag() % 2 != 0
                    && ((int) temp.getTag() - 1 <= 2 || (int) temp.getTag() == 13 || (int) temp.getTag() == 11))
                moveTo(imageButton);
            else if (mode == FLIP && turns == RED) {
                setTarget(imageButton);
            }
            break;
        case 3:
            if (mode == MOVE && (int) temp.getTag() % 2 != 1 && ((int) temp.getTag() - 1 <= 3 || (int) temp.getTag() == 12))
                moveTo(imageButton);
            else if (mode == FLIP && turns == BLACK) {
                setTarget(imageButton);
            }
            break;
            case 4:
            if (mode == MOVE && (int) temp.getTag() % 2 != 0 && ((int) temp.getTag() <= 4 || (int) temp.getTag() == 11))
                moveTo(imageButton);
            else if (mode == FLIP && turns == RED) {
                setTarget(imageButton);
            }
            break;
            case 5:
            if (mode == MOVE && (int) temp.getTag() % 2 != 1 && ((int) temp.getTag() - 1 <= 5 || (int) temp.getTag() == 12))
                moveTo(imageButton);
            else if (mode == FLIP && turns == BLACK) {
                setTarget(imageButton);
            }
            break;
            case 6:
            if (mode == MOVE && (int) temp.getTag() % 2 != 0 && ((int) temp.getTag() <= 6 || (int) temp.getTag() == 11))
                moveTo(imageButton);
            else if (mode == FLIP && turns == RED) {
                setTarget(imageButton);
            }
            break;
            case 7:
            if (mode == MOVE && (int) temp.getTag() % 2 != 1 && ((int) temp.getTag() - 1 <= 7 || (int) temp.getTag() == 12))
                moveTo(imageButton);
            else if (mode == FLIP && turns == BLACK) {
                setTarget(imageButton);
            }
            break;
            case 8:
            if (mode == MOVE && (int) temp.getTag() % 2 != 0 && ((int) temp.getTag() <= 8 || (int) temp.getTag() == 11))
                moveTo(imageButton);
            else if (mode == FLIP && turns == RED) {
                setTarget(imageButton);
            }
            break;
        case 9:
            if (mode == MOVE && (int) temp.getTag() % 2 != 1 && ((int) temp.getTag() - 1 <= 9 || (int) temp.getTag() == 12))
                moveTo(imageButton);
            else if (mode == FLIP && turns == BLACK) {
                setTarget(imageButton);
            }
            break;
        case 10:
            if (mode == MOVE && (int) temp.getTag() % 2 != 0 && ((int) temp.getTag() <= 10 || (int) temp.getTag() == 11))
                moveTo(imageButton);
            else if (mode == FLIP && turns == RED) {
                setTarget(imageButton);
            }
            break;
        case 11:
            if (mode == MOVE && (int) temp.getTag() % 2 != 1 && ((int) temp.getTag() - 1 <= 11 || (int) temp.getTag() == 12))
                moveTo(imageButton);
            else if (mode == FLIP && turns == BLACK){
                cSetTarget(imageButton);
            }
            break;
        case 12:
            if (mode == MOVE && (int) temp.getTag() % 2 != 0 && ((int) temp.getTag() <= 12 || (int) temp.getTag() == 11))
                moveTo(imageButton);
            else if (mode == FLIP && turns == RED){
                cSetTarget(imageButton);
            }
                break;
        case 13:
            if (mode == MOVE && (int) temp.getTag() % 2 != 1 && (int) temp.getTag() - 1 <= 13 && (int) temp.getTag() != 2)
                moveTo(imageButton);
            else if (mode == FLIP && turns == BLACK) {
                setTarget(imageButton);
            }
            break;
        case 14:
            if (mode == MOVE && (int) temp.getTag() % 2 != 0 && (int) temp.getTag() <= 14 && (int) temp.getTag() != 1)
                moveTo(imageButton);
            else if (mode == FLIP && turns == RED) {
                setTarget(imageButton);
            }
            break;
        case EMPTY:
            if (mode == MOVE) moveTo(imageButton);
            break;
        }
    }

    private void cSetTarget(ImageButton currentButton) {
        ImageButton i = currentButton;
        if (currentButton.getTag()==11){
            {
                i = currentButton;
                i = right(i);
                if (i!=null && i.getTag()==EMPTY){
                    target(currentButton, i);
                    if (right(right(i))!=null && right(i).getTag()!=EMPTY  && right(right(i)).getTag()!=EMPTY && (int)right(right(i)).getTag()%2==0) target(currentButton, right(right(i)));
                }else if (i!=null && i.getTag()!=EMPTY){
                    if (right(right(i))!=null && right(i).getTag()==EMPTY && right(right(i)).getTag()!=EMPTY && (int)right(right(i)).getTag()%2==0) target(currentButton, right(right(i)));
                    else if (right(i)!=null && right(i).getTag()!=EMPTY && (int)right(i).getTag()%2==0) target(currentButton, right(i));
                }
            }
            {
                i = currentButton;
                i = left(i);
                if (i!=null && i.getTag()==EMPTY){
                    target(currentButton, i);
                    if (left(left(i))!=null && left(i).getTag()!=EMPTY  && left(left(i)).getTag()!=EMPTY && (int)left(left(i)).getTag()%2==0) target(currentButton, left(left(i)));
                }else if (i!=null && i.getTag()!=EMPTY){
                    if (left(left(i))!=null && left(i).getTag()==EMPTY && left(left(i)).getTag()!=EMPTY && (int)left(left(i)).getTag()%2==0) target(currentButton, left(left(i)));
                    else if (left(i)!=null && left(i).getTag()!=EMPTY && (int)left(i).getTag()%2==0) target(currentButton, left(i));
                }
            }
            {
                i = currentButton;
                i = up(i);
                if (i!=null && i.getTag()==EMPTY){
                    target(currentButton, i);
                    if (up(i)!=null && up(i).getTag()==EMPTY){
                        if (up(up(i))!=null && up(up(i)).getTag()==EMPTY){
                            if (up(up(up(i)))!=null && up(up(up(i))).getTag()==EMPTY){
                                if (up(up(up(up(i))))!=null && up(up(up(up(i)))).getTag()==EMPTY){
                                    if (up(up(up(up(up(up(i))))))!=null
                                            && up(up(up(up(up(i))))).getTag()!=EMPTY
                                            && up(up(up(up(up(up(i)))))).getTag()!=EMPTY
                                            && (int)up(up(up(up(up(up(i)))))).getTag()%2==0) target(currentButton, up(up(up(up(up(up(i)))))));
                                }else if (up(up(up(up(i))))!=null && up(up(up(up(i)))).getTag()!=EMPTY){
                                    if (up(up(up(up(up(up(i))))))!=null
                                            && up(up(up(up(up(i))))).getTag()==EMPTY
                                            && (int)up(up(up(up(up(up(i)))))).getTag()%2==0) target(currentButton, up(up(up(up(up(up(i)))))));
                                    else if (up(up(up(up(up(i)))))!=null
                                            && up(up(up(up(up(i))))).getTag()!=EMPTY
                                            && (int)up(up(up(up(up(i))))).getTag()%2==0) target(currentButton, up(up(up(up(up(i))))));
                                }
                            }else if (up(up(up(i)))!=null && up(up(up(i))).getTag()!=EMPTY){
                                if (up(up(up(up(i))))!=null && up(up(up(up(i)))).getTag()==EMPTY){
                                    if (up(up(up(up(up(up(i))))))!=null
                                            && up(up(up(up(up(i))))).getTag()==EMPTY
                                            && (int)up(up(up(up(up(up(i)))))).getTag()%2==0) target(currentButton, up(up(up(up(up(up(i)))))));
                                    else if (up(up(up(up(up(i)))))!=null
                                            && up(up(up(up(up(i))))).getTag()!=EMPTY
                                            && (int)up(up(up(up(up(i))))).getTag()%2==0) target(currentButton, up(up(up(up(up(i))))));
                                }else if (up(up(up(up(i))))!=null
                                        && up(up(up(up(i)))).getTag()!=EMPTY
                                        && (int)up(up(up(up(i)))).getTag()%2==0) target(currentButton, up(up(up(up(i)))));
                            }
                        }else if (up(up(i))!=null && up(up(i)).getTag()!=EMPTY){
                            if (up(up(up(i)))!=null && up(up(up(i))).getTag()==EMPTY){
                                if (up(up(up(up(i))))!=null && up(up(up(up(i)))).getTag()==EMPTY){
                                    if (up(up(up(up(up(up(i))))))!=null
                                            && up(up(up(up(up(i))))).getTag()==EMPTY
                                            && (int)up(up(up(up(up(up(i)))))).getTag()%2==0) target(currentButton, up(up(up(up(up(up(i)))))));
                                    else if (up(up(up(up(up(i)))))!=null
                                            && up(up(up(up(up(i))))).getTag()!=EMPTY
                                            && (int)up(up(up(up(up(i))))).getTag()%2==0) target(currentButton, up(up(up(up(up(i))))));
                                }else if (up(up(up(up(i))))!=null
                                        && up(up(up(up(i)))).getTag()!=EMPTY
                                        && (int)up(up(up(up(i)))).getTag()%2==0) target(currentButton, up(up(up(up(i)))));
                            }else if (up(up(up(i)))!=null
                                    && up(up(up(i))).getTag()!=EMPTY
                                    && (int)up(up(up(i))).getTag()%2==0) target(currentButton, up(up(up(i))));
                        }
                    }else if (up(i)!=null && up(i).getTag()!=EMPTY){
                        if (up(up(i))!=null && up(up(i)).getTag()==EMPTY){
                            if (up(up(up(i)))!=null && up(up(up(i))).getTag()==EMPTY){
                                if (up(up(up(up(i))))!=null && up(up(up(up(i)))).getTag()==EMPTY){
                                    if (up(up(up(up(up(up(i))))))!=null
                                            && up(up(up(up(up(i))))).getTag()==EMPTY
                                            && (int)up(up(up(up(up(up(i)))))).getTag()%2==0) target(currentButton, up(up(up(up(up(up(i)))))));
                                    else if (up(up(up(up(up(i)))))!=null
                                            && up(up(up(up(up(i))))).getTag()!=EMPTY
                                            && (int)up(up(up(up(up(i))))).getTag()%2==0) target(currentButton, up(up(up(up(up(i))))));
                                }else if (up(up(up(up(i))))!=null
                                        && up(up(up(up(i)))).getTag()!=EMPTY
                                        && (int)up(up(up(up(i)))).getTag()%2==0) target(currentButton, up(up(up(up(i)))));
                            }else if (up(up(up(i)))!=null
                                    && up(up(up(i))).getTag()!=EMPTY
                                    && (int)up(up(up(i))).getTag()%2==0) target(currentButton, up(up(up(i))));
                        }else if (up(up(i))!=null
                                && up(up(i)).getTag()!=EMPTY
                                && (int)up(up(i)).getTag()%2==0) target(currentButton, up(up(i)));
                    }
                }else if (i!=null && i.getTag()!=EMPTY){
                    if (up(i)!=null && up(i).getTag()==EMPTY){
                        if (up(up(i))!=null && up(up(i)).getTag()==EMPTY){
                            if (up(up(up(i)))!=null && up(up(up(i))).getTag()==EMPTY){
                                if (up(up(up(up(i))))!=null && up(up(up(up(i)))).getTag()==EMPTY){
                                    if (up(up(up(up(up(up(i))))))!=null
                                            && up(up(up(up(up(i))))).getTag()==EMPTY
                                            && (int)up(up(up(up(up(up(i)))))).getTag()%2==0) target(currentButton, up(up(up(up(up(up(i)))))));
                                    else if (up(up(up(up(up(i)))))!=null
                                            && up(up(up(up(up(i))))).getTag()!=EMPTY
                                            && (int)up(up(up(up(up(i))))).getTag()%2==0) target(currentButton, up(up(up(up(up(i))))));
                                }else if (up(up(up(up(i))))!=null
                                        && up(up(up(up(i)))).getTag()!=EMPTY
                                        && (int)up(up(up(up(i)))).getTag()%2==0) target(currentButton, up(up(up(up(i)))));
                            }else if (up(up(up(i)))!=null
                                    && up(up(up(i))).getTag()!=EMPTY
                                    && (int)up(up(up(i))).getTag()%2==0) target(currentButton, up(up(up(i))));
                        }else if (up(up(i))!=null
                                && up(up(i)).getTag()!=EMPTY
                                && (int)up(up(i)).getTag()%2==0) target(currentButton, up(up(i)));
                    }else if (up(i)!=null
                            && up(i).getTag()!=EMPTY
                            && (int)up(i).getTag()%2==0) target(currentButton, up(i));
                }
            }
            {
                i = currentButton;
                i = down(i);
                if (i!=null && i.getTag()==EMPTY){
                    target(currentButton, i);
                    if (down(i)!=null && down(i).getTag()==EMPTY){
                        if (down(down(i))!=null && down(down(i)).getTag()==EMPTY){
                            if (down(down(down(i)))!=null && down(down(down(i))).getTag()==EMPTY){
                                if (down(down(down(down(i))))!=null && down(down(down(down(i)))).getTag()==EMPTY){
                                    if (down(down(down(down(down(down(i))))))!=null
                                            && down(down(down(down(down(i))))).getTag()!=EMPTY
                                            && down(down(down(down(down(down(i)))))).getTag()!=EMPTY
                                            && (int)down(down(down(down(down(down(i)))))).getTag()%2==0) target(currentButton, down(down(down(down(down(down(i)))))));
                                }else if (down(down(down(down(i))))!=null && down(down(down(down(i)))).getTag()!=EMPTY){
                                    if (down(down(down(down(down(down(i))))))!=null
                                            && down(down(down(down(down(i))))).getTag()==EMPTY
                                            && (int)down(down(down(down(down(down(i)))))).getTag()%2==0) target(currentButton, down(down(down(down(down(down(i)))))));
                                    else if (down(down(down(down(down(i)))))!=null
                                            && down(down(down(down(down(i))))).getTag()!=EMPTY
                                            && (int)down(down(down(down(down(i))))).getTag()%2==0) target(currentButton, down(down(down(down(down(i))))));
                                }
                            }else if (down(down(down(i)))!=null && down(down(down(i))).getTag()!=EMPTY){
                                if (down(down(down(down(i))))!=null && down(down(down(down(i)))).getTag()==EMPTY){
                                    if (down(down(down(down(down(down(i))))))!=null
                                            && down(down(down(down(down(i))))).getTag()==EMPTY
                                            && (int)down(down(down(down(down(down(i)))))).getTag()%2==0) target(currentButton, down(down(down(down(down(down(i)))))));
                                    else if (down(down(down(down(down(i)))))!=null
                                            && down(down(down(down(down(i))))).getTag()!=EMPTY
                                            && (int)down(down(down(down(down(i))))).getTag()%2==0) target(currentButton, down(down(down(down(down(i))))));
                                }else if (down(down(down(down(i))))!=null
                                        && down(down(down(down(i)))).getTag()!=EMPTY
                                        && (int)down(down(down(down(i)))).getTag()%2==0) target(currentButton, down(down(down(down(i)))));
                            }
                        }else if (down(down(i))!=null && down(down(i)).getTag()!=EMPTY){
                            if (down(down(down(i)))!=null && down(down(down(i))).getTag()==EMPTY){
                                if (down(down(down(down(i))))!=null && down(down(down(down(i)))).getTag()==EMPTY){
                                    if (down(down(down(down(down(down(i))))))!=null
                                            && down(down(down(down(down(i))))).getTag()==EMPTY
                                            && (int)down(down(down(down(down(down(i)))))).getTag()%2==0) target(currentButton, down(down(down(down(down(down(i)))))));
                                    else if (down(down(down(down(down(i)))))!=null
                                            && down(down(down(down(down(i))))).getTag()!=EMPTY
                                            && (int)down(down(down(down(down(i))))).getTag()%2==0) target(currentButton, down(down(down(down(down(i))))));
                                }else if (down(down(down(down(i))))!=null
                                        && down(down(down(down(i)))).getTag()!=EMPTY
                                        && (int)down(down(down(down(i)))).getTag()%2==0) target(currentButton, down(down(down(down(i)))));
                            }else if (down(down(down(i)))!=null
                                    && down(down(down(i))).getTag()!=EMPTY
                                    && (int)down(down(down(i))).getTag()%2==0) target(currentButton, down(down(down(i))));
                        }
                    }else if (down(i)!=null && down(i).getTag()!=EMPTY){
                        if (down(down(i))!=null && down(down(i)).getTag()==EMPTY){
                            if (down(down(down(i)))!=null && down(down(down(i))).getTag()==EMPTY){
                                if (down(down(down(down(i))))!=null && down(down(down(down(i)))).getTag()==EMPTY){
                                    if (down(down(down(down(down(down(i))))))!=null
                                            && down(down(down(down(down(i))))).getTag()==EMPTY
                                            && (int)down(down(down(down(down(down(i)))))).getTag()%2==0) target(currentButton, down(down(down(down(down(down(i)))))));
                                    else if (down(down(down(down(down(i)))))!=null
                                            && down(down(down(down(down(i))))).getTag()!=EMPTY
                                            && (int)down(down(down(down(down(i))))).getTag()%2==0) target(currentButton, down(down(down(down(down(i))))));
                                }else if (down(down(down(down(i))))!=null
                                        && down(down(down(down(i)))).getTag()!=EMPTY
                                        && (int)down(down(down(down(i)))).getTag()%2==0) target(currentButton, down(down(down(down(i)))));
                            }else if (down(down(down(i)))!=null
                                    && down(down(down(i))).getTag()!=EMPTY
                                    && (int)down(down(down(i))).getTag()%2==0) target(currentButton, down(down(down(i))));
                        }else if (down(down(i))!=null
                                && down(down(i)).getTag()!=EMPTY
                                && (int)down(down(i)).getTag()%2==0) target(currentButton, down(down(i)));
                    }
                }else if (i!=null && i.getTag()!=EMPTY){
                    if (down(i)!=null && down(i).getTag()==EMPTY){
                        if (down(down(i))!=null && down(down(i)).getTag()==EMPTY){
                            if (down(down(down(i)))!=null && down(down(down(i))).getTag()==EMPTY){
                                if (down(down(down(down(i))))!=null && down(down(down(down(i)))).getTag()==EMPTY){
                                    if (down(down(down(down(down(down(i))))))!=null
                                            && down(down(down(down(down(i))))).getTag()==EMPTY
                                            && (int)down(down(down(down(down(down(i)))))).getTag()%2==0) target(currentButton, down(down(down(down(down(down(i)))))));
                                    else if (down(down(down(down(down(i)))))!=null
                                            && down(down(down(down(down(i))))).getTag()!=EMPTY
                                            && (int)down(down(down(down(down(i))))).getTag()%2==0) target(currentButton, down(down(down(down(down(i))))));
                                }else if (down(down(down(down(i))))!=null
                                        && down(down(down(down(i)))).getTag()!=EMPTY
                                        && (int)down(down(down(down(i)))).getTag()%2==0) target(currentButton, down(down(down(down(i)))));
                            }else if (down(down(down(i)))!=null
                                    && down(down(down(i))).getTag()!=EMPTY
                                    && (int)down(down(down(i))).getTag()%2==0) target(currentButton, down(down(down(i))));
                        }else if (down(down(i))!=null
                                && down(down(i)).getTag()!=EMPTY
                                && (int)down(down(i)).getTag()%2==0) target(currentButton, down(down(i)));
                    }else if (down(i)!=null
                            && down(i).getTag()!=EMPTY
                            && (int)down(i).getTag()%2==0) target(currentButton, down(i));
                }
            }
        }
        if (currentButton.getTag()==12){
            {
                i = currentButton;
                i = right(i);
                if (i!=null && i.getTag()==EMPTY){
                    target(currentButton, i);
                    if (right(right(i))!=null && right(i).getTag()!=EMPTY  && right(right(i)).getTag()!=EMPTY && (int)right(right(i)).getTag()%2==1) target(currentButton, right(right(i)));
                }else if (i!=null && i.getTag()!=EMPTY){
                    if (right(right(i))!=null && right(i).getTag()==EMPTY && right(right(i)).getTag()!=EMPTY && (int)right(right(i)).getTag()%2==1) target(currentButton, right(right(i)));
                    else if (right(i)!=null && right(i).getTag()!=EMPTY && (int)right(i).getTag()%2==1) target(currentButton, right(i));
                }
            }
            {
                i = currentButton;
                i = left(i);
                if (i!=null && i.getTag()==EMPTY){
                    target(currentButton, i);
                    if (left(left(i))!=null && left(i).getTag()!=EMPTY  && left(left(i)).getTag()!=EMPTY && (int)left(left(i)).getTag()%2==1) target(currentButton, left(left(i)));
                }else if (i!=null && i.getTag()!=EMPTY){
                    if (left(left(i))!=null && left(i).getTag()==EMPTY && left(left(i)).getTag()!=EMPTY && (int)left(left(i)).getTag()%2==1) target(currentButton, left(left(i)));
                    else if (left(i)!=null && left(i).getTag()!=EMPTY && (int)left(i).getTag()%2==1) target(currentButton, left(i));
                }
            }
            {
                i = currentButton;
                i = up(i);
                if (i!=null && i.getTag()==EMPTY){
                    target(currentButton, i);
                    if (up(i)!=null && up(i).getTag()==EMPTY){
                        if (up(up(i))!=null && up(up(i)).getTag()==EMPTY){
                            if (up(up(up(i)))!=null && up(up(up(i))).getTag()==EMPTY){
                                if (up(up(up(up(i))))!=null && up(up(up(up(i)))).getTag()==EMPTY){
                                    if (up(up(up(up(up(up(i))))))!=null
                                            && up(up(up(up(up(i))))).getTag()!=EMPTY
                                            && up(up(up(up(up(up(i)))))).getTag()!=EMPTY
                                            && (int)up(up(up(up(up(up(i)))))).getTag()%2==1) target(currentButton, up(up(up(up(up(up(i)))))));
                                }else if (up(up(up(up(i))))!=null && up(up(up(up(i)))).getTag()!=EMPTY){
                                    if (up(up(up(up(up(up(i))))))!=null
                                            && up(up(up(up(up(i))))).getTag()==EMPTY
                                            && (int)up(up(up(up(up(up(i)))))).getTag()%2==1) target(currentButton, up(up(up(up(up(up(i)))))));
                                    else if (up(up(up(up(up(i)))))!=null
                                            && up(up(up(up(up(i))))).getTag()!=EMPTY
                                            && (int)up(up(up(up(up(i))))).getTag()%2==1) target(currentButton, up(up(up(up(up(i))))));
                                }
                            }else if (up(up(up(i)))!=null && up(up(up(i))).getTag()!=EMPTY){
                                if (up(up(up(up(i))))!=null && up(up(up(up(i)))).getTag()==EMPTY){
                                    if (up(up(up(up(up(up(i))))))!=null
                                            && up(up(up(up(up(i))))).getTag()==EMPTY
                                            && (int)up(up(up(up(up(up(i)))))).getTag()%2==1) target(currentButton, up(up(up(up(up(up(i)))))));
                                    else if (up(up(up(up(up(i)))))!=null
                                            && up(up(up(up(up(i))))).getTag()!=EMPTY
                                            && (int)up(up(up(up(up(i))))).getTag()%2==1) target(currentButton, up(up(up(up(up(i))))));
                                }else if (up(up(up(up(i))))!=null
                                        && up(up(up(up(i)))).getTag()!=EMPTY
                                        && (int)up(up(up(up(i)))).getTag()%2==1) target(currentButton, up(up(up(up(i)))));
                            }
                        }else if (up(up(i))!=null && up(up(i)).getTag()!=EMPTY){
                            if (up(up(up(i)))!=null && up(up(up(i))).getTag()==EMPTY){
                                if (up(up(up(up(i))))!=null && up(up(up(up(i)))).getTag()==EMPTY){
                                    if (up(up(up(up(up(up(i))))))!=null
                                            && up(up(up(up(up(i))))).getTag()==EMPTY
                                            && (int)up(up(up(up(up(up(i)))))).getTag()%2==1) target(currentButton, up(up(up(up(up(up(i)))))));
                                    else if (up(up(up(up(up(i)))))!=null
                                            && up(up(up(up(up(i))))).getTag()!=EMPTY
                                            && (int)up(up(up(up(up(i))))).getTag()%2==1) target(currentButton, up(up(up(up(up(i))))));
                                }else if (up(up(up(up(i))))!=null
                                        && up(up(up(up(i)))).getTag()!=EMPTY
                                        && (int)up(up(up(up(i)))).getTag()%2==1) target(currentButton, up(up(up(up(i)))));
                            }else if (up(up(up(i)))!=null
                                    && up(up(up(i))).getTag()!=EMPTY
                                    && (int)up(up(up(i))).getTag()%2==1) target(currentButton, up(up(up(i))));
                        }
                    }else if (up(i)!=null && up(i).getTag()!=EMPTY){
                        if (up(up(i))!=null && up(up(i)).getTag()==EMPTY){
                            if (up(up(up(i)))!=null && up(up(up(i))).getTag()==EMPTY){
                                if (up(up(up(up(i))))!=null && up(up(up(up(i)))).getTag()==EMPTY){
                                    if (up(up(up(up(up(up(i))))))!=null
                                            && up(up(up(up(up(i))))).getTag()==EMPTY
                                            && (int)up(up(up(up(up(up(i)))))).getTag()%2==1) target(currentButton, up(up(up(up(up(up(i)))))));
                                    else if (up(up(up(up(up(i)))))!=null
                                            && up(up(up(up(up(i))))).getTag()!=EMPTY
                                            && (int)up(up(up(up(up(i))))).getTag()%2==1) target(currentButton, up(up(up(up(up(i))))));
                                }else if (up(up(up(up(i))))!=null
                                        && up(up(up(up(i)))).getTag()!=EMPTY
                                        && (int)up(up(up(up(i)))).getTag()%2==1) target(currentButton, up(up(up(up(i)))));
                            }else if (up(up(up(i)))!=null
                                    && up(up(up(i))).getTag()!=EMPTY
                                    && (int)up(up(up(i))).getTag()%2==1) target(currentButton, up(up(up(i))));
                        }else if (up(up(i))!=null
                                && up(up(i)).getTag()!=EMPTY
                                && (int)up(up(i)).getTag()%2==1) target(currentButton, up(up(i)));
                    }
                }else if (i!=null && i.getTag()!=EMPTY){
                    if (up(i)!=null && up(i).getTag()==EMPTY){
                        if (up(up(i))!=null && up(up(i)).getTag()==EMPTY){
                            if (up(up(up(i)))!=null && up(up(up(i))).getTag()==EMPTY){
                                if (up(up(up(up(i))))!=null && up(up(up(up(i)))).getTag()==EMPTY){
                                    if (up(up(up(up(up(up(i))))))!=null
                                            && up(up(up(up(up(i))))).getTag()==EMPTY
                                            && (int)up(up(up(up(up(up(i)))))).getTag()%2==1) target(currentButton, up(up(up(up(up(up(i)))))));
                                    else if (up(up(up(up(up(i)))))!=null
                                            && up(up(up(up(up(i))))).getTag()!=EMPTY
                                            && (int)up(up(up(up(up(i))))).getTag()%2==1) target(currentButton, up(up(up(up(up(i))))));
                                }else if (up(up(up(up(i))))!=null
                                        && up(up(up(up(i)))).getTag()!=EMPTY
                                        && (int)up(up(up(up(i)))).getTag()%2==1) target(currentButton, up(up(up(up(i)))));
                            }else if (up(up(up(i)))!=null
                                    && up(up(up(i))).getTag()!=EMPTY
                                    && (int)up(up(up(i))).getTag()%2==1) target(currentButton, up(up(up(i))));
                        }else if (up(up(i))!=null
                                && up(up(i)).getTag()!=EMPTY
                                && (int)up(up(i)).getTag()%2==1) target(currentButton, up(up(i)));
                    }else if (up(i)!=null
                            && up(i).getTag()!=EMPTY
                            && (int)up(i).getTag()%2==1) target(currentButton, up(i));
                }
            }
            {
                i = currentButton;
                i = down(i);
                if (i!=null && i.getTag()==EMPTY){
                    target(currentButton, i);
                    if (down(i)!=null && down(i).getTag()==EMPTY){
                        if (down(down(i))!=null && down(down(i)).getTag()==EMPTY){
                            if (down(down(down(i)))!=null && down(down(down(i))).getTag()==EMPTY){
                                if (down(down(down(down(i))))!=null && down(down(down(down(i)))).getTag()==EMPTY){
                                    if (down(down(down(down(down(down(i))))))!=null
                                            && down(down(down(down(down(i))))).getTag()!=EMPTY
                                            && down(down(down(down(down(down(i)))))).getTag()!=EMPTY
                                            && (int)down(down(down(down(down(down(i)))))).getTag()%2==1) target(currentButton, down(down(down(down(down(down(i)))))));
                                }else if (down(down(down(down(i))))!=null && down(down(down(down(i)))).getTag()!=EMPTY){
                                    if (down(down(down(down(down(down(i))))))!=null
                                            && down(down(down(down(down(i))))).getTag()==EMPTY
                                            && (int)down(down(down(down(down(down(i)))))).getTag()%2==1) target(currentButton, down(down(down(down(down(down(i)))))));
                                    else if (down(down(down(down(down(i)))))!=null
                                            && down(down(down(down(down(i))))).getTag()!=EMPTY
                                            && (int)down(down(down(down(down(i))))).getTag()%2==1) target(currentButton, down(down(down(down(down(i))))));
                                }
                            }else if (down(down(down(i)))!=null && down(down(down(i))).getTag()!=EMPTY){
                                if (down(down(down(down(i))))!=null && down(down(down(down(i)))).getTag()==EMPTY){
                                    if (down(down(down(down(down(down(i))))))!=null
                                            && down(down(down(down(down(i))))).getTag()==EMPTY
                                            && (int)down(down(down(down(down(down(i)))))).getTag()%2==1) target(currentButton, down(down(down(down(down(down(i)))))));
                                    else if (down(down(down(down(down(i)))))!=null
                                            && down(down(down(down(down(i))))).getTag()!=EMPTY
                                            && (int)down(down(down(down(down(i))))).getTag()%2==1) target(currentButton, down(down(down(down(down(i))))));
                                }else if (down(down(down(down(i))))!=null
                                        && down(down(down(down(i)))).getTag()!=EMPTY
                                        && (int)down(down(down(down(i)))).getTag()%2==1) target(currentButton, down(down(down(down(i)))));
                            }
                        }else if (down(down(i))!=null && down(down(i)).getTag()!=EMPTY){
                            if (down(down(down(i)))!=null && down(down(down(i))).getTag()==EMPTY){
                                if (down(down(down(down(i))))!=null && down(down(down(down(i)))).getTag()==EMPTY){
                                    if (down(down(down(down(down(down(i))))))!=null
                                            && down(down(down(down(down(i))))).getTag()==EMPTY
                                            && (int)down(down(down(down(down(down(i)))))).getTag()%2==1) target(currentButton, down(down(down(down(down(down(i)))))));
                                    else if (down(down(down(down(down(i)))))!=null
                                            && down(down(down(down(down(i))))).getTag()!=EMPTY
                                            && (int)down(down(down(down(down(i))))).getTag()%2==1) target(currentButton, down(down(down(down(down(i))))));
                                }else if (down(down(down(down(i))))!=null
                                        && down(down(down(down(i)))).getTag()!=EMPTY
                                        && (int)down(down(down(down(i)))).getTag()%2==1) target(currentButton, down(down(down(down(i)))));
                            }else if (down(down(down(i)))!=null
                                    && down(down(down(i))).getTag()!=EMPTY
                                    && (int)down(down(down(i))).getTag()%2==1) target(currentButton, down(down(down(i))));
                        }
                    }else if (down(i)!=null && down(i).getTag()!=EMPTY){
                        if (down(down(i))!=null && down(down(i)).getTag()==EMPTY){
                            if (down(down(down(i)))!=null && down(down(down(i))).getTag()==EMPTY){
                                if (down(down(down(down(i))))!=null && down(down(down(down(i)))).getTag()==EMPTY){
                                    if (down(down(down(down(down(down(i))))))!=null
                                            && down(down(down(down(down(i))))).getTag()==EMPTY
                                            && (int)down(down(down(down(down(down(i)))))).getTag()%2==1) target(currentButton, down(down(down(down(down(down(i)))))));
                                    else if (down(down(down(down(down(i)))))!=null
                                            && down(down(down(down(down(i))))).getTag()!=EMPTY
                                            && (int)down(down(down(down(down(i))))).getTag()%2==1) target(currentButton, down(down(down(down(down(i))))));
                                }else if (down(down(down(down(i))))!=null
                                        && down(down(down(down(i)))).getTag()!=EMPTY
                                        && (int)down(down(down(down(i)))).getTag()%2==1) target(currentButton, down(down(down(down(i)))));
                            }else if (down(down(down(i)))!=null
                                    && down(down(down(i))).getTag()!=EMPTY
                                    && (int)down(down(down(i))).getTag()%2==1) target(currentButton, down(down(down(i))));
                        }else if (down(down(i))!=null
                                && down(down(i)).getTag()!=EMPTY
                                && (int)down(down(i)).getTag()%2==1) target(currentButton, down(down(i)));
                    }
                }else if (i!=null && i.getTag()!=EMPTY){
                    if (down(i)!=null && down(i).getTag()==EMPTY){
                        if (down(down(i))!=null && down(down(i)).getTag()==EMPTY){
                            if (down(down(down(i)))!=null && down(down(down(i))).getTag()==EMPTY){
                                if (down(down(down(down(i))))!=null && down(down(down(down(i)))).getTag()==EMPTY){
                                    if (down(down(down(down(down(down(i))))))!=null
                                            && down(down(down(down(down(i))))).getTag()==EMPTY
                                            && (int)down(down(down(down(down(down(i)))))).getTag()%2==1) target(currentButton, down(down(down(down(down(down(i)))))));
                                    else if (down(down(down(down(down(i)))))!=null
                                            && down(down(down(down(down(i))))).getTag()!=EMPTY
                                            && (int)down(down(down(down(down(i))))).getTag()%2==1) target(currentButton, down(down(down(down(down(i))))));
                                }else if (down(down(down(down(i))))!=null
                                        && down(down(down(down(i)))).getTag()!=EMPTY
                                        && (int)down(down(down(down(i)))).getTag()%2==1) target(currentButton, down(down(down(down(i)))));
                            }else if (down(down(down(i)))!=null
                                    && down(down(down(i))).getTag()!=EMPTY
                                    && (int)down(down(down(i))).getTag()%2==1) target(currentButton, down(down(down(i))));
                        }else if (down(down(i))!=null
                                && down(down(i)).getTag()!=EMPTY
                                && (int)down(down(i)).getTag()%2==1) target(currentButton, down(down(i)));
                    }else if (down(i)!=null
                            && down(i).getTag()!=EMPTY
                            && (int)down(i).getTag()%2==1) target(currentButton, down(i));
                }
            }
        }
    }

    private ImageButton down(ImageButton imageButton) {
        if (imageButton==a1) return a2;
        if (imageButton==a2) return a3;
        if (imageButton==a3) return a4;
        if (imageButton==a4) return a5;
        if (imageButton==a5) return a6;
        if (imageButton==a6) return a7;
        if (imageButton==a7) return a8;
        if (imageButton==a8) return null;

        if (imageButton==b1) return b2;
        if (imageButton==b2) return b3;
        if (imageButton==b3) return b4;
        if (imageButton==b4) return b5;
        if (imageButton==b5) return b6;
        if (imageButton==b6) return b7;
        if (imageButton==b7) return b8;
        if (imageButton==b8) return null;

        if (imageButton==c1) return c2;
        if (imageButton==c2) return c3;
        if (imageButton==c3) return c4;
        if (imageButton==c4) return c5;
        if (imageButton==c5) return c6;
        if (imageButton==c6) return c7;
        if (imageButton==c7) return c8;
        if (imageButton==c8) return null;

        if (imageButton==d1) return d2;
        if (imageButton==d2) return d3;
        if (imageButton==d3) return d4;
        if (imageButton==d4) return d5;
        if (imageButton==d5) return d6;
        if (imageButton==d6) return d7;
        if (imageButton==d7) return d8;
        if (imageButton==d8) return null;
        return null;
    }

    private ImageButton up(ImageButton imageButton) {
        if (imageButton==a1) return null;
        if (imageButton==a2) return a1;
        if (imageButton==a3) return a2;
        if (imageButton==a4) return a3;
        if (imageButton==a5) return a4;
        if (imageButton==a6) return a5;
        if (imageButton==a7) return a6;
        if (imageButton==a8) return a7;

        if (imageButton==b1) return null;
        if (imageButton==b2) return b1;
        if (imageButton==b3) return b2;
        if (imageButton==b4) return b3;
        if (imageButton==b5) return b4;
        if (imageButton==b6) return b5;
        if (imageButton==b7) return b6;
        if (imageButton==b8) return b7;

        if (imageButton==c1) return null;
        if (imageButton==c2) return c1;
        if (imageButton==c3) return c2;
        if (imageButton==c4) return c3;
        if (imageButton==c5) return c4;
        if (imageButton==c6) return c5;
        if (imageButton==c7) return c6;
        if (imageButton==c8) return c7;

        if (imageButton==d1) return null;
        if (imageButton==d2) return d1;
        if (imageButton==d3) return d2;
        if (imageButton==d4) return d3;
        if (imageButton==d5) return d4;
        if (imageButton==d6) return d5;
        if (imageButton==d7) return d6;
        if (imageButton==d8) return d7;
        return null;
    }

    private ImageButton left(ImageButton imageButton) {
        if (imageButton==a1) return null;
        if (imageButton==a2) return null;
        if (imageButton==a3) return null;
        if (imageButton==a4) return null;
        if (imageButton==a5) return null;
        if (imageButton==a6) return null;
        if (imageButton==a7) return null;
        if (imageButton==a8) return null;

        if (imageButton==b1) return a1;
        if (imageButton==b2) return a2;
        if (imageButton==b3) return a3;
        if (imageButton==b4) return a4;
        if (imageButton==b5) return a5;
        if (imageButton==b6) return a6;
        if (imageButton==b7) return a7;
        if (imageButton==b8) return a8;

        if (imageButton==c1) return b1;
        if (imageButton==c2) return b2;
        if (imageButton==c3) return b3;
        if (imageButton==c4) return b4;
        if (imageButton==c5) return b5;
        if (imageButton==c6) return b6;
        if (imageButton==c7) return b7;
        if (imageButton==c8) return b8;

        if (imageButton==d1) return c1;
        if (imageButton==d2) return c2;
        if (imageButton==d3) return c3;
        if (imageButton==d4) return c4;
        if (imageButton==d5) return c5;
        if (imageButton==d6) return c6;
        if (imageButton==d7) return c7;
        if (imageButton==d8) return c8;
        return null;
    }

    private ImageButton right(ImageButton imageButton) {
        if (imageButton==a1) return b1;
        if (imageButton==a2) return b2;
        if (imageButton==a3) return b3;
        if (imageButton==a4) return b4;
        if (imageButton==a5) return b5;
        if (imageButton==a6) return b6;
        if (imageButton==a7) return b7;
        if (imageButton==a8) return b8;

        if (imageButton==b1) return c1;
        if (imageButton==b2) return c2;
        if (imageButton==b3) return c3;
        if (imageButton==b4) return c4;
        if (imageButton==b5) return c5;
        if (imageButton==b6) return c6;
        if (imageButton==b7) return c7;
        if (imageButton==b8) return c8;

        if (imageButton==c1) return d1;
        if (imageButton==c2) return d2;
        if (imageButton==c3) return d3;
        if (imageButton==c4) return d4;
        if (imageButton==c5) return d5;
        if (imageButton==c6) return d6;
        if (imageButton==c7) return d7;
        if (imageButton==c8) return d8;

        if (imageButton==d1) return null;
        if (imageButton==d2) return null;
        if (imageButton==d3) return null;
        if (imageButton==d4) return null;
        if (imageButton==d5) return null;
        if (imageButton==d6) return null;
        if (imageButton==d7) return null;
        if (imageButton==d8) return null;
        return null;
    }

    private void findOnClikKey(ImageButton imageButton) {
        if (imageButton==a1) swichKey = piece_a1;
        if (imageButton==a2) swichKey = piece_a2;
        if (imageButton==a3) swichKey = piece_a3;
        if (imageButton==a4) swichKey = piece_a4;
        if (imageButton==a5) swichKey = piece_a5;
        if (imageButton==a6) swichKey = piece_a6;
        if (imageButton==a7) swichKey = piece_a7;
        if (imageButton==a8) swichKey = piece_a8;

        if (imageButton==b1) swichKey = piece_b1;
        if (imageButton==b2) swichKey = piece_b2;
        if (imageButton==b3) swichKey = piece_b3;
        if (imageButton==b4) swichKey = piece_b4;
        if (imageButton==b5) swichKey = piece_b5;
        if (imageButton==b6) swichKey = piece_b6;
        if (imageButton==b7) swichKey = piece_b7;
        if (imageButton==b8) swichKey = piece_b8;

        if (imageButton==c1) swichKey = piece_c1;
        if (imageButton==c2) swichKey = piece_c2;
        if (imageButton==c3) swichKey = piece_c3;
        if (imageButton==c4) swichKey = piece_c4;
        if (imageButton==c5) swichKey = piece_c5;
        if (imageButton==c6) swichKey = piece_c6;
        if (imageButton==c7) swichKey = piece_c7;
        if (imageButton==c8) swichKey = piece_c8;

        if (imageButton==d1) swichKey = piece_d1;
        if (imageButton==d2) swichKey = piece_d2;
        if (imageButton==d3) swichKey = piece_d3;
        if (imageButton==d4) swichKey = piece_d4;
        if (imageButton==d5) swichKey = piece_d5;
        if (imageButton==d6) swichKey = piece_d6;
        if (imageButton==d7) swichKey = piece_d7;
        if (imageButton==d8) swichKey = piece_d8;
    }

    private void setTarget(ImageButton currentButton) {
        ImageButton i = currentButton;
        if (up(i)!=null) target(currentButton, up(i));
        if (right(i)!=null) target(currentButton, right(i));
        if (down(i)!=null) target(currentButton, down(i));
        if (left(i)!=null) target(currentButton, left(i));
    }

    private void moveTo(ImageButton targetButton) {
        if (targetButton.getDrawingCacheBackgroundColor()==Color.argb(60, 255, 255, 255)){
            if (targetButton.getTag()!=EMPTY) chessX(targetButton);
            targetButton.setImageDrawable(temp.getDrawable());
            targetButton.setTag(temp.getTag());
            temp.setImageResource(R.drawable.chess_x);
            temp.setTag(EMPTY);
            mode = FLIP;
            nextTurn();
        }else {
            resetButtonsBackground();
            mode = FLIP;
        }
        targetButton.setDrawingCacheBackgroundColor(Color.alpha(0));
    }

    private void chessX(ImageButton targetButton) {
        if (targetButton.getTag()==1) {
            j.setImageResource(R.drawable.x_k1);
            setXChess(j);
        }
        if (targetButton.getTag()==2) {
            j.setImageResource(R.drawable.x_k2);
            setXChess(j);
        }
        if (targetButton.getTag()==3) {
            j.setImageResource(R.drawable.x_g1);
            setXChess(j);
        }
        if (targetButton.getTag()==4) {
            j.setImageResource(R.drawable.x_g2);
            setXChess(j);
        }
        if (targetButton.getTag()==5) {
            j.setImageResource(R.drawable.x_m1);
            setXChess(j);
        }
        if (targetButton.getTag()==6) {
            j.setImageResource(R.drawable.x_m2);
            setXChess(j);
        }
        if (targetButton.getTag()==7) {
            j.setImageResource(R.drawable.x_r1);
            setXChess(j);
        }
        if (targetButton.getTag()==8) {
            j.setImageResource(R.drawable.x_r2);
            setXChess(j);
        }
        if (targetButton.getTag()==9) {
            j.setImageResource(R.drawable.x_n1);
            setXChess(j);
        }
        if (targetButton.getTag()==10) {
            j.setImageResource(R.drawable.x_n2);
            setXChess(j);
        }
        if (targetButton.getTag()==11) {
            j.setImageResource(R.drawable.x_c1);
            setXChess(j);
        }
        if (targetButton.getTag()==12) {
            j.setImageResource(R.drawable.x_c2);
            setXChess(j);
        }
        if (targetButton.getTag()==13) {
            j.setImageResource(R.drawable.x_p1);
            setXChess(j);
        }
        if (targetButton.getTag()==14) {
            j.setImageResource(R.drawable.x_p2);
            setXChess(j);
        }
    }

    private void setXChess(ImageButton j) {
        if (turns == RED) {
            if (x111.getTag() == 0) {
                x111.setImageDrawable(j.getDrawable());
                x111.setTag(1);
            } else {
                if (x121.getTag() == 0) {
                    x121.setImageDrawable(j.getDrawable());
                    x121.setTag(1);
                } else {
                    if (x131.getTag() == 0) {
                        x131.setImageDrawable(j.getDrawable());
                        x131.setTag(1);
                    } else {
                        if (x141.getTag() == 0) {
                            x141.setImageDrawable(j.getDrawable());
                            x141.setTag(1);
                        } else {
                            if (x151.getTag() == 0) {
                                x151.setImageDrawable(j.getDrawable());
                                x151.setTag(1);
                            } else {
                                if (x161.getTag() == 0) {
                                    x161.setImageDrawable(j.getDrawable());
                                    x161.setTag(1);
                                } else {
                                    if (x171.getTag() == 0) {
                                        x171.setImageDrawable(j.getDrawable());
                                        x171.setTag(1);
                                    } else {
                                        if (x181.getTag() == 0) {
                                            x181.setImageDrawable(j.getDrawable());
                                            x181.setTag(1);
                                        } else {
                                            if (x112.getTag() == 0) {
                                                x112.setImageDrawable(j.getDrawable());
                                                x112.setTag(1);
                                            } else {
                                                if (x122.getTag() == 0) {
                                                    x122.setImageDrawable(j.getDrawable());
                                                    x122.setTag(1);
                                                } else {
                                                    if (x132.getTag() == 0) {
                                                        x132.setImageDrawable(j.getDrawable());
                                                        x132.setTag(1);
                                                    } else {
                                                        if (x142.getTag() == 0) {
                                                            x142.setImageDrawable(j.getDrawable());
                                                            x142.setTag(1);
                                                        } else {
                                                            if (x152.getTag() == 0) {
                                                                x152.setImageDrawable(j.getDrawable());
                                                                x152.setTag(1);
                                                            } else {
                                                                if (x162.getTag() == 0) {
                                                                    x162.setImageDrawable(j.getDrawable());
                                                                    x162.setTag(1);
                                                                } else {
                                                                    if (x172.getTag() == 0) {
                                                                        x172.setImageDrawable(j.getDrawable());
                                                                        x172.setTag(1);
                                                                    } else {
                                                                        if (x182.getTag() == 0) {
                                                                            x182.setImageDrawable(j.getDrawable());
                                                                            x182.setTag(1);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (turns == BLACK) {
            if (x211.getTag() == 0) {
                x211.setImageDrawable(j.getDrawable());
                x211.setTag(1);
            } else {
                if (x221.getTag() == 0) {
                    x221.setImageDrawable(j.getDrawable());
                    x221.setTag(1);
                } else {
                    if (x231.getTag() == 0) {
                        x231.setImageDrawable(j.getDrawable());
                        x231.setTag(1);
                    } else {
                        if (x241.getTag() == 0) {
                            x241.setImageDrawable(j.getDrawable());
                            x241.setTag(1);
                        } else {
                            if (x251.getTag() == 0) {
                                x251.setImageDrawable(j.getDrawable());
                                x251.setTag(1);
                            } else {
                                if (x261.getTag() == 0) {
                                    x261.setImageDrawable(j.getDrawable());
                                    x261.setTag(1);
                                } else {
                                    if (x271.getTag() == 0) {
                                        x271.setImageDrawable(j.getDrawable());
                                        x271.setTag(1);
                                    } else {
                                        if (x281.getTag() == 0) {
                                            x281.setImageDrawable(j.getDrawable());
                                            x281.setTag(1);
                                        } else {
                                            if (x212.getTag() == 0) {
                                                x212.setImageDrawable(j.getDrawable());
                                                x212.setTag(1);
                                            } else {
                                                if (x222.getTag() == 0) {
                                                    x222.setImageDrawable(j.getDrawable());
                                                    x222.setTag(1);
                                                } else {
                                                    if (x232.getTag() == 0) {
                                                        x232.setImageDrawable(j.getDrawable());
                                                        x232.setTag(1);
                                                    } else {
                                                        if (x242.getTag() == 0) {
                                                            x242.setImageDrawable(j.getDrawable());
                                                            x242.setTag(1);
                                                        } else {
                                                            if (x252.getTag() == 0) {
                                                                x252.setImageDrawable(j.getDrawable());
                                                                x252.setTag(1);
                                                            } else {
                                                                if (x262.getTag() == 0) {
                                                                    x262.setImageDrawable(j.getDrawable());
                                                                    x262.setTag(1);
                                                                } else {
                                                                    if (x272.getTag() == 0) {
                                                                        x272.setImageDrawable(j.getDrawable());
                                                                        x272.setTag(1);
                                                                    } else {
                                                                        if (x282.getTag() == 0) {
                                                                            x282.setImageDrawable(j.getDrawable());
                                                                            x282.setTag(1);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void resetButtonsBackground() {
        a1.setBackgroundColor(Color.alpha(0));
        a2.setBackgroundColor(Color.alpha(0));
        a3.setBackgroundColor(Color.alpha(0));
        a4.setBackgroundColor(Color.alpha(0));
        a5.setBackgroundColor(Color.alpha(0));
        a6.setBackgroundColor(Color.alpha(0));
        a7.setBackgroundColor(Color.alpha(0));
        a8.setBackgroundColor(Color.alpha(0));

        b1.setBackgroundColor(Color.alpha(0));
        b2.setBackgroundColor(Color.alpha(0));
        b3.setBackgroundColor(Color.alpha(0));
        b4.setBackgroundColor(Color.alpha(0));
        b5.setBackgroundColor(Color.alpha(0));
        b6.setBackgroundColor(Color.alpha(0));
        b7.setBackgroundColor(Color.alpha(0));
        b8.setBackgroundColor(Color.alpha(0));

        c1.setBackgroundColor(Color.alpha(0));
        c2.setBackgroundColor(Color.alpha(0));
        c3.setBackgroundColor(Color.alpha(0));
        c4.setBackgroundColor(Color.alpha(0));
        c5.setBackgroundColor(Color.alpha(0));
        c6.setBackgroundColor(Color.alpha(0));
        c7.setBackgroundColor(Color.alpha(0));
        c8.setBackgroundColor(Color.alpha(0));

        d1.setBackgroundColor(Color.alpha(0));
        d2.setBackgroundColor(Color.alpha(0));
        d3.setBackgroundColor(Color.alpha(0));
        d4.setBackgroundColor(Color.alpha(0));
        d5.setBackgroundColor(Color.alpha(0));
        d6.setBackgroundColor(Color.alpha(0));
        d7.setBackgroundColor(Color.alpha(0));
        d8.setBackgroundColor(Color.alpha(0));

        a1.setDrawingCacheBackgroundColor(Color.alpha(0));
        a2.setDrawingCacheBackgroundColor(Color.alpha(0));
        a3.setDrawingCacheBackgroundColor(Color.alpha(0));
        a4.setDrawingCacheBackgroundColor(Color.alpha(0));
        a5.setDrawingCacheBackgroundColor(Color.alpha(0));
        a6.setDrawingCacheBackgroundColor(Color.alpha(0));
        a7.setDrawingCacheBackgroundColor(Color.alpha(0));
        a8.setDrawingCacheBackgroundColor(Color.alpha(0));

        b1.setDrawingCacheBackgroundColor(Color.alpha(0));
        b2.setDrawingCacheBackgroundColor(Color.alpha(0));
        b3.setDrawingCacheBackgroundColor(Color.alpha(0));
        b4.setDrawingCacheBackgroundColor(Color.alpha(0));
        b5.setDrawingCacheBackgroundColor(Color.alpha(0));
        b6.setDrawingCacheBackgroundColor(Color.alpha(0));
        b7.setDrawingCacheBackgroundColor(Color.alpha(0));
        b8.setDrawingCacheBackgroundColor(Color.alpha(0));

        c1.setDrawingCacheBackgroundColor(Color.alpha(0));
        c2.setDrawingCacheBackgroundColor(Color.alpha(0));
        c3.setDrawingCacheBackgroundColor(Color.alpha(0));
        c4.setDrawingCacheBackgroundColor(Color.alpha(0));
        c5.setDrawingCacheBackgroundColor(Color.alpha(0));
        c6.setDrawingCacheBackgroundColor(Color.alpha(0));
        c7.setDrawingCacheBackgroundColor(Color.alpha(0));
        c8.setDrawingCacheBackgroundColor(Color.alpha(0));

        d1.setDrawingCacheBackgroundColor(Color.alpha(0));
        d2.setDrawingCacheBackgroundColor(Color.alpha(0));
        d3.setDrawingCacheBackgroundColor(Color.alpha(0));
        d4.setDrawingCacheBackgroundColor(Color.alpha(0));
        d5.setDrawingCacheBackgroundColor(Color.alpha(0));
        d6.setDrawingCacheBackgroundColor(Color.alpha(0));
        d7.setDrawingCacheBackgroundColor(Color.alpha(0));
        d8.setDrawingCacheBackgroundColor(Color.alpha(0));
    }

    private void setTurns(ImageButton imageButton) {
        if (turns == UNKNOWN){
            if ((int)imageButton.getTag()%2==0){
                turns = BLACK;
                resetButton.setBackgroundColor(Color.argb(50, 0, 0, 0));
                return;
            }
            else if ((int)imageButton.getTag()%2==1){
                turns = RED;
                resetButton.setBackgroundColor(Color.argb(50, 200, 50, 50));
                return;
            }
        }
        else nextTurn();
    }

    private void nextTurn() {
        if (turns==RED){
            turns = BLACK;
            resetButtonsBackground();
            resetButton.setBackgroundColor(Color.argb(50, 0, 0, 0));
            return;
        }
        else if (turns==BLACK){
            turns = RED;
            resetButtonsBackground();
            resetButton.setBackgroundColor(Color.argb(50, 200, 50, 50));
            return;
        }
    }

    private void target(ImageButton currentButton, ImageButton targetButton) {
        targetButton.setDrawingCacheEnabled(true);
        if (((int)currentButton.getTag()==1 && (int)targetButton.getTag()==14) || ((int)currentButton.getTag()==2 && (int)targetButton.getTag()==13));
        else if (((int)targetButton.getTag()!=DARK && (int)targetButton.getTag()!=EMPTY
                && (((int)currentButton.getTag()==13 && (int)targetButton.getTag()==2)
                || ((int)currentButton.getTag()==14 && (int)targetButton.getTag()==1)))

                || ((int)targetButton.getTag()!=DARK && (int)targetButton.getTag()!=EMPTY
                && ((int)currentButton.getTag()==11 || (int)currentButton.getTag()==12))

                || ((int)targetButton.getTag()!=DARK && (int)targetButton.getTag()!=EMPTY
                && ((int)currentButton.getTag()%2==0 && (int)targetButton.getTag()%2==1)
                && ((int)currentButton.getTag()<= (int)targetButton.getTag()+1))

                || ((int)targetButton.getTag()!=DARK && (int)targetButton.getTag()!=EMPTY
                && ((int)currentButton.getTag()%2==1 && (int)targetButton.getTag()%2==0)
                && ((int)currentButton.getTag()<=(int)targetButton.getTag()-1))

                || (int)targetButton.getTag()==EMPTY)
        {
            targetButton.setBackgroundColor(Color.argb(60, 255, 255, 255));
            targetButton.setDrawingCacheBackgroundColor(Color.argb(60, 255, 255, 255));
            temp = currentButton;
            temp.setTag(currentButton.getTag());
            switch ((int)currentButton.getTag()) {
                case 1:
                    temp.setImageResource(R.drawable.chess_k1);
                    break;
                case 2:
                    temp.setImageResource(R.drawable.chess_k2);
                    break;
                case 3:
                    temp.setImageResource(R.drawable.chess_g1);
                    break;
                case 4:
                    temp.setImageResource(R.drawable.chess_g2);
                    break;
                case 5:
                    temp.setImageResource(R.drawable.chess_m1);
                    break;
                case 6:
                    temp.setImageResource(R.drawable.chess_m2);
                    break;
                case 7:
                    temp.setImageResource(R.drawable.chess_r1);
                    break;
                case 8:
                    temp.setImageResource(R.drawable.chess_r2);
                    break;
                case 9:
                    temp.setImageResource(R.drawable.chess_n1);
                    break;
                case 10:
                    temp.setImageResource(R.drawable.chess_n2);
                    break;
                case 11:
                    temp.setImageResource(R.drawable.chess_c1);
                    break;
                case 12:
                    temp.setImageResource(R.drawable.chess_c2);
                    break;
                case 13:
                    temp.setImageResource(R.drawable.chess_p1);
                    break;
                case 14:
                    temp.setImageResource(R.drawable.chess_p2);
                    break;
            }
            mode = MOVE;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_traditional, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings_1) {
            Class c;
            try {
                c = Class.forName("com.urik.darkchess.NewMode");
                Intent i = new Intent(TraditionalMode.this, c);
                startActivity(i);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
