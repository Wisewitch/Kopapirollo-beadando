package com.kopapirollo_beadando;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnKo, btnPapir, btnOllo;
    private ImageView iv_en, iv_gep, imageHp6, imageHp5, imageHp4, imageHp3, imageHp2, imageHp1;
    private TextView tv_gep, tv_en, tv_res, tv_dont;
    private int en_elet, gep_elet, dontetlen;
    private String EnValasztom, GepValaszt, Dontetlen, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnValasztom = "Kő";
                iv_en.setImageResource(R.drawable.rock);
                GepRandom();
                Calculate();;
            }
        });

        btnPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnValasztom = "Papír";
                iv_en.setImageResource(R.drawable.paper);
                GepRandom();
                Calculate();
            }
        });

        btnOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnValasztom = "Olló";
                iv_en.setImageResource(R.drawable.scissors);
                GepRandom();
                Calculate();
            }
        });
    }


    private void GepRandom() {
        Random rand = new Random();
        int gep = rand.nextInt(3);

        if (gep == 0) {
            GepValaszt = "Kő";
            iv_gep.setImageResource(R.drawable.rock);
        }

        else if (gep == 1) {
            GepValaszt = "Papír";
            iv_gep.setImageResource(R.drawable.paper);
        }

        else if (gep == 2) {
            GepValaszt = "Olló";
            iv_gep.setImageResource(R.drawable.scissors);
        }
    }







    public void Calculate() {

        if (EnValasztom.equals("Kő") && GepValaszt.equals("Papir")) {
            result = "Vesztettél!!";
           // EnEletLevon(en_elet);
            en_elet--;
        }

        else if (EnValasztom.equals("Kő") && GepValaszt.equals("Olló")) {
            result = "Nyertél!!";
           // GepEletLevon(gep_elet);
            gep_elet--;
        }

        else if (EnValasztom.equals("Papír") && GepValaszt.equals("Kő")) {
            result = "Nyertél!!";
         //   GepEletLevon(gep_elet);
            gep_elet--;
        }

        else if (EnValasztom.equals("Papír") && GepValaszt.equals("Olló")) {
            result = "Vesztettél!!";
            //EnEletLevon(en_elet);
            en_elet--;
        }

        else if (EnValasztom.equals("Olló") && GepValaszt.equals("Papír")) {
            result = "Nyertél!!";
          //  GepEletLevon(gep_elet);
            gep_elet--;
        }

        else if (EnValasztom.equals("Olló") && GepValaszt.equals("Kő")) {
            result = "Vesztettél!!";
          //  EnEletLevon(en_elet);
            en_elet--;
        }

        else if (EnValasztom.equals("Olló") && GepValaszt.equals("Olló")) {
            dontetlen++;
            result = "Döntetlen! Próbáld újra!";
        }

        else if (EnValasztom.equals("Papír") && GepValaszt.equals("Papír")) {
            dontetlen++;
            result = "Döntetlen! Próbáld újra!";
        }

        else if (EnValasztom.equals("Kő") && GepValaszt.equals("Kő")) {
            dontetlen++;
            result = "Döntetlen! Próbáld újra!";
        }

        tv_res.setText("Döntetlenek száma: " + dontetlen);

        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

       // Vege();
    }







    private void init() {
        iv_gep = (ImageView) findViewById(R.id.iv_gep);
        iv_en = (ImageView) findViewById(R.id.iv_en);

        tv_gep = (TextView) findViewById(R.id.tv_gep);
        tv_en = (TextView) findViewById(R.id.tv_en);

        btnKo = (Button) findViewById(R.id.btnKo);
        btnPapir = (Button) findViewById(R.id.btnPapir);
        btnOllo = (Button) findViewById(R.id.btnOllo);

        imageHp1 = findViewById(R.id.image_hp1);
        imageHp2 = findViewById(R.id.image_hp2);
        imageHp3 = findViewById(R.id.image_hp3);

        imageHp4 = findViewById(R.id.image_hp4);
        imageHp5 = findViewById(R.id.image_hp5);
        imageHp6 = findViewById(R.id.image_hp6);

        tv_res = findViewById(R.id.tv_res);

        en_elet = 3;
        gep_elet = 3;
        dontetlen = 0;
    }
}