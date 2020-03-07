package com.example.tasknumone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {
private EditText recivePhone;
public TextView reciveData ;
private Button getDAta ;
private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        Intent intent = getIntent();
        String  message = intent.getStringExtra(MainActivity.MSG);
        recivePhone = (EditText)findViewById(R.id.phoneNumber);
        reciveData = (TextView) findViewById(R.id.data) ;
        getDAta=(Button)findViewById(R.id.getData);

        recivePhone.setText(message);

        mQueue= Volley.newRequestQueue(this);

    }
        public void btnclick(View view) {

            jsonParse();
        }

        private  void  jsonParse(){
        String url="https://jsonplaceholder.typicode.com/todos";
            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                         try {
//                             JSONArray JSON = new JSONArray(response);
//                             JSONArray jsonArray = (JSONArray) response.getJSONArray("");
                             for (int i = 0 ; i < response.length();i++){
                                 JSONObject data = response.getJSONObject(i);
                                 int userId = data.getInt("userId");
                                 int id = data.getInt("id");
                                 String title = data.getString("title");
                                 String completed = data.getString("completed");
                                // Toast.makeText(this,"ok"+title).show();
                                 Log.d(String.valueOf(userId),String.valueOf(id));
                                 reciveData.append(String.valueOf(userId)+", "+String.valueOf(id)+", "+title +
                                         ",   "+
                                         completed+"\n\n");

                             }
                         }catch (JSONException e){
                             e.printStackTrace();
                         }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                      error.printStackTrace();
                }
            });
            mQueue.add(request);
        }

}
