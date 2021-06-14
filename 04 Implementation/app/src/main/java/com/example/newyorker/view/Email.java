package com.example.newyorker.view;
import com.example.newyorker.model.Customer;
import com.example.newyorker.model.Wall;
import com.sendgrid.*;
import java.io.IOException;
import java.io.Serializable;



public class Email implements Serializable {
    private final String toNewYorker = "NYWallBuilder@gmail.com";
    private final String subject = "Forespørgsel New Yorker væg";
    private final String API_KEY = "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";



    public void sendEmail(String forhandler, Customer customer, Wall wall) throws IOException {




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



        com.sendgrid.Email from = new com.sendgrid.Email(forhandler);
        String subject = "Sending with SendGrid is Fun";
        com.sendgrid.Email til = new com.sendgrid.Email("hjordrup96@live.dk");
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, til, content);

        SendGrid sg = new SendGrid(API_KEY);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }

        /*Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(Uri.parse("mailto:")); // only email apps should handle this
        email.putExtra(Intent.EXTRA_EMAIL, to);
        email.putExtra(Intent.EXTRA_CC, cc);
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, body);
        return email;*/
    }








}


