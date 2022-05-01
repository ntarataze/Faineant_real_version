package uqac.dim.feneant;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.ViewHolder> {
    Context context;
    List<Health> tacheList;
    RecyclerView rvPrograms;

    //final View.OnClickListener onClickListener = new MyOnClickListener();
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView rowTache;
        TextView rowDescription;
        TextView rowJour;
        TextView rowHeure;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowTache = itemView.findViewById(R.id.nomTache);
            rowDescription = itemView.findViewById(R.id.DescriptionTache);
            rowJour = itemView.findViewById(R.id.Echeance_jour);
            rowHeure = itemView.findViewById(R.id.Echeance_heure);
        }
    }
    public HealthAdapter(Context context, List<Health> tacheList, RecyclerView rvPrograms){
        this.context = context;
        this.tacheList = tacheList;
        this.rvPrograms = rvPrograms;
    }
    @NonNull
    @Override
    public HealthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row2, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull HealthAdapter.ViewHolder viewHolder, int i) {
        Health tache = tacheList.get(i);
        viewHolder.rowTache.setText(""+tache.getNameTache());
        viewHolder.rowDescription.setText(tache.getDescription());
        viewHolder.rowJour.setText(tache.getEcheance_jour());
        viewHolder.rowHeure.setText(tache.getEcheance_heure());
    }
    @Override
    public int getItemCount() {
        return tacheList.size();
    }
}