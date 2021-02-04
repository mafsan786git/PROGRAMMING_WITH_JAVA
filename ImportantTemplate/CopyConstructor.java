public class CopyConstructor {
    static class Complex{
        int a;
        int b;
        public Complex(int a,int b){
            this.a = a;
            this.b = b;
        }
        public Complex(Complex c1){
            this.a = 2*c1.a;
            this.b = 3*c1.b;
        }
        @Override
        public String toString(){
            return ""+a + " " + b;
        }
    }
    public static void main(String[] args) {
        Complex c1 = new Complex(10, 20);
        System.out.println(c1);
        Complex c2 = new Complex(c1);
        System.out.println(c2);
    }
    
}
