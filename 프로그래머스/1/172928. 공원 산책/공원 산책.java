class Solution {
    public int[] solution(String[] park, String[] routes) {
        Point point = null;
        for (int i = 0; i < park.length; i++) {
            int idx = park[i].indexOf("S");
            if (-1 < idx) {
                point = new Point(i, idx);        
                break;
            }
        }
        
        int hLength = park.length;
        int wLength = park[0].length();
        for (int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            Point newPoint = point.newPoint(route[0], route[1]);
            
            if (newPoint.h < 0 || newPoint.w < 0 || 
                hLength <= newPoint.h || wLength <= newPoint.w) continue;
            if (!point.isMovable(newPoint, park)) continue;
            
            point = newPoint;
        }
        
        return new int[] {point.h, point.w};
    }
    
    static class Point {
        int h;
        int w;
        
        public Point(int h, int w) {
            this.h = h;
            this.w = w;
        }
        
        public Point newPoint(String op, String strDistance) {
            int distance = 1 * Integer.parseInt(strDistance);
            int[] ops = switch (op) {
                case "N" -> new int[] {distance, 0};
                case "W" -> new int[] {0, distance};
                case "S" -> new int[] {-distance, 0};
                default -> new int[] {0, -distance};
            };
            return new Point(h - ops[0], w - ops[1]);
        }
        
        public boolean isMovable(Point other, String[] park) {
            int maxH = Math.max(this.h, other.h);
            int minH = Math.min(this.h, other.h);
            int maxW = Math.max(this.w, other.w);
            int minW = Math.min(this.w, other.w);
            
            for (int i = minH; i <= maxH; i++) {
                if (park[i].charAt(minW) == 'X') {
                    return false;
                }
            }
            for (int i = minW; i <= maxW; i++) {
                if (park[minH].charAt(i) == 'X') {
                    return false;
                }
            }
            return true;
        }
        
        public String toString() {
            return "(" + h + "," + w + ")";
        }
    }
}