package com.example.practica3;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.practica3.databinding.ActivityMainBinding;
import com.example.practica3.databinding.ActivityResultBinding;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    public static final String WEIGHT_KEY = "peso";
    public static final String HEIGHT_KEY = "altura";
    public static final String IMC_KEY = "masacorporal";

    ActivityResultBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras = getIntent().getExtras();
        DecimalFormat df = new DecimalFormat("#.#");
        binding.setResultImc(df.format(extras.getDouble(IMC_KEY)));
        binding.setDataHeight(String.valueOf(extras.getDouble(HEIGHT_KEY)));
        binding.setDataWeight(String.valueOf(extras.getDouble(WEIGHT_KEY)));
        paintRow(extras.getDouble(IMC_KEY));

    }

    private void paintRow(double imc){
        double normal = 18.5, over = 25, obesity1 = 30, obesity2 = 35, obesity3 = 40;
        if(imc < normal){
            binding.rowUnderWeight.setBackgroundColor(getColor(R.color.blue));
        } else if (imc >= normal && imc < over) {
            binding.rowNormalWeight.setBackgroundColor(getColor(R.color.blue));
        }else if(imc >= over && imc < obesity1){
            binding.rowOverweight.setBackgroundColor(getColor(R.color.yellow));
        }else if(imc >= obesity1 && imc < obesity2){
            binding.rowObesity1.setBackgroundColor(getColor(R.color.orange));
        }else if(imc >= obesity2 && imc < obesity3){
            binding.rowObesity2.setBackgroundColor(getColor(R.color.red));
        }else{
            binding.rowObesity3.setBackgroundColor(getColor(R.color.pink));
        }
    }


}
