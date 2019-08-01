package com.angel.practicandoretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Json_place_holder {
    @GET("posts") //aquí llamo a la parte de la URL que quiero consumir
    Call <List<posts>> getposts(); //creo una lista de la clase donde defini los atributos


}
