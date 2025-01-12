package main.java.Entity;

import java.math.BigDecimal;

public class Numbers {
    private final BigDecimal value;

    public Numbers(String value){
        try {
            this.value = new BigDecimal(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format" + value);
        }
    }

   public Numbers(BigDecimal value){
        if (value == null){
            throw new IllegalArgumentException("Invalid number format");
        }
        else{
            this.value = value;
        }
   }

   public BigDecimal getValue(){
        return value;
   }

   public boolean isPositive(){
        return value.compareTo(BigDecimal.ZERO) > 0;
   }

   public boolean isNegative(){
        return value.compareTo(BigDecimal.ZERO) < 0;
   }

   public boolean isZero(){
        return value.compareTo(BigDecimal.ZERO) == 0;
   }

   public boolean isEqual(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Numbers number = (Numbers) obj;
        return this.value.compareTo(number.getValue()) == 0;
   }

   public String toString(){
        return value.toString();
   }
}
