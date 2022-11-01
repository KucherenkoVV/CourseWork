import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        employee[0] = new Employee("Иванов Дмитрий Александрович", 1, 107034.45f);
        employee[1] = new Employee("Коптев Константин Геннадьевич", 1, 93546.73f);
        employee[2] = new Employee("Степанов Олег Николаевич", 2, 75282.80f);
        employee[3] = new Employee("Лапин Александр Алексеевич", 2, 121457.65f);
        employee[4] = new Employee("Сенченко Михаил Сергеевич", 2, 224563.42f);
        employee[5] = new Employee("Алешин Артем Игоревич", 3, 183716.23f);
        employee[6] = new Employee("Коснырев Илья Семенович", 4, 153595.32f);
        employee[7] = new Employee("Ершов Владимир Олегович", 4, 67300f);
        employee[8] = new Employee("Понькин Павел Владимирович", 5, 89924.50f);
        employee[9] = new Employee("Семыкин Антон Юрьевич", 1, 175303.4f);

        //Печать всех сотрудников
        printAllEmployeers(employee);
        separator();
        //Подсчет суммы зарплат и средней зарплаты
        calculateSalarySumAndAverage(employee);
        separator();
        //Поиск сотрудников с минимальной и максимальной зарплатой
        findMaxAndMinSalary(employee);

    }

    public static void printAllEmployeers(Employee[] employee) {
        for (Employee value : employee) {
            System.out.println(Arrays.toString(new Employee[]{value}));
        }

    }

    public static void calculateSalarySumAndAverage(Employee[] employee) {
        float sum = 0;
        float avg;
        for (Employee value : employee) {
            sum = sum + value.getSalary();
        }
        avg = sum / employee.length;
        System.out.println("Сумма затрат на зарплаты в месяц составляет: " + sum);
        System.out.println("Средняя зарплата по работникам составляет: " + avg);
    }

    public static void separator() {
        System.out.println("___________________________________________________________________________");
        System.out.println("___________________________________________________________________________");
    }

    public static void findMaxAndMinSalary(Employee[] employee) {
        float max = 0;
        float min = employee[0].getSalary();
        String maxSalaryEmployeer = null;
        String minSalaryEmployeer = null;
        for (int i = 0; i < employee.length - 1; i++) {
            if (max < employee[i + 1].getSalary()) {
                max = employee[i].getSalary();
                maxSalaryEmployeer = employee[i].toString();
            }
            if (min > employee[i].getSalary()) {
                min = employee[i].getSalary();
                minSalaryEmployeer = employee[i].toString();
            }
        }
        System.out.println("Сотрудник с мимимальной зарплатой: " + minSalaryEmployeer);
        System.out.println("Сотрудник с максиимальной зарплатой: " + maxSalaryEmployeer);
    }


}