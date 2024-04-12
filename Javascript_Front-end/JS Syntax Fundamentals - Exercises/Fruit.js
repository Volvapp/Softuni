    function solve(fruit, grams, pricePerKg) {
    let neededSum = (grams / 1000) * pricePerKg;
    console.log(`I need $${neededSum.toFixed(2)} to buy ${(grams / 1000).toFixed(2)} kilograms ${fruit}.`);
    }
