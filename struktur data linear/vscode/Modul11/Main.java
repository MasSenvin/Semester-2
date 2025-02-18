package vscode.Modul11;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

       

        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }
}
