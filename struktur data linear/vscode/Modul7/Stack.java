package vscode.Modul7;



public class Stack {
    private int[] elemen;
    private int front, size ;


    public Stack() {
        this.elemen = new int[10];
        this.front = -1;
        this.size = 0;
    }
    public boolean push(int x){
        if (size < elemen.length) {
            size = size++;
            front++;
            elemen[front]= x;
            System.out.println("Data : " + x + " Dipush ke stack");
            return true;
        }else{
            return false;
        }
    }
    public int size(){
        return front +1;
    }
    public boolean isEmpty(){
        return front == -1;
    }
    public int pop(){
        if (front == -1) {
            System.out.println(" Stack kosong");
        }
        int x = elemen[front];
        front--;
        System.out.println("Data "+ x + " dipop dari stack");
        return x;

    }
    public String toString(){
        if (front == -1) {
            System.out.println(" Stack Kosong");
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i <= front; i++) {
            if (i == front) {
                builder.append(elemen[i]);
            }else{
                builder.append(elemen[i] + ", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
    
    

}
