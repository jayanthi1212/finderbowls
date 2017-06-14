package com.ench.jaya.example1212;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static java.util.logging.Logger.global;


public class MainActivity extends AppCompatActivity {

    String Sname,Spass;
    EditText ed1,ed2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText ed1 = (EditText) findViewById(R.id.editText);
        final EditText ed2 = (EditText) findViewById(R.id.editText2);
        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent int112 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(int112);
                Sname = ed1.getText().toString();
                Spass = ed2.getText().toString();
                insertme(Sname, Spass);
            }
        });


    }
    public void insertme(final String Sname , final String Spass ){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Global.login, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean abc = jObj.getBoolean("exits");
                    if (abc)
                    {
                        JSONObject users = jObj.getJSONObject("users");
                        String jjname = users.getString("name");
                        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                        intent.putExtra("use",jjname);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),jjname,Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Server Busy",Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }}
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }){
            @Override
            protected Map<String ,String> getParams() throws AuthFailureError {

                Map<String,String> insert=new HashMap<String, String>();
                insert.put("username",Sname);
                insert.put("password",Spass);


                return insert;

            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);

    }


}



