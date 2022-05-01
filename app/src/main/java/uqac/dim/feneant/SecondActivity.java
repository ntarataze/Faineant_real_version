package uqac.dim.feneant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    DatabaseManager db;
    RecyclerView rvPrograms;
    HealthAdapter healthsAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Health> listeTache = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        db=new DatabaseManager(this);
        listeTache = db.readHealth();
        rvPrograms=findViewById(R.id.recyclerView2);
        layoutManager = new LinearLayoutManager(this);
        rvPrograms.setLayoutManager(layoutManager);
        healthsAdapter =new HealthAdapter(this, listeTache, rvPrograms);
        rvPrograms.setAdapter(healthsAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        db = new DatabaseManager(this);
        listeTache = db.readHealth();
        rvPrograms = findViewById(R.id.recyclerView2);
        layoutManager = new LinearLayoutManager(this);
        rvPrograms.setLayoutManager(layoutManager);
        healthsAdapter = new HealthAdapter(this, listeTache, rvPrograms);
        rvPrograms.setAdapter(healthsAdapter);
    }

    public void openPlanner(View v){
        Intent intent = new Intent(SecondActivity.this, CreatorEvent.class);
        startActivity(intent);
    }
}