package ducban.deptrai.comot.khonghai.projectandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DiemCaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diem_cao);
    }

    public void Back(View view) {
        Intent intent = new Intent(DiemCaoActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
