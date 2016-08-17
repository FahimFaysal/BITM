package com.acrophillic.trackmyroad;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by fahim on 7/27/2016.
 */
public class FileReadWrite {

    private final static String FILE_NAME = "acrophillic.txt";
    private Context context;

    public FileReadWrite(Context context) {
        this.context = context;
    }

     void writeToFile(GPS gps) throws Exception {

        try {
            OutputStreamWriter writer = new OutputStreamWriter(context.openFileOutput(FILE_NAME, Context.MODE_APPEND));
            writer.write(gps.toString());
            writer.close();

        } catch (FileNotFoundException e) {
            throw new Exception(e.getMessage());
        } catch (IOException e) {
        }
    }

     void delete(){
        try {

            File dir = context.getFilesDir();
            File file = new File(dir, FILE_NAME);
            boolean deleted = file.delete();


            Log.e("delte file", deleted+"");


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    ArrayList<GPS>  readFromFile() throws Exception {

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
                    Log.e("fahim string",  builder.append(receivedText).toString());

                }
                output = builder.toString();

                inputStream.close();
            }

        } catch (FileNotFoundException e) {
            throw new Exception(e.getMessage());
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }


         ArrayList<GPS> list = new ArrayList<>();
         StringTokenizer st = new StringTokenizer(output,";");
         while (st.hasMoreTokens()) {


             StringTokenizer st2 = new StringTokenizer(st.nextElement().toString(),",");

             while (st2.hasMoreTokens()) {
                /* System.out.println("1: "+st2.nextToken());
                 System.out.println("2: "+st2.nextToken());
                 System.out.println("3: "+st2.nextToken());*/

                 try {
                     GPS gps = new GPS(Double.parseDouble(st2.nextToken().toString()), Double.parseDouble(st2.nextToken().toString()), st2.nextToken().toString());
                     list.add(gps);
                     System.out.println("TEST: "+gps.toString());
                 }catch (Exception e){
                     e.printStackTrace();
                 }



             }

         }



         return list;
    }

}
