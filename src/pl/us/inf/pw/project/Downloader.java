package pl.us.inf.pw.project;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;
import java.util.Date;

public class Downloader implements Runnable {

    private String url;
    private String name;
    private Date startDate;

    //////////////////////////
    //  CONSTRUCTOR
    /////////////////////////
    public Downloader(String url, String name) {
        this.url = url;
        this.startDate = new Date();
        this.name = name;
    }

    @Override
    public void run() {
        URL website = null;
        try {
            website = new URL(this.url);

        String downloadedFileName = this.name;
            InputStream is = website.openStream();

            // Stream to the destionation file
            FileOutputStream fos = new FileOutputStream("D:/STUDIA" + "/" + downloadedFileName);

            // Read bytes from URL to the local file
            byte[] buffer = new byte[4096];
            int bytesRead = 0;

            System.out.println("Downloading " + downloadedFileName);
            while ((bytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            // Close destination stream
            fos.close();
            // Close URL stream
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
