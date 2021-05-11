import java.util.*;
import java.io.*;

public class FabricBreakup {
    public static void main(String[] args) throws EmptyStackException{
        java.io.File file = new java.io.File("sampleInputFile.txt");
        try{
            Scanner sc= new Scanner(file);
            int task=sc.nextInt();
            Stack pile= new Stack();
            Stack skip=new Stack();
            int count=0;
            int max=0;
                
            for(int i=0; i<task; i++){
                //pile.print();
                //skip.print();
                //System.out.println("size "+pile.size()+" "+skip.size());

                int number=sc.nextInt();
                int code=sc.nextInt();
                if(code==1){
                    int points=sc.nextInt();
                    if(pile.isEmpty()){
                        count=0;
                        pile.push(points);
                        skip.push(count);
                        //System.out.println("is empty working");
                    }
                    else{
                        max=(int)pile.top();
                        if(points>=max){
                            
                            pile.push(points);
                            count=0;
                            skip.push(count);
                        }
                        else{
                            count=(int)skip.top();
                            skip.pop();
                            count=count+1;
                            skip.push(count);

                        }

                    }

                }
                else{
                    if(pile.isEmpty()){
                        int x=-1;
                        System.out.println(number+" "+x);
                    }
                    else{
                        System.out.println(number+" "+skip.top());
                        skip.pop();
                        pile.pop();
                    }
                }
            }

            
        }
        catch(FileNotFoundException e){
                System.err.format("file not exist");
        }
    }
}