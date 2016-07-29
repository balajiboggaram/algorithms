package ds.arrays;

/**
 * Detect if string has all unique characters or not
 *
 */
public class UniqueCharacterDetector {
    
    public static void main(String args[]) {
        driver();
    }

    /**
     * This solution assumes that given text always ranges with ASCII. 0-256 limit
     * 
     * We maintain a list of boolean values and keep setting true as we see them in the given text. 
     * However, if we encounter a character which is already been seen and updated in the charSet, then we claim that
     * all the characters in the given string are not unique.
     */
    public boolean isUniqueWithAuxSpace(String text) {
        if(text != null && !text.isEmpty()) {
            boolean[] charSet = new boolean[256]; // This assumes only for ASCII range. 
            for(Character c : text.toCharArray()) {
                if(charSet[c] == true) {
                    return false;
                }
                charSet[c] = true;
            }
            return true;
        }
        return false;
    }
    
    public static void driver() {
        UniqueCharacterDetector detector = new UniqueCharacterDetector();
        System.out.println(detector.isUniqueWithAuxSpace("hello")); // false
        System.out.println(detector.isUniqueWithAuxSpace("asdfkljq")); // true
        System.out.println(detector.isUniqueWithAuxSpace(null)); // false
        System.out.println(detector.isUniqueWithAuxSpace("")); // false
        System.out.println(detector.isUniqueWithAuxSpace("qwertyuiopasdfghjklzxcvbnm,."));
        
    }

}
