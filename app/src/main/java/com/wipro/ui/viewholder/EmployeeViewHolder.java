package com.wipro.ui.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.wipro.databinding.ItemEmployeeBinding;
import com.wipro.model.Employee;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private final ItemEmployeeBinding binding;

    public EmployeeViewHolder(@NonNull ItemEmployeeBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }
    public void bind(Employee employee) {
        binding.setVariable(BR.model, employee);
        binding.executePendingBindings();
    }
}
