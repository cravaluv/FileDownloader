package pl.us.inf.pw.project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        try {
            String url = "http://download.oracle.com/otn-pub/java/jdk/11.0.1+13/90cf5d8f270a4347a95050320eef3fb7/jdk-11.0.1_windows-x64_bin.exe";
            ExecutorService pool = Executors.newFixedThreadPool(1);
            pool.submit(new Downloader(url));
            pool.submit(new Downloader("https://download-cf.jetbrains.com/idea/ideaIC-2018.2.5.exe"));
            pool.shutdown();
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
