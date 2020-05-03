public class DETest {
    public static void main(String args[]) {
        int gen = 0;
        int maxCycle = 1000;
        Population p = new Population();
        p.Initialize();// 初始化
        while (gen <= maxCycle) {
            p.Mutation();
            p.CrossOver();
            p.Selection();
            gen++;
            p.SaveBest();
        }
    }

}


