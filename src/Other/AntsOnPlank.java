package Other;

public class AntsOnPlank {
    public static int stepsToFirstDrop(int n, int left, int right) {
        int step = 0;
        if (left > right) { //если столкнутся? то:
            int distanceBetweenAnts=left - right;
            int stepToContact = (distanceBetweenAnts/2);
            //если до встречи они преодолели 1 шаг или более им придется столько же идти обратно до начальной позиции
            if(stepToContact>=1){
                stepToContact*=2;
            }
            //если пытаются занять одну и туже позицию шаг отменяется
            if(distanceBetweenAnts%2==0){
                stepToContact-=1;
            }
            int stepLeft = (n + 1 - left) + stepToContact;
            int stepRight = right + 1 + stepToContact;
            step = Math.min(stepLeft, stepRight);
        } else {
            int stepLeft = left + 1;
            int stepRight = n - right + 1;
            step = Math.min(stepLeft, stepRight);
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(stepsToFirstDrop(4, 1, 3));
    }

    public static int stepsToFirstDrop2(int n, int left, int right) {
        int step = 0;
        if (left > right) {
            int distanceBetweenAnts = left - right;
            int stepToContact = (distanceBetweenAnts >> 1) << 1; // сдвигаем вправо на битность и умножаем на 2
            if (distanceBetweenAnts % 2 == 0) {
                stepToContact--; // если дистанция четная, то шаг отменяется
            }
            int stepLeft = (n + 1 - left) + stepToContact;
            int stepRight = right + 1 + stepToContact;
            step = Math.min(stepLeft, stepRight);
        } else {
            int stepLeft = left + 1;
            int stepRight = n - right + 1;
            step = Math.min(stepLeft, stepRight);
        }
        return step;
    }

}
