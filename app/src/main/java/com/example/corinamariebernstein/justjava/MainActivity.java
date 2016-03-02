package com.example.corinamariebernstein.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 *
 * @param quantity is a global var that will hold the quanitity of coffees ordered.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     * @param hasWhip is grabbing UI status of whipped cream CheckBox
     * @param hasHazelnuts is grabbing UI status of crushed hazelnuts CheckBox
     * @param hasCaramel is grabbing UI status of caramel CheckBox
     * @param priceMessage is the variable that will contain the final message to be displayed after order button is clicked
     */
    public void submitOrder(View view) {

        CheckBox hasWhip = (CheckBox) findViewById(R.id.whipped_cream);
        CheckBox hasHazelnuts = (CheckBox) findViewById(R.id.crushed_hazelnuts);
        CheckBox hasCaramel = (CheckBox) findViewById(R.id.caramel);

        String priceMessage = createOrderSummary(calculatePrice(), hasWhip.isChecked(), hasHazelnuts.isChecked(), hasCaramel.isChecked());
        displayMessage(priceMessage);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view) {
        if(quantity > 0) {
            quantity--;
        } else {
            quantity = 0;
        }
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the Order Summary on the screen.
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * This method displays the Order Summary on the screen.
     *
     * @param priceMessage is the var used to build the post-order message in this method.
     */
    private String createOrderSummary(int price,
                                      boolean hasWhipCream,
                                      boolean hasHazelnuts,
                                      boolean hasCaramel) {
        String priceMessage = "Customer name: Corina Marie";
        priceMessage += "\ntoppings: ";
        if(hasWhipCream == true){
            priceMessage += "\n~~~~crema";
        }
        if(hasHazelnuts == true){
            priceMessage += "\n~~~~crushed hazelnuts";
        }
        if(hasCaramel == true) {
            priceMessage += "\n~~~~caramel";
        }
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nGracias!";
        return priceMessage;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}