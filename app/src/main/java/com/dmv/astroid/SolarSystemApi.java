package com.dmv.astroid;
import com.dmv.astroid.modelos.Objeto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface SolarSystemApi {
    @GET("bodies/{id}")
    Call<Objeto> getPlanetDetails(@Path("id") String id);

}
