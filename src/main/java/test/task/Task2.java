package test.task;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task2 {
    String Result;
    int numb;

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public String expandedForm(int number){
        numb = number;
        String[] Numbers = Integer.toString(number).split("");
        String result="";
        for(int i=0;i<Numbers.length-1;i++){
            if(Integer.valueOf(Numbers[i])>0){
                for(int j = i;j<Numbers.length-1;j++){
                    Numbers[i] +='0';
                }
            }
        }
        result = Arrays.toString(Numbers);
        result = result.substring(1,result.length()-1).replace(", 0","").replace(","," +");
        //System.out.println(result);
        Result = result;
        return result;
    }
}
