package josuepaiva.leitorqrcode;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import models.Aluno;
import utils.QrcodeLeitor;

import static utils.Camera.CAMERA_TRASEIRA;

public class MainActivity extends AppCompatActivity {
    private QrcodeLeitor qrcodeLeitor;
    private JSONObject json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button leitorQrcode = (Button) findViewById(R.id.button);
        qrcodeLeitor = new QrcodeLeitor(this);

        final Activity activity = this;

        leitorQrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), qrcodeLeitor.teste(), Toast.LENGTH_LONG).show();
                IntentIntegrator intentIntegrator = new IntentIntegrator(activity);
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                intentIntegrator.setPrompt("Câmera Scan");
                intentIntegrator.setCameraId(CAMERA_TRASEIRA.getValor());
                intentIntegrator.initiateScan();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if(result != null) {
            if(result.getContents() != null) {

                if(result.getContents().matches("([a-zA-Z]{3,})://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?")){
                    Uri uri = Uri.parse(result.getContents());

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }else{
                    try {

                        json = new JSONObject(result.getContents());

                        Aluno aluno = new Aluno();
                        aluno.setNome(json.getString("nome"));
                        aluno.setIdade(json.getInt("idade"));
                        aluno.setMatricula(json.getString("matricula"));
                        aluno.setCurso(json.getString("curso"));
                        aluno.setData_formacao(json.getString("data_formacao"));
                        aluno.setData_ingresso(json.getString("data_ingresso"));
                        aluno.setEmail(json.getString("email"));
                        aluno.setCentro(json.getString("centro"));

                        Intent intent = new Intent(getApplicationContext(), VisualizarDadosActivity.class);
                        intent.putExtra("Aluno", aluno);
                        startActivity(intent);

                    } catch (JSONException e) {
                        alert("Erro na criação do json");
                    }
                    alert(result.getContents());
                }

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
