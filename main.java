
package project;
public class main {

    public static void main(String[] args) {
        Cabinet C =new Cabinet(6);

        for(int i=0;i<10000;i++)
            if(IsPrime(i))C.Add(i);


            C.Display();
            System.out.print("--------------\n");
            double routine=C.Routine();
            if(routine>0.5)
                System.out.printf("there is no routine\n");
            else
                System.out.printf("there is routine\n");

            System.out.printf("%f\n",routine);


    }
     public static boolean IsPrime(int n){
        if(n==2||n==3)return true;
        else{
            if(n%2==0||n%3==0)return false;
        for(int i=1;i<n-6;){
            i+=4;
            if(n%i==0)return false;
            i+=2;
            if(n%i==0)return false;
        }
        }
        return true;
    } 
}

