package com.example.googleeb.td1.UI;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.googleeb.td1.Data.Db;
import com.example.googleeb.td1.Model.Personne;
import com.example.googleeb.td1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String IMG = "img";



    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        ListView listView = v.findViewById(R.id.list_personnes);
        ImageView imageView = v.findViewById(R.id.image_empty);

        Personne p = new Personne();

        ArrayList<Personne> personnes = p.getAllPersonne();

        List<HashMap<String, Object>> list = new ArrayList<>();
        HashMap hashMap = new HashMap();

        if(personnes.size() ==0){
            imageView.setVisibility(View.VISIBLE);
            listView.setVisibility(View.INVISIBLE);
        }else{
            for(int i=0; i<personnes.size(); i++){
                hashMap.put(NAME, personnes.get(i).getFirstName()+" "+personnes.get(i).getLastName());
                hashMap.put(AGE, personnes.get(i).getAge());
                hashMap.put(IMG, R.drawable.ic_user);
                list.add(hashMap);
            }

            SimpleAdapter adapter = new SimpleAdapter(getContext(), list, R.layout.list_item, new String[]{NAME, AGE, IMG}, new int[]{R.id.name, R.id.age, R.id.image_personne});

            listView.setAdapter(adapter);
        }


        return v;
    }

}
