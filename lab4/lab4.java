package LAB4;
import java.util.*;
abstract class Robber{
    //can't create the object for abstract class
    //Partially completed --> because object can't be created
    //can have abstract method+non-abstracting methods
    //Abstract Method only have the method call/not the method definition

    //As per the program
   void RobbingClass(){
        System.out.println("A normal Method with no Abstract Keyword"+"MScAI&ML");
    }
    abstract void RowHouses(int[] arr);
    abstract void RoundHouses(int[] arr);
    abstract void SquareHouses(int[] arr);
    abstract void MuliHouseBuilding();
    //default method
    public void MachineLearning(){
        System.out.println("I am in confusion in liking Machine Learning");
    }
}
class JAVAProfessionalRobber extends Robber{
    public void RowHouses(int[] arr){
        System.out.print("It's ROWHOUSE Robbers ");
        int even=0,odd=0;
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                even+=arr[i];
            }else{
                odd+=arr[i];
            }
        }
        if (even>odd){
           System.out.println(even);
        }else{
            System.out.println(odd);
        }

    }
   public void RoundHouses(int[] arr){
        System.out.print("IT'S FROM ROUNDHOUSES ROBBER ");
       int even=0,odd=0;
       for(int i=0;i<arr.length;i++){
           if(i%2==0 && i!=arr.length-1){
               even+=arr[i];
           }else{
               //odd summation
               odd+=arr[i];
           }
       }
       if(odd>even){
           System.out.println(odd);
       }
       else{
           System.out.println(even);
       }

   }
    public void SquareHouses(int[] arr){
        int even=arr[0]+arr[2],odd=arr[1]=arr[3];
        System.out.println("---IT's SQUARE ROBBER:---------");

        if(even>odd){
            System.out.println("the maximum robber money is:"+even);
        }else{
            System.out.println("the maximum robber money is:"+odd);
        }

    }
    public void MuliHouseBuilding(){
System.out.println("Multiple HouseBuilding");
    }
}


public class lab4 {
    public static void main(String[] args){
        //System.out.println("Abstract Concepts");
        JAVAProfessionalRobber ref_var=new JAVAProfessionalRobber();
        int [] arr={1,2,3,4};
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Size of the array:");
        int n=sc.nextInt();


        //Create the array
        int [] Arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter the element at index "+i+"=");
           Arr[i] =sc.nextInt();

        }
        ref_var.RowHouses(Arr);
        ref_var.RoundHouses(Arr);
        if(n==4) {
            ref_var.SquareHouses(Arr);
        }
       // ref_var.RowHouses(arr);

    }

}
