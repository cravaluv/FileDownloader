package pl.us.inf.pw.project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;
import java.util.Date;

public class Downloader implements Runnable {

    private String url;
    private Date startDate;

    //////////////////////////
    //  CONSTRUCTOR
    /////////////////////////
    public Downloader(String url) {
        this.url = url;
        this.startDate = new Date();
    }

    @Override
    public void run() {
        try {
            URL website = new URL(this.url);
            ReadableByteChannel rbc;
            rbc = java.nio.channels.Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("C:\\STUDIA\\FileDownloader");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //////////////////////////
    //  GETTERS AND SETTERS
    /////////////////////////
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
