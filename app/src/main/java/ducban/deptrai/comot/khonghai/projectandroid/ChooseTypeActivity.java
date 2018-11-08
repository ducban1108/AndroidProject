package ducban.deptrai.comot.khonghai.projectandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_type);
    }

    public void HoiXoayDapXoay(View view) {
        Intent intent = new Intent(ChooseTypeActivity.this,ChoiActivity.class);
        startActivity(intent);
    }

    public void CauHoiKienThuc(View view) {
        Intent intent = new Intent(ChooseTypeActivity.this,ChoiActivity.class);
        startActivity(intent);
    }
}
