package josuepaiva.leitorqrcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import models.Aluno;

public class VisualizarDadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_dados);

        Bundle bundle = getIntent().getExtras();
        Aluno aluno = bundle.getParcelable("Aluno");

        EditText nome = (EditText) findViewById(R.id.editTextNome);
        nome.setText(aluno.getNome(), TextView.BufferType.EDITABLE);

        EditText idade = (EditText) findViewById(R.id.editTextIdade);
        idade.setText(Integer.toString(aluno.getIdade()), TextView.BufferType.EDITABLE);

        EditText matricula = (EditText) findViewById(R.id.editTextMatricula);
        matricula.setText(aluno.getMatricula(), TextView.BufferType.EDITABLE);

        EditText curso = (EditText) findViewById(R.id.editTextCurso);
        curso.setText(aluno.getCurso(), TextView.BufferType.EDITABLE);

        EditText dataformacao = (EditText) findViewById(R.id.editTextDataFormacao);
        dataformacao.setText(aluno.getData_formacao(), TextView.BufferType.EDITABLE);

        EditText dataingresso = (EditText) findViewById(R.id.editTextDataIngresso);
        dataingresso.setText(aluno.getData_ingresso(), TextView.BufferType.EDITABLE);

        EditText email = (EditText) findViewById(R.id.editTextEmail);
        email.setText(aluno.getEmail(), TextView.BufferType.EDITABLE);

        EditText centro = (EditText) findViewById(R.id.editTextCentro);
        centro.setText(aluno.getCentro(), TextView.BufferType.EDITABLE);
    }
}
