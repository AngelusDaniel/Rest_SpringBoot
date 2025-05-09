package AngelusDaniel.request.converters;

import AngelusDaniel.exception.UnsupportedMathOperationException;

public abstract class NumberConverter {

  public static Double convertToDouble(String strNumber) throws UnsupportedMathOperationException{
    if(strNumber == null || strNumber.isEmpty())
      throw new UnsupportedMathOperationException("Please set a numeric value");
    String number = strNumber.replaceAll(",", ".");
    return Double.parseDouble(number);
  }

  public static boolean isNumeric(String strNumber) {
    if(strNumber == null || strNumber.isEmpty()) return false;
    String number = strNumber.replaceAll(",", ".");
    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
  }
}
