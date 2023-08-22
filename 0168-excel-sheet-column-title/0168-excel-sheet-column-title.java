class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            int remainder = columnNumber % 26;
            char charValue = (char) (remainder + 'A');
            result.insert(0, charValue);
            columnNumber /= 26;
        }

        return result.toString();
    }
}