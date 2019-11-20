package fr.epsi.jconte.refactoring.model;

// Movie is just a simple data class
public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;
    private java.lang.String _title;
    private int _priceCode;
    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }
    public java.lang.String getTitle() { return _title;}
    public int getPriceCode() { return _priceCode;}
    public void setPriceCode(int newCode) { _priceCode = newCode;}
}
