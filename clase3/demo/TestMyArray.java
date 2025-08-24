public class TestMyArray {
    public static void main(String[] args){
        MyArrayList<String> myArray  = new MyArrayList<String>();
        myArray.add("Objeto 1");
        myArray.add("Objeto 2");
        myArray.add("Objeto 3");
        myArray.add("Objeto 4");
        myArray.add("Objeto 5");
        myArray.add("Objeto 6");
        myArray.add("Objeto 7");
        myArray.add("Objeto 8");
        myArray.add("Objeto 9");
        myArray.add("Objeto 10");
        System.out.println(myArray);

        myArray.delete(4);
        System.out.println(myArray);

        System.out.println(myArray.get(6));
    }
}