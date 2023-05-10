package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    Point start;
    Point end;

    public Segment(Point start, Point end) {
        if (start==null||end==null||start==end||start.equals(end)) {
            throw new IllegalArgumentException();
        }
        else {
            this.start = start;
            this.end = end;
        }
    }

    double length() {
        double y1 = Math.pow(start.getX()-this.end.getX(),2);
        double y2 = Math.pow(start.getY()-this.end.getY(),2);
        double d = Math.sqrt(y1+y2);

        return d;
    }

    Point middle() {
        double m = (start.getX()+this.end.getX())/2;
        double n = (start.getY()+this.end.getY())/2;

        return new Point(m,n);

    }

    Point intersection(Segment another) {
       double x1 = this.start.getX(), y1 = this.start.getY(),
               x2 = this.end.getX(), y2 = this.end.getY();
       double x3 = another.start.getX(), y3 = another.start.getY(),
               x4 = another.end.getX(), y4 = another.end.getY();
       double d = (x1-x2)*(y3-y4)-(y1-y2)*(x3-x4);
       if (d==0) {
           return null;
       }

       double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
       double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;

       if (xi<Math.min(x1,x2)|| xi>Math.max(x3, x4)){
           return  null;
       }
        if (xi<Math.min(x3,x4)|| xi>Math.max(x3, x4)){
            return  null;
        }


       return new Point(xi,yi);
    }

}
