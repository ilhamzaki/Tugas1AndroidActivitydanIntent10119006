package AKB.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// 21 April 2022 - 10119006 - Ilham zaki - IF1

public class RegistrationActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText etUsername, etPassword, etConfirmPassword;
    ActionBar actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        actionbar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();
        activity();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void initView() {
        btnRegister = findViewById(R.id.btn_register);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
    }

    public void activity() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                if(username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Form Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                } else if(!password.equals(confirmPassword)) {
                    Toast.makeText(RegistrationActivity.this, "Password Tidak Sesuai", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistrationActivity.this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });
    }
}