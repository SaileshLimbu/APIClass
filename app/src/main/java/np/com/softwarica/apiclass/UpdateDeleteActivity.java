package np.com.softwarica.apiclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class UpdateDeleteActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etId, etName, etAge, etSalary;
    private Button btnSearch, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        etId = findViewById(R.id.etEmployeeID);
        etName = findViewById(R.id.etEmployeeName);
        etAge = findViewById(R.id.etEmployeeAge);
        etSalary = findViewById(R.id.etEmployeeSalary);
        btnSearch = findViewById(R.id.btnSearch);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        btnSearch.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = Integer.parseInt(etId.getText().toString());
        switch (v.getId()) {
            case R.id.btnSearch:
                MyRetrofit.getService().getEmployeeById(id).enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        Employee employee = response.body();
                        etName.setText(employee.getEmployee_name());
                        etAge.setText(employee.getEmployee_age() + "");
                        etSalary.setText(employee.getEmployee_salary() + "");
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        Toast.makeText(UpdateDeleteActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btnUpdate:
                String name = etName.getText().toString();
                String salary = etSalary.getText().toString();
                String age = etAge.getText().toString();
                MyRetrofit.getService().updateEmployee(id, new EmployeeCUD(name, salary, age)).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(UpdateDeleteActivity.this, "Employee Updated.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(UpdateDeleteActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btnDelete:
                MyRetrofit.getService().deleteEmployee(id).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(UpdateDeleteActivity.this, "Employee Deleted...", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(UpdateDeleteActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }
}
