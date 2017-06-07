package com.eric.andrew.eric.a009fileoperation01writeread01;

import android.content.Context;
import android.content.ContextWrapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by eric on 07/06/2017.
 */

public class AndrewFileOperation extends ContextWrapper{
    public AndrewFileOperation(Context base) {
        super(base);
    }

    public  void save(String FileName, String text){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput(FileName, Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                {if(writer!=null) writer.close();}
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    public  String load(String FileName){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = openFileInput(FileName);
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while((line=reader.readLine())!=null){
                content.append(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader !=null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        return content.toString();
    }

}
