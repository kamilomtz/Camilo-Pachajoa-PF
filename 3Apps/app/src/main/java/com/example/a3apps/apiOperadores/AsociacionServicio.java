package com.example.a3apps.apiOperadores;



import com.example.a3apps.models.Asociacion;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AsociacionServicio {
    @GET("resource/kqsj-pkfu.json")
    Call<ArrayList<Asociacion>> obtenerAsociaciones();

}

