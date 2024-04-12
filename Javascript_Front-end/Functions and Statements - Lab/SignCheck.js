function solve(num1, num2, num3) {
    let counter = 0;
    if (num1 < 0) {
        counter++;
    }
    if (num2 < 0) {
        counter++;
    }
    if (num3 < 0) {
        counter++;
    }
    if (counter === 1 || counter === 3) {
        console.log("Negative")
    } else {
        console.log("Positive")
    }
}

solve(-6, -14, 14)