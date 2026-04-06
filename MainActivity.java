package com.example.form;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nom, email, phone, adresse, ville;
    Button btnEnvoyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lier XML avec Java
        nom = findViewById(R.id.nom);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        adresse = findViewById(R.id.adresse);
        ville = findViewById(R.id.ville);
        btnEnvoyer = findViewById(R.id.btnEnvoyer);

        btnEnvoyer.setOnClickListener(v -> validerFormulaire());
    }

    private void validerFormulaire() {

        String nomTxt = nom.getText().toString().trim();
        String emailTxt = email.getText().toString().trim();
        String phoneTxt = phone.getText().toString().trim();
        String adresseTxt = adresse.getText().toString().trim();
        String villeTxt = ville.getText().toString().trim();

        // Validation
        if (nomTxt.isEmpty()) {
            nom.setError("Nom obligatoire");
            return;
        }

        if (emailTxt.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailTxt).matches()) {
            email.setError("Email invalide");
            return;
        }

        if (phoneTxt.isEmpty() || phoneTxt.length() < 10) {
            phone.setError("Numéro invalide");
            return;
        }

        if (adresseTxt.isEmpty()) {
            adresse.setError("Adresse obligatoire");
            return;
        }

        if (villeTxt.isEmpty()) {
            ville.setError("Ville obligatoire");
            return;
        }

        // Si tout est OK → passer à 2ème activité
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        intent.putExtra("nom", nomTxt);
        intent.putExtra("email", emailTxt);
        intent.putExtra("phone", phoneTxt);
        intent.putExtra("adresse", adresseTxt);
        intent.putExtra("ville", villeTxt);

        startActivity(intent);
    }
}
