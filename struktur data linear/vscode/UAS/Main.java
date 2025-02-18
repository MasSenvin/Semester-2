package vscode.UAS;

public class Main {
    public static void main(String[] args) {
        String aku = "Agustinus Kevin YudiPratama";
        Stack stack = new Stack();

        // Mem-push setiap karakter ke dalam stack
        for (int i = 0; i < aku.length(); i++) {
            stack.push(aku.charAt(i));
        }

        // Mempop karakter dari stack satu per satu
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println(); // Untuk baris baru setelah semua karakter dipop
    }
}
