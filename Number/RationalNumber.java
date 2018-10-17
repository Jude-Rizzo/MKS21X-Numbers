
public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  * the numerator
   the denominator
  */

  int nume;
  int deno;
  public RationalNumber(int nume, int deno){
    super(nume*1.0 / deno);
    this.nume = nume;
    this.deno = deno;
  }

  public double getValue(){
    return (nume * 1.0) / (deno*1.0);
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return nume;
  }

  public int getDenominator(){
    return deno;
  }

  public RationalNumber reciprocal(){
    return new RationalNumber(deno, nume);
  }
  /**
  *true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return nume == deno;
  }



  public String toString(){
    return "" + nume + "/" + deno;
  }


  private static int gcd(int a, int b){
    if(a == 0 || b == 0)
      return 0;
    if( a >= b){
      while (b>0){
        a = b;
        b = (a%b);
      }

    return a;
  }
    while (a >0){
      b = a;
      a = (b%a);
    }
    return b;
  }



  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    nume = nume/(gcd(nume, deno));
    deno = deno/gcd(nume, deno);
  }



  /******************Operations!!!!****************/


  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(nume * other.getNumerator(), deno * other.getDenominator());
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return this.multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    RationalNumber ans = new RationalNumber(other.getNumerator() * deno + nume * other.getDenominator(), deno * other.getDenominator());
    ans.reduce();
    return ans;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return this.add(other.multiply(new RationalNumber(-1, -1)));
  }
}
