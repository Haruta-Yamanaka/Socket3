package basic.KADAI;

import basic.Threading.CountTenRunnable;

public class CountAZTenRunnable implements Runnable{
    String myAlfabetStr="noalfabet";
public static void main(String[] args){
    

    // CountTenRunnable クラスのインスタンスを作成します。
    CountTenRunnable[] ct = new CountTenRunnable[26];
    Thread[] th = new Thread[26];
    for(int i = 0; i< ct.length;i++){
        ct[i] = new CountTenRunnable();
        String name = (char)(i+97) + "-thread chan";
        ct[i].setAlfabet(name);
        th[i] = new Thread(ct[i]);
        th[i].start();
    }

    System.out.println();

    
    // この try-catch ブロックは、0 から 9 までの値を 500 ミリ秒間隔で出力するループを実行します。
    try {
        for(int i = 0; i < 10; i++) {
            System.out.println("main:i=" + i);
            // メインスレッドを 5   00 ミリ秒間一時停止します。
            Thread.sleep(500);  // ミリ秒単位のスリープ時間
        }
    }
    catch(InterruptedException e) {
        // スレッドが中断された場合は、例外を出力します。
        System.err.println(e);
    }
}



public void setAlfabet(String alfabetstr) {
    myAlfabetStr = alfabetstr;
}

// run メソッドは、新しいスレッドが実行するコードを含みます。
public void run() {
    // この try-catch ブロックは、0 から 9 までの値を 1000 ミリ秒間隔で出力するループを実行します。
    try {
        for(int i = 0; i < 10; i++) {
            System.out.println(myAlfabetStr+" i:" + i);

            // スレッドを 1000 ミリ秒間一時停止します。
            Thread.sleep(1000);  // ミリ秒単位のスリープ時間
        }
    }
    catch(InterruptedException e) {
        // スレッドが中断された場合は、例外を出力します。
        System.err.println(e);
    }
}
}
