package josuepaiva.leitorqrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import utils.QrcodeLeitor;

public class MainActivity extends AppCompatActivity {
    private QrcodeLeitor qrcodeLeitor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button leitorQrcode = (Button) findViewById(R.id.button);
        Button visualizadorDados = (Button) findViewById(R.id.button2);
        qrcodeLeitor = new QrcodeLeitor(this);

        leitorQrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), qrcodeLeitor.teste(), Toast.LENGTH_LONG).show();
            }
        });

        visualizadorDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), VisualizarDadosActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if(result != null) {
            if(result.getContents() != null) {
                alert(result.getContents());
            }else {
                alert("Scan cancelado");
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    public void alert(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
