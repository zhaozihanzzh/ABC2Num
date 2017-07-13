package com.meapps.abc2num;

import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.text.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.net.*;
import android.preference.*;

public class MainActivity extends AppCompatActivity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(this);
        if(preferences.getBoolean("first_boot",true)){
            showAboutDialog();
            preferences.edit().putBoolean("first_boot",false).commit();
        }
        
		final Button deleteAllButton=(Button)findViewById(R.id.delete_all);
		final EditText letterEdit=(EditText)findViewById(R.id.letter_edit);
		final TextView resultText=(TextView)findViewById(R.id.textView);
        deleteAllButton.setOnClickListener(new View.OnClickListener(){
			@Override
            public void onClick(View view){
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
				if(input.isEmpty()){
					resultText.setText("");
					return;
				}
				int result=0;
                boolean isAllLetter=true;

				for(int now=0;now<input.length();now++){
					switch(input.substring(now,now+1)){
                        
						case "A":
							result+=1;
							break;
						case "B":
							result+=2;
							break;
						case "C":
							result+=3;
							break;
						case "D":
							result+=4;
							break;
						case "E":
							result+=5;
							break;
						case "F":
							result+=6;
							break;
						case "G":
							result+=7;
							break;
						case "H":
							result+=8;
							break;
						case "I":
							result+=9;
							break;
						case "J":
							result+=10;
							break;
						case "K":
							result+=11;
							break;
						case "L":
							result+=12;
							break;
						case "M":
							result+=13;
							break;
						case "N":
							result+=14;
							break;
						case "O":
							result+=15;
							break;
						case "P":
							result+=16;
							break;
						case "Q":
							result+=17;
							break;
						case "R":
							result+=18;
							break;
						case "S":
							result+=19;
							break;
						case "T":
							result+=20;
							break;
						case "U":
							result+=21;
							break;
						case "V":
							result+=22;
							break;
						case "W":
							result+=23;
							break;
						case "X":
							result+=24;
							break;
						case "Y":
							result+=25;
							break;
                        case "Z":
                            result+=26;
							break;
						case " ":
						case ",":
						case ".":
						case "?":
						case "!":
						case "\"":
							break;
						default:
                        isAllLetter=false;
					}
				}
				resultText.setText(String.valueOf(result));
                if(!isAllLetter){
                    letterEdit.setError("已自动忽略非字母！");
                }
			    
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_about:
                showAboutDialog();
                break;
            default:
        }
        return true;
    }
    private void showAboutDialog(){
        AlertDialog.Builder aboutDialog=new AlertDialog.Builder(this);
        aboutDialog.setCancelable(true).setIcon(R.drawable.ic_launcher)
        .setTitle("关于").setMessage(R.string.about)
        .setNeutralButton("源代码",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface p1,int p2){
                Uri uri=Uri.parse("https://github.com/zhaozihanzzh/ABC2Num");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        })
        .setNegativeButton("好",null).show();
    }
}
