package com.eiu.vcarpool.constants;

public class Class1 {
    
    public int myPoints(String a, String b){
     int result = 0;
     
     String[] lower = a.split(":"); 
     String[] upper = b.split(":");
     int h1 = Integer.parseInt(lower[0]);
     int h2 = Integer.parseInt(upper[0]);
        int m1 = Integer.parseInt(lower[0]);
        int m2 = Integer.parseInt(upper[0]);
        int s1 = Integer.parseInt(lower[0]);
        int s2 = Integer.parseInt(upper[0]);
        for(int i= h1; i<=h2; i++){
            for(int l=0;l<(m2-m1);l++){
            for(int j=m1; j <=59; j++){
                for(int m=0;m<(s2-s1);m++){
                for(int k=s1;k<=59; k++){
                    System.out.println(i+":"+j+":"+k);
                    String answer = i+":"+j+":"+k;
                    if(k>s2){
                        break;
                    }
                    
                }
                    
                }
//                if(j>m2){
//                    break;
//                }
            }
        }
        }
       
     return result;
    }
    
    public static void main(String args[]){
        Class1 class1 = new Class1();
        class1.myPoints("09:11:11", "11:12:16");
    }
    
}