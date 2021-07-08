package service.bind.test.draglayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/5.
 */
public class CellLayout extends BaseLayout {
    private static final String TAG = "CellLayout";
    Bitmap bitmapBg;
    ImageView film, book, game;

    public CellLayout(Context context) {
        super(context);
        init();
    }

    public CellLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CellLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        bitmapBg = DrawBitmapUtilsKt.getBitmap(getContext(), R.drawable.bg);

        film = new ImageView(getContext());
        film.setImageResource(R.drawable.icon1);
        addView(film);

        game = new ImageView(getContext());
        game.setImageResource(R.drawable.icon2);
        addView(game);

        book = new ImageView(getContext());
        book.setImageResource(R.drawable.icon3);
        addView(book);
    }


    public void setScacle(float v, float v1) {
//        setPivotX(getWidth()/2);
//        setPivotY(getHeight()/2);
//        ViewHelper.setScaleX(this,v);
//        ViewHelper.setScaleX(this,v1);
        setScaleX(v);
        setScaleY(v1);
//        animate().scaleX(v);
//        animate().scaleY(v1);

    }


    @Override
    protected void dispatchDraw(Canvas canvas) {
        DrawBitmapUtilsKt.drawBitmap(canvas, bitmapBg, getWidth(), getHeight());        //  绘制背景图

        film.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "点击了电影馆", Toast.LENGTH_SHORT).show();
            }
        });

        book.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "点击了图书馆", Toast.LENGTH_SHORT).show();
            }
        });

        game.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "点击了游戏", Toast.LENGTH_SHORT).show();
            }
        });
        resetFilmView();
        resetBookView();
        resetGameView();
        super.dispatchDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    private void resetFilmView() {
        int left = 180, top = 440, width = 291, height = 306, right = left + width, bottom = top + height;
        film.layout(left, top, right, bottom);
    }

    private void resetBookView() {
        int left = 320, top = 150, width = 291, height = 306, right = left + width, bottom = top + height;
        book.layout(left, top, right, bottom);
    }

    private void resetGameView() {
        int left = 320, top = 720, width = 291, height = 306, right = left + width, bottom = top + height;
        game.layout(left, top, right, bottom);
    }
}
