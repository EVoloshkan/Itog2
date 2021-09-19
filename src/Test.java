import java.util.Scanner;

public class Test {

    private static String example;
    private static final String numbers = "0123456789";

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите простое уравнение");
            example = scanner.next();
            example = example.toLowerCase();

            if (example.length() != 5) {
                System.out.println("Некорректное выражение. Введите 5 символов");
                continue;
            }

            if (example.indexOf('=') != 3) {
                System.out.println("Некорректное выражение. Введите символ '=' ");
                continue;
            }

            String sign = example.substring(1, 2);
            if (!(sign.equals("+") || sign.equals("-"))) {
                System.out.println("Некорректное выражение. Введите символы '+' или '-'");
                continue;
            }

            String temp = example.replace("x", "");
            if (temp.length() != 4) {
                System.out.println("Некорректное выражение. В уравнении должна присутствовать одна переменная x");
                continue;
            }

            int position = example.indexOf('x');
            byte y, z;
            switch (position) {
                case 0:
                    y = GetNumber(2);
                    z = GetNumber(4);
                    if (y == -1 || z == -1) {
                        System.out.println("Некорректное выражение. Введите числа от 0 до 9");
                    } else {
                        GetTotal(2, 4, y, z, sign);
                    }
                    break;
                case 2:
                    y = GetNumber(0);
                    z = GetNumber(4);
                    if (y == -1 || z == -1) {
                        System.out.println("Некорректное выражение. Введите числа от 0 до 9");
                    } else {
                        GetTotal(0, 4, y, z, sign);
                    }
                    break;
                case 4:
                    y = GetNumber(0);
                    z = GetNumber(2);
                    if (y == -1 || z == -1) {
                        System.out.println("Некорректное выражение. Введите числа от 0 до 9");
                    } else {
                        GetTotal(0, 2, y, z, sign);
                    }
                    break;
                default:
                    System.out.println("Некорректное выражение");
                    break;
            }
        }
    }

    private static void GetTotal(int positionY, int positionZ, byte y, byte z, String sing)
    {
        switch (sing)
        {
            case "+":
                if(positionY == 0 && positionZ == 2)
                {
                    System.out.println("x = " + (y + z));
                } else {
                    System.out.println("x = " + (z - y));
                }
                break;
            case  "-":
                if (positionY == 2 && positionZ == 4)
                {
                    System.out.println("x = " + (y + z));
                } else {
                    System.out.println("x = " + (y - z));
                }
                break;
            default:
                System.out.println("Некорректное выражение");
                break;
        }

    }

    private static byte GetNumber(int index) {
        String symbol = Character.toString(example.charAt(index));
        if (numbers.contains(symbol)) {
            return Byte.parseByte(symbol);
        }
        return  -1;
    }
}
