package com.dmv.astroid.Apod;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Call<String> obtenerJsonString(@Url String url);
}
