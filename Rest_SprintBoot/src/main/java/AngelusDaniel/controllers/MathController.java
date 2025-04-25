package AngelusDaniel.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AngelusDaniel.Math.SimpleMath;
import AngelusDaniel.exception.UnsupportedMathOperationException;
import AngelusDaniel.request.converters.NumberConverter;

@RestController
@RequestMapping("/math")
public class MathController {

  private SimpleMath simplemath = new SimpleMath();

  // 8080/math/sum/3/5
  @RequestMapping("/sum/{numberOne}/{numberTwo}")
  public Double sum(
    @PathVariable("numberOne") String numberOne,
    @PathVariable("numberTwo") String numberTwo
  ) throws Exception {
    if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
    return simplemath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  @RequestMapping("/sub/{numberOne}/{numberTwo}")
  public Double sub(
    @PathVariable("numberOne") String numberOne,
    @PathVariable("numberTwo") String numberTwo
  ){
    if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
    return simplemath.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  @RequestMapping("/mult/{numberOne}/{numberTwo}")
  public Double mult(
    @PathVariable("numberOne") String numberOne,
    @PathVariable("numberTwo") String numberTwo
  ){
    if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
    return simplemath.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  @RequestMapping("/div/{numberOne}/{numberTwo}")
  public Double div(
    @PathVariable("numberOne") String numberOne,
    @PathVariable("numberTwo") String numberTwo
  )
  {
    if(!NumberConverter.isNumeric(numberOne) | !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
    return simplemath.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  @RequestMapping("/mean/{numberOne}/{numberTwo}")
  public Double mean(
    @PathVariable("numberOne") String numberOne,
    @PathVariable("numberTwo") String numberTwo
  )
  {
    if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
    return simplemath.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

  @RequestMapping("/sqrt/{number}")
  public Double sqrt(
    @PathVariable("number") String number
  )
  {
    if(!NumberConverter.isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value");
    if(Double.parseDouble(number) < 0) throw new UnsupportedMathOperationException("Please set a positive value");
    return simplemath.sqrt(NumberConverter.convertToDouble(number));
  }

}
