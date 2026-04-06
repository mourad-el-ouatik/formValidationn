package com.example.form;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.form.R;
public class SecondActivity extends AppCompatActivity {

    TextView Nom, Email, Phone, Adresse, Ville;
    Button btnRetour, btnVerifie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        // 🔗 Lier les composants
        Nom = findViewById(R.id.tvNom);
        Email = findViewById(R.id.tvEmail);
        Phone = findViewById(R.id.tvPhone);
        Adresse = findViewById(R.id.tvAdresse);
        Ville = findViewById(R.id.tvVille);

        btnRetour = findViewById(R.id.btnRetour);
        btnVerifie = findViewById(R.id.btnVerifie);

        // 📥 Récupérer les données envoyées
        String nom = getIntent().getStringExtra("nom");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");
        String adresse = getIntent().getStringExtra("adresse");
        String ville = getIntent().getStringExtra("ville");

        // 📊 Affichage dans les TextView
        Nom.setText(nom);
        Email.setText(email);
        Phone.setText(phone);
        Adresse.setText(adresse);
        Ville.setText(ville);

        //Bouton retour
        btnRetour.setOnClickListener(v -> finish());

        //Bouton vérifier (validation finale)
        btnVerifie.setOnClickListener(v -> {
            Toast.makeText(this, "Informations validées ✅", Toast.LENGTH_LONG).show();
        });
    }
}
