import java.util.Scanner;
public class Length
{
  double m=1000;
  double mm=1;
  double cm=10;
  double km=1000000;
  double inch=25.4;
  double yard=914.4;
  double foot=304.8;
  double mile=1609344;
  public Length()
  {}
  public Length(double m, double mm, double cm, double km, double inch, double yard, double foot, double mile)
  {
    this.m=m;
    this.mm=mm;
    this.cm=cm;
    this.km=km;
    this.inch=inch;
    this.yard=yard;
    this.foot=foot;
    this.mile=mile;
  }

  public double convert_metric(double val, double from, double to)
  {
    double res;
    res = val * (from/to);
    return res;
  }

  public static void main(String[]args)
  {
    Length one = new Length();
    Scanner sc = new Scanner(System.in);
    double from=0;
    double val;
    double to=0;
    double res;
    String resultstr="";
    String fromstr;
    String tostr;
    System.out.println("---Converter Metric---");
    System.out.println("masukkan value, convert dari, lalu ukuran yang diinginkan");
    System.out.println("metric units: ");
    System.out.println("-> mm");
    System.out.println("-> cm");
    System.out.println("-> m");
    System.out.println("-> km");
    System.out.println("-> inch");
    System.out.println("-> yard");
    System.out.println("-> foot");
    System.out.println("-> mile");
    System.out.println("");

    System.out.printf("Value input: ");
    val = sc.nextInt();
    sc.nextLine();
    System.out.println("");

    System.out.printf("Convert dari: ");
    fromstr = sc.nextLine();
    switch(fromstr)
    {

      case "mm": from = one.mm;
      break;

      case "cm": from = one.cm;
      break;

      case "m": from = one.m;
      break;

      case "km": from = one.km;
      break;

      case "inch": from = one.inch;
      break;

      case "yard": from = one.yard;
      break;

      case "foot": from = one.foot;
      break;

      case "mile": from = one.mile;
      break;
    }

    System.out.printf("Convert ke: ");
    tostr = sc.nextLine();
    switch(tostr)
    {
      case "mm": to = one.mm;
      resultstr = "mm";
      break;

      case "cm": to = one.cm;
      resultstr = "cm";
      break;

      case "m": to = one.m;
      resultstr = "m";
      break;

      case "km": to = one.km;
      resultstr = "km";
      break;

      case "inch": to = one.inch;
      resultstr = "inch";
      break;

      case "yard": to = one.yard;
      resultstr = "yard";
      break;

      case "foot": to = one.foot;
      resultstr = "feet";
      break;

      case "mile": to = one.mile;
      resultstr = "mile";
      break;
    }

    res = one.convert_metric(val,from,to);
    System.out.println("");
    System.out.println("Result: " + res + " " + resultstr);

  }

}
