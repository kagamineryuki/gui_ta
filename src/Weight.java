public class Weight {
    private double from, to;

    public double tonne_to_kg(double from){
        to = from * 1000;
        return to;
    }

    public double tonne_to_g(double from){
        to = from * 1000000;
        return to;
    }

    public double tonne_to_mg(double from){
        to = from * 1000000000;
        return to;
    }

    public double tonne_to_pound(double from){
        to = (from * 1000) / 0.45359237;
        return to;
    }

    public double tonne_to_ounce(double from){
        to = (from * 1000) / 0.0283495231;
        return to;
    }

    public double kg_to_tonne(double from){
        to = from / 1000;
        return to;
    }

    public double kg_to_g(double from){
        to = from * 1000;
        return to;
    }

    public double kg_to_mg(double from){
        to = from * 1000000;
        return to;
    }

    public double kg_to_pound(double from){
        to = from / 0.45359237;
        return to;
    }

    public double kg_to_ounce(double from){
        to = from / 0.0283495231;
        return to;
    }

    public double g_to_tonne(double from){
        to = from / 1000000;
        return to;
    }

    public double g_to_kg(double from){
        to = from / 1000;
        return to;
    }

    public double g_to_mg(double from){
        to = from * 1000;
        return to;
    }

    public double g_to_pound(double from){
        to = (from / 1000)/ 0.45359237;
        return to;
    }

    public double g_to_ounce(double from){
        to = (from / 1000)/ 0.0283495231;
        return to;
    }

    public double mg_to_tonne(double from){
        to = from / 1000000000;
        return to;
    }

    public double mg_to_kg(double from){
        to = from / 1000000;
        return to;
    }

    public double mg_to_g(double from){
        to = from / 1000;
        return to;
    }

    public double mg_to_pound(double from){
        to = (from / 1000000)/ 0.45359237;
        return to;
    }

    public double mg_to_ounce(double from){
        to = (from / 1000000)/ 0.0283495231;
        return to;
    }

    public double pound_to_tonne(double from){
        to = (from * 0.45359237)/ 1000;
        return to;
    }

    public double pound_to_kg(double from){
        to = from * 0.45359237;
        return to;
    }

    public double pound_to_g(double from){
        to = (from * 0.45359237)* 1000;
        return to;
    }

    public double pound_to_mg(double from){
        to = (from * 0.45359237)* 1000000;
        return to;
    }

    public double pound_to_ounce(double from){
        to = (from * 0.45359237)/ 0.0283495231;
        return to;
    }

    public double ounce_to_tonne(double from){
        to = (from * 0.0283495231)/ 1000;
        return to;
    }

    public double ounce_to_kg(double from){
        to = from * 0.0283495231;
        return to;
    }

    public double ounce_to_g(double from){
        to = (from * 0.0283495231)* 1000;
        return to;
    }

    public double ounce_to_mg(double from){
        to = (from * 0.0283495231)* 1000000;
        return to;
    }

    public double ounce_to_pound(double from){
        to = (from * 0.0283495231)/ 0.45359237;
        return to;
    }
}