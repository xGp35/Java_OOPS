Optional<IceCream> optional = getIceCream("Strawberry");
if (optional.isPresent()) {
    IceCream ice = optional.get();
} else {
    System.out.println("No ice cream for you !! ")
}

if (getIceCream("Strawberry").isPresent()) {
    IceCream ice = getIceCream("Strawberry").get();
}