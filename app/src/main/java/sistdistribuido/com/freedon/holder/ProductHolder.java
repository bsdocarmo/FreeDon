package sistdistribuido.com.freedon.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import sistdistribuido.com.freedon.R;

/**
 * Created by brunodocarmo on 09/12/17.
 */

public class ProductHolder extends RecyclerView.ViewHolder {

    public final ImageView productImage;
    public final TextView productName;
    public final TextView productDescription;

    public ProductHolder(View itemView) {
        super(itemView);

        productImage = itemView.findViewById(R.id.product_image);
        productName = itemView.findViewById(R.id.product_name);
        productDescription = itemView.findViewById(R.id.product_description);
    }
}
