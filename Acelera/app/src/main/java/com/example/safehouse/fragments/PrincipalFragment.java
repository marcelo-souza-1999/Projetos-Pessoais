package com.example.safehouse.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.safehouse.R;

import com.example.safehouse.activitys.SenhaAlarmeActivity;
import com.example.safehouse.models.BottomSheetDialogSenhaAlarme;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class PrincipalFragment extends Fragment
{
    private TextView sessaoUser, resultado, nomeCasa, textTitulo;
    private Button ativarAlarme, abrirGaragem;
    private FirebaseUser usuarioAtual;
    private SharedPreferences sPreferences = null;

    public PrincipalFragment()
    {

    }

    @Override
    public void onResume()
    {
        super.onResume();

        if (sPreferences.getBoolean("firstRun", true))
        {
            sPreferences.edit().putBoolean("firstRun", false).apply();
            verificarUser();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_principal, container, false);

        sessaoUser = view.findViewById(R.id.textViewUsuario);

        resultado = view.findViewById(R.id.textViewAtivado);

        nomeCasa = view.findViewById(R.id.textViewNomeCasa);

        ativarAlarme = view.findViewById(R.id.buttonAtivarAlarme);

        abrirGaragem = view.findViewById(R.id.buttonAbrirGaragem);

        textTitulo = view.findViewById(R.id.textViewTituloConfiguracoes);

        usuarioAtual = FirebaseAuth.getInstance().getCurrentUser();
        if(usuarioAtual != null)
        {
            sessaoUser.setText("  Usuário logado: "+usuarioAtual.getDisplayName());
        }

        buscarDadosSQL();

        sPreferences = this.getActivity().getSharedPreferences("first run",MODE_PRIVATE);

        textTitulo.setText(Html.fromHtml("<u>SAFE HOUSE<br><center>SUA CASA EM SEGURANÇA</u></center>"));

        ativarAlarme.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               ativarAlarme();
            }
        });

        /*ativado.setTextColor(Color.GREEN);
        desativado.setTextColor(Color.RED);*/

        return view;
    }

    public void verificarBD()
    {

    }

    public void buscarDadosSQL()
    {
        String url = "http://192.168.15.15/webService-Fatec/pegarDados.php?nome="+usuarioAtual.getDisplayName();
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url , new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                 try
                {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("dados");
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject alarmeJsonObj = jsonArray.getJSONObject(i);
                        String alarmeNomeCasa = alarmeJsonObj.getString("alarmeNomeCasa");
                        nomeCasa.setText(nomeCasa.getText()+"  "+alarmeNomeCasa);
                    }
                }
                catch (JSONException e)
                {
                    Toast.makeText(getContext(), "Erro ao recuperar dados do JSON: "+e, Toast.LENGTH_LONG).show();
                }
            }

        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(getContext(), "Erro no JSON: "+error, Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> dado = new HashMap<>();
                dado.put("nome", sessaoUser.getText().toString());

                return dado;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void ativarAlarme()
    {
        BottomSheetDialogSenhaAlarme bottomSheetDialogSenhaAlarme = new BottomSheetDialogSenhaAlarme();
        bottomSheetDialogSenhaAlarme.show(getFragmentManager(), "Ativar Alarme");
    }

    public void verificarUser()
    {
        String getNomeLogado = usuarioAtual.getDisplayName();

        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());

        dialog.setMessage(Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<medium><font color =\"#01C7D2\">Olá "+getNomeLogado+
                ", seja bem vindo!</font>" +
                "<small><p align=left><center>Você cadastrou sua residência no aplicativo, agora você é o administrador." +
                " Primeiro você deverá criar uma senha para o alarme e poderá alterá-la caso desejar."+
                " Além disso, ainda poderá adicionar outros usuários ou torná-los administradores.<br><br>" +
                "Agradecemos por usar nosso aplicativo.</center></small></p>"));
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent intent = new Intent(getContext(), SenhaAlarmeActivity.class);
                startActivity(intent);
            }
        });
        dialog.setCancelable(false);
        dialog.create();
        dialog.show();
    }

}
