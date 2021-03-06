import org.junit.Assert;
import org.junit.Test;

/**
 * Created by siberis on 12/20/2016.
 */
public class Day8Test {
    @Test
    public void rect() {
        Day8 d = new Day8();
        String in = ".......\n" +
                ".......\n" +
                ".......";
        String out = "###....\n" +
                "###....\n" +
                ".......";
        Assert.assertEquals(out, d.rect("rect 3x2", in));
    }

    @Test
    public void rc() {
        Day8 d = new Day8();
        String in = "###....\n" +
                "###....\n" +
                ".......";
        String out = "#.#....\n" +
                "###....\n" +
                ".#.....";
        Assert.assertEquals(out, d.rc("rotate column x=1 by 1", in));
    }

    @Test
    public void rr() {
        Day8 d = new Day8();
        String in = "#.#....\n" +
                "###....\n" +
                ".#.....";
        String out = "....#.#\n" +
                "###....\n" +
                ".#.....";
        Assert.assertEquals(out, d.rr("rotate row y=0 by 4", in));
    }

    @Test
    public void rc2() {
        Day8 d = new Day8();
        String in = "....#.#\n" +
                "###....\n" +
                ".#.....";
        String out = ".#..#.#\n" +
                "#.#....\n" +
                ".#.....";
        Assert.assertEquals(out, d.rc("rotate column x=1 by 1", in));
    }

    @Test
    public void FinalA() {
        Day8 d = new Day8();
        String in = "..................................................\n" +
                "..................................................\n" +
                "..................................................\n" +
                "..................................................\n" +
                "..................................................\n" +
                "..................................................";
        String out = "..................................................\n" +
                "..................................................\n" +
                "..................................................\n" +
                "..................................................\n" +
                "..................................................\n" +
                "..................................................";
        Assert.assertEquals(123, d.draw(data, in).chars().filter(i->i!='.'&&i!='\n').count());
    }

    @Test
    public void FinalB() {
        Day8 d = new Day8();
        String in = "..................................................\n" +
                "..................................................\n" +
                "..................................................\n" +
                "..................................................\n" +
                "..................................................\n" +
                "..................................................";
        String out = ".##..####.###..#..#.###..####.###....##.###...###.\n" +
                "#..#.#....#..#.#..#.#..#....#.#..#....#.#..#.#....\n" +
                "#..#.###..###..#..#.#..#...#..###.....#.#..#.#....\n" +
                "####.#....#..#.#..#.###...#...#..#....#.###...##..\n" +
                "#..#.#....#..#.#..#.#....#....#..#.#..#.#.......#.\n" +
                "#..#.#....###...##..#....####.###...##..#....###..";
        Assert.assertEquals(out, d.draw(data, in));
    }

