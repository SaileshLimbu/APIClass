package np.com.softwarica.apiclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import np.com.softwarica.apiclass.API.EmployeeAPI;
import np.com.softwarica.apiclass.API.MyRetrofit;
import np.com.softwarica.apiclass.models.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchEmployeeActivity extends AppCompatActivity implements View.OnClickListener {
    private Retrofit retrofit;
    private EditText etEmployeeID;
    private Button btnSearch;
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_employee);

        etEmployeeID = findViewById(R.id.etEmployeeID);
        tvOutput = findViewById(R.id.tvOutput);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(this);

        initRetrofit();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void onClick(View v) {
        int id = Integer.parseInt(etEmployeeID.getText().toString());
        MyRetrofit.getService().getEmployeeById(id).enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Employee employee = response.body();
                tvOutput.setText(employee.toString());
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                tvOutput.setText(t.getMessage());
            }
        });
    }
}
