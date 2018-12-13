package com.futpelada.lucas.futpelada.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.futpelada.lucas.futpelada.Controller.clTreinoController;
import com.futpelada.lucas.futpelada.R;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab_NovoTreino;
    private clTreinoController treinoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_NovoTreino = findViewById(R.id.fab_NovoTreino);

        treinoController = new clTreinoController(this);

        treinoController.existeDadosCadastrados(1);

        fab_NovoTreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityCRUDTreino.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
