package com.angel.practicandoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto= (TextView)findViewById(R.id.texto);
        getposts();
    }

    private void getposts(){
        Retrofit retro = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create())
                .build(); //importante mantener el slash al final de la url
//     instancio la interfaz           nombre de la instancia de retrofit
        Json_place_holder aaaaaxd_xd = retro.create(Json_place_holder.class);

        Call<List<posts>> call = aaaaaxd_xd.getposts();
        call.enqueue(new Callback<List<posts>>() {
            @Override
            public void onResponse(Call<List<posts>> call, Response<List<posts>> response) {


                if (!response.isSuccessful()) {
                    texto.setText("Codigo: " + response.code());
                    return;
                }
                List<posts> lista = response.body();
                for (posts p: lista){
                    String content = "";
                    content += "userId:"+ p.getUserId() + "\n";
                    content += "id:"+ p.getId() + "\n";
                    content += "title:"+ p.getTitle() + "\n";
                    content += "body:"+ p.getBody() + "\n\n";
                    texto.append(content);

                }




            }

            @Override
            public void onFailure(Call<List<posts>> call, Throwable t) {
                texto.setText(t.getMessage());


            }
        });


    }
}
