package com.acrophillic.filereadwrite;

import android.content.Context;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by fahim on 7/27/2016.
 */
public class FileReadWrite {

    private final static String FILE_NAME = "acrophillic.txt";
    private Context context;

    public FileReadWrite(Context context) {
        this.context = context;
    }

    public void writeToFile(String text) throws Exception {

        try {
            OutputStreamWriter writer = new OutputStreamWriter(context.openFileOutput(FILE_NAME, Context.MODE_APPEND));
            writer.write(text);
            writer.close();

        } catch (FileNotFoundException e) {
            throw new Exception(e.getMessage());
        } catch (IOException e) {
        }
    }

    String readFromFile() throws Exception {

        String output = "";

        try {
            InputStream inputStream = context.openFileInput(FILE_NAME);
            if (inputStream != null) {
                InputStreamReader reader = new InputStreamReader(inputStream);

                BufferedReader bufferedReader = new BufferedReader(reader);
                String receivedText = "";
                StringBuilder builder = new StringBuilder();

                while ((receivedText = bufferedReader.readLine()) != null) {
                    builder.append(receivedText);
                }
                output = builder.toString();
                inputStream.close();
            }

        } catch (FileNotFoundException e) {
            throw new Exception(e.getMessage());
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }
        return output;
    }

}
