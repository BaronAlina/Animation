package com.example.animation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    final int ALPHA=1;
    final int SCALE=2;
    final int TRANSLATE=3;
    final int ROTATE=4;
    final int COMBO=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        textView.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.textView:
                menu.add(0, ALPHA, 0, "alpha");
                menu.add(1, SCALE, 1, "scale");
                menu.add(2, TRANSLATE, 2, "translate");
                menu.add(3, ROTATE, 3, "rotate");
                menu.add(4, COMBO, 4, "combo");
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Animation animation =null;
        switch (item.getItemId()){
            case ALPHA:
                animation= AnimationUtils.loadAnimation(this, R.anim.myalpha);
                break;
                case SCALE:
                animation= AnimationUtils.loadAnimation(this, R.anim.myscale);
                break;
                case TRANSLATE:
                animation= AnimationUtils.loadAnimation(this, R.anim.trans);
                break;
                case ROTATE:
                animation= AnimationUtils.loadAnimation(this, R.anim.myrotate);
                break;
                case COMBO:
                animation= AnimationUtils.loadAnimation(this, R.anim.mycombo);
                break;
        }
        textView.startAnimation(animation);
        return super.onContextItemSelected(item);
    }
}