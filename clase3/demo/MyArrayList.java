public class MyArrayList<T> {
    private T[] myArray;
    private int size;
    private static int default_size=10;

    /**
     * metodo constructor, donde se inicializan los parametross
     * @param size
     */
    public MyArrayList(){
        myArray = (T[]) new Object[default_size];
        size = 0;
    }

    /**
     * agrega un objeto en la ultima pocision de myArray
     * @param object
     * 
     */
    public void add(T object) {
        if(size == myArray.length) {
            increaseSize();
        }    
        myArray[size]=object;
        size++;
        
    }

    /**
     * Borra una pocision del arreglo
     * @param i
     */
    public void delete (int index){
        for(int i =index; i< size; i++){
            if(i +1 != size)
                myArray[i] = myArray[i+1];
            else 
                myArray[i] = null;
        }
        size--;
    }

    public T get(int index){
        return this.myArray[index];
    }

    /**
     * metodo que genera una cadena del arreglo en formato
     * val1, val2, val3
     */
    public String toString(){
        String returnString = "";
        for(int i=0; i<myArray.length; i++){
            returnString += myArray[i] + ",";
        }
        return returnString;
    }

    private void increaseSize(){
        T[] newArray  = (T[]) new Object[myArray.length*2];
        for(int i= 0; i <myArray.length; i++) {
            newArray[i]= myArray[i];
        }
        myArray=newArray;
    }   
}