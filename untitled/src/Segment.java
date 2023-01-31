class Segment {
    Point point1, point2,point3,point4;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;

        if (point1.equals(point2)) {
            throw new IllegalArgumentException();
        }
        if (point1 == null || point2 == null) {
            throw new IllegalArgumentException();
        }
        if (point1.getX() == point2.getX() && point1.getY() == point2.getY()) {
            throw new IllegalArgumentException();
        }
    }
    public Point intersection(Segment second) {
        Point point3 = second.point1;
        Point point4 = second.point2;

        double t = ((((point1.getX() - point3.getX()) * (point3.getY() - point4.getY()))
                - ((point1.getY() - point3.getY()) * (point3.getX() - point4.getX())))
                / ((((point1.getX() - point2.getX()) * (point3.getY() - point4.getY()))
                - ((point1.getY() - point2.getY()) * (point3.getX() - point4.getX())))));

        double u = ((((point1.getX() - point3.getX()) * (point1.getY() - point2.getY()))
                - ((point1.getY() - point3.getY()) * (point1.getX() - point2.getX())))
                / ((((point1.getX() - point2.getX()) * (point3.getY() - point4.getY()))
                - ((point1.getY() -point2.getY()) * (point3.getX() - point4.getX())))));

        double x = (point1.getX() + t * (point2.getX() - point1.getX()));
        double y = (point1.getY() + t * (point2.getY() - point1.getY()));


        if (0.0 <= t && t <= 1.0 && 0.0 <= u && u <= 1.0) {
            return new Point(x, y);
        } else {
            return null;
        }
    }
}

