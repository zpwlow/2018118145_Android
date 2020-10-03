package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.FragmentManager;


@SuppressLint("ValidFragment")
class InputDialogFragment extends DialogFragment {

    private EditText mUsername;

    public interface LoginInputListener
    {
        void onLoginInputComplete(String toString);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_input, null);
        mUsername = (EditText) view.findViewById(R.id.id_txt_username);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("确定",
                                   new DialogInterface.OnClickListener()
                                   {
                                       @Override
                                       public void onClick(DialogInterface dialog, int id)
                                       {
                                           LoginInputListener listener = (LoginInputListener) getActivity();
                                           listener.onLoginInputComplete(mUsername.getText().toString());
                                       }
                                   }).setNegativeButton("取消", null);

        return builder.create();
    }


}
