function getSmallest(first, second, third) {
    
    if (first <= second && first <= third) {
        return first;
    } else if (second <= first && second <= third) {
        return second;
    } else if (third <= first && third <= second) {
        return third;
    }
}

console.log(getSmallest(600,
    342,
    123
    ));