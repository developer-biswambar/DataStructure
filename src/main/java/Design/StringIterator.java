package Design;

/**
 * Design and implement a data structure for a compressed string iterator. The given compressed string will be in
 * the form of each letter followed by a positive integer representing the number of this letter
 * existing in the original uncompressed string.
 * <p>
 * Implement the StringIterator class:
 * <p>
 * next() Returns the next character if the original string still has uncompressed characters, otherwise returns a white space.
 * hasNext() Returns true if there is any letter needs to be uncompressed in the original string, otherwise returns false.
 * <p>
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
public class StringIterator {
  String compressedString;
  Character cur;
  int count;
  int i;

  public StringIterator(String compressedString) {
    this.compressedString = compressedString;
    this.cur = null;
    this.i = 0;
    this.count = 0;
  }

  public char next() {
    if (count == 0) {
      if (i >= compressedString.length()) {return ' ';}
      cur = compressedString.charAt(i++);
      while (i < compressedString.length() && compressedString.charAt(i) >= '0' && compressedString.charAt(i) <= '9') {
        count = 10 * count + (compressedString.charAt(i)-'0');
        i++;
      }
    }
    count--;
    return cur;
  }

  public boolean hasNext() {
    return i < compressedString.length() || count != 0;
  }
}
