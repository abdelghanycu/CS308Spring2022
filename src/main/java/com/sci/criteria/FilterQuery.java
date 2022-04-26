package com.sci.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterQuery {

  private String attributeName;
  private Object attributeValue;
  private Operator op;
//  private String type;// int double boolean
}
