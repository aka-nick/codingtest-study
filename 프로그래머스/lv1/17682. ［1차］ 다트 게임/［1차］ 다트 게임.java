import java.util.stream.Stream;

class Solution {
    public int solution(String str) {
        // sdt - S : single (^1) / D : double (^2) / T : Triple (^3)
		// bp - * : 보너스(* 2) / # : 패널티(* -1)
        String[] points = str.replaceAll("\\D+", " ").split("\\s+");
		String[] calcs = Stream.of(str.replaceAll("\\d+", " ").split("\\s+")).skip(1).toArray(String[]::new);
        int total = 0;
		double[][] pointSdtBp = new double[points.length][3];
		
		for (int i = 0; i < points.length; i += 1) {
			double point = Long.valueOf(points[i]);
			double sdt = "S".equals(calcs[i].substring(0,1)) ? 1 : ("D".equals(calcs[i].substring(0,1)) ? 2 : 3);
			double bp = calcs[i].length() == 1 ? 1 : ("*".equals(calcs[i].substring(1)) ? 2 : -1);
            
			pointSdtBp[i][0] = point;
			pointSdtBp[i][1] = sdt;
			pointSdtBp[i][2] = bp;
			if (i > 0 && bp == 2) pointSdtBp[i-1][2] *= bp;
		}
		
		for (double[] psb : pointSdtBp) {
			total += Math.pow(psb[0], psb[1]) * psb[2];
		}
		
		return total;
    }
}