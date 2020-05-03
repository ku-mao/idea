import java.util.Random;

public class Population {
    public static int NP = 1000;// 种群规模
    public static int size = 10;// 个体的长度
    public static int xMin = -10;// 最小值
    public static int xMax = 10;// 最大值
    public static double F = 0.5;// 变异的控制参数
    public static double CR = 0.8;// 杂交的控制参数

    private double X[][] = new double[NP][size];// 个体
    private double XMutation[][] = new double[NP][size];
    private double XCrossOver[][] = new double[NP][size];
    private double fitness_X[] = new double[NP];// 适应值

    public double[][] getX() {
        return X;
    }

    /**
     * 矩阵的复制
     *x把x复制给个体
     */
    public void setX(double x[][]) {
        for (int i = 0; i < NP; i++) {
            for (int j = 0; j < size; j++) {
                this.X[i][j] = x[i][j];
            }
        }
    }

    public double[] getFitness_X() {
        return fitness_X;
    }

    public void setFitness_X(double[] fitness_X) {
        for (int i = 0; i < NP; i++) {
            this.fitness_X[i] = fitness_X[i];
        }
    }

    public double[][] getXMutation() {
        return XMutation;
    }

    public void setXMutation(double xMutation[][]) {
        for (int i = 0; i < NP; i++) {
            for (int j = 0; j < size; j++) {
                this.XMutation[i][j] = xMutation[i][j];
            }
        }
    }

    public double[][] getXCrossOver() {
        return XCrossOver;
    }

    public void setXCrossOver(double xCrossOver[][]) {
        for (int i = 0; i < NP; i++) {
            for (int j = 0; j < size; j++) {
                this.XCrossOver[i][j] = xCrossOver[i][j];
            }
        }
    }

    /**
     * 适应值的计算
     * XTemp根据个体计算适应值
     */
    public double CalculateFitness(double XTemp[]) {
        double fitness = 0;
        for (int i = 0; i < size; i++) {
            fitness += XTemp[i] * XTemp[i];// 做一个X的平方相加的函数
        }
        return fitness;
    }

    /**
     * 初始化：随机初始化种群，计算个体的适应值
     */
    public void Initialize() {
        double XTemp[][] = new double[NP][size];
        double FitnessTemp[] = new double[NP];
        Random r = new Random();
        for (int i = 0; i < NP; i++) {
            for (int j = 0; j < size; j++) {
                XTemp[i][j] = xMin + r.nextDouble() * (xMax - xMin);
            }
            // 计算适应值
            FitnessTemp[i] = CalculateFitness(XTemp[i]);
        }

        this.setX(XTemp);
        this.setFitness_X(FitnessTemp);
    }

    /******** 变异操作 ***********/
    public void Mutation() {
        double XTemp[][] = new double[NP][size];
        double XMutationTemp[][] = new double[NP][size];
        XTemp = this.getX();
        Random r = new Random();
        for (int i = 0; i < NP; i++) {
            int r1 = 0, r2 = 0, r3 = 0;
            while (r1 == i || r2 == i || r3 == i || r1 == r2 || r1 == r3
                    || r2 == r3) {// 取r1,r2,r3
                r1 = r.nextInt(NP);
                r2 = r.nextInt(NP);
                r3 = r.nextInt(NP);
            }
            for (int j = 0; j < size; j++) {
                XMutationTemp[i][j] = XTemp[r1][j] + F
                        * (XTemp[r2][j] - XTemp[r3][j]);
            }
        }
        this.setXMutation(XMutationTemp);
    }

    /**
     * 交叉操作
     */
    public void CrossOver() {
        double XTemp[][] = new double[NP][size];
        double XMutationTemp[][] = new double[NP][size];
        double XCrossOverTemp[][] = new double[NP][size];

        XTemp = this.getX();
        XMutationTemp = this.getXMutation();
        // 交叉操作
        Random r = new Random();
        for (int i = 0; i < NP; i++) {
            for (int j = 0; j < size; j++) {
                double rTemp = r.nextDouble();
                if (rTemp <= CR) {
                    XCrossOverTemp[i][j] = XMutationTemp[i][j];
                } else {
                    XCrossOverTemp[i][j] = XTemp[i][j];
                }
            }
        }
        this.setXCrossOver(XCrossOverTemp);
    }

    /**
     * 选择操作：使用贪婪选择策略
     */
    public void Selection() {
        double XTemp[][] = new double[NP][size];
        double XCrossOverTemp[][] = new double[NP][size];
        double FitnessTemp[] = new double[NP];
        double FitnessCrossOverTemp[] = new double[NP];

        XTemp = this.getX();
        XCrossOverTemp = this.getXCrossOver();// 交叉变异后的个体
        FitnessTemp = this.getFitness_X();

        // 对群体进行重新设置
        for (int i = 0; i < NP; i++) {
            FitnessCrossOverTemp[i] = CalculateFitness(XCrossOverTemp[i]);
            if (FitnessCrossOverTemp[i] < FitnessTemp[i]) {
                for (int j = 0; j < size; j++){
                    XTemp[i][j] = XCrossOverTemp[i][j];
                }
                FitnessTemp[i] = FitnessCrossOverTemp[i];
            }
        }
        this.setX(XTemp);
        this.setFitness_X(FitnessTemp);
    }

    /**
     * 保存每一代的全局最优值
     */
    public void SaveBest() {
        double FitnessTemp[] = new double[NP];
        FitnessTemp = this.getFitness_X();
        int temp = 0;
        // 找出最小值
        for (int i = 1; i < NP; i++) {
            if (FitnessTemp[temp] > FitnessTemp[i]) {
                temp = i;
            }
        }
        System.out.println(FitnessTemp[temp]);
    }
}
