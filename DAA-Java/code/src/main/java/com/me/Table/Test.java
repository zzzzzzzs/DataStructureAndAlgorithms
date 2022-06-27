package com.me.Table;

import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {
    Table<Bean> table = new Table();
    table.createTable(Bean.class);
    table.insert(Bean.builder().col1("aa").col2(null).col3(111).build());
    table.insert(Bean.builder().col1("bb").col2("bb2").col3(2).build());
    table.insert(Bean.builder().col1("cc").col2("cc3").col3(3).build());
    table.insert(Bean.builder().col1("dd").col2(null).col3(4).build());
    table.insert(Bean.builder().col1("ee").col2("ee5").col3(5).build());
    ArrayList<Bean> aa = table.selectWhere("col1,col2", "aa", null);
    //    table.deleteWhere("col1", "aa");
    //    table.print();
    table.updateWhere("col2", new Object[] {null}, "col2", new Object[] {"dd"});
    //    table.print();
    //    table.sort();
    table.print(aa);
  }
}
