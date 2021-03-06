package com.example.newyorker.model;


import android.content.Context;
import android.net.Uri;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import uk.co.jakebreen.sendgridandroid.SendGrid;
import uk.co.jakebreen.sendgridandroid.SendGridMail;
import uk.co.jakebreen.sendgridandroid.SendGridResponse;
import uk.co.jakebreen.sendgridandroid.SendTask;


public class Email implements Serializable {
    private final String toNewYorker = "fredrikbille01@gmail.com";


    public void sendEmail(Customer customer, String details) {


        String body = "Kunde navn: " + customer.getCustomerName() +
                "\nKunde E-mail: " + customer.getCustomerEmailAddress() +
                "\nKunde Tlf: " + customer.getCustomerPhoneNumber() +
                "\nKunde Adresse: " + customer.getCustomerAddress() +
                "\nKunde Post Nr: " + customer.getCustomerZIPCode() +
                "\n\n" + "Kunde Noter: " +
                "\n" +customer.getCustomerNotes() +
                "\n\n" + details;





        SendGrid sendGrid = SendGrid.create("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");

        SendGridMail mail = new SendGridMail();
        mail.addRecipient("fredrikbille@hotmail.com", "Bitch");
        mail.addRecipientCarbonCopy(toNewYorker, "NewYorker");
        mail.setFrom("NYWallBuilder@gmail.com", "NewYorkerApp");
        mail.setSubject("Forespørgsel på New Yorker væg");
        mail.setContent(body);






        SendTask task = new SendTask(sendGrid, mail);
        try {
            SendGridResponse response = task.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


