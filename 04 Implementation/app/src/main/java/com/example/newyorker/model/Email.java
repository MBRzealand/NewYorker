package com.example.newyorker.model;

import java.util.concurrent.ExecutionException;

import uk.co.jakebreen.sendgridandroid.SendGrid;
import uk.co.jakebreen.sendgridandroid.SendGridMail;
import uk.co.jakebreen.sendgridandroid.SendGridResponse;
import uk.co.jakebreen.sendgridandroid.SendTask;

public class Email {


    public void sendEmail() {
        uk.co.jakebreen.sendgridandroid.SendGrid sendGrid = SendGrid.create("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");
        SendGridMail mail = new SendGridMail();
        mail.addRecipient("fredrikbille@hotmail.com", "Fredrik");
        mail.setFrom("NYWallBuilder@gmail.com", "András");
        mail.setSubject("Hej fra sendgrid");
        mail.setContent("Hej, det virker nu. Måske.");
        System.out.println("about to send");
        SendTask task = new SendTask(sendGrid, mail);
        try {
            System.out.println("we in try");
            SendGridResponse response = task.execute().get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        }
    }
}


