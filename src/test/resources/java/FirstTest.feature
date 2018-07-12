Feature: Calculating
  Scenario Outline: First test
  Given two numbers <a> and <b>
  When we try to find sum of our numbers
  Then result should be <c>
    Examples:
   |c|a|b|
  |0|0|0|
  |5|2|3|
  |-5|-2|-3|
  |3.2|1.2|2|
