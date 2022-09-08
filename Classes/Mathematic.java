package Classes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Mathematic {

    static final int INF = (int) 1e9;
    static final long INFL = (long) 1e18;
    static final double EPS = 1e-9;
    static final double PI = Math.PI;
    static final double E = Math.E;
    static final int[] dx = { 1, 0, -1, 0 };
    static final int[] dy = { 0, 1, 0, -1 };
    static final BigInteger ZERO = BigInteger.ZERO;
    static final BigInteger ONE = BigInteger.ONE;
    static final BigInteger TWO = BigInteger.TWO;
    static final BigInteger THREE = BigInteger.TEN;

    // greatest common divisor
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // extended Euclidean Algorithm
    static int gcdExtended(int a, int b, int x, int y) {
        if (a == 0) {
            x = 0;
            y = 1;
            return b;
        }
        int x1 = 1, y1 = 1;
        int gcd = gcdExtended(b % a, a, x1, y1);
        x = y1 - (b / a) * x1;
        y = x1;

        return gcd;
    }

    // least common multiple
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // modular exponentiation
    public static int pow(int a, int b, int mod) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    // modular inverse
    public static int inv(int a, int mod) {
        return pow(a, mod - 2, mod);
    }

    // Euler's totient function
    public static int phi(int n) {
        int res = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0)
                    n /= i;
                res -= res / i;
            }
        }
        if (n > 1)
            res -= res / n;
        return res;
    }

    // Sieve of Eratosthenes
    public static boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i <= n; i++)
            prime[i] = true;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i)
                    prime[j] = false;
            }
        }
        return prime;
    }

    // Sieve of Eratosthenes
    public static int[] sieve(int n, int start) {
        int[] prime = new int[n + 1];
        for (int i = start; i <= n; i++)
            prime[i] = i;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == i) {
                for (int j = i * i; j <= n; j += i)
                    if (prime[j] == j)
                        prime[j] = i;
            }
        }
        return prime;
    }

    // fibonacci
    static int fib(int n) {
        int a = 0, b = 1, t;
        for (int i = 1; i <= n; i++) {
            t = a + b;
            b = a;
            a = t;
        }
        return a;
    }

    // factorial
    static int fact(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++)
            res *= i;
        return res;
    }

    // all factors of a number
    static List<Integer> factors(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                res.add(i);
                if (i * i != n)
                    res.add(n / i);
            }
        }
        return res;
    }

    // factor of a number
    static void factor(int num) {
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // nCr
    static int nCr(int n, int r) {
        return fact(n) / (fact(r) * fact(n - r));
    }

    // nPr
    static int nPr(int n, int r) {
        return fact(n) / fact(n - r);
    }

    // Catalan number
    static int catalan(int n) {
        return nCr(2 * n, n) / (n + 1);
    }

    // isPrime
    static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i < n; i++) { // -> (int i = 2; i < n;)
            if (n % i == 0) {
                return false;
            }
            return true;
        }
        return true;
    }

    // Chinese Remainder Theorem
    static int[] crt(int[] num, int[] rem, int k) {
        int prod = 1;
        for (int i = 0; i < k; i++)
            prod *= num[i];

        int result = 0;
        for (int i = 0; i < k; i++) {
            int pp = prod / num[i];
            result += rem[i] * inv(pp, num[i]) * pp;
        }
        return new int[] { result % prod, prod };
    }

    // Chinese Remainder Theorem
    // k is size of num[] and rem[]. Returns the smallest
    // number x such that:
    // x % num[0] = rem[0],
    // x % num[1] = rem[1],
    // ..................
    // x % num[k-2] = rem[k-1]
    // Assumption: Numbers in num[] are pairwise coprime
    // (gcd for every pair is 1)
    static int findMinX(int num[], int rem[], int k) {
        int x = 1; // Initialize result
        // As per the Chinese remainder theorem,
        // this loop will always break.
        while (true) {
            // Check if remainder of x % num[j] is
            // rem[j] or not (for all j from 0 to k-1)
            int j;
            for (j = 0; j < k; j++)
                if (x % num[j] != rem[j])
                    break;
            // If all remainders matched, we found x
            if (j == k)
                return x;
            // Else try next number
            x++;
        }
    }

    static class Line {

        static final double INF = 1e9, EPS = 1e-9;

        double a, b, c;

        Line(Point p, Point q) {
            if (Math.abs(p.x - q.x) < EPS) {
                a = 1;
                b = 0;
                c = -p.x;
            } else {
                a = (p.y - q.y) / (q.x - p.x);
                b = 1.0;
                c = -(a * p.x + p.y);
            }

        }

        Line(Point p, double m) {
            a = -m;
            b = 1;
            c = -(a * p.x + p.y);
        }

        boolean parallel(Line l) {
            return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS;
        }

        boolean same(Line l) {
            return parallel(l) && Math.abs(c - l.c) < EPS;
        }

        Point intersect(Line l) {
            if (parallel(l))
                return null;
            double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
            double y;
            if (Math.abs(b) < EPS)
                y = -l.a * x - l.c;
            else
                y = -a * x - c;

            return new Point(x, y);
        }

        Point closestPoint(Point p) {
            if (Math.abs(b) < EPS)
                return new Point(-c, p.y);
            if (Math.abs(a) < EPS)
                return new Point(p.x, -c);
            return intersect(new Line(p, 1 / a));
        }

    }

    static class LineSegment {

        Point p, q;

        LineSegment(Point a, Point b) {
            p = a;
            q = b;
        }

        boolean intersect(LineSegment ls) {
            Line l1 = new Line(p, q), l2 = new Line(ls.p, ls.q);
            if (l1.parallel(l2)) {
                if (l1.same(l2))
                    return p.between(ls.p, ls.q) || q.between(ls.p, ls.q) || ls.p.between(p, q) || ls.q.between(p, q);
                return false;
            }
            Point c = l1.intersect(l2);
            return c.between(p, q) && c.between(ls.p, ls.q);
        }

    }

    static class Point implements Comparable<Point> {

        static final double EPS = 1e-9;

        double x, y;

        Point(double a, double b) {
            x = a;
            y = b;
        }

        public int compareTo(Point p) {
            if (Math.abs(x - p.x) > EPS)
                return x > p.x ? 1 : -1;
            if (Math.abs(y - p.y) > EPS)
                return y > p.y ? 1 : -1;
            return 0;
        }

        public double dist(Point p) {
            return Math.sqrt(sq(x - p.x) + sq(y - p.y));
        }

        static double sq(double x) {
            return x * x;
        }

        Point rotate(double angle) {
            double c = Math.cos(angle), s = Math.sin(angle);
            return new Point(x * c - y * s, x * s + y * c);
        }
        // for integer points and rotation by 90 (counterclockwise) : swap x and y,
        // negate x

        Point rotate(double theta, Point p) // rotate around p
        {
            Vector v = new Vector(p, new Point(0, 0));
            return translate(v).rotate(theta).translate(v.reverse());
        }

        Point translate(Vector v) {
            return new Point(x + v.x, y + v.y);
        }

        Point reflectionPoint(Line l) // reflection point of p on line l
        {
            Point p = l.closestPoint(this);
            Vector v = new Vector(this, p);
            return this.translate(v).translate(v);
        }

        boolean between(Point p, Point q) {
            return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
                    && y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
        }

        // returns true if it is on the line defined by a and b
        boolean onLine(Point a, Point b) {
            if (a.compareTo(b) == 0)
                return compareTo(a) == 0;
            return Math.abs(new Vector(a, b).cross(new Vector(a, this))) < EPS;
        }

        boolean onSegment(Point a, Point b) {
            if (a.compareTo(b) == 0)
                return compareTo(a) == 0;
            return onRay(a, b) && onRay(b, a);
        }

        // returns true if it is on the ray whose start point is a and passes through b
        boolean onRay(Point a, Point b) {
            if (a.compareTo(b) == 0)
                return compareTo(a) == 0;
            return new Vector(a, b).normalize().equals(new Vector(a, this).normalize()); // implement equals()
        }

        // returns true if it is on the left side of Line pq
        // add EPS to LHS if on-line points are accepted
        static boolean ccw(Point p, Point q, Point r) {
            return new Vector(p, q).cross(new Vector(p, r)) > 0;
        }

        static boolean collinear(Point p, Point q, Point r) {
            return Math.abs(new Vector(p, q).cross(new Vector(p, r))) < EPS;
        }

        static double angle(Point a, Point o, Point b) // angle AOB
        {
            Vector oa = new Vector(o, a), ob = new Vector(o, b);
            return Math.acos(oa.dot(ob) / Math.sqrt(oa.norm2() * ob.norm2()));
        }

        static double distToLine(Point p, Point a, Point b) // distance between point p and a line defined by points a,
                                                            // b (a != b)
        {
            if (a.compareTo(b) == 0)
                return p.dist(a);
            // formula: c = a + u * ab
            Vector ap = new Vector(a, p), ab = new Vector(a, b);
            double u = ap.dot(ab) / ab.norm2();
            Point c = a.translate(ab.scale(u));
            return p.dist(c);
        }
        // Another way: find closest point and calculate the distance between it and p

        static double distToLineSegment(Point p, Point a, Point b) {
            Vector ap = new Vector(a, p), ab = new Vector(a, b);
            double u = ap.dot(ab) / ab.norm2();
            if (u < 0.0)
                return p.dist(a);
            if (u > 1.0)
                return p.dist(b);
            return distToLine(p, a, b);
        }
        // Another way: find closest point and calculate the distance between it and p
    }

    static class Vector {

        double x, y;

        Vector(double a, double b) {
            x = a;
            y = b;
        }

        Vector(Point a, Point b) {
            this(b.x - a.x, b.y - a.y);
        }

        Vector scale(double s) {
            return new Vector(x * s, y * s);
        } // s is a non-negative value

        double dot(Vector v) {
            return (x * v.x + y * v.y);
        }

        double cross(Vector v) {
            return x * v.y - y * v.x;
        }

        double norm2() {
            return x * x + y * y;
        }

        Vector reverse() {
            return new Vector(-x, -y);
        }

        Vector normalize() {
            double d = Math.sqrt(norm2());
            return scale(1 / d);
        }
    }

    static class Triangle {

        static final double EPS = 1e-9;

        Point a, b, c;
        double ab, bc, ca;

        Triangle(Point p, Point q, Point r) // counter clockwise
        {
            a = p;
            if (Point.ccw(p, q, r)) {
                b = q;
                c = r;
            } else {
                b = r;
                c = q;
            }

            ab = a.dist(b);
            bc = b.dist(c);
            ca = c.dist(a);
        }

        double perm() {
            return ab + bc + ca;
        }

        double area() {
            double s = (ab + bc + ca) / 2.0;
            return Math.sqrt(s * (s - ab) * (s - bc) * (s - ca)); // take care of overflow
        }

        double area2() {
            return Math.abs(a.x * b.y - a.y * b.x + b.x * c.y - b.y * c.x + c.x * a.y - c.y * a.x) / 2.0;
        }
        /*
         * 1. We take the absolute value because the result could be negative which
         * means that point q is on
         * the left of the line segment pr
         * 
         * 2. If the area is zero, then the three points are collinear
         */

        double area3() {
            return 0.5 * ((c.y - a.y) * (b.x - a.x) - (b.y - a.y) * (c.x - a.x));
        }

        double rInCircle() {
            return area() / (perm() * 0.5);
        }

        Point inCenter() // intersection of the angle bisectors, center of inscribed circle
        {
            double p = perm();
            double x = (a.x * bc + b.x * ca + c.x * ab) / p;
            double y = (a.y * bc + b.y * ca + c.y * ab) / p;
            return new Point(x, y);
        }

        double rCircumCircle() {
            return ab * bc * ca / (4.0 * area());
        }

        Point circumCircle() {
            double bax = b.x - a.x, bay = b.y - a.y;
            double cax = c.x - a.x, cay = c.y - a.y;

            double e = bax * (a.x + b.x) + bay * (a.y + b.y);
            double f = cax * (a.x + c.x) + cay * (a.y + c.y);
            double g = 2.0 * (bax * (c.y - b.y) - bay * (c.x - b.x));

            if (Math.abs(g) < EPS)
                return null;

            return new Point((cay * e - bay * f) / g, (bax * f - cax * e) / g);

        }

        static double areaMedians(double ma, double mb, double mc) // medians of the triangle
        {
            double s = (ma + mb + mc) / 2.0; // max(ma, mb, mc) < s
            return Math.sqrt(s * (s - ma) * (s - mb) * (s - mc)) * 4.0 / 3.0;
        }

        static double areaHeights(double ha, double hb, double hc) // heights of the triangle
        {
            double ha_1 = 1.0 / ha, hb_1 = 1.0 / hb, hc_1 = 1.0 / hc;
            double s = (ha_1 + hb_1 + hc_1) / 2.0;
            return 1.0 / (Math.sqrt(s * (s - ha_1) * (s - hb_1) * (s - hc_1)) * 4.0);
        }

    }

    static class Rectangle {

        static final double EPS = 1e-9;

        Point ll, ur;

        Rectangle(Point a, Point b) {
            ll = a;
            ur = b;
        }

        double area() {
            return (ur.x - ll.x) * (ur.y - ll.y);
        }

        boolean contains(Point p) {
            return p.x <= ur.x + EPS && p.x + EPS >= ll.x && p.y <= ur.y + EPS && p.y + EPS >= ll.y;
        }

        Rectangle intersect(Rectangle r) {
            Point ll = new Point(Math.max(this.ll.x, r.ll.x), Math.max(this.ll.y, r.ll.y));
            Point ur = new Point(Math.min(this.ur.x, r.ur.x), Math.min(this.ur.y, r.ur.y));
            if (Math.abs(ur.x - ll.x) > EPS && Math.abs(ur.y - ll.y) > EPS && this.contains(ll) && this.contains(ur)
                    && r.contains(ll) && r.contains(ur))
                return new Rectangle(ll, ur);
            return null;
        }

    }

    static class Circle { // equation: (x-c.x)^2 + (y-c.y)^2 = r^2

        static final double EPS = 1e-9;

        Point c;
        double r;

        Circle(Point p, double k) {
            c = p;
            r = k;
        }

        int inside(Point p) // 1 for inside, 0 for border, -1 for outside
        {
            double d = p.dist(c);

            return d + EPS < r ? 1 : Math.abs(d - r) < EPS ? 0 : -1;
        }

        double circum() {
            return 2 * Math.PI * r;
        }

        double area() {
            return Math.PI * r * r;
        }

        double arcLength(double deg) {
            return deg / 360.0 * circum(); // major and minor chords exist
        }

        double chordLength(double deg) {
            return 2 * r * Math.sin(degToRad(deg) / 2.0);
        }

        double sectorArea(double deg) {
            return deg / 360.0 * area();
        }

        double segmentArea(double deg) {
            return sectorArea(deg) - r * r * Math.sin(degToRad(deg)) / 2.0;
        }

        boolean intersect(Circle cir) {
            return c.dist(cir.c) <= r + cir.r + EPS && c.dist(cir.c) + EPS >= Math.abs(r - cir.r);
        }

        // returns true if the circle intersects with the line segment defined by p and
        // q at one or two points
        boolean intersect(Point p, Point q) {
            Line l = new Line(p, q);
            if (Math.abs(l.b) < EPS) {
                if (l.c * l.c > r * r + EPS)
                    return false;

                double y1 = Math.sqrt(Math.abs(r * r - l.c * l.c)), y2 = -y1;
                return new Point(-l.c, y1).between(p, q) && new Point(-l.c, y2).between(p, q);
            }
            double a = l.a * l.a + 1, b = 2 * l.a * l.c, c = l.c * l.c - r * r;
            if (b * b - 4 * a * c + EPS < 0)
                return false;

            double dis = b * b - 4 * a * c;

            double x1 = (-b + Math.sqrt(dis)) / (2.0 * a), x2 = (-b - Math.sqrt(dis)) / (2.0 * a);

            return new Point(x1, -l.a * x1 - l.c).between(p, q) || new Point(x2, -l.a * x2 - l.c).between(p, q);
        }

        static Point findCenter(Point p, Point q, double r) // for the other center, swap p and q
        {
            double d2 = (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
            double det = r * r / d2 - 0.25;
            if (Math.abs(det) < EPS)
                det = 0.0;
            if (det < 0.0)
                return null;
            double h = Math.sqrt(det);
            return new Point((p.x + q.x) / 2.0 + (p.y - q.y) * h, (p.y + q.y) / 2.0 + (q.x - p.x) * h);
        }

    }

    static double degToRad(double d) {
        return d * Math.PI / 180.0;
    }

    static double radToDeg(double r) {
        return r * 180.0 / Math.PI;
    }

    static double round(double x) {
        return Math.round(x * 1000) / 1000.0; // use it because of -0.000
    }

    // Volume of Tetrahedron WXYZ, sides order: WX, WY, WZ, XY, XZ, YZ
    static double vTetra(double[] sides) {
        double[] coff = new double[3];
        for (int i = 0; i < 3; i++)
            coff[i] = sides[(i + 1) % 3] * sides[(i + 1) % 3] + sides[(i + 2) % 3] * sides[(i + 2) % 3]
                    - sides[5 - i] * sides[5 - i];

        double sqrt = 4 * sides[0] * sides[0] * sides[1] * sides[1] * sides[2] * sides[2];
        for (int i = 0; i < 3; i++)
            sqrt -= coff[i] * coff[i] * sides[i] * sides[i];
        sqrt += coff[0] * coff[1] * coff[2];

        return 1 / 12.0 * Math.sqrt(sqrt);
    }

    static class PrimeFactorization {

        static ArrayList<Integer> primes; // generated by sieve

        /*
         * 1. Generating a list of prime factors of N
         */
        static ArrayList<Integer> primeFactors(int N) // O(sqrt(N) / ln sqrt(N))
        {
            ArrayList<Integer> factors = new ArrayList<Integer>(); // take abs(N) in case of -ve integers
            int idx = 0, p = primes.get(idx);

            while (p * p <= N) {
                while (N % p == 0) {
                    factors.add(p);
                    N /= p;
                }
                p = primes.get(++idx);
            }

            if (N != 1) // last prime factor may be > sqrt(N)
                factors.add(N); // for integers whose largest prime factor has a power of 1
            return factors;
        }

        /*
         * 2. Sum of divisors of N
         */
        static long sumDiv(int N) {
            int idx = 0, p = primes.get(0);
            long ans = 1;
            while (p * p <= N) {
                int e = 0;
                while (N % p == 0) {
                    N /= p;
                    ++e;
                }
                ans *= (pow(p, e + 1) - 1) / (p - 1);
                p = primes.get(++idx);
            }
            if (N != 1)
                ans *= (pow(N, 2) - 1) / (N - 1);
            return ans;
        }

        /*
         * 3. Euler's Totient Function (Number of positive integers < N relatively prime
         * to N)
         */
        static int phi(int N) {
            int ans = N, idx = 0, p = primes.get(0);
            while (p * p <= N) {
                if (N % p == 0)
                    ans -= ans / p;
                while (N % p == 0)
                    N /= p;
                p = primes.get(++idx);
            }

            if (N != 1)
                ans -= ans / N;
            return ans;
        }

        static long pow(long a, int n) {
            long res = 1;
            while (n != 0) {
                if ((n & 1) == 1)
                    res *= a;
                a *= a;
                n >>= 1;
            }
            return res;
        }
    }

    static class ValidSquare {

        public static boolean validSquare_rev1(int[] p1, int[] p2, int[] p3, int[] p4) {
            return isSquare(p1, p2, p3, p4);
        }

        static boolean isSquare(int[]... points) {
            Map<Double, Integer> map = new HashMap<>();
            double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == j)
                        continue;
                    double dist = dist(points[i], points[j]);
                    map.put(dist, map.getOrDefault(dist, 0) + 1);
                    min = Math.min(min, dist);
                    max = Math.max(max, dist);
                }
            }
            return map.size() == 2 && map.get(min) == 8 && map.get(max) == 4;
        }

        static double dist(int[] a, int[] b) {
            int x = a[0] - b[0];
            int y = a[1] - b[1];
            return Math.sqrt(x * x + y * y);
        }

        public boolean validSquare(int[]... points) {
            Map<Double, List<String>> map = new HashMap<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == j)
                        continue;
                    if (Arrays.equals(points[i], points[j]))
                        return false;
                    double dist = dist(points[i], points[j]);
                    map.computeIfAbsent(dist, val -> new ArrayList<>()).add(String.format("%d -> %d", i, j));
                }
            }
            Set<Integer> req = new HashSet<>();
            req.add(8);
            req.add(4);
            if (map.size() != 2)
                return false;
            for (List<String> line : map.values()) {
                req.remove(line.size());
            }
            return req.isEmpty();
        }
    }
}
