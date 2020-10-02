package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<CarLogo> carLogoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCarLogo(); //初始化汽车标志
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CarLogoAdapter adapter = new CarLogoAdapter(carLogoList);
        recyclerView.setAdapter(adapter);
    }

    private void initCarLogo(){
        for(int i=0;i<2;i++){
            CarLogo aodi = new CarLogo("奥迪",R.drawable.aodi_pic);
            carLogoList.add(aodi);
            CarLogo baoma = new CarLogo("宝马",R.drawable.baoma_pic);
            carLogoList.add(baoma);
            CarLogo baoshijie = new CarLogo("保时捷",R.drawable.baoshijie_pic);
            carLogoList.add(baoshijie);
            CarLogo benchi = new CarLogo("奔驰",R.drawable.benchi_pic);
            carLogoList.add(benchi);
            CarLogo binli = new CarLogo("宾利",R.drawable.binli_pic);
            carLogoList.add(binli);
            CarLogo falali = new CarLogo("法拉利",R.drawable.falali_pic);
            carLogoList.add(falali);
            CarLogo fute = new CarLogo("福特",R.drawable.fute_pic);
            carLogoList.add(fute);
            CarLogo kaidilake = new CarLogo("凯迪拉克",R.drawable.kaidilake_pic);
            carLogoList.add(kaidilake);
            CarLogo lanbojini = new CarLogo("兰博基尼",R.drawable.lanbojini_pic);
            carLogoList.add(lanbojini);
            CarLogo leikesasi = new CarLogo("雷克萨斯",R.drawable.leikesasi_pic);
            carLogoList.add(leikesasi);
            CarLogo luhu = new CarLogo("路虎",R.drawable.luhu_pic);
            carLogoList.add(luhu);
            CarLogo mashaladi = new CarLogo("玛莎拉蒂",R.drawable.mashaladi_pic);
            carLogoList.add(mashaladi);
        }
    }
}