package np.com.softwarica.apiclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void displayAllEmployee(View view) {
        startActivity(new Intent(this, DisplayAllEmployeeActivity.class));
    }

    public void searchEmployee(View view) {
        startActivity(new Intent(this, SearchEmployeeActivity.class));
    }

    public void addEmployee(View view) {
        startActivity(new Intent(this, AddEmployeeActivity.class));
    }

    public void updateDeleteEmployee(View view) {
        startActivity(new Intent(this, UpdateDeleteActivity.class));
    }
}