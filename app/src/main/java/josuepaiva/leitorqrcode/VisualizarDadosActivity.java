package josuepaiva.leitorqrcode;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsoluteLayout;

public class VisualizarDadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_dados);

        ConstraintLayout constraint = (ConstraintLayout)findViewById(R.id.ConstraitLayout);

    }
}
