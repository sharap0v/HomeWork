package homework2javalevel2;

class ZinaException extends Exception{

    public ZinaException(String message) {
        super(message);
        System.out.println("Творится бардак Олег трогает зинку за ляжку! \nРекомендуется перестать и обрабатывать строки только подобные этой\n \"10 3 1 2\\n2 3 2 2\\n5 6 7 1\\n300 3 1 0\"");
    }
}