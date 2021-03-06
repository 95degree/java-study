import cube.Cube;
import plan.CubePlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import plan.Plan;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CubeTest {
    private Cube normalCube;
    private Cube randomCube;

    @BeforeEach
    void createCube() {
        CubePlan cubePlan = new CubePlan();
        normalCube = new Cube(cubePlan.createNormalCubePlanMap());
        randomCube = new Cube(cubePlan.createRandomCubePlanMap());
    }

    @DisplayName("normal 큐브가 잘 만들어지는지 확인")
    @Test
    void createNormalCube() {
        char[][] front = {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}};
        char[][] back = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        char[][] right = {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}};
        char[][] left = {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}};
        char[][] top = {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}};
        char[][] bottom = {{'P', 'P', 'P'}, {'P', 'P', 'P'}, {'P', 'P', 'P'}};

        assertAll(
                () -> assertThat(normalCube.getCubePlanMap().get(Plan.FRONT)).isEqualTo(front),
                () -> assertThat(normalCube.getCubePlanMap().get(Plan.BACK)).isEqualTo(back),
                () -> assertThat(normalCube.getCubePlanMap().get(Plan.RIGHT)).isEqualTo(right),
                () -> assertThat(normalCube.getCubePlanMap().get(Plan.LEFT)).isEqualTo(left),
                () -> assertThat(normalCube.getCubePlanMap().get(Plan.TOP)).isEqualTo(top),
                () -> assertThat(normalCube.getCubePlanMap().get(Plan.BOTTOM)).isEqualTo(bottom)
        );
    }

    @DisplayName("random 큐브와 normal 큐브가 출력이 되는지 확인")
    @Test
    void printCube() {
        System.out.println(normalCube.toString());
        System.out.println();
        System.out.println(randomCube.toString());
    }
}
