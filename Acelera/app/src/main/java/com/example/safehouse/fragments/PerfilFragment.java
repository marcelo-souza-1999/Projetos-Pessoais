package com.example.safehouse.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.safehouse.R;
import com.example.safehouse.models.BottomSheetDialogEditNome;

public class PerfilFragment extends Fragment
{
    private TextView editarNome, editarEmail;

    public PerfilFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_perfil, container, false);

        editarNome = view.findViewById(R.id.textViewEditarNome);
        editarEmail = view.findViewById(R.id.textViewEditarEmail);

        editarNome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                BottomSheetDialogEditNome bottomSheetDialogEditNome = new BottomSheetDialogEditNome();
                bottomSheetDialogEditNome.show(getFragmentManager(), null);
            }
        });

        return view;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d("resultado", "Teste");
    }
}
