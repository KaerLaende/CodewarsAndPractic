
public class Main {
    public static void main(String[] args) {
	int projitMin = 13800;
    int posobie=13300;
    int ramaider = 29100;
        System.out.println("остаток от ЗП после налогов");
        System.out.println(90000*(1-0.13));
        System.out.println(salary(projitMin, posobie));
    }
	public static int salary(int projitMin, int posobie ){
        int summPosobie = posobie*3;
        int maxFamilySalary = projitMin*5;
        int remainder = maxFamilySalary-summPosobie;
        int salary = 90000;
        int remainderSum=12*remainder;
        System.out.println("Нехватка дохода за 12 месяцав: "+remainderSum);

        return remainderSum/salary;
    }
}


