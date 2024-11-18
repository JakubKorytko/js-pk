//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Color randomColor = new Color(123, 222, 65,234);

        System.out.println(randomColor);
        //
        System.out.print(randomColor.blue()+ ", ");
        System.out.print(randomColor.green() + ", ");
        System.out.print(randomColor.red()  + ", ");
        System.out.print(randomColor.alpha()  + System.lineSeparator());
        //
        System.out.println(randomColor.toString());
    }
}