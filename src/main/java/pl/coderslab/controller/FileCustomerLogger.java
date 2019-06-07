package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

@Repository
public class FileCustomerLogger implements CustomerLogger {
    private String filename;

    @Autowired
    public FileCustomerLogger() {

    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(String message) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true))) {

            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            bufferedWriter.write("" + hour + ":" + minute + ": " + message + "\n");
        } catch (IOException e) {
            System.out.println("Logowanie do pliku nie powiodło się :/");
        }
    }
}
