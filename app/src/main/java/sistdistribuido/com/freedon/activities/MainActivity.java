package sistdistribuido.com.freedon.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import sistdistribuido.com.freedon.adapters.ProductAdapter;
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

        Product product = new Product(1, "Sofá", "Lindo sofá, pouco usado",
                1, 1);
        products.add(product);

        Product product2 = new Product(2, "Guarda-roupa", "Guarda-roupa 3 portas",
                1, 1);
        products.add(product2);

        product = new Product(3, "Mesa", "Mesa de 4 lugares",
                1, 1);
        products.add(product);

        recyclerView.setAdapter(new ProductAdapter(this, products));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
    }

    private void bindViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }
}
