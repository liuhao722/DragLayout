package service.bind.test.draglayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.nineoldandroids.animation.AnimatorSet;

/**
 * Created by Administrator on 2016/9/5.
 */
public class CellLayout extends BaseLayout {
    private static final String TAG = "CellLayout";
    AnimatorSet set = new AnimatorSet();
    Paint mPaint = new Paint();
    Bitmap bitmap;
    Bitmap bitmapItemFilm;
    Bitmap bitmapItemBook;
    Bitmap bitmapItemGame;
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
        bitmap = DrawBitmapUtilsKt.getBitmap(getContext(), R.drawable.bg);
        bitmapItemFilm = DrawBitmapUtilsKt.getBitmap(getContext(), R.drawable.icon1);
        bitmapItemGame = DrawBitmapUtilsKt.getBitmap(getContext(), R.drawable.icon2);
        bitmapItemBook = DrawBitmapUtilsKt.getBitmap(getContext(), R.drawable.icon3);

        film = new ImageView(getContext());
        film.setImageResource(R.drawable.icon1);
        addView(film);

        game = new ImageView(getContext());
        game.setImageResource(R.drawable.icon2);
        addView(game);

        book = new ImageView(getContext());
        book.setImageResource(R.drawable.icon3);
        addView(book);

//        set.playTogether(
//                ObjectAnimator.ofFloat(myView, rotationX, 0, 360),
//                ObjectAnimator.ofFloat(myView, rotationY, 0, 180),
//                ObjectAnimator.ofFloat(myView, rotation, 0, -90),
//                ObjectAnimator.ofFloat(myView, translationX, 0, 90),
//                ObjectAnimator.ofFloat(myView, translationY, 0, 90),
//                ObjectAnimator.ofFloat(myView, scaleX, 1, 1.5f),
//                ObjectAnimator.ofFloat(myView, scaleY, 1, 0.5f),
//                ObjectAnimator.ofFloat(myView, alpha, 1, 0.25f, 1)
//        );
//        set.setDuration(5 * 1000);

//        mPaint.setColor(Color.RED);
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
        DrawBitmapUtilsKt.drawBitmap(canvas, bitmap, getWidth(), getHeight());

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
//        imageView.setLayoutParams(params);


//        DrawBitmapUtilsKt.drawItemBitmap(canvas, bitmapItemBook, getWidth(), getHeight(), 330f, 80f);
//        DrawBitmapUtilsKt.drawItemBitmap(canvas, bitmapItemGame, getWidth(), getHeight(), 180f, 350f);
//        DrawBitmapUtilsKt.drawItemBitmap(canvas, bitmapItemFilm, getWidth(), getHeight(), 350f, 620f);
        super.dispatchDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        if (event.getRawX() > 0) {
//            if (event.getRawX() > 180 && event.getRawX() < bitmapItemFilm.getWidth() + 350) {
//                Log.e(TAG, "有效的x点击范围");
//                if (event.getRawY() > 350 && event.getRawY() < bitmapItemFilm.getHeight() + 620) {
//                    Log.e(TAG, "有效的Y点击范围");
//                }
//            }
//        }
//        Log.e(TAG, "点击位置X：" + event.getRawX() + "\t点击位置Y：" + event.getRawY());
//        Log.e(TAG, "一次点击事件结束\n");
//        Log.e(TAG, "------------------------------------------------------------------------------------");
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
