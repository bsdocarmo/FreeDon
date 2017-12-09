package sistdistribuido.com.freedon.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import sistdistribuido.com.freedon.models.Product;

/**
 * Created by Bruno on 04/12/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter {


    private List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
