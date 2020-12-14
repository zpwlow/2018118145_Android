package com.example.stickynotes.ui.editnote;

import androidx.lifecycle.ViewModel;

import com.example.stickynotes.model.Note;
import com.example.stickynotes.model.NoteBook;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EditNoteViewModel extends ViewModel {
    List<String> list;
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

    public void saveNote(String toString, String toString1) {
        Calendar calendar = Calendar.getInstance();
         //获取系统的日期
         //年
        int year = calendar.get(Calendar.YEAR);
         //月
        int month = calendar.get(Calendar.MONTH)+1;
        //日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String time = Integer.toString(year) + '.' + month + '.' + day;
        Note note = new Note();
        note.setNotename(toString1);
        note.setContent(toString);
        note.setWritetime(time);
        note.save();

    }

    public void updateNote(String string, String toString, int noteid) {
        Calendar calendar = Calendar.getInstance();
        //获取系统的日期
        //年
        int year = calendar.get(Calendar.YEAR);
        //月
        int month = calendar.get(Calendar.MONTH)+1;
        //日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String time = Integer.toString(year) + '.' + month + '.' + day;
        DataSupport.delete(Note.class,noteid);

        Note note = new Note();
        note.setContent(string);
        note.setNotename(toString);
        note.setWritetime(time);
        note.save();

    }
    // TODO: Implement the ViewModel
}
