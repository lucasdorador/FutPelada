package com.futpelada.lucas.futpelada.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.futpelada.lucas.futpelada.Adapters.clTreinoAdapter;
import com.futpelada.lucas.futpelada.Classes.clTreino;
import com.futpelada.lucas.futpelada.Controller.clTreinoController;
import com.futpelada.lucas.futpelada.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab_NovoTreino;
    private clTreinoController treinoController;
    private RecyclerView recycleViewTreinos;
    private SwipeRefreshLayout swipeTreinos;
    private LinearLayoutManager mLayoutManagerTodosTreinos;
    private clTreinoAdapter adapterSQLite;
    private List<clTreino> treino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_NovoTreino = findViewById(R.id.fab_NovoTreino);
        recycleViewTreinos = findViewById(R.id.recycleViewTreinos);
        swipeTreinos = findViewById(R.id.swipeTreinos);

        treinoController = new clTreinoController(this);
        carregarTodosTreinos();

        fab_NovoTreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityCRUDTreino.class);
                startActivity(intent);
                finish();
            }
        });

        swipeTreinos.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });

        swipeTreinos.setColorSchemeResources(R.color.colorPrimary);
    }

    private void retornaTodosTreinos() {
        treino = treinoController.retornaListaClasseEmpresaSQLite();
    }

    private void carregarTodosTreinos() {
        recycleViewTreinos.setHasFixedSize(true);
        mLayoutManagerTodosTreinos = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recycleViewTreinos.setLayoutManager(mLayoutManagerTodosTreinos);
        retornaTodosTreinos();
        adapterSQLite = new clTreinoAdapter(treino, MainActivity.this);
        recycleViewTreinos.setAdapter(adapterSQLite);
        adapterSQLite.notifyDataSetChanged();
    }
}
