package com.example.safehouse.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.safehouse.R;
import com.example.safehouse.fragments.PrincipalFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SenhaAlarmeActivity extends AppCompatActivity
{
    private EditText txtSenhaAlarme;
    private FirebaseUser usuarioAtual;
    private final static String endWebService = "http://192.168.0.128/webService-Fatec/insertSenha.php";
    private SharedPreferences sPreferences = null;
    private String getNomeLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha_alarme);

        usuarioAtual = FirebaseAuth.getInstance().getCurrentUser();
        if(usuarioAtual != null)
        {
            getNomeLogado = usuarioAtual.getDisplayName();
        }

        txtSenhaAlarme = findViewById(R.id.editTextSenhaAlarme);

        txtSenhaAlarme.setEnabled(false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        verificarSenha();
    }

    public void verificarSenha()
    {
        String url = "http://172.20.42.171/webService-Fatec/pegarSenha.php";
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url , new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Log.d("valorPHP", "Dado: "+response);

                try
                {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("dados");
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject senhaJsonObj = jsonArray.getJSONObject(i);
                        String senhaAlarme = senhaJsonObj.getString("senha");
                        String getSenha = senhaAlarme;

                        txtSenhaAlarme.setText(getSenha);

                        txtSenhaAlarme.setEnabled(true);
                    }
                }
                catch (JSONException e)
                {
                    avisoSenha();
                }
            }

        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(getApplicationContext(), "Erro no JSON: "+error, Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(stringRequest);
    }

    public void avisoSenha()
    {
        String getNomeLogado = usuarioAtual.getDisplayName();

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Aviso");
        dialog.setMessage(Html.fromHtml("<medium><font color =\"#01C7D2\">Caro "+getNomeLogado+
                "<small><p align=left><center>O alarme da sua casa encontra-se sem senha.<br>" +
                "Defina uma senha para poder ativá-lo<br>" +
                " e manter sua casa em segurança.</center></small></p>"));
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                txtSenhaAlarme.setEnabled(true);
            }
        });
        dialog.setCancelable(false);
        dialog.create();
        dialog.show();
    }

    public void salvarSenha (View view)
    {
        if(txtSenhaAlarme.getText().length() <6)
        {
            Toast.makeText(getApplicationContext(), "A senha precisa conter 6 dígitos",Toast.LENGTH_LONG).show();
        }
        else
        {
            insertDadosSQL(endWebService);
        }
    }

    private void insertDadosSQL (String URL)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Log.d("getWebService", "Conectou no web service");
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("getErrorWebService", error.getMessage());
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> parametros = new HashMap<String, String>();
                FirebaseUser usuarioAtual = FirebaseAuth.getInstance().getCurrentUser();
                if(usuarioAtual != null)
                {
                    parametros.put("senha_Android", txtSenhaAlarme.getText().toString());

                    Log.d("valor", txtSenhaAlarme.getText().toString());
                }
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        abrirFragment();
    }

    public void abrirFragment()
    {
        Toast.makeText(getApplicationContext(), "Senha criada com sucesso.", Toast.LENGTH_LONG).show();
        finish();
    }
}
