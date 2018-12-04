public class suhu {
    private double from, to;

    public double celcius_to_kelvin(double from){
        to = from + 273.15;
        return to;
    }

    public double celcius_to_fahrenheit(double from){
        to = ((9/5) * from) + 32;
        return to;
    }

    public double celcius_to_reamur(double from){
        to = from * 0.8;
        return to;
    }

    public double fahrenheit_to_celcius(double from){
        to = (5/9) * (from - 32);
        return to;
    }

    public double fahrenheit_to_reamur(double from){
        to = ( from - 32) / 2.25;
        return to;
    }

    public double fahrenheit_to_kelvin(double from){
        to = (5/9) * (from - 32) + 273;
        return to;
    }

    public double kelvin_to_celcius(double from){
        to = from - 273.15;
        return to;
    }

    public double kelvin_to_fahrenheit(double from){
        to = ((from - 273) * (9/5)) + 32;
        return to;
    }

    public double kelvin_to_reamur(double from){
        to = (from - 273.15) * 0.8;
        return to;
    }

    public double reamur_to_celcius(double from){
        to = from * 1.25;
        return to;
    }

    public double reamur_to_fahrenheit(double from){
        to = from * 2.25 + 32;
        return to;
    }

    public double reamur_to_kelvin(double from){
        to = from * 1.25 + 273.15;
        return to;
    }

}
