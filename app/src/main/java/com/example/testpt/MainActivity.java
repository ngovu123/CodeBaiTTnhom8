package com.example.testpt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtC, edtResult;
    TextView textViewResult;
    Button btnCalculate, btnDelete, btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);
        edtResult = findViewById(R.id.edtResult);
        textViewResult = findViewById(R.id.textViewResult);

        btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateQuadraticEquation();
            }
        });

        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý sự kiện xóa ở đây
                edtA.setText("");
                edtB.setText("");
                edtC.setText("");
                edtResult.setText("");
                textViewResult.setVisibility(View.GONE);
                edtResult.setVisibility(View.GONE);
            }
        });

        btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý sự kiện đóng ở đây
                finish();
            }
        });
    }

    private void calculateQuadraticEquation() {
        try {
            double a = Double.parseDouble(edtA.getText().toString());
            double b = Double.parseDouble(edtB.getText().toString());
            double c = Double.parseDouble(edtC.getText().toString());

            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                edtResult.setText("Phương trình có hai nghiệm: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                edtResult.setText("Phương trình có một nghiệm kép: x = " + x);
            } else {
                edtResult.setText("Phương trình vô nghiệm.");
            }

            // Hiển thị kết quả
            textViewResult.setVisibility(View.VISIBLE);
            edtResult.setVisibility(View.VISIBLE);
        } catch (NumberFormatException e) {
            edtResult.setText("Nhập không hợp lệ. Vui lòng kiểm tra lại.");
        }
    }
}
