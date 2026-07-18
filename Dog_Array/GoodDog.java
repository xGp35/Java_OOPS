class GoodDog {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int s) {
        size = s;
        // this.size is not required as parameter name is different from instance variable
        // if this "method parameter" was also called size, like setSize (int size)
        // Then I would have to provide this.size = size. As its s, so "this" is optional
    }

    void bark() {
        if (size > 60) {
            System.out.println("Woof!, Woof!");
        } else if (size > 14) {
            System.out.println("Ruff!, Ruff!");
        } else {
            System.out.println("Yip!, Yip!");
        }
    }
}

class GoodDogTestDrive {
    public static void main(String[] args) {
        GoodDog one = new GoodDog();
        one.setSize(70);
        GoodDog two = new GoodDog();
        two.setSize(8);
        System.out.println("Dog one: " + one.getSize());
        System.out.println("Dog two: " + two.getSize());
        one.bark();
        two.bark();
    }
}