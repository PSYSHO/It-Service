package test.task;

import java.util.Arrays;

public class Task1 {
    String[] a1;
    String[] a2;
    String[] r;


    public Task1() {
    }

    public Task1(String[] a1, String[] a2) {
        this.a1 = a1;
        this.a2 = a2;
        r = new String[a1.length];
    }

    public String[] getA1() {
        return a1;
    }

    public void setA1(String[] a1) {
        this.a1 = a1;
        r = new String[a1.length];
    }

    public String[] getA2() {
        return a2;
    }

    public void setA2(String[] a2) {
        this.a2 = a2;
    }

    public String[] getR() {
        return r;
    }

    public void setR(String[] r) {
        this.r = r;
    }

    public String[] sort(){
       for(int i =0;i<a1.length;i++){
           for(int j=0;j<a2.length;j++){
               if(a2[j].contains(a1[i]))r[i]=a1[i];
           }
       }
       r =unNull(r);
       Arrays.sort(r);
       return r;
    }
    private  static String[] unNull(String[] r){
        int lastElement =0;
        for(int i =0;i<r.length;i++){
            if(r[i]!=null){
                r[lastElement]=r[i];
                lastElement++;
            }
        }
        String[] notNullArray = Arrays.copyOf(r,lastElement);
        return  notNullArray;
    }

}
