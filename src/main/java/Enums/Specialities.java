package Enums;

public enum Specialities {

    CARDIOLOGY("CARDIOLOGY"),
    RADIOLOGY("RADIOLOGY"),
    DERMATOLOGY("DERMATOLOGY");
    private  String text;

    Specialities( String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }


}
