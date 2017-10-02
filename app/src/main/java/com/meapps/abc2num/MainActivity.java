package com.meapps.abc2num;

import android.content.*;
import android.content.pm.*;
import android.net.*;
import android.os.*;
import android.preference.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.text.*;
import android.view.*;
import android.widget.*;
import com.bumptech.glide.*;
import java.io.*;
import java.net.*;

import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(this);
        int installedVersion = -1;
		try {
			final int VERSION=getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;

            installedVersion = preferences.getInt("install_version", -1);
            if(installedVersion < VERSION) {
                showChangeLogDialog();
                preferences.edit().putInt("install_version", VERSION).commit();
            }
        } catch(PackageManager.NameNotFoundException e) {}

		if(installedVersion == -1) {
			showAboutDialog();
			preferences.edit().putBoolean("first_boot", false).commit();
		}

		final Button deleteAllButton=(Button)findViewById(R.id.delete_all);
		final EditText letterEdit=(EditText)findViewById(R.id.letter_edit);
		final TextView resultText=(TextView)findViewById(R.id.textView);
        deleteAllButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    letterEdit.setText("");
                }
            });
		letterEdit.addTextChangedListener(new TextWatcher(){

                @Override
                public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {
                    // TODO: Implement this method
                }

                @Override
                public void onTextChanged(CharSequence p1, int p2, int p3, int p4) {
                    // TODO: Implement this method
                }

                @Override
                public void afterTextChanged(Editable p1) {
                    final String input=p1.toString().toUpperCase();
                    if(input.isEmpty()) {
                        resultText.setText("");
                        return;
                    }
                    int result=0;
                    boolean isAllLetter=true;

                    for(int now=0;now < input.length();now++) {
                        switch(input.substring(now, now + 1)) {

                            case "A":
                                result += 1;
                                break;
                            case "B":
                                result += 2;
                                break;
                            case "C":
                                result += 3;
                                break;
                            case "D":
                                result += 4;
                                break;
                            case "E":
                                result += 5;
                                break;
                            case "F":
                                result += 6;
                                break;
                            case "G":
                                result += 7;
                                break;
                            case "H":
                                result += 8;
                                break;
                            case "I":
                                result += 9;
                                break;
                            case "J":
                                result += 10;
                                break;
                            case "K":
                                result += 11;
                                break;
                            case "L":
                                result += 12;
                                break;
                            case "M":
                                result += 13;
                                break;
                            case "N":
                                result += 14;
                                break;
                            case "O":
                                result += 15;
                                break;
                            case "P":
                                result += 16;
                                break;
                            case "Q":
                                result += 17;
                                break;
                            case "R":
                                result += 18;
                                break;
                            case "S":
                                result += 19;
                                break;
                            case "T":
                                result += 20;
                                break;
                            case "U":
                                result += 21;
                                break;
                            case "V":
                                result += 22;
                                break;
                            case "W":
                                result += 23;
                                break;
                            case "X":
                                result += 24;
                                break;
                            case "Y":
                                result += 25;
                                break;
                            case "Z":
                                result += 26;
                                break;
                            case " ":
                            case ",":
                            case ".":
                            case "?":
                            case "!":
                            case "\"":
                                break;
                            default:
                                isAllLetter = false;
                        }
                    }
                    resultText.setText(String.valueOf(result));
                    if(!isAllLetter) {
                        letterEdit.setError("已自动忽略非字母！");
                    }

                }
            });
        loadBingImage();
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item_about:
                showAboutDialog();
                break;

            case R.id.item_changelog:
                showChangeLogDialog();
                break;
            default:
        }
        return true;
    }
    private void showAboutDialog() {
        AlertDialog.Builder aboutDialog=new AlertDialog.Builder(this);
        aboutDialog.setCancelable(true).setIcon(R.drawable.ic_launcher)
            .setTitle("关于").setMessage(R.string.about)
            .setNeutralButton("源代码", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface p1, int p2) {
                    Uri uri=Uri.parse("https://github.com/zhaozihanzzh/ABC2Num");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
            })
            .setNegativeButton("好", null).show();
    }
    private void showChangeLogDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        try {
            InputStream is = getAssets().open("changelogs.txt");
            int lenght = is.available();  
            byte[]  buffer = new byte[lenght];  
            is.read(buffer);
            is.close();
            String result = new String(buffer, "utf8");
            builder.setTitle("更新日志").setMessage(result).setPositiveButton("好", null).create().show();
        } catch(IOException e) {} 
    }
    private void loadBingImage() {
        new Thread(new Runnable(){
                @Override
                public void run() {
                    String content = null;
                    String requestURL = "http://guolin.tech/api/bing_pic";
                    HttpURLConnection connection = null;
                    BufferedReader reader = null;
                    try {
                        URL url = new URL(requestURL);
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(8000);
                        connection.setReadTimeout(8000);
                        InputStream in = connection.getInputStream();
                        StringBuilder response = new StringBuilder();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        while ((content = reader.readLine()) != null) {
                            response.append(content);
                        }
                        content = response.toString();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    finally {
                        if (reader != null){
                            try {
                                reader.close();
                            } catch(IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if(connection != null){
                            connection.disconnect();
                        }
                    }
                    showBingImage(content);
                }
            }).start();
    }
    private void showBingImage(final String content){
        runOnUiThread(new Runnable(){
            @Override
            public void run() {
                Glide.with(MainActivity.this).load(content).into((ImageView)findViewById(R.id.bing_image));
            }
        });
    }
}
