import java.util.*;
import java.lang.*;

public class test
{
    public static Queue<Integer> CopyQ(Queue<Integer> q){
        Queue<Integer>  Q = new LinkedList<>();
        int i = q.size();
        while(i-->0){
            int k = q.remove();
            Q.add(k);
            q.add(k);
        }
        return Q;
    }

    public static Queue<Integer> ReverseQR(Queue<Integer> Q){
        if(!Q.isEmpty()){
            int k = Q.remove();
            ReverseQR(Q).add(k);
        }
        return Q;
    }

    public static Queue<Character> ReverseQRC(Queue<Character> Q){
        if(!Q.isEmpty()){
            char k = Q.remove();
            ReverseQRC(Q).add(k);
        }
        return Q;
    }

    public static Queue<Integer> ReverseQC(Queue<Integer> Q){
        Queue<Integer> q = CopyQ(Q);
        return ReverseQR(q);
    }

    public static Queue<Integer> Mirror(Queue<Integer> Q){
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> c = CopyQ(Q);
        Queue<Integer> r = ReverseQC(Q);
        while(!r.isEmpty()){
            q.add(r.remove());
        }
        while(!c.isEmpty()){
            q.add(c.remove());
        }
        return q;
    }

    public static Queue<Integer> ShiftZeroes(Queue<Integer> Q){
        Queue<Integer> q = new LinkedList<>();
        int i = Q.size();
        int j = 0;
        while(i-->0){
            int k = Q.remove();
            if(k!=0){
                q.add(k);
                Q.add(k);
            }
            else{
                Q.add(k);
                j++;
            }
        }
        while(j-->0){
            q.add(0);
        }
        return q;
    }

    public static Queue<Integer> ETE(Queue<Integer> Q){
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> q = ReverseQC(Q);
        int i = 0;
        while(i<Q.size()){
            int k = q.remove();
            if(i%3==0){
                r.add(k);
            }
            q.add(k);
            i++;
        }
        return r;
    }

    public static boolean Anagrams(String a, String b){
        if(a.length()!=b.length()){
            return false;
        }
        else{
            Queue<Character> qa = new LinkedList<Character>();
            Queue<Character> qb = new LinkedList<Character>();
            for(int i=0; i<a.length(); i++){
                qa.add(a.charAt(i));
                qb.add(b.charAt(i));
            }
            ReverseQRC(qb);
            boolean flag = true;
            while(!qa.isEmpty() && flag){
                flag = (qb.remove()==qa.remove())? true: false;
            }
            if(flag){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(Anagrams(a, b));
    }

}
