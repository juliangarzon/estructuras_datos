package clase4.demo;

public class TestList {
    public static void main (String args[]){
        LinkedList myList = new LinkedList();

        System.out.println(myList.size());
        myList.add("objeto 1");
        myList.add("objeto 2");
        myList.add("objeto 3");
        myList.add("objeto 4");
        myList.add("objeto 5");
        myList.add("objeto 6");
        System.out.println(myList.size());
        System.out.println(myList);
        myList.delete(6);  
        System.out.println(myList);
    }
}
