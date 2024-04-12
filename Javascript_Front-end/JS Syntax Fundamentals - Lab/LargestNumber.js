function solve(...input){

    const sortedArr = input.sort(function (a,b){
        return b - a;
    });
    console.log(`The largest number is ${sortedArr[0]}.`);
}

solve(-3,
    -5,
    -22.5);