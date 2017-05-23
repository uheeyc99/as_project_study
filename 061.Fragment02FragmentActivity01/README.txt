
01.MainActivity继承自FragmentActivity
02.函数setContentView(R.layout.activity_main)调用布局文件“R.layout.activity_main”；
    布局文件把页面分成三部分 1.fragment 2.用帧占了一个位置 3.include了一个layout
03.fragment利用“android:name”启动了Java类，
    而Java类在启动后在onCreateView里 又通过“android:id”读取了fragment布局文件，真正实现了页面布局


Reference:
http://blog.csdn.net/lmj623565791/article/details/37970961/
