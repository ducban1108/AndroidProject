package ducban.deptrai.comot.khonghai.projectandroid;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ducban.deptrai.comot.khonghai.projectandroid.database.DatabaseHelper;
import ducban.deptrai.comot.khonghai.projectandroid.model.Question;

public class ChoiActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvQuestion;
    private Button btnCaseA;
    private Button btnCaseB;
    private Button btnCaseC;
    private Button btnCaseD;
    private DatabaseHelper databaseHelper;
    private TextView tvTimedown;
    private TextView tvSoCau;
    private int trueCase;
    private int i;
    private int dem;
    private int wait;
    private boolean check;
    private TextView tvCoin;
    private boolean run;
    private int coin;
    private Dialog dialog;
    private ArrayList<Question> questions = new ArrayList<>();
    private ImageView imHelp_5050;
    private ImageView imHelp_audience;
    private ImageView imHelp_call;
    private ImageView imHelp_stop;
    private int timeRunHelp;
    private int idHelp;
    private Animation animationButton;
    private boolean checkPickAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi);
        databaseHelper = new DatabaseHelper(this);
        questions = databaseHelper.getData();
        initView();
        asyncTask.execute();


    }

    private void initView() {
        i = 0;
        dem = 30;
        wait = 30;
        coin = 0;
        timeRunHelp = 30;
        tvQuestion = (TextView) findViewById(R.id.tvQuestions);
        tvTimedown = (TextView) findViewById(R.id.tv_timeDown);
        tvCoin = (TextView) findViewById(R.id.tvCoin);
        tvSoCau = (TextView) findViewById(R.id.tvSoCau);
        btnCaseA = (Button) findViewById(R.id.btn_answer_A);
        btnCaseB = (Button) findViewById(R.id.btn_answer_B);
        btnCaseC = (Button) findViewById(R.id.btn_answer_C);
        btnCaseD = (Button) findViewById(R.id.btn_answer_D);
        setText(i);
        btnCaseA.setOnClickListener(this);
        btnCaseB.setOnClickListener(this);
        btnCaseC.setOnClickListener(this);
        btnCaseD.setOnClickListener(this);
        imHelp_5050.setOnClickListener(this);
        imHelp_audience.setOnClickListener(this);
        imHelp_call.setOnClickListener(this);
        imHelp_stop.setOnClickListener(this);
    }

    public void setText(int i) {
        run = true;
        int tm = i + 1;
        tvCoin.setText(coin + "");
        tvSoCau.setText("Câu hỏi số " + tm + " :");
        checkPickAnswer = true;
        btnCaseA.setBackgroundResource(R.drawable.button);
        btnCaseB.setBackgroundResource(R.drawable.button);
        btnCaseC.setBackgroundResource(R.drawable.button);
        btnCaseD.setBackgroundResource(R.drawable.button);
        tvQuestion.setText(questions.get(i).getQuestion());
        btnCaseA.setText("A. " + questions.get(i).getAns_a());
        btnCaseB.setText("B. " + questions.get(i).getAns_b());
        btnCaseC.setText("C. " + questions.get(i).getAns_c());
        btnCaseD.setText("D. " + questions.get(i).getAns_d());
        btnCaseA.setEnabled(true);
        btnCaseB.setEnabled(true);
        btnCaseC.setEnabled(true);
        btnCaseD.setEnabled(true);
        dem = 30;
        switch (questions.get(i).getResult()) {
            case 1:
                trueCase = R.id.btn_answer_A;
                break;
            case 2:
                trueCase = R.id.btn_answer_B;
                break;
            case 3:
                trueCase = R.id.btn_answer_C;
                break;
            case 4:
                trueCase = R.id.btn_answer_D;
                break;
        }
    }


    @Override
    public void onClick(View v) {
        run = false;
        if (!checkPickAnswer) {
            return;
        }
        if (v.getId() == R.id.btn_answer_A ||
                v.getId() == R.id.btn_answer_B ||
                v.getId() == R.id.btn_answer_C ||
                v.getId() == R.id.btn_answer_D) {
            v.setBackgroundResource(R.drawable.answer_choose);

            if (v.getId() == trueCase) {
                check = true;
                wait = 0;
                coin = coin + 200 * (i + 1);
            } else {
                check = false;
                wait = 0;
            }
            checkPickAnswer = false;
        }

    }

    private AsyncTask<Void, Integer, Void> asyncTask = new AsyncTask<Void, Integer, Void>() {
        @Override
        protected Void doInBackground(Void... params) {
            for (dem = 30; dem >= 0; dem--) {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(dem);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (run) {
                tvTimedown.setText(values[0] + "");
            } else {
                dem++;
            }
            wait++;
            timeRunHelp++;
            showHelp(timeRunHelp, idHelp);
            if (wait == 4 && check) {
                switch (trueCase) {
                    case R.id.btn_answer_A:
                        btnCaseA.setBackgroundResource(R.drawable.answer_true);
                        animnButon(btnCaseA);
                        break;
                    case R.id.btn_answer_B:
                        btnCaseB.setBackgroundResource(R.drawable.answer_true);
                        animnButon(btnCaseB);
                        break;
                    case R.id.btn_answer_C:
                        btnCaseC.setBackgroundResource(R.drawable.answer_true);
                        animnButon(btnCaseC);
                        break;
                    case R.id.btn_answer_D:
                        btnCaseD.setBackgroundResource(R.drawable.answer_true);
                        animnButon(btnCaseD);
                        break;
                }
            }
            if (wait == 4 && !check) {
                switch (trueCase) {
                    case R.id.btn_answer_A:
                        btnCaseA.setBackgroundResource(R.drawable.answer_false);
                        break;
                    case R.id.btn_answer_B:
                        btnCaseB.setBackgroundResource(R.drawable.answer_false);
                        break;
                    case R.id.btn_answer_C:
                        btnCaseC.setBackgroundResource(R.drawable.answer_false);
                        break;
                    case R.id.btn_answer_D:
                        btnCaseD.setBackgroundResource(R.drawable.answer_false);
                        break;
                }
            }
            if (wait == 6 && check) {
                setText(++i);
            }
            if ((wait == 6 && !check) || dem == 0 || i == 16) {
                initDiaLogFinish(coin);
            }
        }
    };
    public void animnButon(Button btn){
        animationButton= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_check);
        btn.startAnimation(animationButton);
    }
    public void initDiaLogFinish(int coin){
        dialog=new Dialog(this,android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth);
        LayoutInflater layoutInflater= LayoutInflater.from(this);
        View view=layoutInflater.inflate(R.layout.dialog_finish,null);
        TextView tvFinish= (TextView) view.findViewById(R.id.tvFinish);
        tvFinish.setText("Bạn đã dành được "+ coin+" điểm. Cảm ơn bạn đã tham gia " +
                "chương trình. Chúc bạn thành công trong cuộc sống !!!");
        Button btnFinish= (Button) view.findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                dialog.dismiss();
            }
        });
        dialog.setCancelable(true);
        dialog.setContentView(view);
        dialog.show();
    }
    public void showHelp(int timeRunHelp,int idHelp){

    }
}
