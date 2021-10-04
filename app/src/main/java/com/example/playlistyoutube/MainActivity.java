package com.example.playlistyoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String Api_key="AIzaSyB7hA1R7YLrHQERL1J2IAtCbWijLvovrQA";
    String ID_playlist="PLgIqj6EWVN2-Pdn_2VfLCcK5lW4b5NpTq";
    //&maxResults=50
    String get_Json_url="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLgIqj6EWVN2-Pdn_2VfLCcK5lW4b5NpTq&key=AIzaSyB7hA1R7YLrHQERL1J2IAtCbWijLvovrQA&maxResults=50";
    ListView lvMovies;
    ArrayList<MovieYoutube> arrayListMovies;
    MovieYoutubeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMovies=findViewById(R.id.lv_Movie);
        arrayListMovies=new ArrayList<>();
        adapter= new MovieYoutubeAdapter(this,R.layout.item_movie_youtube,arrayListMovies);
        lvMovies.setAdapter(adapter);

        getJson(get_Json_url);
    }
    private void getJson(String Url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, Url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonItems =response.getJSONArray("items");
                            String title="";
                            String url="";
                            String idvieo="";
                            String description="";
                            for (int i=0;i<jsonItems.length();i++) {
                                JSONObject jsonItem = jsonItems.getJSONObject(i);
                                JSONObject jsonsnippet = jsonItem.getJSONObject("snippet");
                                title = jsonsnippet.getString("title");

                                JSONObject jsonThumbnails = jsonsnippet.getJSONObject("thumbnails");
                                JSONObject jsonMedium = jsonThumbnails.getJSONObject("medium");
                                url = jsonMedium.getString("url");
                                JSONObject jsonResouceId = jsonsnippet.getJSONObject("resourceId");
                                idvieo = jsonResouceId.getString("videoId");
                                description = jsonsnippet.getString("description");
                                Toast.makeText(MainActivity.this, description, Toast.LENGTH_SHORT).show();

                                arrayListMovies.add(new MovieYoutube(title,url,idvieo));
                            }
                            adapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        //Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Loi", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }
}