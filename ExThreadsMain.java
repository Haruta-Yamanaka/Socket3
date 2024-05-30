package basic.KADAI;
import java.util.Random;
public class ExThreadsMain {
public static void main(String[] args){
Random r = new Random();
CountNumberOfDivisor[] cnd = new CountNumberOfDivisor[10];
Thread[] th = new Thread[cnd.length];
System.out.println("Now starting.....");
for(int i = 0;i < cnd.length;i++){
    if(i<3){
        cnd[i] = new CountNumberOfDivisor(r.nextInt(100000));
    }
    else if(i<6){
        cnd[i] = new CountNumberOfDivisor(r.nextInt(10000));
    }
    else{
        cnd[i] = new CountNumberOfDivisor(r.nextInt(1000));
    }
    cnd[i].setString((char)(97+i)+"-Tread-Chan");
    th[i] = new Thread(cnd[i]);
    th[i].start();
}
System.out.println("Finish.");
}
}
