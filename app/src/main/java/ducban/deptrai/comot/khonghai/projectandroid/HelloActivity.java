package ducban.deptrai.comot.khonghai.projectandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class HelloActivity extends AppCompatActivity {
    private ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        logo = (ImageView) findViewById(R.id.logo);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.myanimation);
        logo.startAnimation(myanim);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(HelloActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}
