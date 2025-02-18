package vscode.Modul7;

public class Main {
    public static void main(String[] args) {
        Stack Stack = new Stack();//1

        Stack.push(23);//2
        Stack.push(45);//3
        Stack.push(56);//4
        System.out.println("Ukuran : "+Stack.size()+ " => "+ Stack.toString());//5


        if (Stack.isEmpty()) //6
            System.out.println("data sudah habis");
        else
            System.out.println("Ukuran : "+Stack.size()+ " => "+Stack.toString());
       

        int e = Stack.pop(); //7
        System.out.println("Data yang di pop : " + e);
        if (Stack.isEmpty())
            System.out.println("data sudah habis");
        else
            System.out.println("Ukuran : "+Stack.size()+ " => "+Stack.toString());
        

         Stack.push(56); //8
        if (Stack.isEmpty())
            System.out.println("data sudah habis");
        else
            System.out.println("Ukuran : "+Stack.size()+ " => "+Stack.toString());

        if (Stack.isEmpty()) //9
            System.out.println("data sudah habis");
        else
            System.out.println("Ukuran : "+Stack.size()+ " => "+Stack.toString());
    }
}
