package sistdistribuido.com.freedon.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import sistdistribuido.com.freedon.Adapters.ProductAdapter;
import sistdistribuido.com.freedon.R;
import sistdistribuido.com.freedon.models.Product;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();

        List<Product> products = new ArrayList<>(); // Receber do webservice aqui

        recyclerView.setAdapter(new ProductAdapter(products));

    }

    private void bindViews() {
        recyclerView = findViewById(R.id.recycleView);
    }
}
