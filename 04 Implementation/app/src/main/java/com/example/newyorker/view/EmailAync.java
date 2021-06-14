package com.example.newyorker.view;

import android.content.Context;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;

import java.lang.ref.WeakReference;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class EmailAync extends AsyncTask<Void,Void,Void> {

        private final WeakReference<Context> context;
        private Session session;
        private String email;
        private String subject;
        private String message;
        private ProgressDialog mProgressDialog;

        public EmailAync(Context context, String email, String subject, String message) {
            this.context = new WeakReference<>(context);
            this.email = email;
            this.subject = subject;
            this.message = message;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(context.get(), "Sender mail", "vent venligst...",false,false);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mProgressDialog.dismiss();
        }

        @Override
        protected Void doInBackground(Void... params) {

            Properties props = new Properties();

            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(MailCredentials.getEMAIL(), MailCredentials.getPASSWORD());
                        }
                    });

            try {
                MimeMessage mm = new MimeMessage(session);
                mm.setFrom(new InternetAddress(MailCredentials.getEMAIL()));
                mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                mm.setSubject(subject);
                mm.setText(message);
                Transport.send(mm);

            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return null;
        }