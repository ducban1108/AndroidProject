package ducban.deptrai.comot.khonghai.projectandroid.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import ducban.deptrai.comot.khonghai.projectandroid.model.Question;

public class DatabaseHelper {
    public static final String TABLE_NAME="cauhoi";
    public static final String DV_NAME="caudo.sql";
    public static final String PATH= Environment.getDataDirectory()+
            "/data/ducban.deptrai.comot.khonghai.projectandroid.database/databases/"+DV_NAME;
    public static final String TABLE_ID="_id";
    public static final String TABLE_QUESTION="Question";
    public static final String TABLE_CASE_A="CaseA";
    public static final String TABLE_CASE_B="CaseB";
    public static final String TABLE_CASE_C="CaseC";
    public static final String TABLE_CASE_D="CaseD";
    public static final String TABLE_RESULT="Result";
    private Context context;
    private SQLiteDatabase database;

    public DatabaseHelper(Context context) {
        this.context = context;
        copyDataBase(context);
    }

    private void copyDataBase(Context context) {
        File file= new File(PATH);
        if (file.exists()){
            return;
        }
        File parent= file.getParentFile();
        parent.mkdirs();
        try {
            FileOutputStream outputStream=new FileOutputStream(file);
            InputStream inputStream= context.getAssets().open(DV_NAME);
            byte []b= new byte[1024];
            int count= inputStream.read(b);
            while (count!=-1){
                outputStream.write(b,0,count);
                inputStream.read(b);
            }
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openDataBase(){
        database=context.openOrCreateDatabase(TABLE_NAME,context.MODE_PRIVATE,null);
    }

    public void closeDaTaBase(){
        database.close();
    }

    public ArrayList<Question> getData(){
        openDataBase();
        database.beginTransaction();
        ArrayList<Question> arrQuestions=new ArrayList<>();
        String table = TABLE_NAME ;
        for (int i=1;i<16;i++) {


            String sql="SELECT * FROM "+table+" ORDER BY random() limit 1";

            Cursor cursor= database.rawQuery(sql,null);
            int indexId= cursor.getColumnIndex(TABLE_ID);
            int indexQuestion= cursor.getColumnIndex(TABLE_QUESTION);
            int indexCaseA=cursor.getColumnIndex(TABLE_CASE_A);
            int indexCaseB=cursor.getColumnIndex(TABLE_CASE_B);
            int indexCaseC=cursor.getColumnIndex(TABLE_CASE_C);
            int indexCaseD=cursor.getColumnIndex(TABLE_CASE_D);
            int indexResult=cursor.getColumnIndex(TABLE_RESULT);
            cursor.moveToFirst();
            int id=cursor.getInt(indexId);
            String question= cursor.getString(indexQuestion);
            String caseA= cursor.getString(indexCaseA);
            String caseB= cursor.getString(indexCaseB);
            String caseC= cursor.getString(indexCaseC);
            String caseD= cursor.getString(indexCaseD);
            int trueCase= cursor.getInt(indexResult);
            Question question1=new Question(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrQuestions.add(question1);
        }
        database.close();
        closeDaTaBase();
        return arrQuestions;
    }

}
