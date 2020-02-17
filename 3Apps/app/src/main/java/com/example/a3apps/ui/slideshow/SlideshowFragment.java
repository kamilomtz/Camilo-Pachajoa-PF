package com.example.a3apps.ui.slideshow;

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
import com.example.a3apps.apiOperadores.CentroServicio;
import com.example.a3apps.models.CentrosSalud;
import com.example.a3apps.models.CentrosSaludAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private Retrofit retrofit;
    private RecyclerView recyclerview;
    private ArrayList listaOperadores= new ArrayList<>();
    private CentrosSaludAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        recyclerview =root.findViewById(R.id.rvcentrossalud);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //listaOperadoresAdapter = new OperadorAdapter(listaOperadores);
        //recyclerview.setAdapter(listaOperadoresAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(llm);
        adapter= new CentrosSaludAdapter(listaOperadores);
        recyclerview.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(recyclerview.getContext(),llm.getOrientation());
        recyclerview.addItemDecoration(itemDecoration);


        obtenerDatos();
        return root;
    }

    private void obtenerDatos() {
        CentroServicio  service = retrofit.create(CentroServicio.class);
        Call<ArrayList<CentrosSalud>> centrosRespuestaCall = service.obtenerCentros();
        centrosRespuestaCall.enqueue(new Callback<ArrayList<CentrosSalud>>() {

            public void onResponse(Call<ArrayList<CentrosSalud>> call, Response<ArrayList<CentrosSalud>> response) {
                if(response.isSuccessful()) {

                    listaOperadores = response.body();
                    adapter = new CentrosSaludAdapter(listaOperadores);
                    recyclerview.setAdapter(adapter);
                }
                else
                {
                    Log.e(TAG, " onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CentrosSalud>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }


        });
    }


}