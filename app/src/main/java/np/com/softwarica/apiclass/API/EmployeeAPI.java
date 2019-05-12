package np.com.softwarica.apiclass.API;

import java.util.List;

import np.com.softwarica.apiclass.models.Employee;
import np.com.softwarica.apiclass.models.EmployeeCUD;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmployeeAPI {

    @GET("employees")
    Call<List<Employee>> getAllContact();

    @GET("employee/{id}")
    Call<Employee> getEmployeeById(@Path("id") int id);

    @POST("create")
    Call<Void> addEmployee(@Body EmployeeCUD employee);

    @PUT("update/{id}")
    Call<Void> updateEmployee(@Path("id") int id, @Body EmployeeCUD cud);

    @DELETE("update/{id}")
    Call<Void> deleteEmployee(@Path("id") int id);
}
