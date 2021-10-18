package com.example.shoptastic;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Women1Activity extends AppCompatActivity {

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

        itemName.setText("Anarkali Dress");
        imageView.setImageResource(R.drawable.women1);
        itemPrice.setText("Rs. 1499");
        descriptionInfo.setText(getString(R.string.women1));

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // coffee price
                int basePrice = 1499;
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
                    Toast.makeText(Women1Activity.this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT).show();
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

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }

    private int calculatePrice(CheckBox addGift) {

        int basePrice = 1499;

        if (addGift.isChecked()) {
            // add the cream cost $2
            basePrice = basePrice + 25;
        }

        return basePrice * quantity;
    }
}