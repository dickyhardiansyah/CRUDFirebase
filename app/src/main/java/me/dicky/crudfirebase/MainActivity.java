package me.dicky.crudfirebase;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import me.dicky.crudfirebase.Model.Request;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Dicky";
    private DatabaseReference database;

    private EditText etNama, etEmail, etDesk;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance().getReference();

        etNama = findViewById(R.id.et_nama);
        etEmail = findViewById(R.id.et_email);
        etDesk = findViewById(R.id.et_desk);


        Button button = findViewById(R.id.btn_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Snama = etNama.getText().toString();
                String Semail = etEmail.getText().toString();
                String Sdesk = etDesk.getText().toString();

                if (Snama.equals("")) {
                    etNama.setError("Silahkan masukkan nama");
                    etNama.requestFocus();
                } else if (Semail.equals("")) {
                    etEmail.setError("Silahkan masukkan email");
                    etEmail.requestFocus();
                } else if (Sdesk.equals("")) {
                    etDesk.setError("Silahkan masukkan deskripsi");
                    etDesk.requestFocus();
                } else {
                    loading = ProgressDialog.show(MainActivity.this,
                            null,
                            "Please wait..",
                            true,
                            false);

                    submitUser(new Request(
                            Snama.toLowerCase(),
                            Semail.toLowerCase(),
                            Sdesk.toLowerCase()));
                }
            }
        });

    }

    private void submitUser(Request request){
        database.child("Request")
                .child("request satu")
//                .push()
                .setValue(request)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        loading.dismiss();

                        etNama.setText("");
                        etEmail.setText("");
                        etDesk.setText("");

                        Toast.makeText(MainActivity.this,
                                "Data Berhasil Di Tambahkan",
                                Toast.LENGTH_SHORT).show();
                    }
                });


    }
}
