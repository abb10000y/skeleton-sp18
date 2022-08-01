public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet P) {
        double d_x = Math.abs(this.xxPos - P.xxPos);
        double d_y = Math.abs(this.yyPos - P.yyPos);
        double r = Math.sqrt(Math.pow(d_x, 2.0) + Math.pow(d_y, 2.0));
        return r;
    }

    public double calcForceExertedBy(Planet P) {
        //double G = 6.67 / Math.pow(10, 11);
        double F = (G * this.mass * P.mass) / Math.pow(this.calcDistance(P), 2);
        return F;
    }

    public double calcForceExertedByX(Planet P) {
        double F = this.calcForceExertedBy(P) * (P.xxPos - this.xxPos) / this.calcDistance(P);
        return F;
    }

    public double calcForceExertedByY(Planet P) {
        double F = this.calcForceExertedBy(P) * (P.yyPos - this.yyPos) / this.calcDistance(P);
        return F;
    }

    public double calcNetForceExertedByX(Planet[] Ps) {
        double F = 0;
        for (Planet P : Ps) {
            if (this.equals(P) != true) {
                F = F + this.calcForceExertedByX(P);
            }
        }
        return F;
    }

    public double calcNetForceExertedByY(Planet[] Ps) {
        double F = 0;
        for (Planet P : Ps) {
            if (this.equals(P) != true) {
                F = F + this.calcForceExertedByY(P);
            }
        }
        return F;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel = this.xxVel + aX * dt;
        this.yyVel = this.yyVel + aY * dt;
        this.xxPos = this.xxPos + xxVel * dt;
        this.yyPos = this.yyPos + yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
