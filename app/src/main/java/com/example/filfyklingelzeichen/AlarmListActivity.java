package com.example.filfyklingelzeichen;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AlarmListActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    private List<Alarm> alarms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_list);

        // Find views by ids
        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler);

        setupRecyclerView();

        // Process fab onclick
        fab.setOnClickListener(v -> {
            // TODO: Open constructor
        });
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        // TODO: Get alarms
        alarms = new ArrayList<>();

        adapter = new RecyclerAlarmsAdapter(recyclerView, alarms, index -> {
            // TODO: Open constructor
        });
        recyclerView.setAdapter(adapter);
    }
}