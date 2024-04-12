function solve(num1, num2, operator) {

    switch (operator){
        case "multiply":
            console.log(num1 * num2);
            break
        case "divide":
            console.log(num1 / num2);
            break
        case "add":
            console.log(num1 + num2);
            break
        case "subtract":
            console.log(num1 - num2);
            break
    }
}
solve(4,2,'multiply')