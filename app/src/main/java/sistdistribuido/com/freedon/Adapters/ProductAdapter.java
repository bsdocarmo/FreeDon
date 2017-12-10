package sistdistribuido.com.freedon.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import sistdistribuido.com.freedon.R;
import sistdistribuido.com.freedon.holder.ProductHolder;
import sistdistribuido.com.freedon.models.Product;

/**
 * Created by Bruno on 04/12/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter {


    private Context context;
    private List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent,
                false);

        ProductHolder productHolder = new ProductHolder(view);

        return productHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ProductHolder productHolder = (ProductHolder) holder;

        Product product = products.get(position);

        productHolder.productName.setText(product.getName());
        productHolder.productDescription.setText(product.getDescription());
        productHolder.productImage.setImageResource(R.mipmap.ic_launcher_round);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
