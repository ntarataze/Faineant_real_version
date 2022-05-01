package uqac.dim.feneant;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="feneant.db";
    private static final int DATABASE_VERSION=9;

    public DatabaseManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String strSQL_Health=" create table if not exists  T_Health("
                +"idTache integer primary key autoincrement,"
                +"nameTache text not null,"
                +"descriptif text not null,"
                +"echeance_jour text not null,"
                +"echeance_heure text not null,"
                +"when_ integer not null"
                +")";

        String strSQL_Nutrition="create table if not exists T_Nutrition("
                +"idTache integer primary key autoincrement,"
                +"nameTache text not null,"
                +"descriptif text not null,"
                +"echeance_jour text not null,"
                +"echeance_heure text not null"
                +")";

        String strSQL_fitness="create table if not exists  T_Fitness("
                +"idTache integer primary key autoincrement,"
                +"nameTache text not null,"
                +"descriptif text not null,"
                +"echeance_jour text not null,"
                +"echeance_heure text not null"
                +")";

        String strSQL_Work="create table if not exists  T_Work("
                +"idTache integer primary key autoincrement,"
                +"nameTache text not null,"
                +"descriptif text not null,"
                +"echeance_jour text not null,"
                +"echeance_heure text not null"
                +")";

        String strSQL_Study="create table if not exists  T_Study("
                +"idTache integer primary key autoincrement,"
                +"nameTache text not null,"
                +"descriptif text not null,"
                +"echeance_jour text not null,"
                +"echeance_heure text not null"
                +")";

        String strSQL_Travel="create table if not exists  T_Travel("
                +"idTache integer primary key autoincrement,"
                +"nameTache text not null,"
                +"descriptif text not null,"
                +"echeance_jour text not null,"
                +"echeance_heure text not null"
                +")";

        db.execSQL(strSQL_Health);
        db.execSQL(strSQL_Nutrition);
        db.execSQL(strSQL_fitness);
        db.execSQL(strSQL_Work);
        db.execSQL(strSQL_Study);
        db.execSQL(strSQL_Travel);
        Log.i("DATABASE","onCreate invoked");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String z="drop table T_Health";
        String y="drop table T_Nutrition";
        String w="drop table T_Fitness";
        String x="drop table T_Work";
        String v="drop table T_Study";
        String a="drop table T_Travel";

        db.execSQL(z);
        db.execSQL(y);
        db.execSQL(w);
        db.execSQL(x);
        db.execSQL(v);
        db.execSQL(a);
        onCreate(db);

    }

    public void insertIntoHealth(String nameTache, String descriptif,String echeance_jour,String echeance_heure){
        nameTache=nameTache.replace("'","''");
        echeance_jour=echeance_jour.replace("'","''");
        descriptif=descriptif.replace("'","''");
        echeance_jour=echeance_jour.replace("'","''");
        echeance_heure=echeance_heure.replace("'","''");
        String strSql = "insert into T_Health (nameTache,descriptif, echeance_jour, echeance_heure,when_) values ('"
                + nameTache + "', '" + descriptif + "', '" + echeance_jour + "','" + echeance_heure + "', " + new Date().getTime() + ")";
        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE","onUpgrade invoked");
    }

    public List<Health> readHealth(){
        List<Health> healthsList=new ArrayList<>();
        String strSql="select * from T_Health order by idTache asc";
        Cursor cursor=this.getReadableDatabase().rawQuery(strSql, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Health health=new Health(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
            healthsList.add(health);
            cursor.moveToNext();
        }
        cursor.close();
        return healthsList;
    }

}
