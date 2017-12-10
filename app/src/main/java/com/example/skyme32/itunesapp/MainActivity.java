package com.example.skyme32.itunesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;



public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    public String stringJSON = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        methodRequest("https://itunes.apple.com/search?term=michael+jackson");
    }

    public void methodRequest(String url) {
        // Creates the Volley request queue
        RequestQueue mRequestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Activity, RESPONSE: ##",response.toString());
                        //Aqui añades el adpter, el listview, etc --> solo muestro por log el string que devuelve, yo haria una clase que fuese parsear el objeto musica, etc.

                        TextView txt = (TextView) findViewById(R.id.editText1);
                        txt.setText(response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.e("Actividad JSON","Error, no se ha podido conectar a la URL indicada");
                    }
                });

        // Adds the JSON object request "obreq" to the request queue
        mRequestQueue.add(jsObjRequest);
    }



}
