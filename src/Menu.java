import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    String help = "Menu:\n 1) help  " +
            "\n 2) add income \n 3) show incomes \n 4) show outcome incomes \n " +
            "5) add expense \n 6) show expenses \n 7) show outcome expenses";

    public void Run(){
        String command;
        Scanner in = new Scanner(System.in);
        Map<String, Character> commands = new HashMap<String, Character>();
        Character c;
        commands.put("help", 'h');
        commands.put("add income", 'a');
        commands.put("show incomes", 's');
        commands.put("show outcome incomes", 'o');
        commands.put("add expense", 'b');
        commands.put("show expenses", 'c');
        commands.put("show outcome expenses", 'd');
        System.out.println(help);
        try {
            String amount;
            while (true) {
                command = in.nextLine();
                if (commands.containsKey(command)){
                    c = commands.get(command);
                }
                else{
                    c = 'e';
                }
                switch (c) {
                    case 'h':
                        show_help();
                        break;
                    case 'q':
                        break;
                    case 'a':
                        FileWriter fileWriter = new FileWriter("incomes.txt", true);
                        Income income = new Income();
                        amount = in.nextLine();
                        command = in.nextLine();
                        income.add(amount, command, fileWriter);
                        fileWriter.close();
                        break;
                    case 's':
                        BufferedReader fileReader = new BufferedReader(new FileReader("incomes.txt"));
                        Income.show(fileReader);
                        fileReader.close();
                        break;
                    case 'o':
                        BufferedReader fileReader2 = new BufferedReader(new FileReader("incomes.txt"));
                        Income.outcome(fileReader2);
                        fileReader2.close();
                        break;
                    case 'b':
                        FileWriter fileWriter2 = new FileWriter("expenses.txt", true);
                        Expense expense = new Expense();
                        amount = in.nextLine();
                        command = in.nextLine();
                        expense.add(amount, command, fileWriter2);
                        fileWriter2.close();
                        break;
                    case 'c':
                        BufferedReader fileReader3 = new BufferedReader(new FileReader("expenses.txt"));
                        Expense.show(fileReader3);
                        fileReader3.close();
                        break;
                    case 'd':
                        BufferedReader fileReader4 = new BufferedReader(new FileReader("expenses.txt"));
                        Expense.outcome(fileReader4);
                        fileReader4.close();
                        break;
                    default:
                        System.out.println("Такой команды не существует. Для просмотра команд введите help.");
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void show_help(){
        System.out.println(help);
    }

}
