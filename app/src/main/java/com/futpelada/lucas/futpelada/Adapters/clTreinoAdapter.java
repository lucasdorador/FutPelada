package com.futpelada.lucas.futpelada.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.futpelada.lucas.futpelada.Classes.clTreino;
import com.futpelada.lucas.futpelada.Controller.clTreinoController;
import com.futpelada.lucas.futpelada.R;

import java.util.List;

public class clTreinoAdapter  extends RecyclerView.Adapter<clTreinoAdapter.ViewHolder> {

    private List<clTreino> mTreinoList;
    private Activity activity;
    private clTreino TreinoSelecionado;
    private clTreinoController treinoController;

    public clTreinoAdapter(List<clTreino> l, Activity a) {
        activity = a;
        mTreinoList = l;
        treinoController = new clTreinoController(activity);
    }

    @NonNull
    @Override
    public clTreinoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layouttreinos, viewGroup, false);
        return new clTreinoAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final clTreinoAdapter.ViewHolder holder, int position) {
        final clTreino item = mTreinoList.get(position);

        holder.txtNomeTreino.setText(item.getNome());
        holder.txtLocalTreino.setText(item.getLocal());
        holder.linearLayout_Treinos.setTag(item.get_id());

        holder.linearLayout_Treinos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String EmpresaClicada = (String) view.getTag();
                //pcdCarregaEmpresa_SQLite(EmpresaClicada);

            }
        });
    }

    public void pcdCarregaTreino_SQLite(String keyEmpresa){
        //TreinoSelecionado = treinoController.retornaClasseEmpresaSQLite(keyEmpresa);
        //abreActivityMenus(EmpresaSelecionada.getKey_empresa(), EmpresaSelecionada);
    }

    @Override
    public int getItemCount() {
        return mTreinoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtNomeTreino, txtLocalTreino;
        protected LinearLayout linearLayout_Treinos;

        public ViewHolder(View itemView) {
            super(itemView);

            txtNomeTreino = itemView.findViewById(R.id.txtNomeTreino);
            txtLocalTreino = itemView.findViewById(R.id.txtLocalTreino);
            linearLayout_Treinos = itemView.findViewById(R.id.linearLayout_Treinos);
        }

    }
}

