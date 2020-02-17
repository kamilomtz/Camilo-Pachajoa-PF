package com.example.a3apps.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.a3apps.R;
import com.example.a3apps.apiOperadores.OperadorServicio;
import com.example.a3apps.models.OperadorAdapter;
import com.example.a3apps.models.Operadores;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private Retrofit retrofit;
    private RecyclerView recyclerview;
    private ArrayList listaOperadores= new ArrayList<>();
    private OperadorAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);

            }
        });

        recyclerview =root.findViewById(R.id.rvoperadores);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //listaOperadoresAdapter = new OperadorAdapter(listaOperadores);
        //recyclerview.setAdapter(listaOperadoresAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(llm);
        adapter= new OperadorAdapter(listaOperadores);
        recyclerview.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(recyclerview.getContext(),llm.getOrientation());
        recyclerview.addItemDecoration(itemDecoration);


        obtenerDatos();
        return root;
    }

    private void obtenerDatos(){
        OperadorServicio service= retrofit.create(OperadorServicio.class);
        Call<ArrayList<Operadores>> operadoresRespuestaCall = service.obtenerOperador();
        operadoresRespuestaCall.enqueue(new Callback<ArrayList<Operadores>>() {
            @Override

            public void onResponse(Call<ArrayList<Operadores>> call, Response<ArrayList<Operadores>> response) {
            if(response.isSuccessful()){

                 listaOperadores = response.body();
                 adapter=new OperadorAdapter(listaOperadores);
                 recyclerview.setAdapter(adapter);




                //listaOperadoresAdapter.adicionarOperador(listaOperadores);

            }else
            {
                Log.e(TAG, " onResponse: "+response.errorBody());
            }
        }

        @Override
        public void onFailure(Call<ArrayList<Operadores>> call, Throwable t) {
            Log.e(TAG," onFailure: "+t.getMessage());
        }


    });
    }
}