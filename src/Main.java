

public class Main {
    private static Employee[] employee;

    public static void main(String[] args) {
        employee = new Employee[10];
        //Для тестирования работы цикла на отбор ненулевых ячеек из массива удалены 2 ячейки
        employee[0] = new Employee("Иванов Дмитрий Александрович", 1, 107034.45f);
        employee[1] = new Employee("Коптев Константин Геннадьевич", 1, 93546.73f);
        employee[2] = new Employee("Степанов Олег Николаевич", 2, 75282.80f);
        employee[3] = new Employee("Лапин Александр Алексеевич", 2, 121457.65f);
        employee[4] = new Employee("Сенченко Михаил Сергеевич", 3, 224563.42f);

        employee[6] = new Employee("Коснырев Илья Семенович", 4, 153595.32f);
        employee[7] = new Employee("Ершов Владимир Олегович", 4, 67300f);
        employee[8] = new Employee("Понькин Павел Владимирович", 5, 89924.50f);


        //--Базовая сложность--
        //Печать всех сотрудников
        printAllEmployeers();
        separator();
        //Подсчет суммы зарплат и средней зарплаты
        System.out.println("Сумма затрат на зарплаты в месяц составляет: " + calculateSalarySum(employee));
        System.out.println("Средняя зарплата за месяц составляет: " + calculateAverageSalary(employee));
        separator();
        //Поиск сотрудников с минимальной и максимальной зарплатой
        System.out.println("Сотрудник с минимальной зарплатой: " + findMinSalary(employee));
        System.out.println("Сотрудник с максимальной зарплатой: " + findMaxSalary(employee));
        separator();
        //Печать ФИО сотрудников
        printFullname();
        separator();

        //--Повышенная сложность--
        //Проиндексировать зп на процент
        System.out.println("Процент повышения ЗП: " + indexingSalary(employee, 4));
        printAllEmployeers();
        separator();
        //Поиск минимальной ЗП по отделу
        int dep = 4;
        System.out.println("Сотрудник с минимальной зарплатой в отделе №" + dep + " : " + findMinSalary(departmentFilter(dep)));
        separator();
        //Поиск максимальной ЗП по отделу
        System.out.println("Сотрудник с максимальной зарплатой в отделе №" + dep + " : " + findMaxSalary(departmentFilter(dep)));
        separator();
        //Сумма зарплаты по отделу
        System.out.println("Сумма затрат на зарплаты по отделу №" + dep + " : " + calculateSalarySum(departmentFilter(dep)));
        separator();
        //Средняя зарплата по отделу
        System.out.println("Средняя зарплата по отделу №" + dep + " : " + calculateAverageSalary(departmentFilter(dep)));
        separator();
        //Индексация ЗП по отделу
        dep = 1;
        System.out.println("Процент повышения ЗП отдела №" + dep + " : " + indexingSalary(departmentFilter(dep), 5));
        separator();
        //Печать сотрудников отдела
        System.out.println("Сотрудники отдела №" + dep);
        printDepartmentEmployees(departmentFilter(dep));
        separator();
        //Вывод сотрудников с ЗП меньше(больше) заданной
        float salaryFind = 100_000f;
        System.out.printf("Заданная ЗП: %.2f\n", salaryFind);
        findEmployeesSalaryLessSet(salaryFind);
        separator();
        findEmployeesSalaryMoreSet(salaryFind);
        separator();

    }

    public static void printAllEmployeers() {
        for (Employee value : employee) {
            if (value != null) {
                System.out.println(value);
            }
        }
    }

    public static float calculateSalarySum(Employee[] employee) {
        float sum = 0;
        for (Employee value : employee) {
            if (value != null) {
                sum += value.getSalary();
            }
        }
        return sum;
    }

    public static float calculateAverageSalary(Employee[] employee) {
        float avgNotNull = 0;
        for (Employee value : employee) {
            if (value != null) {
                avgNotNull++;
            }
        }
        return calculateSalarySum(employee) / avgNotNull;
    }

    public static void separator() {
        System.out.println("___________________________________________________________________________");
    }

    public static Employee findMaxSalary(Employee[] employees) {
        float max = 0;
        Employee maxSalaryEmployee = employees[0];
        for (Employee value : employees) {
            if (value != null && max < value.getSalary()) {
                max = value.getSalary();
                maxSalaryEmployee = value;
            }
        }
        return maxSalaryEmployee;
    }

    public static Employee findMinSalary(Employee[] employees) {
        float min = employees[0].getSalary();
        Employee minSalaryEmployee = employees[0];
        for (Employee value : employees) {
            if (value != null && min > value.getSalary()) {
                min = value.getSalary();
                minSalaryEmployee = value;
            }
        }
        return minSalaryEmployee;
    }

    public static void printFullname() {
        for (Employee value : employee) {
            if (value != null) {
                System.out.println("ФИО сотрудника:  " + value.getFullName());
            }
        }
    }

    public static float indexingSalary(Employee[] employee, float sizeIndexing) {

        for (Employee value : employee) {
            if (value != null) {
                value.setSalary(value.getSalary() + ((value.getSalary()) / 100 * sizeIndexing));
            }
        }
        return sizeIndexing;
    }

    public static Employee[] departmentFilter(int department) {
        int counter1 = 0;
        int counter2 = 0;
        for (Employee value : employee) {
            if (value != null && value.getDepartment() == department) {
                counter1++;
            }
        }
        Employee[] departmentArray = new Employee[counter1];
        for (Employee value : employee) {
            if (value != null && value.getDepartment() == department) {
                departmentArray[counter2] = value;
                counter2++;
            }

        }
        return departmentArray;
    }

    public static void printDepartmentEmployees(Employee[] employee) {

        for (Employee value : employee) {
            if (value != null) {
                System.out.println(value.getId() + " " + value.getFullName() + " " + value.getSalary());

            }
        }
    }

    public static void findEmployeesSalaryLessSet(float lessSalary) {
        System.out.println("Сотрудники с ЗП меньше заданной:");
        for (Employee value : employee) {
            if (value != null && value.getSalary() < lessSalary) {
                System.out.println(value.getId() + " " + value.getFullName() + " " + value.getSalary());
            }
        }
    }

    public static void findEmployeesSalaryMoreSet(float moreSalary) {
        System.out.println("Сотрудники с ЗП большей или равной заданной:");
        for (Employee value : employee) {
            if (value != null && value.getSalary() >= moreSalary) {
                System.out.println(value.getId() + " " + value.getFullName() + " " + value.getSalary());
            }
        }
    }



}