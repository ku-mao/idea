import java.util.Date;
import java.util.Random;

public class DE {
    private int population_size;     // population numbers
    private int iter_num;        // number of iteration
    private int param_num;            // variables of problem
    private double param_bottom_bound;    // lower bound of variables
    private double param_upper_bound;    // upper bound of variables
    private double F = 0.5;    //mutation factor
    private double CR = 0.5; // cross rate
    // tmp
    private double[][] population;         // population's array
    private double[] fitness;            // personal's fitness
    private Random rand;               // getting a rand number for using // 申明 rand ,后面new 实例化 ，基础类型不需要new
    //output
    private double[] final_individual;


    /*
     *
     * @param 种群数量，迭代次数，变量个数，变量的下边界，变量的上边界
     * @return final_individual
     */

    public DE(int population_size, int iter_num, double MutateFactor, double CrossRate, int param_num, double param_bottom_bound, double param_upper_bound) {
        this.population_size = population_size;
        this.iter_num = iter_num;
        this.param_num = param_num;
        this.F = MutateFactor;
        this.CR = CrossRate;
        this.param_bottom_bound = param_bottom_bound;
        this.param_upper_bound = param_upper_bound;
        final_individual = run();

    }

    public double[] getTheFinalParams() {
        return final_individual;
    }

    /*
     *
     * @param void
     * @return final_best_individual
     */
    private double[] run() {   // step1: 初始化种群
        this.init();
        // 初始化最终最优值
        double[] final_best_individual = null;
        // step2:开始迭代
        for (int iter = 0; iter < iter_num; iter++) {   // mutate operation
            double[][] mutated_population = this.mutate();
            // cross operation
            double[][] crossedpopulation = this.cross(mutated_population);
            // select operation
            this.select(crossedpopulation);
            // 找出最值的个体
            int[] index = insertDescendSortIndex(fitness, 1);

            StringBuffer sb = new StringBuffer();
            sb.append("The " + (iter + 1) + "-th iter's score is" + fitness[index[0]] + "(");
            for (int j = 0; j < param_num - 1; j++)
                sb.append(this.population[index[0]][j] + ",");
            sb.append(this.population[index[0]][param_num - 1] + ")");
            System.out.println(sb.toString());
            final_best_individual = this.population[index[0]];
            double final_fitness = scorefunc(final_best_individual);
            System.out.println(final_fitness);
        }
        return final_best_individual;

    }

    /*
     *
     * @param
     * @return
     */

    private int[] insertDescendSortIndex(final double[] arr, int sortTopN) {
        int[] indexes = new int[arr.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;

        }
        for (int i = 1; i < indexes.length; i++) {
            for (int j = 0; j < i && j < sortTopN; j++) {
                if (arr[indexes[i]] > arr[indexes[j]]) {
                    int tmp = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = tmp;
                }
            }
        }
        if (indexes.length > sortTopN) {
            int[] ans = new int[sortTopN];
            for (int i = 0; i < sortTopN; i++) {
                ans[i] = indexes[i];

            }
            return ans;

        }
        return indexes;

    }

    /*
     *
     * @param void
     * @return void
     */
    private void init() {
        rand = new Random(new Date().getTime());  //实例化rand
        population = new double[population_size][param_num];
        fitness = new double[population_size];
        for (int i = 0; i < population_size; i++) {
            for (int j = 0; j < param_num; j++) {
                population[i][j] = param_bottom_bound + rand.nextDouble() * (param_upper_bound - param_bottom_bound);

            }
            fitness[i] = scorefunc(population[i]);

        }
    }

    /*
     *
     * @param void
     * @return mutated_population
     */
    private double[][] mutate() {
        double[][] mutated_population = new double[population_size][param_num]; //
        for (int i = 0; i < population_size; i++) {
            int ind1 = rand.nextInt(population_size);
            int ind2 = rand.nextInt(population_size);
            int ind3 = rand.nextInt(population_size);
            while (ind1 == i || ind2 == i || ind3 == i || ind1 == ind2 || ind1 == ind3 || ind2 == ind3) {
                ind1 = rand.nextInt(population_size);
                ind2 = rand.nextInt(population_size);
                ind3 = rand.nextInt(population_size);

            }
            for (int j = 0; j < param_num; j++) {
                mutated_population[i][j] = population[ind1][j] + F * (population[ind2][j] - population[ind3][j]);
            }

        }
        return mutated_population;
    }

    /*
     *
     * @param mutated_population
     * @return crossedpopulation
     */
    private double[][] cross(double[][] mutated_population) // 输入参数是一个二维数组
    {
        double[][] crossedpopulation = new double[population_size][param_num];
        for (int i = 0; i < population_size; i++) {
            int Jrand = rand.nextInt(param_num); // 随机生成一个在param_num间的整数
            for (int j = 0; j < param_num; j++) {
                if (j == Jrand || rand.nextDouble() < CR) {
                    crossedpopulation[i][j] = mutated_population[i][j];

                } else {
                    crossedpopulation[i][j] = population[i][j];

                }
                if (crossedpopulation[i][j] > this.param_upper_bound || crossedpopulation[i][j] < this.param_bottom_bound) {
                    crossedpopulation[i][j] = param_bottom_bound + rand.nextDouble() * (param_upper_bound - param_bottom_bound);

                }
            }
        }
        return crossedpopulation;  // 返回的是一个二维数组

    }

    /*
     * 最大值计算
     * @param crossedpopulation
     * @return void
     */
    private void select(double[][] crossedpopulation) {
        for (int i = 0; i < population_size; i++) {
            double new_sco = scorefunc(crossedpopulation[i]);
            if (new_sco > fitness[i]) {
                population[i] = crossedpopulation[i];
                fitness[i] = new_sco;
            }
        }
    }
    /*
     *
     * 求解问题的适应值函数（度量函数）
     * @param 求解的解
     * @return 适应值
     */

    private double scorefunc(double[] individual) {
        double sco = 0;
        for (int i = 0; i < param_num; i++) {
            sco += individual[i] * individual[i];

        }
        return sco;
    }
    /*
     * 主函数开始执行DE算法
     * main function for DE
     * @param void
     * @return void
     */

    public static void main(String[] args)
    {
        DE de=new DE(100,500,0.5,0.8,5,0,10);
        double[] params=de.getTheFinalParams();
        System.out.println();
        for(int j=0;j<params.length;j++)
        {
            System.out.printf("%4.6f ,",params[j]);

        }
        System.out.println("\nHave a good day!");
    }
}

