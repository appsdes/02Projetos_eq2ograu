package br.edu.fatec.eqmovunif;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA, editTextB, editTextC;
    private TextView textViewDelta, textViewX1, textViewX2, textViewResult;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);

        textViewDelta = findViewById(R.id.textViewDelta);
        textViewX1 = findViewById(R.id.textViewX1);
        textViewX2 = findViewById(R.id.textViewX2);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(v -> setButtonCalculate()); // Adicionando o listener ao botão
    }

    private void setButtonCalculate() {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        double c = Double.parseDouble(editTextC.getText().toString());

        double delta = b * b - 4 * a * c;
        textViewDelta.setText("Delta: " + delta);

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            textViewX1.setText("x1: " + x1);
            textViewX2.setText("x2: " + x2);
            textViewResult.setText("");
        } else if (delta == 0) {
            double x = -b / (2 * a);
            textViewX1.setText("x1 = x2: " + x);
            textViewX2.setText("");
            textViewResult.setText("");
        } else {
            textViewDelta.setText("");
            textViewX1.setText("");
            textViewX2.setText("");
            textViewResult.setText("Não é uma equação do 2º grau ou não tem raízes reais.");
        }
    }
}
