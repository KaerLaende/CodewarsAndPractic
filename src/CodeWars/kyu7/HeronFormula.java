package CodeWars.kyu7;
/*
Write function heron which calculates the area of a triangle with sides a, b, and c (x, y, z in COBOL).

s=(a+b+c)/2



Output should have 2 digits precision.
 */
public class HeronFormula {
    public static double heron(double a, double b, double c) {
        return Math.sqrt(square(a, b, c)*(square(a, b, c)-a)*(square(a, b, c)-b)*(square(a, b, c)-c));
    }
    public static double square(double a, double b, double c){
        return (a+b+c)/2;
    }


}
