package uqac.dim.feneant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewHome;

    String s1[], s2[], s3[];
    int images[] = {R.drawable.health, R.drawable.nutrition, R.drawable.fitness, R.drawable.work,
    R.drawable.study, R.drawable.travel};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewHome = findViewById(R.id.recyclerViewHome);

        s1 = getResources().getStringArray(R.array.lifestyleCategories);
        s2 = getResources().getStringArray(R.array.numberOfSkills);
        s3 = getResources().getStringArray(R.array.lazinessPercentage);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, s3, images);
        recyclerViewHome.setAdapter(myAdapter);
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}