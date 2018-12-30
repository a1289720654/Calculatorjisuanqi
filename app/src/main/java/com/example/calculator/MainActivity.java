package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText input = null;//显示器初始化
    boolean clear_flag;//显示器是否需要清除

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*实例化按钮*/
        Button button_1 = (Button) findViewById(R.id.button_1);
        Button button_2 = (Button) findViewById(R.id.button_2);
        Button button_3 = (Button) findViewById(R.id.button_3);
        Button button_4 = (Button) findViewById(R.id.button_4);
        Button button_5 = (Button) findViewById(R.id.button_5);
        Button button_6 = (Button) findViewById(R.id.button_6);
        Button button_7 = (Button) findViewById(R.id.button_7);
        Button button_8 = (Button) findViewById(R.id.button_8);
        Button button_9 = (Button) findViewById(R.id.button_9);
        Button button_0 = (Button) findViewById(R.id.button_0);


        Button point = (Button) findViewById(R.id.point);//小数点
        Button equal = (Button) findViewById(R.id.equal);//等于
        Button clear = (Button) findViewById(R.id.clear);//清除
        Button delete = (Button) findViewById(R.id.delete);//删除一个字符
        Button add = (Button) findViewById(R.id.add);//+
        Button minus = (Button) findViewById(R.id.minus);//-
        Button multi = (Button) findViewById(R.id.multi);//*
        Button divide = (Button) findViewById(R.id.divide);//除
        Button sign = (Button) findViewById(R.id.sign);//正负号变化
        Button sqrt = (Button) findViewById(R.id.sqrt);//平方根
        Button percent =(Button)findViewById(R.id.percent);//%
        Button square =(Button)findViewById(R.id.square);//平方
        Button sin =(Button)findViewById(R.id.sin);
        Button cos =(Button)findViewById(R.id.cos);
        /*实例化显示屏*/
        input = (EditText)findViewById(R.id.input);//定义显示屏
        /*监听器*/
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        point.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);
        delete.setOnClickListener(this);
        add.setOnClickListener(this);
        minus.setOnClickListener(this);
        multi.setOnClickListener(this);
        divide.setOnClickListener(this);
        input.setOnClickListener(this);
        sign.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        percent.setOnClickListener(this);
        square.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
    }

    public void onClick(View v) {

        String str = input.getText().toString();//获取字符串
        switch (v.getId()) {
            case R.id.button_0:
            case R.id.button_1:
            case R.id.button_2:
            case R.id.button_3:
            case R.id.button_4:
            case R.id.button_5:
            case R.id.button_6:
            case R.id.button_7:
            case R.id.button_8:
            case R.id.button_9:
            case R.id.point:
                if (clear_flag) {
                    clear_flag = false;
                    str="";
                   //input.setText("");
                }
                input.setText(str + ((Button) v).getText());//获得按钮的test值
                break;
            case R.id.minus:
            case R.id.divide:
            case R.id.multi:
            case R.id.add:
                clear_flag=false;
                input.setText(str + " " + ((Button) v).getText() + " ");//在屏幕显示+，-，*，/，并于字符间有空格
                break;
                /*定义按钮+/-的在显示屏的显示值*/
            case R.id.sign:
                double result1 =0- Double.parseDouble(str);//定义result1为双精度，单精度为float
                String r1=String.valueOf(result1);
                input.setText(r1);
                break;
            case R.id.sqrt:
                if(Double.parseDouble(str)>=0){
                    double result2 =Math.sqrt(Double.parseDouble(str));
                    String r2=String.valueOf(result2);
                    input.setText(r2);
                }else{
                    Toast.makeText(MainActivity.this,"请输入非负数！",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.percent:
                double result3 =0.01* Double.parseDouble(str);
                String r3=String.valueOf(result3);
                input.setText(r3);
                break;
            case R.id.square:
                double result4 =Math.pow(Double.parseDouble(str),2);
                String r4=String.valueOf(result4);
                input.setText(r4);
                break;
            case R.id.sin:
                double result5 =Math.sin(Double.parseDouble(str));
                String r5=String.valueOf(result5);
                input.setText(r5);
                break;
            case R.id.cos:
                double result6 =Math.cos(Double.parseDouble(str));
                String r6=String.valueOf(result6);
                input.setText(r6);
                break;
            case R.id.delete:
                input.setText(str.substring(0, str.length() - 1));//从字符串的0位置开始，索引到字符串的倒数第二个字符串
                break;
            case R.id.clear:
                clear_flag = false;
                input.setText("");
                break;
            case R.id.equal:
                getResult();
                break;
        }
    }

    private void getResult() {
        String exp = input.getText().toString();
        /*如果字符串不存在空格，返回原字符串的值*/
        if (!exp.contains(" ")) {
            return;
        }
      /*  if (clear_flag) {
            clear_flag = false;
            return;
        }*/
        clear_flag = true;
        double result = 0.0;
        String s1 = exp.substring(0, exp.indexOf(" ")); //获取运算符前面的字符串
        String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
        String s2 = exp.substring(exp.indexOf(" ") + 3);//获取运算符后面的字符串
        if (!s1.equals(" ") && !s2.equals(" ")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            switch (op) {
                case "+":
                    result = d1 + d2;
                    break;
                case "-":
                    result = d1 - d2;
                    break;
                case "*":
                    result = d1 * d2;
                    break;
                case "/":
                    if (d2 == 0) {
                        Toast.makeText(MainActivity.this, "除数不能为0", Toast.LENGTH_SHORT).show();
                    } else {
                        result = d1 / d2;
                    }
                    break;
                }
                //判断第一个字符是否为小数点，如果是小数点自动变为0.x,如果用正负号转换，自动变为-0.x
            if (s1.charAt(0)=='.') {
                d1=0+d1;
            }
            if(s2.charAt(0)=='.'){
                d2=0+d2;
            }
            if(s1.charAt(0)!='-'){
                d1=0-d1;
            }

            input.setText(String.valueOf(result));//把运算结果输出到显示屏

        } else if(s1.charAt(0)!='-'){
            String s = exp.substring(2, exp.indexOf(" "));
            double d1 =0- Double.parseDouble(s);
        }else if(s2.charAt(0)!='-'){
            String s = exp.substring(exp.indexOf(" ") + 4);
            double d2 =0- Double.parseDouble(s);
        }else
            return;

        }
    }





