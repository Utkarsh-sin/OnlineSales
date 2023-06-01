import java.util.*;
class Probablity{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        

        //take choice from user if they want to get probability for flipping coin or rolling dice
        System.out.println("Enter 1 to check probablity of flipping a coin");
        System.out.println("Enter 2 to check probablity of rolling a dice");
        int choice = sc.nextInt();

        //input no. of events
        System.out.println("Enter number of events");
        int noOfEvents = sc.nextInt();

        HashMap<Integer,Integer> hm =new HashMap<>();

        switch(choice){
            case 1:
                //take input for probability of head and tail in 2D array     
                hm.clear();       
                for(int i=0;i<2;i++){
                    hm.put(sc.nextInt(),sc.nextInt());
                }
                //call function to get rough probability
                coinFlip(noOfEvents,hm);
                break;
            case 2:
                hm.clear();
                for(int i=0;i<6;i++){
                    hm.put(sc.nextInt(),sc.nextInt());
                 }
                rollDice(noOfEvents,hm);
                break;
            default:
                System.out.println("Please enter correct choice");
                
        }
        sc.close();
    }

    public static void coinFlip(int events, HashMap<Integer,Integer> coin){

        //Assumption: 1 represents Head; 2 represents tail
        double probHead = coin.get(1);
        double probTail = coin.get(2);

        //caculate exact proability of head and tail
        double exactHead = events*probHead;
        double exactTail = events*probTail;

        //get random variance is 1% or 2%
        double random = (Math.random()+1)/100 * events;

        //get random sign for positive or negative >0.1?2:0)variance
        int sign =(int) ( Math.random() * 2 + 1);
        double roughHead,roughTail;

        //calculate rough variance based on sign
        if(sign==0 ){
            roughHead= exactHead+random;
            roughTail = exactTail-random;
        } 
        else{
            roughHead= exactHead-random;
            roughTail = exactTail+random;
        }

        System.out.println("No of heads : "+Math.round(roughHead)+"\n"+"No of tails : "+Math.round(roughTail));
        
    }


    public static void rollDice(int events, HashMap<Integer,Integer> dice){

        int prob1 = dice.get(1)*events/100;
        int prob2 = dice.get(2)*events/100;;
        int prob3 = dice.get(3)*events/100;;
        int prob4 = dice.get(4)*events/100;;
        int prob5 = dice.get(5)*events/100;;
        int prob6 = dice.get(6)*events/100;;

        System.out.println("No of 1 : "+prob1+"\n"+"No of 2 : "+prob2+"\n"+"No of 3 : "+prob3+"\n"+"No of 4 : "+prob4+"\n"+"No of 5 : "+prob5+"\n"+"No of 6 : "+prob6+"\n");
       
    }

}