package com.me.Table;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Bean {
  String col1;
  String col2;
  Integer col3;
}
