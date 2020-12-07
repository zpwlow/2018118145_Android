package com.example.stickynotes.ui.note;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.stickynotes.model.Note;
import com.example.stickynotes.model.NoteBook;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class NoteViewModel extends ViewModel {
    List<String> list;
    MutableLiveData<String> chooseBook;
    public MutableLiveData<List<Note>> notelist ;

    public NoteViewModel() {
        if(notelist==null){
            notelist = new MutableLiveData<>();
            notelist.postValue(DataSupport.where("notename=?",
                    "english").find(Note.class));
        }
        if(chooseBook ==null){
            chooseBook = new MutableLiveData<>();
            chooseBook.postValue("english");
        }

    }

    public MutableLiveData<List<Note>> getNotelist() {
        if(notelist==null){
            notelist = new MutableLiveData<>();
            notelist.postValue(DataSupport.where("notename=?",
                    "english").find(Note.class));
        }

        return notelist;
    }

    public void setNotelist(MutableLiveData<List<Note>> notelist) {
        this.notelist = notelist;
    }

    public List<String> getNoteBook() {
        if(list==null){
            list = new ArrayList<String>();
        }
        list.clear();
        List<NoteBook> noteBooks = DataSupport.findAll(NoteBook.class);
        for(NoteBook noteBook:noteBooks){
            list.add(noteBook.getNotename());
        }
        return list;
    }

    public void iniNote() {
        notelist.postValue(DataSupport.where("notename=?",
                "english").find(Note.class));
    }

    public void updateNote(String toString) {
        notelist.postValue(DataSupport.where("notename=?",
                toString).find(Note.class));
    }

    public MutableLiveData<String> getChooseBook() {
        return chooseBook;
    }
}

