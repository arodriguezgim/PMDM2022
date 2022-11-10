package org.iesch.a12_pokemon_retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.iesch.a12_pokemon_retrofit.model.Pokemon;

import java.util.ArrayList;

//3 Creamos el adaptadaor e implementamos los pasos
public class ListaPokemonAdapter extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder> {
    //5
    private ArrayList<Pokemon> dataset;
    private Context context;
    //9
    public ListaPokemonAdapter(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }



    @NonNull
    @Override
    public ListaPokemonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //8
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPokemonAdapter.ViewHolder holder, int position) {
        // 7
        Pokemon p = dataset.get(position);
        holder.nombreTextView.setText(p.getName());
        // 19 cargamos la imagen con Glide
        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + p.getNumber() + ".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);

    }

    @Override
    public int getItemCount() {
        //6
        return dataset.size();
    }
    //15 Creamos el metodo en el adaptador
    // Permitimos que el Arraylist que llega lo junte con el arraylist del adaptador
    public void adicionarPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        // 16 con este metodo actualizaremos el recyclerView en la pantalla
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //4a
        private ImageView fotoImageView;
        private TextView nombreTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //4b
            fotoImageView = itemView.findViewById(R.id.fotoImageView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
        }
    }
}