    String data = "rect 1x1\n" +
            "rotate row y=0 by 20\n" +
            "rect 1x1\n" +
            "rotate row y=0 by 2\n" +
            "rect 1x1\n" +
            "rotate row y=0 by 3\n" +
            "rect 2x1\n" +
            "rotate row y=0 by 2\n" +
            "rect 1x1\n" +
            "rotate row y=0 by 3\n" +
            "rect 2x1\n" +
            "rotate row y=0 by 2\n" +
            "rect 1x1\n" +
            "rotate row y=0 by 4\n" +
            "rect 2x1\n" +
            "rotate row y=0 by 2\n" +
            "rect 1x1\n" +
            "rotate row y=0 by 2\n" +
            "rect 1x1\n" +
            "rotate row y=0 by 2\n" +
            "rect 1x1\n" +
            "rotate row y=0 by 3\n" +
            "rect 2x1\n" +
            "rotate row y=0 by 2\n" +
            "rect 1x1\n" +
            "rotate row y=0 by 5\n" +
            "rect 1x1\n" +
            "rotate row y=0 by 2\n" +
            "rect 1x1\n" +
            "rotate row y=0 by 6\n" +
            "rect 5x1\n" +
            "rotate row y=0 by 2\n" +
            "rect 1x3\n" +
            "rotate row y=2 by 8\n" +
            "rotate row y=0 by 8\n" +
            "rotate column x=0 by 1\n" +
            "rect 7x1\n" +
            "rotate row y=2 by 24\n" +
            "rotate row y=0 by 20\n" +
            "rotate column x=5 by 1\n" +
            "rotate column x=4 by 2\n" +
            "rotate column x=2 by 2\n" +
            "rotate column x=0 by 1\n" +
            "rect 7x1\n" +
            "rotate column x=34 by 2\n" +
            "rotate column x=22 by 1\n" +
            "rotate column x=15 by 1\n" +
            "rotate row y=2 by 18\n" +
            "rotate row y=0 by 12\n" +
            "rotate column x=8 by 2\n" +
            "rotate column x=7 by 1\n" +
            "rotate column x=5 by 2\n" +
            "rotate column x=2 by 1\n" +
            "rotate column x=0 by 1\n" +
            "rect 9x1\n" +
            "rotate row y=3 by 28\n" +
            "rotate row y=1 by 28\n" +
            "rotate row y=0 by 20\n" +
            "rotate column x=18 by 1\n" +
            "rotate column x=15 by 1\n" +
            "rotate column x=14 by 1\n" +
            "rotate column x=13 by 1\n" +
            "rotate column x=12 by 2\n" +
            "rotate column x=10 by 3\n" +
            "rotate column x=8 by 1\n" +
            "rotate column x=7 by 2\n" +
            "rotate column x=6 by 1\n" +
            "rotate column x=5 by 1\n" +
            "rotate column x=3 by 1\n" +
            "rotate column x=2 by 2\n" +
            "rotate column x=0 by 1\n" +
            "rect 19x1\n" +
            "rotate column x=34 by 2\n" +
            "rotate column x=24 by 1\n" +
            "rotate column x=23 by 1\n" +
            "rotate column x=14 by 1\n" +
            "rotate column x=9 by 2\n" +
            "rotate column x=4 by 2\n" +
            "rotate row y=3 by 5\n" +
            "rotate row y=2 by 3\n" +
            "rotate row y=1 by 7\n" +
            "rotate row y=0 by 5\n" +
            "rotate column x=0 by 2\n" +
            "rect 3x2\n" +
            "rotate column x=16 by 2\n" +
            "rotate row y=3 by 27\n" +
            "rotate row y=2 by 5\n" +
            "rotate row y=0 by 20\n" +
            "rotate column x=8 by 2\n" +
            "rotate column x=7 by 1\n" +
            "rotate column x=5 by 1\n" +
            "rotate column x=3 by 3\n" +
            "rotate column x=2 by 1\n" +
            "rotate column x=1 by 2\n" +
            "rotate column x=0 by 1\n" +
            "rect 9x1\n" +
            "rotate row y=4 by 42\n" +
            "rotate row y=3 by 40\n" +
            "rotate row y=1 by 30\n" +
            "rotate row y=0 by 40\n" +
            "rotate column x=37 by 2\n" +
            "rotate column x=36 by 3\n" +
            "rotate column x=35 by 1\n" +
            "rotate column x=33 by 1\n" +
            "rotate column x=32 by 1\n" +
            "rotate column x=31 by 3\n" +
            "rotate column x=30 by 1\n" +
            "rotate column x=28 by 1\n" +
            "rotate column x=27 by 1\n" +
            "rotate column x=25 by 1\n" +
            "rotate column x=23 by 3\n" +
            "rotate column x=22 by 1\n" +
            "rotate column x=21 by 1\n" +
            "rotate column x=20 by 1\n" +
            "rotate column x=18 by 1\n" +
            "rotate column x=17 by 1\n" +
            "rotate column x=16 by 3\n" +
            "rotate column x=15 by 1\n" +
            "rotate column x=13 by 1\n" +
            "rotate column x=12 by 1\n" +
            "rotate column x=11 by 2\n" +
            "rotate column x=10 by 1\n" +
            "rotate column x=8 by 1\n" +
            "rotate column x=7 by 2\n" +
            "rotate column x=5 by 1\n" +
            "rotate column x=3 by 3\n" +
            "rotate column x=2 by 1\n" +
            "rotate column x=1 by 1\n" +
            "rotate column x=0 by 1\n" +
            "rect 39x1\n" +
            "rotate column x=44 by 2\n" +
            "rotate column x=42 by 2\n" +
            "rotate column x=35 by 5\n" +
            "rotate column x=34 by 2\n" +
            "rotate column x=32 by 2\n" +
            "rotate column x=29 by 2\n" +
            "rotate column x=25 by 5\n" +
            "rotate column x=24 by 2\n" +
            "rotate column x=19 by 2\n" +
            "rotate column x=15 by 4\n" +
            "rotate column x=14 by 2\n" +
            "rotate column x=12 by 3\n" +
            "rotate column x=9 by 2\n" +
            "rotate column x=5 by 5\n" +
            "rotate column x=4 by 2\n" +
            "rotate row y=5 by 5\n" +
            "rotate row y=4 by 38\n" +
            "rotate row y=3 by 10\n" +
            "rotate row y=2 by 46\n" +
            "rotate row y=1 by 10\n" +
            "rotate column x=48 by 4\n" +
            "rotate column x=47 by 3\n" +
            "rotate column x=46 by 3\n" +
            "rotate column x=45 by 1\n" +
            "rotate column x=43 by 1\n" +
            "rotate column x=37 by 5\n" +
            "rotate column x=36 by 5\n" +
            "rotate column x=35 by 4\n" +
            "rotate column x=33 by 1\n" +
            "rotate column x=32 by 5\n" +
            "rotate column x=31 by 5\n" +
            "rotate column x=28 by 5\n" +
            "rotate column x=27 by 5\n" +
            "rotate column x=26 by 3\n" +
            "rotate column x=25 by 4\n" +
            "rotate column x=23 by 1\n" +
            "rotate column x=17 by 5\n" +
            "rotate column x=16 by 5\n" +
            "rotate column x=13 by 1\n" +
            "rotate column x=12 by 5\n" +
            "rotate column x=11 by 5\n" +
            "rotate column x=3 by 1\n" +
            "rotate column x=0 by 1";
}
