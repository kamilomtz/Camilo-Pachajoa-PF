package com.example.a3apps.ui.home;

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
import com.example.a3apps.apiOperadores.AsociacionServicio;
import com.example.a3apps.models.Asociacion;
import com.example.a3apps.models.AsociacionAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Retrofit retrofit;
    private RecyclerView recyclerview;
    private ArrayList listaOperadores= new ArrayList<>();
    private AsociacionAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
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
        adapter= new AsociacionAdapter(listaOperadores);
        recyclerview.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(recyclerview.getContext(),llm.getOrientation());
        recyclerview.addItemDecoration(itemDecoration);


        obtenerDatos();
        return root;
    }

    private void obtenerDatos(){
        AsociacionServicio service= retrofit.create(AsociacionServicio.class);
        Call<ArrayList<Asociacion>> operadoresRespuestaCall = service.obtenerAsociaciones();
        operadoresRespuestaCall.enqueue(new Callback<ArrayList<Asociacion>>() {
            @Override

            public void onResponse(Call<ArrayList<Asociacion>> call, Response<ArrayList<Asociacion>> response) {
                if(response.isSuccessful()){

                    listaOperadores = response.body();
                    adapter= new AsociacionAdapter(listaOperadores);
                    recyclerview.setAdapter(adapter);




                    //listaOperadoresAdapter.adicionarOperador(listaOperadores);

                }else
                {
                    Log.e(TAG, " onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Asociacion>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }


        });
    }
}