package basic.KADAI;

public class CountNumberOfDivisor implements Runnable{
private int i ;
private int count;
private String name = "Noname";
protected CountNumberOfDivisor(int i){
this.i = i;
count = 0;
}

public void run(){
    
for(int m = 1;m<i;m++){
    if(i%m==0){
        count++;
    }
}
System.out.println(name+" has "+getCount() + " divisor.");
}



public int getCount(){
    return count;
}

public void setString(String str){
    name = str;
}
}
