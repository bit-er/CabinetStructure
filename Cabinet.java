
package project;

import java.util.concurrent.ThreadLocalRandom;

public class Cabinet {
public Node Drawers[];
public Node current;
private int len;
public Cabinet(int len){
    Drawers=new Node[len];
    this.len=len;
}   
public boolean isEmpty(){
    for(int i=0;i<len;i++)
        if(Drawers[i]!=null)return false;
    return true;
}
public boolean isEmpty(int draw){
    draw=draw%len;
    if(Drawers[draw]==null)return true;
    return false;
}
public void Add(int data){
    int i=data%len;
    current=Drawers[i];
    Node n=new Node(data);
    if(current==null||current.getData()>=data){
        n.setNext(current);
        Drawers[i]=n;
    }
    else{
    while(current.getNext()!=null&&current.getNext().getData()<data)
        current=current.getNext();
    n.setNext(current.getNext());
    current.setNext(n);
    }
}
public void DeleteAll(){
    for(int i=0;i<len;i++)
        Drawers[i]=null;
}
public void DeleteFromDrawFromFront(int draw){
    draw=draw%len;
    if(Drawers[draw]==null||Drawers[draw].getNext()==null)Drawers[draw]=null;
    else Drawers[draw]=Drawers[draw].getNext();
}
public void DeleteFromDrawFromBack(int draw){
    draw=draw%len;
    current=Drawers[draw];
    Node previous = null;
    if(current==null||current.getNext()==null)Drawers[draw]=null;
    else{
    while(current.getNext()!=null){
        previous=current;
        current=current.getNext();
    }
    previous.setNext(null);
    }
}
public void DeleteFromDrawAtPosition(int draw,int p){
    draw=draw%len;
    current=Drawers[draw];
    if(p--==0){
        Drawers[draw]=Drawers[draw].getNext();
    }
    else{
    while(p--!=0)
        current=current.getNext();
    
    if(current.getNext()!=null)
    current.setNext(current.getNext().getNext());
    else current.setNext(null);
    }
}
public int Search(int data){
    int count=0;
    current=Drawers[data%len];
    while(current!=null){
        if(current.getData()==data)return count;
        current=current.getNext();
        count++;
    }
    return -1;
}
public void Reshape(int len){
    Cabinet C=new Cabinet(len);
   for(int i=0;i<this.len;i++){
        current=Drawers[i];
        while(current!=null){
            C.Add(current.getData());
            current=current.getNext();
        }
    }
   this.Drawers=C.GetDrawers();
   this.len=len;
}
public double Routine(){
        double count[]=new double[len];
        double c=0;
        for(int i=0;i<len;i++){
            Node n=Drawers[i];
            while(n!=null){
                n=n.getNext();
                count[i]++;
                c++;
            }
        }
        double entropy=0;
        for(int i=0;i<len;i++){
            if(count[i]!=0) {
                double n = count[i]/ c;
                entropy += (-n * (Math.log10(n) / Math.log10(len)));
            }
        }
        return entropy;
    }

public void Display(){
    for(int i=0;i<len;i++){
        current=Drawers[i];
        System.out.printf("%d :",i);
        while(current!=null){
            System.out.printf("%d  ",current.getData());
            current=current.getNext();
        }
        System.out.println();
    }
}
public void DisplayDraw(int n){
        current=Drawers[n];
        while(current!=null){
            System.out.printf("%d  ",current.getData());
            current=current.getNext();
        }
}
public Node[] GetDrawers(){
    return this.Drawers;
}
public void SetDrawes(Node[] n){
    this.Drawers=n;
}
}

