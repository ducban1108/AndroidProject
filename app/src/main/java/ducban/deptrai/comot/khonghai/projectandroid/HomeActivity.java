package ducban.deptrai.comot.khonghai.projectandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void HuongDan(View view) {
        Intent intent = new Intent(HomeActivity.this,HuongDanActivity.class);
        startActivity(intent);
    }

    public void Thoat(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Thoát");
        builder.setMessage("Bạn có muốn thoát không?");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }

    public void VaoGame(View view) {
        Intent intent = new Intent(HomeActivity.this,ChooseTypeActivity.class);
        startActivity(intent);
    }

    public void DiemCao(View view) {
        Intent intent = new Intent(HomeActivity.this,DiemCaoActivity.class);
        startActivity(intent);
    }
}
