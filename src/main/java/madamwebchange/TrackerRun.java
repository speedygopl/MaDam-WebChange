package madamwebchange;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TrackerRun {
    TrackerObject trackerObject = new TrackerObject();
    public String webPageStart = "";
    public String webPage = "";
    boolean change = false;

    public TrackerRun() throws IOException {
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        TrackerRun trackerRun = new TrackerRun();
        trackerRun.startTracker();
    }

    public void startTracker() throws IOException, InterruptedException {
        downloadCurrentWebpage(trackerObject);
        if(hasChanged()){
            sendEmail(trackerObject);
            waitTime(trackerObject);
            startTracker();
        } else {
            waitTime(trackerObject);
            startTracker();
        }
    }

    public String downloadCurrentWebpage(TrackerObject trackerObject) throws IOException {
        webPage = "";
        String link = trackerObject.link;
        URL url = new URL(link);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            webPage = webPage.concat(line);
        }
        return webPage;
    }

    public boolean hasChanged() {
        if(webPage.equals(webPageStart)) {
            change = false;
            System.out.println("no changes detected ...");
        } else {
            change = true;
            webPageStart = webPage;
            System.out.println(webPageStart);
        }
        return change;
    }

    public void waitTime(TrackerObject trackerObject) throws InterruptedException {
        TimeUnit.MINUTES.sleep(Integer.parseInt(trackerObject.frequency));
    }

    public void sendEmail(TrackerObject trackerObject){
        String to = trackerObject.email;
        String from = "damazy5@wp.pl";
        String host = "smtp.wp.pl";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", host);
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("damazy5", "SzarmutA351");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Your Madam Tracker !!!");
            message.setText("WebPage has changed !!!");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
