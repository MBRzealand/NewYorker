package com.example.newyorker.view;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.example.newyorker.model.Customer;
import com.example.newyorker.model.Wall;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

import uk.co.jakebreen.sendgridandroid.SendGrid;
import uk.co.jakebreen.sendgridandroid.SendGridMail;
import uk.co.jakebreen.sendgridandroid.SendGridResponse;
import uk.co.jakebreen.sendgridandroid.SendTask;


public class Email implements Serializable {
    private final String toNewYorker = "fredrikbille@hotmail.com";

    private final String subject = "Forespørgsel New Yorker væg";


    public void sendEmail(){


        /*String[] to = {forhandler};
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
                "\n"+customer.getCustomerNotes();*/


        Log.d("András","Mailen oprettes.");
        SendGrid sendGrid = SendGrid.create("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");
        SendGridMail mail = new SendGridMail();
        mail.addRecipient("fredrikbille@hotmail.com", "Bitch");
        mail.setFrom("NYWallBuilder@gmail.com", "Bille");
        mail.setSubject("Hej fra yeppers");
        mail.setContent("Hej, det virker nu. DO YOU EVEN SEND!?.");
        Log.d("András","Mailen er nu konstrueret.");
        Log.d("András","Mailen sendes.");
        SendTask task = new SendTask(sendGrid, mail);
        try {
            SendGridResponse response = task.execute().get();
            Log.d("András", "Mailen er sendt til APIet" + response.getErrorMessage() );
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }








}


