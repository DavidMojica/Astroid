package com.dmv.astroid.modelos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface SolarSystemApi {
    @GET("bodies/{id}")
    Call<Objeto> getBodyDetails(@Path("id") String id);
}
