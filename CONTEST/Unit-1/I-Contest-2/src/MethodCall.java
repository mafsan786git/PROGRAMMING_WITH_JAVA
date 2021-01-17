public class MethodCall {
    public boolean Prime(int a)
    {
        if(a%2 == 0)
            return true;
        return false;
    }
    public static void main(String[] args) {
        MethodCall obj = new MethodCall();
        if(obj.Prime(2))
            System.out.println("Even");
        else
            System.out.println("Odd");
    }
}
