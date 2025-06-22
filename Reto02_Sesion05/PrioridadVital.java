public enum PrioridadVital {
    FC, PA, SPO2;

    public static int getOrden(PrioridadVital tipo) {
        switch (tipo) {
            case FC: return 1;
            case PA: return 2;
            case SPO2: return 3;
            default: return 99;
        }
    }
}