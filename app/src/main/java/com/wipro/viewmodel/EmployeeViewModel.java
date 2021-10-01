package com.wipro.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.wipro.model.EmployeeData;
import com.wipro.util.JsonParser;

public class EmployeeViewModel extends AndroidViewModel {
    private final MutableLiveData<EmployeeData> employeeData;
    public EmployeeViewModel(Application application) {
        super(application);
        employeeData = new MutableLiveData<>();
    }

    public MutableLiveData<EmployeeData> getEmployeeData() {
        return employeeData;
    }

    public void setEmployeeData(EmployeeData employees) {
        employeeData.postValue(employees);
    }

    public void fetchEmployeeData() {
        if(employeeData.getValue()==null) {
            setEmployeeData(JsonParser.getAssetJsonData(getApplication(), "EmployeeData.json", EmployeeData.class));
        }
    }
}
