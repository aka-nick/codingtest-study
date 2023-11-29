import java.util.*;
import java.util.stream.*;

class Solution {

    public int[] solution(String[] wallpaper) {
        int xSize = wallpaper.length;
        int ySize = wallpaper[0].length();
        
        List<Point> points = IntStream.range(0, xSize)
            .mapToObj(i -> i)
            .flatMap(xidx -> IntStream.range(0, ySize)
                     .filter(yidx -> wallpaper[xidx].charAt(yidx) == '#')
                     .mapToObj(yidx -> new Point(xidx, yidx)))
            .collect(Collectors.toList());
        
        int minX = points.stream()
            .mapToInt(point -> point.x)
            .min().getAsInt();
        int minY = points.stream()
            .mapToInt(point -> point.y)
            .min().getAsInt();
        int maxX = points.stream()
            .mapToInt(point -> point.x)
            .max().getAsInt() + 1;
        int maxY = points.stream()
            .mapToInt(point -> point.y)
            .max().getAsInt() + 1;
        
        return new int[]{ minX, minY, maxX, maxY };
    }

    static class Point {
        int x;
        int y;
        public Point(int nx, int ny) {
            x = nx;
            y = ny;
        }
    }
    
}