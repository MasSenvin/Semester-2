package vscode.proyek.fiks;

public class MyListNode {
    private Object data;
        private MyListNode next;

        public MyListNode(Object data) {
            this.data = data;
            this.next = null;
        }

        public Object getData() {
            return data;
        }

        public MyListNode getNext() {
            return next;
        }

        public void setNext(MyListNode next) {
            this.next = next;
        }
    }


