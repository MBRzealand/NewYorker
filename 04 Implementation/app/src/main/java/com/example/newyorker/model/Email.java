package com.example.newyorker.model;


import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import uk.co.jakebreen.sendgridandroid.SendGrid;
import uk.co.jakebreen.sendgridandroid.SendGridMail;
import uk.co.jakebreen.sendgridandroid.SendGridResponse;
import uk.co.jakebreen.sendgridandroid.SendTask;


public class Email implements Serializable {
    private final String toNewYorker = "hjordrup96@live.dk";


    public void sendEmail(Customer customer, Wall wall) {


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


