function solve(arr, step){
    let newArr = [];
    let temp = 0;
    for(let i = 0; i < arr.length; i++){
        if (i % step === 0){
            console.log(arr[i])
        }
    }
    return newArr;
}
solve(['5',
'20',
'31',
'4',
'20'],
2)