package darchi07.sotsuron003;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class design003 extends AppCompatActivity {


    static HashMap<Integer,String> mondai = new HashMap<>();//問題文格納

    Random r = new Random();
    int mon=1;
    TextView mondaisu, Toi, output;
    double starttime = 0,endtime = 0;
    String input="";
    double inputtime= 0;
    private ArrayList<String> arrayLast = new ArrayList<String>();
    int clcount=0;
    int character=0;
    int n ;
    double resulttime=0;//総合時間
    int mojisu=0,gojisu=0;
    int jikken=10;

    static {

        mondai.put(1, "add");  mondai.put(2, "length"); mondai.put(3, "play");    mondai.put(4, "design");  mondai.put(5, "end");
        mondai.put(6, "value");   mondai.put(7, "earth");  mondai.put(8, "test");   mondai.put(9, "dentsu");   mondai.put(10, "vote");
        mondai.put(11, "hat");  mondai.put(12, "italab"); mondai.put(13, "computer");    mondai.put(14, "access");  mondai.put(15, "sit");
        mondai.put(16, "alarm");   mondai.put(17, "sea");  mondai.put(18, "teach");   mondai.put(19, "long");   mondai.put(20, "put");
        mondai.put(21, "string");  mondai.put(22, "glance"); mondai.put(23, "click");    mondai.put(24, "list");  mondai.put(25, "happy");
        mondai.put(26, "wear");   mondai.put(27, "peach");  mondai.put(28, "rock");   mondai.put(29, "lock");   mondai.put(30, "up");
        mondai.put(31, "apple");  mondai.put(32, "cost"); mondai.put(33, "apply");    mondai.put(34, "prove");  mondai.put(35, "skill");
        mondai.put(36, "sense");   mondai.put(37, "power");  mondai.put(38, "sort");   mondai.put(39, "view");   mondai.put(40, "war");
        mondai.put(41, "amuse");  mondai.put(42, "loss"); mondai.put(43, "gaze");    mondai.put(44, "blink");  mondai.put(45, "life");
        mondai.put(46, "class");   mondai.put(47, "jam");  mondai.put(48, "exact");   mondai.put(49, "short");   mondai.put(50, "odd");
        mondai.put(51, "zman");  mondai.put(52, "diet"); mondai.put(53, "joy");    mondai.put(54, "luck");  mondai.put(55, "pain");
        mondai.put(56, "egg");   mondai.put(57, "dog");  mondai.put(58, "door");   mondai.put(59, "milk");   mondai.put(60, "box");
        mondai.put(61, "watch");  mondai.put(62, "map"); mondai.put(63, "lemon");    mondai.put(64, "hard");  mondai.put(65, "camera");
        mondai.put(66, "tree");   mondai.put(67, "fish");  mondai.put(68, "town");   mondai.put(69, "time");   mondai.put(70, "house");
        mondai.put(71, "room");  mondai.put(72, "meal"); mondai.put(73, "sky");    mondai.put(74, "farm");  mondai.put(75, "people");
        mondai.put(76, "cloud");   mondai.put(77, "game");  mondai.put(78, "music");   mondai.put(79, "lie");   mondai.put(80, "cat");
        mondai.put(81, "jr");  mondai.put(82, "video"); mondai.put(83, "ice");    mondai.put(84, "part");  mondai.put(85, "key");
        mondai.put(86, "bell");   mondai.put(87, "fool");  mondai.put(88, "side");   mondai.put(89, "snow");   mondai.put(90, "food");
        mondai.put(91, "answer");  mondai.put(92, "love"); mondai.put(93, "care");    mondai.put(94, "king");  mondai.put(95, "space");
        mondai.put(96, "cut");   mondai.put(97, "become");  mondai.put(98, "lend");   mondai.put(99, "low");   mondai.put(100, "few");
        mondai.put(101, "2015");  mondai.put(102, "exist"); mondai.put(103, "miss");    mondai.put(104, "marry");  mondai.put(105, "mean");
        mondai.put(106, "no");   mondai.put(107, "2016");  mondai.put(108, "enter");   mondai.put(109, "hold");   mondai.put(110, "noon");
        mondai.put(111, "not");  mondai.put(112, "me"); mondai.put(113, "mine");    mondai.put(114, "sing");  mondai.put(115, "catch");
        mondai.put(116, "none");   mondai.put(117, "what");  mondai.put(118, "chance");   mondai.put(119, "east");   mondai.put(120, "north");
        mondai.put(121, "1234");  mondai.put(122, "able"); mondai.put(123, "touch");    mondai.put(124, "west");  mondai.put(125, "south");
        mondai.put(126, "5678");   mondai.put(127, "where");  mondai.put(128, "young");   mondai.put(129, "ill");   mondai.put(130, "today");
        mondai.put(131, "men");  mondai.put(132, "man"); mondai.put(133, "new");    mondai.put(134, "now");  mondai.put(135, "yes");
        mondai.put(136, "9012");   mondai.put(137, "bill");  mondai.put(138, "dance");   mondai.put(139, "know");   mondai.put(140, "corn");
        mondai.put(141, "fox");  mondai.put(142, "hall"); mondai.put(143, "bomb");    mondai.put(144, "japan");  mondai.put(145, "god");
        mondai.put(146, "date");   mondai.put(147, "fill");  mondai.put(148, "quiz");   mondai.put(149, "list");   mondai.put(150, "gas");
        mondai.put(151, "knock");  mondai.put(152, "3456"); mondai.put(153, "holy");    mondai.put(154, "beach");  mondai.put(155, "lazy");
        mondai.put(156, "hello");   mondai.put(157, "crazy");  mondai.put(158, "7890");   mondai.put(159, "and");   mondai.put(160, "when");
        mondai.put(161, "while");  mondai.put(162, "ever"); mondai.put(163, "alone");    mondai.put(164, "once");  mondai.put(165, "then");
        mondai.put(166, "on");   mondai.put(167, "off");  mondai.put(168, "never");   mondai.put(169, "just");   mondai.put(170, "still");
        mondai.put(171, "pen");  mondai.put(172, "campus"); mondai.put(173, "indeed");    mondai.put(174, "all");  mondai.put(175, "long");
        mondai.put(176, "raw");   mondai.put(177, "cute");  mondai.put(178, "wet");   mondai.put(179, "close");   mondai.put(180, "monkey");
        mondai.put(181, "quick");  mondai.put(182, "wild"); mondai.put(183, "blow");    mondai.put(184, "share");  mondai.put(185, "select");
        mondai.put(186, "plate");   mondai.put(187, "yen");  mondai.put(188, "smell");   mondai.put(189, "can");   mondai.put(190, "order");
        mondai.put(191, "gray");  mondai.put(192, "red"); mondai.put(193, "cent");    mondai.put(194, "menu");  mondai.put(195, "center");
        mondai.put(196, "net");   mondai.put(197, "bowl");  mondai.put(198, "lip");   mondai.put(199, "poem");   mondai.put(200, "gram");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        setContentView(R.layout.design003);
        n = r.nextInt(200) + 1;
        Toi = (TextView)findViewById(R.id.mondai);

        Toi.setText("第1問:" + mondai.get(n));
        EditText editText =(EditText)findViewById(R.id.editText);

        starttime = System.nanoTime();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Log.d("未確定","文字列"+s+"スタート"+start+"アフター"+after+"カウント"+count);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               Log.d("未確定","第"+mon+"問"+"文字列"+s+"スタート"+start+"びふぉー"+before+"カウント"+count);
                input = input + "'" + String.valueOf(s)+"'";

                if(before>count){
                    if(count!=0){
                        input = input + "←";
                    }
                    gojisu++;
                }else if (before == count){
                    //input = input + "¥'" + String.valueOf(s)+"¥'";
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Log.d("未確定","文字列"+s);
            }

        });

        editText.setOnKeyListener(new View.OnKeyListener() {
             @Override
             public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    //Log.d("onkey", "onEnter");
                    input = input+"→";
                    onEnter();
                    return false;
                    } else if (event.getAction() == KeyEvent.ACTION_DOWN &&keyCode==KeyEvent.KEYCODE_DEL) {

                    //Log.d("誤字","←が押されたよ！");
                    return false;
                    } else {
                    return false;
                }
             }
          }

        );
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    public void onEnter(){
        EditText editText =(EditText)findViewById(R.id.editText);
        String edit  = editText.getText().toString();

        if(edit.equals(mondai.get(n))){
            //Log.d("文字一致","文字一致");

            if(mon!=jikken){
                endtime = System.nanoTime();
                inputtime = inputtime + endtime-starttime;
                mon++;
                character= character +mondai.get(n).length();
                mojisu=0;
                n = r.nextInt(200) + 1;

                Toi.setText("第" + mon + "問:" + mondai.get(n));
                editText.getEditableText().clear();
                editText.requestFocus();
                //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                //InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                //inputMethodManager.showSoftInput(editText, 0);
                starttime = System.nanoTime();
               // Log.v("実験 ", "総文字数:入力時間, " + (character) + " " + resulttime+"乱数"+n);
            }else if(mon==jikken){
                endtime=System.nanoTime();
                inputtime= inputtime+endtime-starttime;
                character= character +mondai.get(n).length();
                Toi.setText("終了です！");
                resulttime=inputtime/(1000000000);
                Log.v("実験 ", "終了です");
                Log.v("結果 ", "総文字数:入力時間, " + (character+jikken) + " " + resulttime+" 誤入力数:  "+(gojisu-(jikken-1))+" 入力文字 " +input);
            }
        }/*else if(!edit.equals(mondai.get(n))){
            //Log.d("文字", "一致ならず" + mondai.get(n) + "入力" + edit + "→" + edit.equals(mondai.get(n)));
        }*/

    }



}
