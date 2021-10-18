package com.example.shoptastic;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoptastic.database.OrderContract;

public class Women2Activity  extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    // first of all we will get the views that are  present in the layout of info

    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, itemName, itemPrice, descriptionInfo;
    CheckBox addGift;
    Button addtoCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        itemName = findViewById(R.id.itemNameInfo);
        itemPrice = findViewById(R.id.itemPrice);
        addGift = findViewById(R.id.gift);
        addtoCart = findViewById(R.id.addtocart);
        descriptionInfo = findViewById(R.id.descriptioninfo);

        itemName.setText("Slim Fit Jeans");
        imageView.setImageResource(R.drawable.women2);
        itemPrice.setText("Rs. 1899");
        descriptionInfo.setText(getString(R.string.women2));

        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Women2Activity.this, SummaryActivity.class);
                startActivity(intent);

                // once this button is clicked we want to save our values in the database and send those values
                // right away to summary activity where we display the order info
                saveCart();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // coffee price
                int basePrice = 1899;
                quantity++;
                displayQuantity();
                int coffePrice = basePrice * quantity;
                String setnewPrice = String.valueOf(coffePrice);
                itemPrice.setText(setnewPrice);


                // checkBoxes functionality

                int ifCheckBox = calculatePrice(addGift);
                itemPrice.setText("Rs." + ifCheckBox);

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 5;
                // because we dont want the quantity go less than 0
                if (quantity == 0) {
                    Toast.makeText(Women2Activity.this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int coffePrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(coffePrice);
                    itemPrice.setText(setnewPrice);


                    // checkBoxes functionality

                    int ifCheckBox = calculatePrice(addGift);
                    itemPrice.setText("$ " + ifCheckBox);
                }
            }
        });

    }

    private boolean saveCart() {
        // getting the values from our views
        String name = itemName.getText().toString();
        String price = itemPrice.getText().toString();
        String quantity = quantitynumber.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);

        if (addGift.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_HASGIFT, "Is Gift?: YES");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_HASGIFT, "Is Gift?: NO");

        }
        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri==null) {
                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success  adding to Cart", Toast.LENGTH_SHORT).show();

            }
        }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;
    }

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }

    private int calculatePrice(CheckBox addGift) {

        int basePrice = 1899;

        if (addGift.isChecked()) {
            // add the cream cost $2
            basePrice = basePrice + 25;
        }

        return basePrice * quantity;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_HASGIFT
        };

        return new CursorLoader(this, mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
            int hasGift = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_HASGIFT);


            String nameofdrink = cursor.getString(name);
            String priceofdrink = cursor.getString(price);
            String quantityofdrink = cursor.getString(quantity);
            String yeshasGift = cursor.getString(hasGift);

            itemName.setText(nameofdrink);
            itemPrice.setText(priceofdrink);
            quantitynumber.setText(quantityofdrink);
        }


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        itemName.setText("");
        itemPrice.setText("");
        quantitynumber.setText("");
    }
}