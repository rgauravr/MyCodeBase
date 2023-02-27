public class subString {
    // function to find repeating elements

    public void subString(String str) {

        char[] arr = str.toCharArray();
        if (str.length() >= 1) {
            String s = new String();
            for (int l = 1; l <= str.length(); l++) {
                for (int i = 0; i <= str.length() - l; i++) {
                    for (int j = i; j <= l + i - 1; j++) {
                        s = s + String.valueOf(arr[j]);
                    }
                    System.out.print(s+ "  ");
                    s = "";
                }

            }
        }
    }


    // Driver code
    public static void main(String args[]) {
        String str = "abcd";
        new subString().subString(str);
    }

}
