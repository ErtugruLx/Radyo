package com.onurcicek.radyo.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.onurcicek.radyo.R;
import com.onurcicek.radyo.adapter.RadyoAdapter;
import com.onurcicek.radyo.app.AppController;
import com.onurcicek.radyo.model.Radyo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String url = "http://ertugrulkarakaya.com/soru/radyo.php";
    private RequestQueue requestQueue;
    private ProgressDialog pDialog;
    private List<Radyo> radyoItems = new ArrayList<Radyo>();
    private ListView listView;
    private RadyoAdapter adapter;

    public Array sorux;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView = (ListView) findViewById(R.id.list);
        adapter = new RadyoAdapter(this, radyoItems);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Radyolar Yükleniyor...");
        pDialog.show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
                pDialogGizle();
                try {
                    JSONArray radyolar = response.getJSONArray("radyolar");
                    for (int i = 0; i < radyolar.length(); i++) {
                        JSONObject radyo= radyolar.getJSONObject(i);
                        Radyo nesne = new Radyo();
                        nesne.setRadyoid(radyo.getString("radyoid"));
                        nesne.setRadyoismi(radyo.getString("radyoisim"));
                        nesne.setRadyourl(radyo.getString("radyourl"));
                        nesne.setRadyofotograf(radyo.getString("radyofotograf"));
                        radyoItems.add(nesne);
                    }
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                pDialogGizle();

            }
        });
        //requestQueue.add(jsonObjectRequest);
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long rowId) {
                Intent i = new Intent(getApplicationContext(), RadyoActivity.class);
                i.putExtra("radyoid", radyoItems.get(position).getRadyoid());
                i.putExtra("radyoisim", radyoItems.get(position).getRadyoismi());
                i.putExtra("radyourl", radyoItems.get(position).getRadyourl());
                i.putExtra("radyofotograf", radyoItems.get(position).getRadyofotograf());
                startActivity(i);
                finish();
            }
        });
    }


    private void pDialogGizle() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}
