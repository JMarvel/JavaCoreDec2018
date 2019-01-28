public enum CourseList {
    Archery(1),
    Blocking(2),
    Bomb_creation(3),
    Brewing(4),
    Dark_magic(5),
    Fire_magic(6),
    Lockpicking(7),
    Metabolism_control(8),
    Oil_preparation(9),
    Pickpocket(10),
    Smithing(11),
    Sneak(12);

    private int id;

    CourseList (int id) {
        this.id = id;
    }

    CourseList getById(int id) {
        return CourseList.values()[id];
    }

    public String toString() {
        return this.name().toLowerCase();
    }
}
