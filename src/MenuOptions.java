public enum MenuOptions {
    NEW_GAME(1),
    LOAD_GAME(2),
    EXIT(3);

    private final int value;

    MenuOptions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MenuOptions getMenu_Option(int value) {
        for (MenuOptions menu_option : MenuOptions.values()) {
            if (menu_option.getValue() == value) {
                return menu_option;
            }
        }
        return null;
    }
    public static void displayMenu() {
        System.out.println("""
                [1] New Game
                [2] Load Game
                [3] Quit
                """);
    }

}
