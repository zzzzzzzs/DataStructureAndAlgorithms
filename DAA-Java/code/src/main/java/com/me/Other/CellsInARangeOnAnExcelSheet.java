package com.me.Other;

import java.util.ArrayList;
import java.util.List;

/**
 * Excel 表中某个范围内的单元格
 *
 * https://leetcode-cn.com/contest/weekly-contest-283/problems/cells-in-a-range-on-an-excel-sheet/
 */
public class CellsInARangeOnAnExcelSheet {
  public List<String> cellsInRange(String s) {
    // String[] dict = {};
    List<String> res = new ArrayList<>();
    String[] split = s.split(":");
    int row = (split[1].charAt(0) - 'A') - (split[0].charAt(0) - 'A');
    int col = (split[1].charAt(1) - '1') - (split[0].charAt(1) - '1');
    for (int i = 0; i <= row; i++) {
      for (int j = 0; j <= col; j++) {
        String str = String.valueOf((char)(split[0].charAt(0) + i)) + (char) (split[0].charAt(1) + j);
        res.add(str);
      }
    }
    return res;
  }

  void test() {
    String ss = "U7:X9";
    List<String> cells = cellsInRange(ss);
    System.out.println(cells);
  }

  public static void main(String[] args) {
    new CellsInARangeOnAnExcelSheet().test();
  }
}
