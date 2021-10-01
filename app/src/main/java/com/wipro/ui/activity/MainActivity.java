package com.wipro.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.wipro.R;
import com.wipro.databinding.ActivityMainBinding;
import com.wipro.ui.adapter.EmployeeAdapter;
import com.wipro.viewmodel.EmployeeViewModel;

public class MainActivity extends AppCompatActivity {
    private EmployeeViewModel employeeViewModel;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        employeeViewModel = new EmployeeViewModel(getApplication());
        setAdapter(binding);
        parseEmployeeData();
    }

    private void parseEmployeeData() {
        binding.progressBar.setVisibility(View.VISIBLE);
        new Thread(() -> employeeViewModel.fetchEmployeeData()).start();
    }

    private void setAdapter(ActivityMainBinding binding) {
        EmployeeAdapter employeeAdapter = new EmployeeAdapter();
        binding.rvEmployee.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.rvEmployee.setAdapter(employeeAdapter);
        employeeViewModel.getEmployeeData().observe(this, employeeData -> {
            if(employeeData!=null) {
                employeeAdapter.setEmployeeList(employeeData.getEmployeeList());
            }
            binding.progressBar.setVisibility(View.GONE);
        });
    }
}