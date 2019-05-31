package com.example.safehouse.models;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.safehouse.R;
import com.example.safehouse.fragments.PerfilFragment;

public class BottomSheetDialogEditNome extends BottomSheetDialogFragment
{
    private TextView salvarAlteracao, cancelarAlteraca;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
       View view = inflater.inflate(R.layout.activity_editar_nome, container, false);

        salvarAlteracao = view.findViewById(R.id.textViewSalvarNomeEditado);


        salvarAlteracao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                atualizarNome();
            }
        });

       return view;
    }

    public void atualizarNome()
    {
        dismiss();

        restartFragment();
    }

    private void restartFragment()
    {
        PerfilFragment perfilFragment = new PerfilFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer,perfilFragment);
        fragmentTransaction.commit();
    }

}
