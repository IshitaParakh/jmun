package com.google.codelabs.mdc.java.shrine;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.codelabs.mdc.java.shrine.network.AboutEntry;
import com.google.codelabs.mdc.java.shrine.network.ImageRequester;
import com.google.codelabs.mdc.java.shrine.network.ProductEntry;

import java.util.List;

/**
 * Adapter used to show a simple grid of products.
 */
public class ProductCardRecyclerViewAdapter extends RecyclerView.Adapter<ProductCardViewHolder> {

    private List<AboutEntry> aboutList;
    //private ImageRequester imageRequester;

    ProductCardRecyclerViewAdapter(List<AboutEntry> aboutList) {
        this.aboutList = aboutList;
        //imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public ProductCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shr_product_card, parent, false);
        return new ProductCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCardViewHolder holder, int position) {
        if (aboutList != null && position < aboutList.size()) {
            AboutEntry product = aboutList.get(position);
            holder.productTitle.setText(product.title);
            holder.productPrice.setText(product.price);
        }
    }

    @Override
    public int getItemCount() {
        return aboutList.size();
    }
}
