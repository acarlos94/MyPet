package banzoprojects.com.pet.infra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import banzoprojects.com.pet.R;
import banzoprojects.com.pet.animal.dominio.Animal;

/**
 * Created by Romilson on 10/12/2016.
 */

public class AnimalAdapter extends BaseAdapter {
    private List<Animal> animal;
    private Context context;
    public AnimalAdapter(List<Animal> animal, Context context){
        this.animal = animal;
        this.context = context;
    }
    @Override
    public int getCount() {
        return animal.size();
    }

    @Override
    public Object getItem(int position) {
        return animal.get(position);
    }

    @Override
    public long getItemId(int position) {
        return animal.get(position).get_idAnimal();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_animal,null);
        }
        Animal a = this.animal.get(position);
        TextView textViewAnimal = (TextView)view.findViewById(R.id.tvNomeAnimal);
        TextView textViewRaça = (TextView)view.findViewById(R.id.tvRaca);
        TextView textViewSexo = (TextView)view.findViewById(R.id.tvSexo);
        textViewSexo.setText(a.getSexo());
        textViewAnimal.setText(a.getNome());
        textViewRaça.setText(a.getTipo());

        return view;
    }
}
