public class JvmComprehension {

    public static void main(String[] args) {
        int i = 1;                      // 1 Пропишется в Stack т.к. указан тип "int", а не "Integer".
        Object o = new Object();        // 2 Создаст новый объект в куче, а в Stack создаст ссылку на этот объект.
        Integer ii = 2;                 // 3 Создаст новый объект в куче (целочисленное значение), а в Stack создаст ссылку на этот объект.
        printAll(o, i, ii);             // 4 в Metaspace
        System.out.println("finished"); // 7 в Metaspace
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 Создаст новый объект в куче (целочисленное значение), а в Stack создаст ссылку на этот объект. т.к. тип "Int а не Integer"
        System.out.println(o.toString() + i + ii);  // 6 в Metaspace
        //
        // Объекты и поля оздадутся и будут задействованы 1 раз, поэтому сборщик мусора удалит их всех после первой проверки
        // Bootstrap ClassLoader будет загружать эти классы т.к. это базовые классами из библиотеки java.lang
        //
    }
}