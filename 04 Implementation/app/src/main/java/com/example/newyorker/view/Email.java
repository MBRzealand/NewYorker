package com.example.newyorker.view;
import android.content.Intent;
import android.net.Uri;

import com.example.newyorker.model.Customer;
import com.example.newyorker.model.Wall;

import java.io.Serializable;


public class Email implements Serializable {
    private final String toNewYorker = "fredrikbille@hotmail.com";

    private final String subject = "Forespørgsel New Yorker væg";


    public Intent sendEmail(String forhandler, Customer customer, Wall wall){


        String[] to = {forhandler};
        String[] cc = {toNewYorker};

        String body = "Kunde navn: " + customer.getCustomerName() +
                "\nKunde E-mail: " + customer.getCustomerEmailAddress() +
                "\nKunde Tlf: " + customer.getCustomerPhoneNumber() +
                "\nKunde Adresse: " + customer.getCustomerAddress() +
                "\nKunde Post Nr: " + customer.getCustomerZIPCode() +
                "\nVæg Bredde: " + wall.getWallWidth() + " Cm." +
                "\nVæg Højde: " + wall.getWallHeight() + " Cm." +
                "\nVæg Pris: " + Math.round(wall.getWallPrice() * 100.0) / 100.0 + " Kr." +
                "\n\n" + "Kunde Noter: " +
                "\n"+customer.getCustomerNotes();


        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(Uri.parse("mailto:")); // only email apps should handle this
        email.putExtra(Intent.EXTRA_EMAIL, to);
        email.putExtra(Intent.EXTRA_CC, cc);
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, body);
        return email;
    }








}


