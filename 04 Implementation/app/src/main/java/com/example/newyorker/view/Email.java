package com.example.newyorker.view;
import android.content.Intent;
import android.net.Uri;


import com.example.newyorker.model.Customer;
import com.example.newyorker.model.Wall;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email implements Serializable {
    private final String toNewYorker = "NYWallBuilder@gmail.com";
    private final String passWord = "cdXpu5LFJsaWTRi";

    private final String subject = "Forespørgsel New Yorker væg";

    private Message prepareMessage(Session session, String myAccountEmail, String recepient, String body){

        try {


            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("this shit is jank AF");
            message.setText(body);
            return message;



        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void sendEmail(String forhandler, Customer customer, Wall wall) throws Exception {

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(toNewYorker, passWord);
            }
        });




        /*String[] to = {forhandler};
        String[] cc = {toNewYorker};*/

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

        Message message = prepareMessage(session, toNewYorker, forhandler, "body");
        Transport.send(message);


        /*Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(Uri.parse("mailto:")); // only email apps should handle this
        email.putExtra(Intent.EXTRA_EMAIL, to);
        email.putExtra(Intent.EXTRA_CC, cc);
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, body);
        return email;*/
    }








}


