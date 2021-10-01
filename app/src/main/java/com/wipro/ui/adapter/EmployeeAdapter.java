package com.wipro.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.wipro.R;
import com.wipro.model.Employee;
import com.wipro.ui.viewholder.EmployeeViewHolder;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
    private final List<Employee> employeeList;

    public EmployeeAdapter() {
        employeeList = new ArrayList<>();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmployeeViewHolder(
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_employee, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
       holder.bind(employeeList.get(position));
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public void setEmployeeList(List<Employee> list) {
        employeeList.clear();
        employeeList.addAll(list);
        notifyDataSetChanged();
    }
}
