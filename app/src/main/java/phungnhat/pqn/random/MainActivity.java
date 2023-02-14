package phungnhat.pqn.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edtMin, edtMax;
    Button btnRandom;
    TextView txtRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtMin = findViewById(R.id.edtMin);
        edtMax = findViewById(R.id.edtMax);
        btnRandom = findViewById(R.id.btnRandom);
        txtRandom = findViewById(R.id.txtRandom);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtMin.getText().toString().equals("") || edtMax.getText().toString().equals("")
                        || edtMin.getText().toString().equals("") && edtMax.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Bạn nhập thiếu giá trị", Toast.LENGTH_SHORT).show();
//                    .isEmpty() == 0 Xem chuỗi đó có lỗi hay không
//                    .length() == 0 Chuỗi đó đang không có ký tự
                    return;
                }
                else if (Integer.parseInt(edtMin.getText().toString()) > Integer.parseInt(edtMax.getText().toString())){
                    Toast.makeText(MainActivity.this, "Min không được nhỏ hơn Max", Toast.LENGTH_SHORT).show();
                    edtMax.setText("");
                }
                else
                {
                    int min, max;
                    min = Integer.parseInt(edtMin.getText().toString().trim());
                    max = Integer.parseInt(edtMax.getText().toString().trim());
                    Random random = new Random();
                    int rd = random.nextInt(max - min + 1) + min;
                    txtRandom.setText(rd +"");
                }
            }
        });
    }
}