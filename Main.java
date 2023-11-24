package s06dz;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    //Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//Создать множество ноутбуков.
//Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
// и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
//Например: “Введите цифру, соответствующую необходимому критерию:
//1 - ОЗУ 2 - Объем ЖД 3 - Операционная система 4 - Цвет 5 - диагональ экрана
//Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно в Map.
//Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
//Частые ошибки:
//1. Заставляете пользователя вводить все существующие критерии фильтрации
//2. Невозможно использовать более одного критерия фильтрации одновременно
//3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
//4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять
// характеристики ноутбуков или добавить еще ноутбук, то программа начинает работать некорректно
    public static void main(String[] args) {

        Set<Notebook> notebooks = new HashSet<>();
        Notebook nb1 = new Notebook("Asus", 4, 128,14);
        Notebook nb2 = new Notebook("Xiaomi",4,256,15);
        Notebook nb3 = new Notebook("Dogee",6,256,13);
        Notebook nb4 = new Notebook("Samsung",8,512,14);
        Notebook nb5 = new Notebook("HP",8,512,15);
        Notebook nb6 = new Notebook("Lenovo",16,1024,17);

        notebooks.add(nb1);
        notebooks.add(nb2);
        notebooks.add(nb3);
        notebooks.add(nb4);
        notebooks.add(nb5);
        notebooks.add(nb6);

//        print(notebooks);
        System.out.println("------");
        Notebook nbSelect = new Notebook("", 0, 0,0);
        boolean a = true;
        Scanner scanner = new Scanner(System.in);
        while (a){
            printMenu();
            String sel = scanner.nextLine();
            switch (sel){
                case "1":
                    System.out.print("Введите модель ноутбука: ");
                    nbSelect.model = scanner.nextLine();
                    System.out.println("заданные параметры: "+nbSelect.toStringNotEmpty());
                    break;
                case "2":
                    System.out.print("Введите объем памяти: ");
                    nbSelect.op = Integer.parseInt(scanner.nextLine());
                    System.out.println("заданные параметры: "+nbSelect.toStringNotEmpty());
                    break;
                case "3":
                    System.out.print("Введите размер SSD: ");
                    nbSelect.ssd = Integer.parseInt(scanner.nextLine());
                    System.out.println("заданные параметры: "+nbSelect.toStringNotEmpty());
                    break;
                case "4":
                    System.out.print("Введите диагональ экрана: ");
                    nbSelect.diagonal = Integer.parseInt(scanner.nextLine());
                    System.out.println("заданные параметры: "+nbSelect.toStringNotEmpty());
                    break;
                case "5":
                    print(selectBy(notebooks, nbSelect));
                    break;
                case "6":
                    a = false;
                    break;
                default:
                    break;
            }
        }

//        print(selectBy(notebooks, nbSelect));
    }

        static Set<Notebook> selectBy(Set<Notebook> notebooks, Notebook nbSelect){
        Set<Notebook> result = new HashSet<>();
        for (Notebook nb: notebooks) {
            if (nbSelect.isBetter(nb)) {
                result.add(nb);
            }
        }
        return result;
    }
    static void print(Set<Notebook> notebooks)
    {
        for (Notebook nb: notebooks) {
            System.out.println(nb);
        }
    }
    static void printMenu(){
        System.out.println("Введите номер: \n 1 - модель ноутбука\n 2 - объем памяти\n 3 - размер SSD\n 4 - диагональ экрана\n "+
                "5 - вывести подходящие ноутбуки\n 6 - выход");

    }
}
