package de.kp.ames.web.client.openlayers.geometry;

import de.kp.ames.web.client.openlayers.util.JSObject;

/**
 * ...
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Point extends Geometry {

    protected Point(JSObject point){
        super(point);
    }

    /**
     *
     * @param x - double
     * @param y - double
     */
    public Point(double x, double y) {
        super(PointImpl.create(x,y));
    }

    public static Point narrowToPoint(JSObject point){
        return (point == null)?null: new Point(point);
    }

    public double getX(){
        return PointImpl.getX(getJSObject());
    }

    public double getY(){
        return PointImpl.getY(getJSObject());
    }

    public String getId(){
        return PointImpl.getId(getJSObject());
    }

    public void setX(double x){
        PointImpl.setX(getJSObject(), x);
    }

    public void setY(double y){
        PointImpl.setY(getJSObject(), y);
    }

    public double[] getXY(){
        double[] xy = {this.getX(), this.getY()};
        return xy;
    }

    public void setXY(double x, double y){
        this.setX(x);
        this.setY(y);
    }
    
    // __EXTENSION__ Dr. Krusche & Partner PartG
    public void move(double dx, double dy) {
    	PointImpl.move(getJSObject(), dx, dy);
	}
    
}
