public class Currency {
    private double from, to;

    public double idr_to_usd(double from){
        to = from * 0.0000696995;
        return to;
    }

    public double idr_to_sgd(double from){
        to = from * 0.0000955452;
        return to;
    }

    public double idr_to_aud(double from){
        to = from * 0.0000952752;
        return to;
    }

    public double usd_to_idr(double from){
        to = from * 14351.85;
        return to;
    }

    public double usd_to_sgd(double from){
        to = from * 1.37064;
        return to;
    }

    public double usd_to_aud(double from){
        to = from * 1.36677;
        return to;
    }

    public double sgd_to_idr(double from){
        to = from * 10459.70;
        return to;
    }

    public double sgd_to_usd(double from){
        to = from * 0.729564;
        return to;
    }

    public double sgd_to_aud(double from){
        to = from * 0.996999;
        return to;
    }

    public double aud_to_idr(double from){
        to = from * 10492.43;
        return to;
    }

    public double aud_to_usd(double from){
        to = from * 0.731876;
        return to;
    }

    public double aud_to_sgd(double from){
        to = from * 1.00323;
        return to;
    }
}
