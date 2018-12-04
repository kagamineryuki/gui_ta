public class Metric
{
  private double from, res;
  //private double to;

  //M
  public double m_to_mm(double from){
    res = from*1000;
    return res;
  }

  public double m_to_cm(double from){
    res = from * 100;
    return res;
  }

  public double m_to_m(double from){
    res = from;
    return res;
  }

  public double m_to_km(double from){
    res=from/1000;
    return res;
  }

  public double m_to_in(double from){
    res = from * (1000/25.4);
    return res;
  }

  public double m_to_yard(double from){
    res = from * (1000/914.4);
    return res;
  }

  public double m_to_ft(double from){
    res = from * (1000/314.8);
    return res;
  }

  public double m_to_mile(double from){
    res=from * (1000/1609344);
    return res;
  }




  //mm
  public double mm_to_mm(double from){
    res = from;
    return res;
  }

  public double mm_to_cm(double from){
    res = from /10;
    return res;
  }

  public double mm_to_m(double from){
    res = from/1000;
    return res;
  }

  public double mm_to_km(double from){
    res=from/1000000;
    return res;
  }

  public double mm_to_in(double from){
    res = from / 25.4;
    return res;
  }

  public double mm_to_yard(double from){
    res = from /914.4;
    return res;
  }

  public double mm_to_ft(double from){
    res = from /314.8;
    return res;
  }

  public double mm_to_mile(double from){
    res= from /1609344;
    return res;
  }

  //cm
  public double cm_to_mm(double from){
    res = from*10;
    return res;
  }

  public double cm_to_cm(double from){
    res = from;
    return res;
  }

  public double cm_to_m(double from){
    res = from/100;
    return res;
  }

  public double cm_to_km(double from){
    res=from/100000;
    return res;
  }

  public double cm_to_in(double from){
    res = from * (10/25.4);
    return res;
  }

  public double cm_to_yard(double from){
    res = from * (10/914.4);
    return res;
  }

  public double cm_to_ft(double from){
    res = from * (10/314.8);
    return res;
  }

  public double cm_to_mile(double from){
    res=from * (10/1609344);
    return res;
  }

  //km
  public double km_to_mm(double from){
    res = from*1000000;
    return res;
  }

  public double km_to_cm(double from){
    res = from * 100000;
    return res;
  }

  public double km_to_m(double from){
    res = from * 1000;
    return res;
  }

  public double km_to_km(double from){
    res=from;
    return res;
  }

  public double km_to_in(double from){
    res = from * (1000000/25.4);
    return res;
  }

  public double km_to_yard(double from){
    res = from * (1000000/914.4);
    return res;
  }

  public double km_to_ft(double from){
    res = from * (1000000/314.8);
    return res;
  }

  public double km_to_mile(double from){
    res=from * (1000000/1609344);
    return res;
  }

  //inch
  public double in_to_mm(double from){
    res = from*25.4;
    return res;
  }

  public double in_to_cm(double from){
    res = from * 2.54;
    return res;
  }

  public double in_to_m(double from){
    res = from * (25.4*1000);
    return res;
  }

  public double in_to_km(double from){
    res=from * (25.4/1000000);
    return res;
  }

  public double in_to_in(double from){
    res = from;
    return res;
  }

  public double in_to_yard(double from){
    res = from * (25.4/914.4);
    return res;
  }

  public double in_to_ft(double from){
    res = from * (25.4/314.8);
    return res;
  }

  public double in_to_mile(double from){
    res=from * (25.4/1609344);
    return res;
  }

  //yard

  public double yard_to_mm(double from){
    res = from*914.4;
    return res;
  }

  public double yard_to_cm(double from){
    res = from * 91.44;
    return res;
  }

  public double yard_to_m(double from){
    res = from * (914.4/1000);
    return res;
  }

  public double yard_to_km(double from){
    res=from * (914.4/1000000);
    return res;
  }

  public double yard_to_in(double from){
    res = from * (914.4/25.4);
    return res;
  }

  public double yard_to_yard(double from){
    res = from;
    return res;
  }

  public double yard_to_ft(double from){
    res = from * (914.4/314.8);
    return res;
  }

  public double yard_to_mile(double from){
    res=from * (914.4/1609344);
    return res;
  }


  //foot

  public double ft_to_mm(double from){
    res = from*304.8;
    return res;
  }

  public double ft_to_cm(double from){
    res = from * 30.48;
    return res;
  }

  public double ft_to_m(double from){
    res = from * (304.8/1000);
    return res;
  }

  public double ft_to_km(double from){
    res=from * (304.8/1000000);
    return res;
  }

  public double ft_to_in(double from){
    res = from * (304.8/25.4);
    return res;
  }

  public double ft_to_yard(double from){
    res = from * (304.8/914.4);
    return res;
  }

  public double ft_to_ft(double from){
    res = from;
    return res;
  }

  public double ft_to_mile(double from){
    res=from * (304.8/1609344);
    return res;
  }

  //mile

  public double mile_to_mm(double from){
    res = from*1609344;
    return res;
  }

  public double mile_to_cm(double from){
    res = from * (1609344/10);
    return res;
  }

  public double mile_to_m(double from){
    res = from * (1609344/1000);
    return res;
  }

  public double mile_to_km(double from){
    res=from * (1609344/1000000);
    return res;
  }

  public double mile_to_in(double from){
    res = from * (1609344/25.4);
    return res;
  }

  public double mile_to_yard(double from){
    res = from * (1609344/914.4);
    return res;
  }

  public double mile_to_ft(double from){
    res = from * (1609344/314.8);
    return res;
  }

  public double mile_to_mile(double from){
    res=from;
    return res;
  }
}
