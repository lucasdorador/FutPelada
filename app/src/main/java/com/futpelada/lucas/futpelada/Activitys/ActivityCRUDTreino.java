package com.futpelada.lucas.futpelada.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.futpelada.lucas.futpelada.Classes.clTreino;
import com.futpelada.lucas.futpelada.Controller.clTreinoController;
import com.futpelada.lucas.futpelada.R;

public class ActivityCRUDTreino extends AppCompatActivity {

    private BootstrapEditText edtNomeTreino, edtLocalTreino, edtValorTreino;
    private BootstrapButton btnGravar;
    private clTreinoController treinoController;
    private clTreino treino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudtreino);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        treinoController = new clTreinoController(this);
        treino = new clTreino();

        edtNomeTreino = findViewById(R.id.edtNomeTreino);
        edtLocalTreino = findViewById(R.id.edtLocalTreino);
        edtValorTreino = findViewById(R.id.edtValorTreino);
        edtValorTreino.setText("0.00");
        btnGravar = findViewById(R.id.btnGravar);

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validaCampos = true;
                if (edtNomeTreino.getText().toString().equals("")) {
                    validaCampos = false;
                    edtNomeTreino.setError("Campo obrigatório!");
                }

                if (validaCampos) {
                    treino.set_id(treinoController.retornaProximoID());
                    treino.setNome(edtNomeTreino.getText().toString());
                    treino.setLocal(edtLocalTreino.getText().toString());
                    treino.setValorMensal(Double.parseDouble(edtValorTreino.getText().toString()));

                    if (!treinoController.insereTreino(treino)) {
                        Toast.makeText(ActivityCRUDTreino.this, "Houve um erro ao gravar o Treino", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ActivityCRUDTreino.this, "Treino gravado com sucesso!", Toast.LENGTH_LONG).show();
                        edtNomeTreino.setText("");
                        edtLocalTreino.setText("");
                        edtValorTreino.setText("0.00");

                        Intent intent = new Intent(ActivityCRUDTreino.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

    }

}
