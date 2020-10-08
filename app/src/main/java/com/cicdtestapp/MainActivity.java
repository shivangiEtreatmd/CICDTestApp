package com.cicdtestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.cicdtestapp.Adapters.EmployeesAdapter;
import com.cicdtestapp.databinding.ActivityMainBinding;
import com.cicdtestapp.models.Employees;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EmployeesAdapter employeesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.rvList.setLayoutManager(new LinearLayoutManager(this));
        employeesAdapter = new EmployeesAdapter();
        binding.rvList.setAdapter(employeesAdapter);
        setData();
    }

    private void setData() {
        List<Employees> employeesList = new ArrayList<>();

        Employees emp1 = new Employees("ABC", "West vancouver", 45464);
        Employees emp2 = new Employees("XYZ", "East vancouver", 879664);
        Employees emp3 = new Employees("PQR", "North vancouver", 567949);
        Employees emp4 = new Employees("MNO", "South vancouver", 989894);

        employeesList.add(emp1);
        employeesList.add(emp2);
        employeesList.add(emp3);
        employeesList.add(emp4);

        employeesAdapter.updateData(employeesList);

    }

}