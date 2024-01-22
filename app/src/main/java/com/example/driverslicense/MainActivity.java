package com.example.driverslicense;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.driverslicense.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.btnCalculator.setOnClickListener(view -> {

            String currentYear = binding.txtCurrentYear.getText().toString();
            String birthYear = binding.txtBirth.getText().toString();

            if(currentYear.isEmpty()){
                binding.txtCurrentYear.setError("Informe o ano atual corretamente!");
            } else if (birthYear.isEmpty()){
                binding.txtBirth.setError("Informe o seu ano de nascimento corretamente!");
            } else {
                licenseCalculator();
            }
        });

        binding.iconRefresh.setOnClickListener(view -> refreshData());

        }

        private void licenseCalculator(){

        int currentYear = Integer.parseInt(binding.txtCurrentYear.getText().toString());
        int birthYear = Integer.parseInt(binding.txtBirth.getText().toString());
        int age =  currentYear - birthYear;

        if(age < 18){
            binding.txtResult.setText("INAPTO\n Você não pode tirar a carteira de habilitação!");
        } else {
            binding.txtResult.setText("APTO\n Você pode tirar sua carteira de habilitação!");
        }

        }
         private void refreshData(){
            binding.txtBirth.setText("");
            binding.txtCurrentYear.setText("");
            binding.txtResult.setText("");
        }
    }


