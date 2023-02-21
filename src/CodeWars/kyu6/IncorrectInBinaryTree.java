package CodeWars.kyu6;
/*
  We are storing numbers in the nodes of a binary tree. The tree starts at the root node.
  The root has two child nodes, its leftchild and rightchild. Each of those nodes also has two child nodes,
  and so on, until we reach the leaf nodes, nodes that have no children. Each node stores one nonnegative
  integer. The value at every non-leaf node is supposed to be the sum of its two children. But the value at one
  node is incorrect. Find this node.

Example: Consider the tree below. Note that 13 is the sum of 6 and 7, but the value 15 is incorrect,
 because 15 != 5 + 9 and 27 != 13 + 15. Clearly the 15 should be changed to 14.
                                  108
                        /                    \
                    /                            \
                 54                              54
            /          \                    /          \
          27           27                 27           27
         /    \       /    \            /    \       /    \
        13    15     13    15          13    15     13    15
       /  \   / \   /  \   / \       /  \   / \   /  \   / \
      6   7   5  9  6   7   5   9   6   7   5  9  6   7   5   9

 */

import java.util.Arrays;
import java.util.Collections;

public class IncorrectInBinaryTree {

    public static int[] findIncorrectNumber(int[] tree) {
        int[] incorrect = new int[2]; // - for answer
        //some variables:
        int sumNodes=0;
        int roots=0;
        int treeSize=0;
        int step=0;
        int stepPlus=0;
        int stepToNextChild=0;
        do { // find amount root:
            if(step==0){
                step++;
            }else{
                step=step*2;
            }
            treeSize = (7*step)+stepPlus;
            roots=step*4;
            if(stepPlus==0){
                stepPlus++;
            }else{
                stepPlus=step*2;
            }
        }
        while(tree.length!=treeSize);
        //find first stepToNextChild
        stepToNextChild+=roots;
        //revers tree for ease visualize
        for (int i = 0;  i < tree.length / 2; i++) {
            int temp = tree[i];
            tree[i] = tree[tree.length - i - 1];
            tree[tree.length - i - 1] = temp;
        } //Example: |9,5|7,6|15,13|27|

        for (int i = 0; i < tree.length; i++) {
            //if we are finish all root
            if(i>0&&i%roots==0){
                roots=roots/2; // next size of new (parent node)
                stepToNextChild=roots;
            }
            // core
            if(i%2==0){
                sumNodes=tree[i]+tree[i+1];
                if (sumNodes != tree[i+stepToNextChild]) {
//                    if (tree.length-i>3){
//                    if(tree[i+stepToNextChild]+tree[i+stepToNextChild+1]==tree[(i+stepToNextChild+(roots/2))]){
//                        incorrect[0]=(tree.length-1-i);
//                        incorrect[1]=tree[i+stepToNextChild]-tree[i+1];
//                        break;
//                    }}
//                    else {
                    incorrect[0] = (tree.length - 1) - (i + stepToNextChild);
                    incorrect[1] = sumNodes;
                    break;
                }
//                }
                stepToNextChild--;
            }
        }
        return new int[]{incorrect[0],incorrect[1]};
    }



    public static void main(String[] args) {
        int[] test1 = new int[]{27, 13, 15, 6, 7, 5, 9};//answer [2,14]
        int[] test3 = new int[]{19, 9, 10, 4, 5, 4, 6, 3, 2, 1, 4, 1, 3, 2, 4};  // answer [3,5]
        int[] test4 = new int[]{21, 9, 10, 4, 5, 4, 6, 2, 2, 1, 4, 1, 3, 2, 4}; // answer [0,19]
        int[] test2 = new int[]{29, 13, 16, 5, 8, 9, 1};  // answer [6,7]
        //если неправильное значение возникает на уровне листа, то правый потомок всегда будет неправильным

        System.out.println(Arrays.toString(findIncorrectNumber(test2)));
    }







    public static int[] findIncorrectNumber1(int[] tree) {
        int[] incorrect = new int[2]; // - for answer
        //some variables:
        int sumNodes=0;
        int roots=0;
        int treeSize=0;
        int step=0;
        int stepPlus=0;
        int stepToNextChild=0;

//           27
//          /    \
//         13    15
//        /  \   / \
//       6   7   5  9

        for (int i = 0; i < tree.length; i++) {
            if(tree[i]!=(tree[i+1]+tree[i+2])){
                incorrect[0] = (tree.length - 1) - (i + stepToNextChild);
                incorrect[1] = sumNodes;
                break;
            }

            if(i%2==0){
                sumNodes=tree[i]+tree[i+1];
                if (sumNodes != tree[i+stepToNextChild]) {
                    incorrect[0] = (tree.length - 1) - (i + stepToNextChild);
                    incorrect[1] = sumNodes;
                    break;
                }
                stepToNextChild--;
            }
        }
        return new int[]{incorrect[0],incorrect[1]};
    }

}
