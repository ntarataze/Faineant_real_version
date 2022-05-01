package uqac.dim.feneant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewHome;

    String s1[], s2[], s3[];
    int images[] = {R.drawable.health, R.drawable.nutrition, R.drawable.fitness, R.drawable.work,
    R.drawable.study, R.drawable.travel};

    private DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseManager( this );
        db.insertIntoHealth("coeur","rdv","MAY 23 2023","19:00");

        recyclerViewHome = findViewById(R.id.recyclerViewHome);

        s1 = getResources().getStringArray(R.array.lifestyleCategories);
        s2 = getResources().getStringArray(R.array.numberOfSkills);
        s3 = getResources().getStringArray(R.array.lazinessPercentage);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, s3, images);
        recyclerViewHome.setAdapter(myAdapter);
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(this));

        db=new DatabaseManager(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_health:
                onBackPressed();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_nutrition:
                onBackPressed();
                return true;

            case R.id.menu_fitness:
                onBackPressed();
                return true;

            case R.id.menu_work:
                onBackPressed();
                return true;

            case R.id.menu_study:
                onBackPressed();
                return true;

            case R.id.menu_travel:
                onBackPressed();
                return true;

            default:
                return true;
        }
    }

}