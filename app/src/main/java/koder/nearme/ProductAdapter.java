package koder.nearme;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.realm.RealmResults;

/**
 * Created by a7md on 5/1/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private RealmResults<Product> products;

    public ProductAdapter(RealmResults<Product> products) {
        this.products = products;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = products.get(position);

        holder.textView_title.setText(product.title);
        holder.textView_quantity.setText(product.quantity);
        holder.textView_calories.setText(product.calories);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        public TextView textView_title;
        public TextView textView_quantity;
        public TextView textView_calories;

        public ProductViewHolder(View itemView) {
            super(itemView);
            textView_title = (TextView) itemView.findViewById(R.id.textView_title);
            textView_quantity = (TextView) itemView.findViewById(R.id.textView_quantity);
            textView_calories = (TextView) itemView.findViewById(R.id.textView_clories);
        }
    }
}
