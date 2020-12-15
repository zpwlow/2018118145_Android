package com.example.stickynotes.ui.editnote;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.stickynotes.R;
import com.example.stickynotes.model.Note;
import com.example.stickynotes.ui.note.NoteViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.litepal.crud.DataSupport;



public class EditNote extends Fragment {

    private ArrayAdapter<String> arrayAdapter;
    private EditText editText;
    private EditNoteViewModel mViewModel;
    private FloatingActionButton ediToNote;
    Spinner spinner;
    View view;
    NoteViewModel noteViewModel;


    public static EditNote newInstance() {
        return new EditNote();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_edit_note, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(EditNoteViewModel.class);
        noteViewModel = new ViewModelProvider(requireActivity()).get(NoteViewModel.class);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //设置下拉菜单
        spinner = view.findViewById(R.id.spinnerNote);
        arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item,
                mViewModel.getNoteBook());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelection(arrayAdapter.getPosition(noteViewModel.getChooseBook().getValue()),true);

        //发送Note到数据库
        editText = view.findViewById(R.id.editNote);
        ediToNote = view.findViewById(R.id.sendtoNote);
        //修改的数据
        if(getArguments()!=null){
            if(getArguments().containsKey("Noteid")){
                editText.setText(DataSupport.find(Note.class,getArguments().getInt("Noteid")).getContent());
                ediToNote.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavController navController = Navigation.findNavController(v);
                        navController.navigate(R.id.action_editNote_to_note);

                        //将下面的代码搬移到 onStop()函数
                        //mViewModel.updateNote(editText.getText().toString(),
                                //spinner.getSelectedItem().toString(),
                               // getArguments().getInt("Noteid"));
                    }
                });
            }
        }
        else {
            //新建的数据
            ediToNote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_editNote_to_note);

                    //将下面的代码搬移到 onStop()函数
                    //mViewModel.saveNote(editText.getText().toString(),
                            //spinner.getSelectedItem().toString());
                }
            });
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        // 编辑note后点击发送的按钮，关闭活动，导致保存数据，造成使用错误
        //原来的发送按钮里面的处理语句搬移到此处，解决上述问题
        if(getArguments()!=null) {
            if (getArguments().containsKey("Noteid")) {
                Note note = DataSupport.find(Note.class, getArguments().getInt("Noteid"));
                if (!editText.getText().toString().equals(note.getContent())) {
                    mViewModel.updateNote(editText.getText().toString(),
                            spinner.getSelectedItem().toString(),
                            getArguments().getInt("Noteid"));
                }
            }
        }
        else {
            if (editText.getText().toString().length()>0){
                mViewModel.saveNote(editText.getText().toString(),
                        spinner.getSelectedItem().toString());
            }
        }



    }

}
