package com.dmv.astroid;
import com.dmv.astroid.modelos.Objeto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface SolarSystemApi {
    @GET("bodies/{bodyName}")
    Call<Objeto> getBodyDetails(@Path("bodyName") String bodyName);
}
