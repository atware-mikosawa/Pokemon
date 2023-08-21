package Class;

public class outPut {
    public static void main(String[] args){
        Class instance1 = new Class();
        Class instance2 = new Class();

        instance1.numAdd();
        System.out.println(instance2.getNum());
        Class instance3 = new Class();
        System.out.println(instance3.getNum());
    }
}
