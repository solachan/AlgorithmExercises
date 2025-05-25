package algorithm.leetcode.algorithm.interview;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定
//）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如
//enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
//
// enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
//
// dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
//
// 示例1:
//
//  输入：
//["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog",
//"dequeueAny"]
//[[], [[0, 0]], [[1, 0]], [], [], []]
// 输出：
//[null,null,null,[0,0],[-1,-1],[1,0]]
//
//
// 示例2:
//
//  输入：
//["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat",
//"dequeueAny"]
//[[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
// 输出：
//[null,null,null,null,[2,1],[0,0],[1,0]]
//
//
// 说明:
//
//
// 收纳所的最大容量为20000
//
// Related Topics 设计 队列 👍 31 👎 0
public class NO03_06_AnimalShelf {
    public static void main(String[] args) {
        AnimalShelf animalShelf = new AnimalShelf();
        animalShelf.enqueue(new int[]{0,0});
        animalShelf.enqueue(new int[]{1,0});
        animalShelf.enqueue(new int[]{2,1});
        System.out.println(Arrays.toString(animalShelf.dequeueCat()));
        System.out.println(Arrays.toString(animalShelf.dequeueDog()));
        System.out.println(Arrays.toString(animalShelf.dequeueAny()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class AnimalShelf {
        Deque<Integer> dog,cat,any;

        public AnimalShelf() {
            dog = new LinkedList<>();
            cat = new LinkedList<>();
            any = new LinkedList<>();
        }

        public void enqueue(int[] animal) {
            if(animal[1] == 0){
                cat.offer(animal[0]);
            }else {
                dog.offer(animal[0]);
            }
            any.offer(animal[0]);
        }

        public int[] dequeueAny() {
            int[] animal = new int[2];
            while(!any.isEmpty()){
                if(!dog.isEmpty() && dog.getFirst().equals(any.getFirst())){
                    break;
                }
                if(!cat.isEmpty() && cat.getFirst().equals(any.getFirst())){
                    break;
                }
                any.poll();
            }
            if(!any.isEmpty()) {
                animal[0] = any.poll();
                if (!dog.isEmpty() && animal[0] == dog.getFirst()) {
                    animal[1] = 1;
                    dog.poll();
                } else if(!cat.isEmpty() && animal[0] == cat.getFirst()){
                    animal[1] = 0;
                    cat.poll();
                }
            }else {
                animal[0] = -1;
                animal[1] = -1;
            }
            return animal;
        }

        public int[] dequeueDog() {
            int[] animal = new int[2];
            if(!dog.isEmpty()){
                animal[0] = dog.poll();
                animal[1] = 1;
            }else {
                animal[0] = -1;
                animal[1] = -1;
            }
            return animal;
        }

        public int[] dequeueCat() {
            int[] animal = new int[2];
            if(!cat.isEmpty()){
                animal[0] = cat.poll();
                animal[1] = 0;
            }else {
                animal[0] = -1;
                animal[1] = -1;
            }
            return animal;
        }
    }

    /**
     * Your AnimalShelf object will be instantiated and called as such:
     * AnimalShelf obj = new AnimalShelf();
     * obj.enqueue(animal);
     * int[] param_2 = obj.dequeueAny();
     * int[] param_3 = obj.dequeueDog();
     * int[] param_4 = obj.dequeueCat();
     */
    //leetcode submit region end(Prohibit modification and deletion)
}
