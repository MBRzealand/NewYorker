package com.example.newyorker.model;



import android.content.Intent;
import android.net.Uri;



public class Email {


    private final String toNewYorker = "fredrikbille@hotmail.com";
    private final String emailType = "*/*";
    private final String subject = "Forespørgsel New Yorker væg";

    public Intent sendEmail(String forhandler, Customer customer){

        String mailto = "mailto:" + forhandler + "?cc=" + toNewYorker;

        String body = "Kunde navn: " + customer.getCustomerName() +
                "\nKunde E-mail: " + customer.getCustomerEmailAdress() +
                "\nKunde Tlf: " + customer.getCustomerPhoneNumber() +
                "\nKunde Adresse: " + customer.getCustomerAddress() +
                "\nKunde Post Nr: " + customer.getCustomerZIPCode();



        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setType(emailType);
        email.setData(Uri.parse(mailto));
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, body);
        return email;
    }








}


