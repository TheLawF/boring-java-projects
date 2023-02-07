package misc.testcode;

import com.github.thelawf.math.MathUtil;
import com.github.thelawf.math.RectangularCoordinate;

import java.util.Random;

public class TestForCode {
    public static void main(String[] args) {
        System.out.println(MathUtil.getPointOnEclipse(RectangularCoordinate.ZERO,
                20, 10, Math.PI / 2));

    }
}
