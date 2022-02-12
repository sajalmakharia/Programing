package com.pratise.dp.iteration;

// to find the nth number whose factor can be only 2 or 3 or 5
public class UglyNumber {
    public static void main(String[] args) {
        int n=10;
        int i=1,j=1,k=1;
        int[] ugly = new int[n];
        int next=0;
        /*for(int i1=0;i1<n;i1++){
            next = Math.min(Math.min(2*i,3*j),5*k);
            ugly[i1]=next;
            i=(next==2*i)?++i:i;
            j=(next==3*j)?++j:j;
            k=(next==5*k)?++k:k;
        }
       *//* for(int a=0;a<n;a++){
            System.out.print(ugly[a]+" ");
        }*//*
        System.out.println(ugly[n-1]);*/
        test(8);
    }
    static void test(int number){

            int rem;
            String num="";
            while (number>0) {
                // remainder for check element position
                rem = number % 4;
                switch (rem) {

                    // if number is 1st position in tree
                    case 1:
                        num+='2';
                        break;

                    // if number is 2nd position in tree
                    case 2:
                        num+='3';
                        break;

                    // if number is 3rd position in tree
                    case 3:
                        num+='5';
                        break;

                    // if number is 4th position in tree
                    case 0:
                        num+='7';
                        break;
                }

                if (number % 4 == 0)
                    number--;

                number = number / 4;
            }

        System.out.println( new StringBuilder(num).reverse());
        }

}
