package algorithm1.day01;

// Яндекс. Тренировки по алгоритмам июнь 2021, занятие 1

// C. Телефонные номера

// Телефонные номера в адресной книге мобильного телефона имеют один из следующих форматов:
// +7<код><номер>,
// 8<код><номер>,
// <номер>,

// <номер> — это семь цифр,
// <код> — это три цифры или три цифры в круглых скобках.

// Если код не указан, то считается, что он равен 495.

// Кроме того, в записи телефонного номера может стоять знак “-” между любыми двумя цифрами (см. пример).

// На данный момент в адресной книге телефона Васи записано всего три телефонных номера, и он хочет записать туда еще один.
// Но он не может понять, не записан ли уже такой номер в телефонной книге.
// Помогите ему! Два телефонных номера совпадают, если у них равны коды и равны номера.
// Например, +7(916)0123456 и 89160123456 — это один и тот же номер.

// Формат ввода
// В первой строке входных данных записан номер телефона, который Вася хочет добавить в адресную книгу своего телефона.
// В следующих трех строках записаны три номера телефонов, которые уже находятся в адресной книге телефона Васи.
// Гарантируется, что каждая из записей соответствует одному из трех приведенных в условии форматов.

// Формат вывода
// Для каждого телефонного номера в адресной книге выведите YES (заглавными буквами),
// если он совпадает с тем телефонным номером, который Вася хочет добавить в адресную книгу или NO (заглавными буквами) в противном случае.

import java.io.FileNotFoundException;
import java.util.Scanner;

public class C {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String newNumber = sc.nextLine();
        String number1 = sc.nextLine();
        String number2 = sc.nextLine();
        String number3 = sc.nextLine();

        System.out.println(isEquals(newNumber, number1));
        System.out.println(isEquals(newNumber, number2));
        System.out.println(isEquals(newNumber, number3));
    }

    public static String isEquals(String n1, String n2) {

        int i = n1.length() - 1;
        int j = n2.length() - 1;

        // check number
        int count = 7;
        while (count > 0) {
            while (n1.charAt(i) == '-') i--;
            while (n2.charAt(j) == '-') j--;

            if (n1.charAt(i) != n2.charAt(j))
                return "NO";

            i--;
            j--;

            count--;
        }

        // check code
        i = nextNumber(i, n1);
        j = nextNumber(j, n2);

        String defaultCode = "495";
        if (i == -1 && j == -1) return "YES";
        else if (i == -1) {

            count = 3;
            int iDef = defaultCode.length() - 1;
            while (count > 0) {

                j = nextNumber(j, n2);

                if (defaultCode.charAt(iDef) != n2.charAt(j))
                    return "NO";

                j--;
                iDef--;

                count--;
            }

        } else if (j == -1) {

            count = 3;
            int iDef = defaultCode.length() - 1;
            while (count > 0) {

                i = nextNumber(i, n1);

                if (defaultCode.charAt(iDef) != n1.charAt(i))
                    return "NO";

                i--;
                iDef--;

                count--;
            }
        } else  {

            count = 3;
            while (count > 0) {

                i = nextNumber(i, n1);
                j = nextNumber(j, n2);

                if (n1.charAt(i) != n2.charAt(j))
                    return "NO";

                i--;
                j--;

                count--;
            }
        }

        return "YES";
    }

    public static int nextNumber(int i, String str) {
        while (i >= 0 && (str.charAt(i) == '-' || str.charAt(i) == '(' || str.charAt(i) == ')'))
            i--;
        return i;
    }
}