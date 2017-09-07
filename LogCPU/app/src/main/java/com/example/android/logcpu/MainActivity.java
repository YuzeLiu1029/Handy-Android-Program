package com.example.android.logcpu;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonBegin = (Button) findViewById(R.id.button_begin);
        buttonBegin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){


                String FileName = "log";
                File myDir = getFilesDir();

                try {
                    File file = new File(myDir,FileName);
                    if(file.exists()){
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fos = new FileOutputStream(file);
                    for(int i = 0; i < 100; i++){
//                        FileOutputStream fos = new FileOutputStream(file);

                        String usageResult = readUsage();
                        String freqResult = getfrequency();
                        //String dashline = "-----------------------------------------\n";

                        fos.write(usageResult.getBytes());
                        fos.write(freqResult.getBytes());
                        //fos.write(dashline.getBytes());
                        //Thread.sleep(100);
                    }

                    fos.flush();
                    fos.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Button buttonStop = (Button) findViewById(R.id.button_stop);
        buttonStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
            }
        });
    }



    private String readUsage() {
        try {
            RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");
            StringBuilder returnStringUsage = new StringBuilder();

            String loadSkip = reader.readLine();

            float result;
            float result1;
            float result2;
            float result3;

            String load = reader.readLine();
            String[] toks = load.split(" +");  // Split on one or more spaces

            long idle1 = Long.parseLong(toks[4]) + Long.parseLong(toks[5]);
            long cpu1 = Long.parseLong(toks[1])+Long.parseLong(toks[2]) + Long.parseLong(toks[3])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);


            load = reader.readLine();
            toks = load.split(" +");

            long idle1_1 = Long.parseLong(toks[4])  + Long.parseLong(toks[5]);
            long cpu1_1 = Long.parseLong(toks[1])+Long.parseLong(toks[2]) + Long.parseLong(toks[3])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

//            long idle1_1 = Long.parseLong(toks[4]);
//            long cpu1_1 = Long.parseLong(toks[1])+Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[5])
//                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);


            load = reader.readLine();
            toks = load.split(" +");

            long idle1_2 = Long.parseLong(toks[4])  + Long.parseLong(toks[5]);
            long cpu1_2 = Long.parseLong(toks[1])+Long.parseLong(toks[2]) + Long.parseLong(toks[3])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

//            long idle1_2 = Long.parseLong(toks[4]);
//            long cpu1_2 = Long.parseLong(toks[1])+Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[5])
//                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);


            load = reader.readLine();
            toks = load.split(" +");

            long idle1_3 = Long.parseLong(toks[4]) + Long.parseLong(toks[5]);
            long cpu1_3 = Long.parseLong(toks[1])+Long.parseLong(toks[2]) + Long.parseLong(toks[3])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

//            long idle1_3 = Long.parseLong(toks[4]);
//            long cpu1_3 = Long.parseLong(toks[1])+Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[5])
//                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);



            try {
                Thread.sleep(100);
            } catch (Exception e) {}

            reader.seek(0);

            loadSkip = reader.readLine();

            load = reader.readLine();
            toks = load.split(" +");
            long idle2 = Long.parseLong(toks[4]) + Long.parseLong(toks[5]);
            long cpu2 = Long.parseLong(toks[1])+Long.parseLong(toks[2]) + Long.parseLong(toks[3])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

//            Log.i("1 Token",toks[0]);
//            Log.i("2 Token",toks[1]);
//            Log.i("3 Token",toks[2]);
//            Log.i("4 Token",toks[3]);
//            Log.i("5 Token",toks[4]);
//            Log.i("6 Token",toks[5]);
//            Log.i("7 Token",toks[6]);
//            Log.i("8 Token",toks[7]);
//            Log.i("9 Token",toks[8]);
//            Log.i("10 Token",toks[9]);

            load = reader.readLine();
            toks = load.split(" +");
            long idle2_1 = Long.parseLong(toks[4]) + Long.parseLong(toks[5]);
            long cpu2_1 = Long.parseLong(toks[1])+Long.parseLong(toks[2]) + Long.parseLong(toks[3])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);


            load = reader.readLine();
            toks = load.split(" +");
            long idle2_2 = Long.parseLong(toks[4]) + Long.parseLong(toks[5]);
            long cpu2_2 = Long.parseLong(toks[1])+Long.parseLong(toks[2]) + Long.parseLong(toks[3])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);


            load = reader.readLine();
            toks = load.split(" +");
            long idle2_3 = Long.parseLong(toks[4]) + Long.parseLong(toks[5]);
            long cpu2_3 = Long.parseLong(toks[1])+Long.parseLong(toks[2]) + Long.parseLong(toks[3])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);


            if(((cpu2 + idle2) - (cpu1 + idle1)) != 0){
                result = (float)(cpu2 - cpu1) / ((cpu2 + idle2) - (cpu1 + idle1));
                Log.i("CPU usage", String.valueOf(result));

                //returnStringUsage.append("CPU0 : ");
                returnStringUsage.append(String.valueOf(result));
                returnStringUsage.append(" ");
                //returnStringUsage.append(System.getProperty("line.separator"));
            } else {
                Log.i("CPU usage", "idle");

                //returnStringUsage.append("CPU0 : ");
                //returnStringUsage.append("idle");
                //returnStringUsage.append(System.getProperty("line.separator"));
                returnStringUsage.append("0");
                returnStringUsage.append(" ");
            }


            if(((cpu2_1 + idle2_1) - (cpu1_1 + idle1_1)) != 0){
                result1 = (float)(cpu2_1 - cpu1_1) / ((cpu2_1 + idle2_1) - (cpu1_1 + idle1_1));
                Log.i("CPU usage", String.valueOf(result1));

                //returnStringUsage.append("CPU1 : ");
                returnStringUsage.append(String.valueOf(result1));
                returnStringUsage.append(" ");
                //returnStringUsage.append(System.getProperty("line.separator"));
            } else {
                Log.i("CPU usage", "idle");

//                returnStringUsage.append("CPU1 : ");
//                returnStringUsage.append("idle");
//                returnStringUsage.append(System.getProperty("line.separator"));
                returnStringUsage.append("0");
                returnStringUsage.append(" ");
            }

            if(((cpu2_2 + idle2_2) - (cpu1_2 + idle1_2)) != 0){
                result2 = (float)(cpu2_2 - cpu1_2) / ((cpu2_2 + idle2_2) - (cpu1_2 + idle1_2));
                Log.i("CPU usage", String.valueOf(result2));

                //returnStringUsage.append("CPU2 : ");
                returnStringUsage.append(String.valueOf(result2));
                returnStringUsage.append(" ");
                //returnStringUsage.append(System.getProperty("line.separator"));
            } else {
                Log.i("CPU usage", "idle");

//                returnStringUsage.append("CPU2 : ");
//                returnStringUsage.append("idle");
//                returnStringUsage.append(System.getProperty("line.separator"));
                returnStringUsage.append("0");
                returnStringUsage.append(" ");
            }

            if(((cpu2_3 + idle2_3) - (cpu1_3 + idle1_3)) != 0){
                result3 = (float)(cpu2_3 - cpu1_3) / ((cpu2_3 + idle2_3) - (cpu1_3 + idle1_3));
                Log.i("CPU usage", String.valueOf(result3));

                //returnStringUsage.append("CPU3 : ");
                returnStringUsage.append(String.valueOf(result3));
                //returnStringUsage.append(" ");
               returnStringUsage.append(System.getProperty("line.separator"));
            } else {
                Log.i("CPU usage", "idle");

//                returnStringUsage.append("CPU3 : ");
//                returnStringUsage.append("idle");
//                returnStringUsage.append(System.getProperty("line.separator"));
                returnStringUsage.append("0");
                returnStringUsage.append(System.getProperty("line.separator"));
            }


            reader.close();
            String finalResult = returnStringUsage.toString();

            return finalResult;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return "error" ;
    }

    private String getfrequency(){
        StringBuilder returnFreq = new StringBuilder();
        try {
            RandomAccessFile fr1 = new RandomAccessFile("/sys/devices/system/cpu/cpu0/online", "r");
            String line1 = fr1.readLine();
            if(line1.equals("1")){
                fr1.close();
                try{
                    RandomAccessFile fr2 = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "r");
                    String line2 = fr2.readLine();
                    Log.i("CPU0 curfreq: ", line2);

                    //returnFreq.append("CPU0 : ");
                    returnFreq.append(line2);
                    returnFreq.append(" ");
                    //returnFreq.append(System.getProperty("line.separator"));

                    fr2.close();
                } catch (IOException e){
                    Log.e("Get curfreq0","error");
                }
            } else {
                Log.i("CPU0 curfreq: ", "idle - 0");

//                returnFreq.append("CPU0 : ");
//                returnFreq.append("idle");
//                returnFreq.append(System.getProperty("line.separator"));
                returnFreq.append("0");
                returnFreq.append(" ");
            }
        } catch (IOException e){
            Log.e("Get online stat0","error");
        }

        try {
            RandomAccessFile fr1 = new RandomAccessFile("/sys/devices/system/cpu/cpu1/online", "r");
            String line1 = fr1.readLine();
            if(line1.equals("1")){
                fr1.close();
                try{
                    RandomAccessFile fr2 = new RandomAccessFile("/sys/devices/system/cpu/cpu1/cpufreq/scaling_cur_freq", "r");
                    String line2 = fr2.readLine();
                    Log.i("CPU1 curfreq: ", line2);

//                    returnFreq.append("CPU1 : ");
                    returnFreq.append(line2);
                    returnFreq.append(" ");
//                    returnFreq.append(System.getProperty("line.separator"));

                    fr2.close();
                } catch (IOException e){
                    Log.e("Get curfreq1","error");
                }
            } else {
                Log.i("CPU1 curfreq: ", "idle - 1");

//                returnFreq.append("CPU1 : ");
//                returnFreq.append("idle");
//                returnFreq.append(System.getProperty("line.separator"));
                returnFreq.append("0");
                returnFreq.append(" ");
            }
        } catch (IOException e){
            Log.e("Get online stat1","error");
        }

        try {
            RandomAccessFile fr1 = new RandomAccessFile("/sys/devices/system/cpu/cpu2/online", "r");
            String line1 = fr1.readLine();
            if(line1.equals("1")){
                fr1.close();
                try{
                    RandomAccessFile fr2 = new RandomAccessFile("/sys/devices/system/cpu/cpu2/cpufreq/scaling_cur_freq", "r");
                    String line2 = fr2.readLine();
                    Log.i("CPU2 curfreq: ", line2);

//                    returnFreq.append("CPU2 : ");
//                    returnFreq.append(line2);
//                    returnFreq.append(System.getProperty("line.separator"));
                    returnFreq.append(line2);
                    returnFreq.append(" ");

                    fr2.close();
                } catch (IOException e){
                    Log.e("Get curfreq2","error");
                }
            } else {
                Log.i("CPU2 curfreq: ", "idle - 2");

//                returnFreq.append("CPU2 : ");
//                returnFreq.append("idle");
//                returnFreq.append(System.getProperty("line.separator"));
                returnFreq.append("0");
                returnFreq.append(" ");
            }
        } catch (IOException e){
            Log.e("Get online stat2","error");
        }

        try {
            RandomAccessFile fr1 = new RandomAccessFile("/sys/devices/system/cpu/cpu3/online", "r");
            String line1 = fr1.readLine();
            if(line1.equals("1")){
                fr1.close();
                try{
                    RandomAccessFile fr2 = new RandomAccessFile("/sys/devices/system/cpu/cpu3/cpufreq/scaling_cur_freq", "r");
                    String line2 = fr2.readLine();
                    Log.i("CPU3 curfreq: ", line2);

//                    returnFreq.append("CPU3 : ");
//                    returnFreq.append(line2);
//                    returnFreq.append(System.getProperty("line.separator"));
                    returnFreq.append(line2);
                    returnFreq.append(System.getProperty("line.separator"));

                    fr2.close();
                } catch (IOException e){
                    Log.e("Get curfreq3","error");
                }
            } else {
                Log.i("CPU3 curfreq: ", "idle - 3");

//                returnFreq.append("CPU3 : ");
//                returnFreq.append("idle");
//                returnFreq.append(System.getProperty("line.separator"));
                returnFreq.append("0");
                returnFreq.append(System.getProperty("line.separator"));

            }
        } catch (IOException e){
            Log.e("Get online stat3","error");
        }
        return returnFreq.toString();
    }


}



