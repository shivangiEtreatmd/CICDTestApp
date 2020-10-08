package com.cicdtestapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cicdtestapp.R;
import com.cicdtestapp.databinding.EmployeesListBinding;
import com.cicdtestapp.models.Employees;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.EmployeesHolder> {

    private List<Employees> list = new ArrayList<>();

    public void updateData(List<Employees> employeesList) {
        this.list.clear();
        this.list.addAll(employeesList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employees_list, parent, false);

        return new EmployeesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeesHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EmployeesHolder extends RecyclerView.ViewHolder {
        private EmployeesListBinding viewBinding;

        public EmployeesHolder(@NonNull View itemView) {
            super(itemView);
            viewBinding = EmployeesListBinding.bind(itemView);
        }

        public void bind(Employees employees) {
            viewBinding.tvName.setText(employees.getName());
            viewBinding.tvAddress.setText(employees.getAddress());
            viewBinding.tvContactNo.setText(employees.getContactNo());
        }
    }
}
