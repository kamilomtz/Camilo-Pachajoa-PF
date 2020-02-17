package com.example.a3apps.apiOperadores;


import com.example.a3apps.models.Operadores;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OperadorServicio {
    @GET("resource/y5w5-h7te.json")
    Call<ArrayList<Operadores>> obtenerOperador();
}
