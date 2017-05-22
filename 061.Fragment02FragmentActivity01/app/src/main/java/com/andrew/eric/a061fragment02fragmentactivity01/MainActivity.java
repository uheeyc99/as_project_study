package com.andrew.eric.a061fragment02fragmentactivity01;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity  implements View.OnClickListener{
    RadioButton rb1,rb2,rb3;
    RadioGroup rg;
    Fragment fg1,fg2,fg3;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        rb1 = (RadioButton) findViewById(R.id.rb_1);
        rb2 = (RadioButton) findViewById(R.id.rb_2);
        rb3 = (RadioButton) findViewById(R.id.rb_3);

        rg= (RadioGroup) findViewById(R.id.rg);

        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);

        rg.check(R.id.rb_1);

        fragmentManager = getSupportFragmentManager();
        fg1= new Fragment01();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_content,fg1);
        fragmentTransaction.commit();

    }

    @Override
    public void onClick(View v) {
//        fragmentManager = getSupportFragmentManager();  //不需要每次都赋值
        fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId()){
            case R.id.rb_1:
                hideFragment(fragmentTransaction);
                fg1= new Fragment01();
                fragmentTransaction.replace(R.id.fl_content,fg1);
                fragmentTransaction.commit();
                break;

            case R.id.rb_2:
                fg2= new Fragment02();
                fragmentTransaction.replace(R.id.fl_content,fg2);
                fragmentTransaction.commit();
                break;

            case R.id.rb_3:
                fg3= new Fragment03();
                fragmentTransaction.replace(R.id.fl_content,fg3);
                fragmentTransaction.commit();
                break;

        }

    }


    /*
 * 去除（隐藏）所有的Fragment
 * */
    private void hideFragment(FragmentTransaction transaction) {
        if (fg1 != null) {
            //transaction.hide(f1);隐藏方法也可以实现同样的效果，不过我一般使用去除
            transaction.remove(fg1);
        }
        if (fg2 != null) {
            //transaction.hide(f2);
            transaction.remove(fg2);
        }
        if (fg3 != null) {
            //transaction.hide(f3);
            transaction.remove(fg3);
        }


    }
}
