package pl.slemjet.algorithms.simple;

public class StringReverser {

    public static String reverseStringRecursive(String string){
        if(!string.isEmpty()){
            return reverseStringRecursive(string.substring(1)) + string.substring(0, 1);
        }
        return "";
    }
}
