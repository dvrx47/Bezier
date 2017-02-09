/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bezier;

/**
 *
 * @author mikolaj
 */
public class Point2d {
    public double x,y;
    public Point2d(double a, double b){
        x = a;
        y = b;
    }
    
    public int intX(){
        return (int) Math.round(x);
    }
    
    public int intY(){
        return (int) Math.round(y);
    }
}
