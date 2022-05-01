package uqac.dim.feneant;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class TacheAdapter extends RecyclerView.Adapter<TacheAdapter.ViewHolder> {
    static TacheAdapter tacheAdapter;
    Context context;
    List<Tache> tacheList;
    RecyclerView rvPrograms;


    //final View.OnClickListener onClickListener = new MyOnClickListener();
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView rowTacheId;
        TextView rowTache;
        TextView rowDescription;
        TextView rowJour;
        TextView rowHeure;
        CheckBox ch1;
        private TacheAdapter adapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowTacheId = itemView.findViewById(R.id.TacheID);
            rowTache = itemView.findViewById(R.id.nomTache);
            rowDescription = itemView.findViewById(R.id.DescriptionTache);
            rowJour = itemView.findViewById(R.id.Echeance_jour);
            rowHeure = itemView.findViewById(R.id.Echeance_heure);
            //ch1=itemView.findViewById(R.id.Checko);

            ch1 = itemView.findViewById(R.id.Checko);
            //adapter = new HealthAdapter();

            ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                {
                    if ( isChecked )
                    {
                        System.out.println("lkdsqk");
                        TacheAdapter.tacheAdapter.tacheList.remove(getAdapterPosition());
                        TacheAdapter.tacheAdapter.notifyItemRemoved(getAdapterPosition());
                        int currentID = Integer.parseInt(rowTacheId.getText().toString());
                        SecondActivity.db.updateCheckTache(currentID, true);
                        Log.i("CHECKBOX"," recu");
                    }

                }
            });

            /*if (ch1.isChecked()){
                System.out.println("lkdsqk");
                //adapter.tacheList.remove(getAdapterPosition());
                //adapter.notifyItemRemoved(getAdapterPosition());
                Log.i("CHECKBOX"," recu");

            }*/


        }
    }
    public TacheAdapter(Context context, List<Tache> tacheList, RecyclerView rvPrograms){
        this.context = context;
        this.tacheList = tacheList;
        this.rvPrograms = rvPrograms;

        TacheAdapter.tacheAdapter = this;

    }
    @NonNull
    @Override
    public TacheAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row2, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull TacheAdapter.ViewHolder viewHolder, int i) {
        Tache tache = tacheList.get(i);
        System.out.println("la tache id est : " + tache.getIdTache());

        viewHolder.rowTacheId.setText(Integer.toString(tache.getIdTache()));
        viewHolder.rowTache.setText(""+tache.getNameTache());
        viewHolder.rowDescription.setText(tache.getDescription());
        viewHolder.rowJour.setText(tache.getEcheance_jour());
        viewHolder.rowHeure.setText(tache.getEcheance_heure());


        //int currentID = Integer.parseInt(rowTacheId.getText().toString());
        //ch1=itemView.findViewById(R.id.Checko);

        /*CheckBox ch1 = viewHolder.itemView.findViewById(R.id.Checko);
        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    TacheAdapter.tacheAdapter.tacheList.remove(getAdapterPosition());
                    TacheAdapter.tacheAdapter.notifyItemRemoved(i);
                    SecondActivity.db.updateCheckTache(tache.getIdTache(), true);
                    Log.i("CHECKBOX"," recu");
                }

            }
        });*/
    }
    @Override
    public int getItemCount() {
        return tacheList.size();
    }


}