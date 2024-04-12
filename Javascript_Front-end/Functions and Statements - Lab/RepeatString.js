function solve(text, reps){
    let newString = '';
    for (let i = 0; i < reps; i++) {
        newString += text;
    }
    console.log(newString)
}
solve('abc',3)