package com.example.a3apps.apiOperadores;



import com.example.a3apps.models.CentrosSalud;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CentroServicio {
    @GET("resource/kj8i-7tey.json")
    Call<ArrayList<CentrosSalud>> obtenerCentros();
}
