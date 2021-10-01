package com.wipro.viewmodel;

import android.app.Application;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.wipro.model.EmployeeData;
import com.wipro.util.JsonParser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.times;

@PrepareForTest(JsonParser.class)
@RunWith(PowerMockRunner.class)
public class EmployeeViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();
    private EmployeeViewModel viewModel;
    @Mock
    Application application;

    @Mock
    EmployeeData employeeData;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        viewModel = new EmployeeViewModel(application);
    }

    @Test
    public void fetchEmployeeData() {
        PowerMockito.mockStatic(JsonParser.class);
        Mockito.when(JsonParser.getAssetJsonData(application,"EmployeeData.json", EmployeeData.class)).thenReturn(employeeData);
        viewModel.fetchEmployeeData();
        Assert.assertEquals(employeeData,viewModel.getEmployeeData().getValue());
    }
}
