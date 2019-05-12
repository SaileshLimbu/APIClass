package np.com.softwarica.apiclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import np.com.softwarica.apiclass.API.MyRetrofit;
import np.com.softwarica.apiclass.models.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayAllEmployeeActivity extends AppCompatActivity {

    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_employee);

        tvDisplay = findViewById(R.id.tvDisplay);

        MyRetrofit.getService().getAllContact().enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                List<Employee> employees = response.body();
                for(Employee employee: employees){
                    tvDisplay.append(employee.toString() + "\n");
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Toast.makeText(DisplayAllEmployeeActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}