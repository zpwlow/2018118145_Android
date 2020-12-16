package com.example.stickynotes.ui.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stickynotes.R;
import com.example.stickynotes.model.Note;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    List<Note> noteList;

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    MutableLiveData<List<Note>> mutableLiveData;

    public NoteAdapter(List<Note> noteList,
                       MutableLiveData<List<Note>> mutableLiveData,
                       Context context) {
        this.noteList = noteList;
        this.mutableLiveData = mutableLiveData;
        this.context = context;
    }

    Context context;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note2,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //noteList.size()-1-position 将recyclerView 的列表倒置显示.
        // 最新更新的显示在前面。
        String text = noteList.get(noteList.size()-1-position).getContent();
        int start = (int) getLineMaxNumber(text,20,170);
        int end = text.length();
        if (end>start) {
            TextPaint tp = holder.textView1.getPaint();
            tp.setFakeBoldText(true);
            String line = text.substring(0,start);
            holder.textView1.setText(line);
            String text1 = text.substring(start,end);
            holder.textView.setText(text1);
        }
        else {
            holder.textView1.setText(text);
            holder.textView.setText("");
        }
        //holder.textView.setText(noteList.get(position).getContent());
        holder.textView2.setText(noteList.get(noteList.size()-1-position).getWritetime());

        //设置长按删除事件
        holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final AlertDialog dialog = builder.create();
                //设置对话框布局
                View dialogView = View.inflate(context, R.layout.delete_note, null);
                dialog.setView(dialogView);
                dialog.show();

                //设置删除
                dialogView.findViewById(R.id.cancleDelete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialogView.findViewById(R.id.sureDelete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DataSupport.delete(Note.class,noteList.get(noteList.size()-1-position).getId());
                        noteList.remove(noteList.size()-1-position);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });

                return true;
            }
        });

        //设置修改
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                Bundle bundle = new Bundle();
                bundle.putInt("Noteid",noteList.get(noteList.size()-1-position).getId());
                navController.navigate(R.id.action_note_to_editNote,bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(noteList==null){
            noteList = new ArrayList<>();
        }
        return noteList.size();
    }

    private float getLineMaxNumber(String text, float size,float maxWidth) {
        if (null == text || "".equals(text)){
            return 0;
        }
        Paint paint = new Paint();
        paint.setTextSize(size);
        //得到文本内容总体长度
        float textWidth = paint.measureText(text);
        // textWidth
        float width = textWidth / text.length();
        float total = maxWidth / width;
        return total;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView1;
        TextView textView2;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView11);
            textView2 = itemView.findViewById(R.id.timetext);
            textView1 = itemView.findViewById(R.id.heardtext);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
