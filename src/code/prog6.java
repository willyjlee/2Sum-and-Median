package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by william_lee on 9/3/16.
 */
public class prog6 {

    //answer: 427
    private static final int NUM = 1000000;
    public static void main(String[]args){


        System.out.println(median());
        System.exit(0);

    }
    public static int median () {
        Scanner in = new Scanner(System.in);

        int a=0;
        int x;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int c=0;c<10000;c++){
            x=in.nextInt();
            if(c==0){
                a=(a+x)%10000;
                arr.add(x);
            }else{
                boolean val=false;
                for(int i=arr.size()-1;i>=0;i--){
                    if(x>arr.get(i)){
                        val=true;
                        arr.add(i+1, x);
                        break;
                    }
                }
                if(!val){
                    arr.add(0, x);
                }
                int m=arr.get((arr.size()-1)/2);
                a=(a+m)%10000;
            }
        }
        return a;

//        int[]arr=new int[10000];
//        int read;
//        int ans=0;
//        for(int i=0;i<10000;i++){
//            read=in.nextInt();
//            if(i==0){
//                arr[0]=read;
//                ans=(ans+arr[0])%10000;
//            }else{
//
//            }
//        }

    }

    public static int sum(){
        Scanner in = new Scanner(System.in);
        HashSet<Long>orig=new HashSet<>();
        for(int i=0;i<NUM;i++){
            orig.add(in.nextLong());
        }
        Long[]arrl=orig.toArray(new Long[orig.size()]);
        long[]arr=new long[arrl.length];
        for(int i=0;i<arrl.length;i++){
            arr[i]=arrl[i].longValue();
        }
        Arrays.sort(arr);

        HashSet<Long>set = new HashSet<>();
        int rind=arr.length-1;
        int ind;
        long at;
        for(int i=0;i<arr.length;i++){
            at=arr[i];
            while(rind>i && at+arr[rind]>10000){
                rind--;
            }
            if(rind>i){
                ind=rind;
                while(ind>i && at+arr[ind]>=-10000){
                    set.add(at+arr[ind]);
                    ind--;
                }
            }else{
                break;
            }
        }
        return set.size();
    }


}
