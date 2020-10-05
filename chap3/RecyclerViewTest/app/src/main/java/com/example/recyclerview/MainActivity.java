package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class MainActivity extends AppCompatActivity{

    private List<CarLogo> carLogoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCarLogo(); //初始化汽车标志
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        CarLogoAdapter adapter = new CarLogoAdapter(carLogoList);
        recyclerView.setAdapter(adapter);
    }



    private void initCarLogo(){
        for(int i=0;i<2;i++){
            //CarLogo aodi = new CarLogo("奥迪",R.drawable.aodi_pic);
            CarLogo aodi = new CarLogo(getRandomLengthName("奥迪 "),R.drawable.aodi_pic);
            carLogoList.add(aodi);
            //CarLogo baoma = new CarLogo("宝马",R.drawable.baoma_pic);
            CarLogo baoma = new CarLogo(getRandomLengthName("宝马 "),R.drawable.baoma_pic);
            carLogoList.add(baoma);
            //CarLogo baoshijie = new CarLogo("保时捷",R.drawable.baoshijie_pic);
            CarLogo baoshijie = new CarLogo(getRandomLengthName("保时捷 "),R.drawable.baoshijie_pic);
            carLogoList.add(baoshijie);
            //CarLogo benchi = new CarLogo("奔驰",R.drawable.benchi_pic);
            CarLogo benchi = new CarLogo(getRandomLengthName("奔驰 "),R.drawable.benchi_pic);
            carLogoList.add(benchi);
            //CarLogo binli = new CarLogo("宾利",R.drawable.binli_pic);
            CarLogo binli = new CarLogo(getRandomLengthName("宾利 "),R.drawable.binli_pic);
            carLogoList.add(binli);
            //CarLogo falali = new CarLogo("法拉利",R.drawable.falali_pic);
            CarLogo falali = new CarLogo(getRandomLengthName("法拉利 "),R.drawable.falali_pic);
            carLogoList.add(falali);
            //CarLogo fute = new CarLogo("福特",R.drawable.fute_pic);
            CarLogo fute = new CarLogo(getRandomLengthName("福特 "),R.drawable.fute_pic);
            carLogoList.add(fute);
            CarLogo kaidilake = new CarLogo(getRandomLengthName("凯迪拉克 "),R.drawable.kaidilake_pic);
            carLogoList.add(kaidilake);
            CarLogo lanbojini = new CarLogo(getRandomLengthName("兰博基尼 "),R.drawable.lanbojini_pic);
            carLogoList.add(lanbojini);
            CarLogo leikesasi = new CarLogo(getRandomLengthName("雷克萨斯 "),R.drawable.leikesasi_pic);
            carLogoList.add(leikesasi);
            CarLogo luhu = new CarLogo(getRandomLengthName("路虎 "),R.drawable.luhu_pic);
            carLogoList.add(luhu);
            CarLogo mashaladi = new CarLogo(getRandomLengthName("玛莎拉蒂 "),R.drawable.mashaladi_pic);
            carLogoList.add(mashaladi);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }


    public void showEditDialog(View view)
    {
        InputDialogFragment editNameDialog = new InputDialogFragment();
        editNameDialog.show(getFragmentManager(), "EditNameDialog");
    }

    public void showDialog(final View view){
        final EditText mUsername;
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        View input_view = inflater.inflate(R.layout.dialog_input,null);
        mUsername = (EditText) input_view.findViewById(R.id.id_txt_username);
        builder.setView(input_view)
                // Add action buttons
                .setPositiveButton("确定",
                        new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int id)
                            {
                                String text = mUsername.getText().toString();
                                final CarLogoAdapter.ViewHolder holder =
                                        new CarLogoAdapter.ViewHolder(view);
                                holder.logoName.setText(text);
                            }
                        }).setNegativeButton("取消", null);
        builder.show();
        /*
        final EditText inputServer = new EditText(MainActivity.this);
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("修改汽车LOGO名字").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String text = inputServer.getText().toString();
                final CarLogoAdapter.ViewHolder holder =
                        new CarLogoAdapter.ViewHolder(view);
                holder.logoName.setText(text);
            }

        });
        builder.show();


         */

        /*
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("这是一个弹窗");
        dialog.setCancelable(false);
        dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();  */
    }




}