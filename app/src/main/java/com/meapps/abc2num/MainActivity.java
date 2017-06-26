package com.meapps.abc2num;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import java.util.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		final Button okButton=(Button)findViewById(R.id.OK_button);
		final EditText letterEdit=(EditText)findViewById(R.id.letter_edit);
		final TextView resultText=(TextView)findViewById(R.id.textView);
		okButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				final String input=letterEdit.getText().toString().toUpperCase();
				if(input.isEmpty()){
					resultText.setText("未发现输入的字母。");
					return;
				}
				int result=0;
				
				for(int now=0;now<input.length();now++){
					switch(input.substring(now,now+1)){
						case "Z":
							result+=26;
							break;
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
						default:
						Toast.makeText(MainActivity.this,"已自动忽略非字母！",Toast.LENGTH_SHORT).show();
						//resultText.setText(input.substring(now,now+1));
					}
				}
				resultText.setText(String.valueOf(result));
			}
		});
    }
}
