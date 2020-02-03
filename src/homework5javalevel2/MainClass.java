package homework5javalevel2;

public class MainClass {

    static final int SIZE = 10000000;
    static final int h = SIZE / 2;

    public static float[] createMassiv() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        return arr;
    }

    public static float[] changeMassiv(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
        }
        return arr;
    }

    public static void methodOne() {
        float[] arr = createMassiv();
        long a = System.currentTimeMillis();
        changeMassiv(arr);
        System.out.println("Время работы первого " + (System.currentTimeMillis() - a));
    }

    public static void methodTwo() {
        float[] arr = createMassiv();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        new Thread() {
            public void run() {
                changeMassiv(a1);
            }
        }.start();
        new Thread() {
            public void run() {
                changeMassiv(a2);
            }
        }.start();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Время работы второго " + (System.currentTimeMillis() - a));
    }

    public static void main(String[] args) {
        methodOne();
        methodTwo();
    }
}