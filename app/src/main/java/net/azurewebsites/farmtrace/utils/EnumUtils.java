package net.azurewebsites.farmtrace.utils;

/**
 * Created by sebichondo on 8/27/15.
 */
public class EnumUtils {
    public class FertilizerType {
        public static final int Anyhdrous = 0;
        public static final int Dry = 1;
        public static final int Liquid =2;
        public static final int Micronutrients = 3;
    }

    public class ChemicalType{
        public static final int Insecticide=0;
        public static final int Fungicide=1;
    }

    public class FertilizerNutrientType{
        public static final int NPK=0;
        public static final int TSP=1;
        public static final int DAP=2;
        public static final int CAN=3;
        public static final int ASN=4;
    }

    public class ChemicalActiveIngeredient{
        public static final int Thiamethoxam=0;
        public static final int Difenoconazole=1;
        public static final int Imidacloprid=2;
        public static final int AlphaCrypermethrin=3;
        public static final int Acetamiprid=4;
        public static final int Spinosad=5;
        public static final int Lambdacyhalothrin=6;
        public static final int Cryromazine=7;
        public static final int Spiromesifen=8;
        public static final int BacillusThuringiensis=9;
        public static final int Azadiraachtin=10;
        public static final int Pyrethrins=11;
        public static final int Tebuconazole=12;
        public static final int Carbendazim=13;
        public static final int Manozeb=14;
        public static final int Chlorothalonil=15;
        public static final int CopperOxychloride=16;
        public static final int Sulphur=17;
        public static final int Azoxystrobin=18;
        public static final int MonoDipotassiumPhosphates=19;
    }

    public class UserType{
        public static final int FieldEmployee=0;
        public static final int HeadOfficeEmployee=1;
        public static final int Farmer=2;
        public static final int Buyer=3;
    }

    public class FarmingActivityType{
        public static final int Planting=0;
        public static final int FertilizerApplication=1;
        public static final int CropProtection=2;
        public static final int Irrigation=3;
    }
}
