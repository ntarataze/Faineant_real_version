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
    private static final int DATABASE_VERSION=15;

    public DatabaseManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String strSQL_tache=" create table if not exists  T_Tache("
                +"idTache integer primary key autoincrement,"
                +"nameTache text not null,"
                +"descriptif text not null,"
                +"echeance_jour text not null,"
                +"echeance_heure text not null,"
                +"when_ integer not null,"
                +"type text,"
                +"ischeck text"
                +")";
        ;

        db.execSQL(strSQL_tache);
        Log.i("DATABASE","onCreate invoked");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String z="drop table if exists T_Tache";

        db.execSQL(z);
        onCreate(db);

    }

    public void insertIntoTache(String nameTache, String descriptif,String echeance_jour,String echeance_heure){
        nameTache=nameTache.replace("'","''");
        echeance_jour=echeance_jour.replace("'","''");
        descriptif=descriptif.replace("'","''");
        echeance_jour=echeance_jour.replace("'","''");
        echeance_heure=echeance_heure.replace("'","''");
        String strSql = "insert into T_Tache (nameTache,descriptif, echeance_jour, echeance_heure,when_, ischeck) values ('"
                + nameTache + "', '" + descriptif + "', '" + echeance_jour + "','" + echeance_heure + "', '" + new Date().getTime() + "', 'FALSE' );";
        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE","onUpgrade invoked");
    }

    public List<Tache> readTache(){
        List<Tache> healthsList=new ArrayList<>();
        String strSql="select * from T_Tache order by idTache asc";
        Cursor cursor=this.getReadableDatabase().rawQuery(strSql, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            if(!cursor.getString(7).toLowerCase().equals("true"))
            {
                Tache tache=new Tache(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4), cursor.getInt(0),cursor.getString(7));
                healthsList.add(tache);
            }
            cursor.moveToNext();
        }
        cursor.close();
        return healthsList;
    }

    public void updateCheckTache(int idTache, boolean ischeck){
        String strSql = "update T_Tache set ischeck = 'TRUE' where idTache = " + idTache;
        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE","onUpgrade invoked");
    }

}

