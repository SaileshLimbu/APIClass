package np.com.softwarica.apiclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import np.com.softwarica.apiclass.API.MyRetrofit;
import np.com.softwarica.apiclass.models.Employee;
import np.com.softwarica.apiclass.models.EmployeeCUD;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEmployeeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText  etName, etSalary, etAge;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        etName = findViewById(R.id.etEmployeeName);
        etSalary = findViewById(R.id.etEmployeeSalary);
        etAge = findViewById(R.id.etEmployeeAge);
        btnAdd = findViewById(R.id.btnAddEmployee);

        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String salary = etSalary.getText().toString();
        String age = etAge.getText().toString();

        EmployeeCUD employee = new EmployeeCUD(name, salary, age);

        MyRetrofit.getService().addEmployee(employee).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()){
                    Toast.makeText(AddEmployeeActivity.this, "Employee Registered.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(AddEmployeeActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
