/**
 * @author zs
 * @date 2022/2/27
 */
public class CountingWordsWithAGivenPrefix {

  public int prefixCount(String[] words, String pref) {
    int num = 0;
    for (String word : words) {
      if (word.length() >= pref.length()) {
        String str = word.substring(0, pref.length());
        if (str.equals(pref)) {
          num += 1;
        }
      }
    }
    return num;
  }

  void test() {
    String[] strs = {"leetcode", "win", "loops", "success"};
    int at = prefixCount(strs, "code");
    System.out.println(at);
  }

  public static void main(String[] args) {
    new CountingWordsWithAGivenPrefix().test();
  }
}
