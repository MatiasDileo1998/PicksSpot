package pickspot.cl;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import pickspot.cl.model.Usuario;


public class MainActivity<FirebaseAuth> extends AppCompatActivity {
    private Button btExplorar;
    private Button btBrujula;
    private Button btCamara;
    private Button btRegistro;
    private EditText txtEmail;
    private EditText txtContrasena;
    private ProgressDialog progressDialog;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // mAuth = FirebaseAuth.getInstance();

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtContrasena = (EditText) findViewById(R.id.txtContrasena);

        btExplorar= (Button) findViewById(R.id.btExplorar);
        btRegistro= (Button) findViewById(R.id.btRegistro);
        btBrujula= (Button) findViewById(R.id.btBrujula);
        btCamara= (Button) findViewById(R.id.btCamara);

        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario();
                usuario.setEmail(txtEmail.getText().toString());
                usuario.setPassword(txtContrasena.getText().toString());

                databaseReference.child("Usuario").child(usuario.getEmail()).setValue(usuario);
            }
        });


        btExplorar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, ActivityMapBox.class);
                startActivity(i);}
        });
        progressDialog = new ProgressDialog(this);
       // btExplorar.setOnClickListener(this);

        //btRegistro = (Button) findViewById(R.id.btRegistro);
       // btRegistro.setOnClickListener(this);

        btBrujula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, brujula.class);
                startActivity(i);}
        });
        btCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Camara.class);
                startActivity(i);}
        });


    }
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void datosRegistro(){

        Usuario usuario = new Usuario();
        usuario.setEmail(txtEmail.getText().toString());
        usuario.setPassword(txtContrasena.getText().toString());

        databaseReference.child("Usuario").child(usuario.getEmail()).setValue(usuario);

    }

}





