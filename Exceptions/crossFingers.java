public void crossFingers() {
    try {
        anObject.takeRisk();
    } catch(BadException e) {
        System.out.println("Aargh!");
        e.printStackTrace();
    }
}