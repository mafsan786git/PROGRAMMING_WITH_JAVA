

public class TowerOfHanoi {

    public static void main(String[] args) {
        TowerH(3, 'S', 'D', 'H');
    }


    public static void TowerH(int n,char src,char dst,char help){
        if(n == 0)
            return ;
        TowerH(n-1, src, help,dst);
        System.out.println("Move "+n + " disk from " + src + " to " + dst);
        TowerH(n-1, help, dst, src);
    } 
    
}
